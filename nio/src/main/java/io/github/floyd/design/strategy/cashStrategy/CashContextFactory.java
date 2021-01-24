package io.github.floyd.design.strategy.cashStrategy;

import io.github.floyd.design.strategy.factory.CashNormal;
import io.github.floyd.design.strategy.factory.CashRebate;
import io.github.floyd.design.strategy.factory.CashReturn;
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
 * date 2021/1/16

 */
public class CashContextFactory {
    CashSuper cashSuper = null;

    public CashContextFactory(String type) {
        switch (type) {
            case "正常收费":
                cashSuper = new CashNormal();
                break;
            case "满300返100":
                cashSuper = new CashReturn(BigDecimal.valueOf(300L), BigDecimal.valueOf(100L));
                break;
            case "打8折":
                cashSuper = new CashRebate(BigDecimal.valueOf(0.8));
                break;
            default:
        }
    }

    public BigDecimal getResult(BigDecimal money) {
        return cashSuper.acceptCash(money);
    }
}
