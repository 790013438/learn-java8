package io.github.floyd.java8.nio.channel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @author 79001
 */
public class TransferFrom {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransferFrom.class);

    public static void main(String... args) throws IOException {
        String filePath = TransferFrom.class.getClassLoader().getResource("").getFile();
        String file = filePath + File.separator + "log4j.properties";
        String toFile = filePath + File.separator + "copy.txt";

        try (RandomAccessFile fromRandomAccessFile = new RandomAccessFile(file, "rw");
             RandomAccessFile toRandomAccessFile = new RandomAccessFile(toFile, "rw")) {
            LOGGER.debug(file);
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
