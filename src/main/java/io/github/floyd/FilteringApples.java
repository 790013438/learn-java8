package io.github.floyd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author floyd
 */
public class FilteringApples {

    private static final Logger logger = LoggerFactory.getLogger(FilteringApples.class);

    public static void main(String ...args) {

        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        List<Apple> heavyApples = inventory.stream()
            .filter((Apple a) -> a.getWeight() > 150)
            .collect(toList());
        logger.debug("heavy apples {}", heavyApples);

        List<Apple> heavyApples2 = inventory.parallelStream()
            .filter((Apple a) -> a.getWeight() > 150)
            .collect(toList());
        logger.debug("heavy apples {}", heavyApples2);
    }

    public static class Apple {
        private int weight;
        private String color;

        Apple(int weight, String color){
            this.weight = weight;
            this.color = color;
        }

        Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
        }
    }
}
