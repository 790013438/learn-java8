package io.github.floyd.java8.nio.channel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.channels.FileChannel;

/**
 * @author 79001
 */
public class TransferFrom {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransferFrom.class);

    public static void main(String... args) throws IOException {
        String filePath;
        URL url = TransferFrom.class.getClassLoader().getResource(".");
        LOGGER.debug("URL {}", url);
        if (url != null) {
            filePath = url.getFile();
        } else {
            filePath = new File("").getAbsolutePath();
        }
        LOGGER.debug("获取到的相对路径{}", filePath);
        String file = filePath + File.separator + "log4j.properties";
        String toFile = filePath + File.separator + "copy.txt";

        try (RandomAccessFile fromRandomAccessFile = new RandomAccessFile(file, "rw");
             RandomAccessFile toRandomAccessFile = new RandomAccessFile(toFile, "rw")) {
            LOGGER.debug("要读取的文件{}", file);
            FileChannel fromFileChannel = fromRandomAccessFile.getChannel();
            FileChannel toFileChannel = toRandomAccessFile.getChannel();

            long position = 0;
            long count = fromFileChannel.size();

            toFileChannel.transferFrom(fromFileChannel, position, count);
        } catch (Exception e) {
            LOGGER.error("复制失败");
        }
    }
}
