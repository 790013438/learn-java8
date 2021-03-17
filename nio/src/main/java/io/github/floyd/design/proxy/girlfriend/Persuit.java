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
 * date 2021/1/29
 * @see *#
 */
public class Persuit implements GiveGift {

    private SchoolGirl mm;

    public Persuit(SchoolGirl schoolGirl) {
        this.mm = schoolGirl;
    }

    /**
     * 送洋娃娃
     */
    @Override
    public void giveDolls() {
        System.out.println(mm.getName() + "送你洋娃娃");
    }

    /**
     * 送花
     */
    @Override
    public void giveFlowers() {
        System.out.println(mm.getName() + "送你鲜花");
    }

    /**
     * 送巧克力
     */
    @Override
    public void giveChocolate() {
        System.out.println(mm.getName() + "送你巧克力");
    }
}
