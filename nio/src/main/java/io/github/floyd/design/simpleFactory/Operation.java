package io.github.floyd.design.simpleFactory;

/**
 * 此类的主要功能是： <br/>
 * 1. 处理<br/>
 * 此类提供的主要方法有：<br/>
 * 1.
 *
 * @author chengmiao
 * @version 1.0
 * ClassName io.github.floyd.design.simpleFactory
 * Company: com.yinhai
 * date 2020/12/19

 */
public abstract class Operation {
    protected double numberA = 0;
    protected double numberB = 0;

    /**
     * 计算
     * @return 返回计算结果
     */
    abstract double getResult();

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }
}
