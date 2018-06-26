package io.github.floyd.java8.defaultmethods;

public interface Calculator {

    int add (int first, int second);

    int subtract(int first, int second);

    int multiply(int first, int second);

    int divide(int number, int divisor);

    default int mod(int first, int second) {
        return first % second;
    }
}
