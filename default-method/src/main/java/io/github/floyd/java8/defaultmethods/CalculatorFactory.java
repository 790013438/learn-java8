package io.github.floyd.java8.defaultmethods;

public class CalculatorFactory {

    public static Calculator getInstance() {
        return new BasicCalculator();
    }
}
