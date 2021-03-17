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
public class Proxy implements GiveGift {

    /**
     * 代理的类
     */
    private Persuit gg;

    public Proxy(SchoolGirl mm) {
        this.gg = new Persuit(mm);
    }

    /**
     * 送洋娃娃
     */
    @Override
    public void giveDolls() {
        gg.giveDolls();
    }

    /**
     * 送花
     */
    @Override
    public void giveFlowers() {
        gg.giveFlowers();
    }

    /**
     * 送巧克力
     */
    @Override
    public void giveChocolate() {
        gg.giveChocolate();
    }
}
