package io.github.floyd.design.decorator.person;

/**
 * 此类的主要功能是： <br/>
 * 1. 处理<br/>
 * 此类提供的主要方法有：<br/>
 * 1.
 *
 * @author chengmiao
 * @version 1.0
 * ClassName io.github.floyd.design.decorator.person
 * Company: com.yinhai
 * date 2021/1/28
 * @see *#
 */
public class PersonMain {
    public static void main(String[] args) {
        Person xc = new Person("小菜");
        System.out.println("第一种装扮");

        BigTrouser bigTrouser = new BigTrouser();
        TShirts tShirts = new TShirts();

        bigTrouser.decorate(xc);
        tShirts.decorate(bigTrouser);

        tShirts.show();
    }
}
