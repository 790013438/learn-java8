package io.github.floyd.java8;

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
        String fileName = "nio-data.txt";
        String fileString = Objects.requireNonNull(FileChannel.class.getClassLoader().getResource("")).getFile();
        // 读取位置
        LOGGER.debug("读取 {} 路径下的文件", fileString);
        assert fileString != null;
        fileName = fileString + File.separator + fileName;
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw")) {
            // 读取一行
//            while (randomAccessFile.readBoolean()) {
//                LOGGER.debug("一行 {}", randomAccessFile.readLine());
//            }
            //  File可以获取channel吗, 不可以,获得channel
            java.nio.channels.FileChannel fileChannel = randomAccessFile.getChannel();
            // 分配缓存大小
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            // 开始读取到缓存，异步，开始后可以执行之后的代码
            int byteInt = fileChannel.read(byteBuffer);
            while (byteInt != -1) {
                LOGGER.debug("读取 {} 字节", byteInt);
                // 弹 spring, 等待缓存读取完
                byteBuffer.flip();

                // 缓存存在没有输出的字节，循环输出
                while (byteBuffer.hasRemaining()) {
                    // 读取一个字节转换成字符格式
                    LOGGER.debug("读取{}", (char) byteBuffer.get());
                }

                byteBuffer.clear();
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
