package io.github.floyd.design.strategy;

import io.github.floyd.design.strategy.Strategy;

/**
 * 此类的主要功能是： <br/>
 * 1. 处理<br/>
 * 此类提供的主要方法有：<br/>
 * 1.
 *
 * @author chengmiao
 * @version 1.0
 * ClassName io.github.floyd.design.strategy.factory
 * Company: com.yinhai
 * date 2021/1/3

 */
public class Context {
    Strategy strategy;
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInterface() {
        strategy.algorithmInterface();
    }
}
