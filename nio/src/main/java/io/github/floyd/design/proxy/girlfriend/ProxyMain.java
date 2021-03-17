package io.github.floyd.design.proxy.girlfriend;

/**
 * 此类的主要功能是： <br/>
 * 1. 处理<br/>
 * 此类提供的主要方法有：<br/>
 * 1.
 *
 * @author chengmiao
 * @version 1.0
 * ClassName io.github.floyd.design.proxy
 * Company: com.yinhai
 * date 2021/1/31
 */
public class ProxyMain {
    public static void main(String[] args) {
        SchoolGirl julia = new SchoolGirl();
        julia.setName("李娇娇");

        Proxy dahlia = new Proxy(julia);

        dahlia.giveDolls();
        dahlia.giveFlowers();
        dahlia.giveChocolate();
    }
}
