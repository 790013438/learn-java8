package io.github.floyd.design.strategy.cashStrategy;

import io.github.floyd.design.strategy.factory.CashSuper;

import java.math.BigDecimal;

/**
 * 此类的主要功能是： <br/>
 * 1. 处理<br/>
 * 此类提供的主要方法有：<br/>
 * 1.
 *
 * @author chengmiao
 * @version 1.0
 * ClassName io.github.floyd.design.strategy.cashStrategy
 * Company: com.yinhai
 * date 2021/1/10

 */
public class CashContext {
    private CashSuper cashSuper;

    public CashContext(CashSuper cashSuper) {
        this.cashSuper = cashSuper;
    }

    public BigDecimal getResult(BigDecimal money) {
        return cashSuper.acceptCash(money);
    }
}
