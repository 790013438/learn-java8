package io.github.floyd.java8.nio.channel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.security.CodeSource;

/**
 * @author 79001
 */
public class TransferFrom {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransferFrom.class);
    private static final String FILE = "log4j.properties";

    public static void main(String... args) throws IOException {

        // 查找jar的旁边有没有文件
        CodeSource codeSource = TransferFrom.class.getProtectionDomain().getCodeSource();
        File location = new File(codeSource.getLocation().getFile());
        LOGGER.debug("jar或class所在的路径{}", location);
        File srcFile = new File(location.getParentFile(), FILE);
        // 包含到一个类里
        SrcFile srcFile1 = new SrcFile();
        srcFile1.setFile(srcFile);
        try (ReadableByteChannel readableByteChannel = readableByteChannelFunction.apply(srcFile1);
             // 比较使用简便的方式，放在jar旁边
             FileChannel transferFileChannel = new RandomAccessFile(new File(location.getParentFile(), "nio-data.md"), "rw").getChannel()) {
            // 使用简单的, 如果jar包旁边的文件存在，则是srcFile.length()；如果不存在，则是jar包里的默认资源inputStream.available()
            transferFileChannel.transferFrom(readableByteChannel, 0, srcFile1.getSize());
        } catch (Exception e) {
            LOGGER.error("使用transfer出错{}", e);
        }

        // 写入copy.txt
        String toFileString = "copy.txt";
        // 获取资源文件
        try (ReadableByteChannel readableByteChannel = readableByteChannelFunction.apply(srcFile1);
             // 要写入的文件, 位置在执行命令窗口所在的位置
             FileChannel fileChannel = new RandomAccessFile(new File(location.getParentFile(), toFileString), "rw").getChannel()) {

            // 缓存大小
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            // 读取文件内容到缓存
            int readInt = readableByteChannel.read(byteBuffer);
            // 当缓存里有内容，没有读取完
            while (readInt != -1) {
                LOGGER.debug("读取文件大小{}", readInt);
                // 将缓存里的转为写入文件
                byteBuffer.flip();
                // 写入到目标文件
                fileChannel.write(byteBuffer);
                // 去掉已经读取的缓存
                byteBuffer.compact();
                // 读取文件内容到缓存
                readInt = readableByteChannel.read(byteBuffer);
            }
        } catch (Exception e) {
            LOGGER.error("读取文件{}", e);
        }
    }

    private static ThrowableFunction<SrcFile, ReadableByteChannel> readableByteChannelFunction = (SrcFile srcFile) -> {
        File resourceFile = srcFile.getFile();
        LOGGER.debug("{}文件存在: {}", resourceFile, resourceFile.exists());
        // 有，jar包旁边的文件作为资源文件，源文件
        if (resourceFile.exists()) {
            RandomAccessFile srcRandomAccessFile = new RandomAccessFile(resourceFile, "rw");
            srcFile.setSize(resourceFile.length());
            return srcRandomAccessFile.getChannel();
        }
        // 没有，则从jar包里获取源文件
        // 得到jar包的文件
        InputStream inputStream = TransferFrom.class.getClassLoader().getResourceAsStream(FILE);
        assert inputStream != null;
        LOGGER.debug("inputStream{} 的大小: {}", inputStream, inputStream.available());
        // todo 安全问题，会截断吗，available获得的是int；在jar包里的不容易使用transferFrom, nio处理jar包外的好用
        srcFile.setSize(new Long(inputStream.available()));
        // 源文件
        return Channels.newChannel(inputStream);
    };

    @FunctionalInterface
    private interface ThrowableFunction<T, R> {
        /**
         * 会抛出异常的function
         *
         * @param t 给参数
         * @return 转换后的结果
         * @throws Exception 异常
         */
        R apply(T t) throws Exception;
    }

    private static class SrcFile {
        private Long size;
        private File file;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        public File getFile() {
            return file;
        }

        public void setFile(File file) {
            this.file = file;
        }
    }
}
