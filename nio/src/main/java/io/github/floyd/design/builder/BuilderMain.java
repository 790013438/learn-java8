package io.github.floyd.design.builder;

/**
 * 此类的主要功能是： <br/>
 * 1. 处理<br/>
 * 此类提供的主要方法有：<br/>
 * 1.
 *
 * @author chengmiao
 * @version 1.0
 * ClassName io.github.floyd.design
 * Company: com.yinhai
 * date 2020/8/27

 */
public class BuilderMain {

    public static void main(String[] args) {
        Director director = new Director();
        Builder builder1 = new ConcreteBuilder1();
        Builder builder2 = new ConcreteBuilder2();

        director.createProduct(builder1);
        Product product1 = builder1.getResult();
        product1.show();

        director.createProduct(builder2);
        Product product2 = builder2.getResult();
        product2.show();
    }
}
