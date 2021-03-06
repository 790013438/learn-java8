package io.github.floyd.java8.lambda.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.function.Function;

public class LambdaException {

    public static void main (String[] args) {
        Function<BufferedReader, String> f = (BufferedReader b) -> {
            try {
                return b.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
