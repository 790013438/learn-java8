package io.github.floyd.java8.defaultmethods;

public class UseCalculate {

    public static void main(String[] args) {
        Calculator calculator = new BasicCalculator();
        int sum = calculator.add(1, 2);
        System.out.println(sum);

        BasicCalculator cal = new BasicCalculator();
        int difference = cal.subtract(3, 2);
        System.out.println(difference);

        System.out.println(cal.mod(3, 2));
    }
}
