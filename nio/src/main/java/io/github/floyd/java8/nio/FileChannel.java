package io.github.floyd.java8.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Objects;

/**
 * @author 程淼
 * @version 1.0
 * ClassName io.github.floyd.java8
 * Description: 描述
 * Company: com.yinhai
 * date 2019/1/18
 */
public class FileChannel {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileChannel.class);

    public static void main(String[] args) throws IOException {
        // 要测试的文件名
        String fileName = "nio-data.txt";
        String fileString = Objects.requireNonNull(FileChannel.class.getClassLoader().getResource("")).getFile();
        // 读取位置
        LOGGER.debug("读取 {} 路径下的文件", fileString);
        assert fileString != null;
        // 要读取的文件名
        fileName = fileString + File.separator + fileName;
        // 缓存大小
        int sizeInt = 256;
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw")) {
            //  File可以获取channel吗, 不可以,获得channel
            java.nio.channels.FileChannel fileChannel = randomAccessFile.getChannel();
            // 分配缓存大小
            ByteBuffer byteBuffer = ByteBuffer.allocate(sizeInt);

            // 开始读取到缓存，异步，开始后可以执行之后的代码
            int byteInt = fileChannel.read(byteBuffer);
            // 没有读取完则继续读
            while (byteInt != -1) {
                LOGGER.debug("读取 {} 字节", byteInt);
                // 弹 spring, 之前是将数据读到buffer，写出stdio
                byteBuffer.flip();

                StringBuilder stringBuilder = new StringBuilder();
                // 缓存存在没有输出的字节，循环输出
                while (byteBuffer.hasRemaining()) {
                    Character ch = (char) byteBuffer.get();
                    // 读取一个字节转换成字符格式
                    LOGGER.debug("读取{}", ch);
                    stringBuilder.append(ch);
                }
                LOGGER.debug("拼接字符 {}", stringBuilder);

                // 清空所有数据
                byteBuffer.compact();
                // 从channel读取到buffer
                byteInt = fileChannel.read(byteBuffer);
            }
        }

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw")) {
            // 读取一行
            while (randomAccessFile.getFilePointer() < randomAccessFile.length()) {
                LOGGER.debug("一行 {}", randomAccessFile.readLine());
            }
        }
    }
}
