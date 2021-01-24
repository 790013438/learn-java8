package io.github.floyd.design.strategy.factory;

import java.math.BigDecimal;

/**
 * 此类的主要功能是： <br/>
 * 1. 处理<br/>
 * 此类提供的主要方法有：<br/>
 * 1.
 *
 * @author chengmiao
 * @version 1.0
 * ClassName io.github.floyd.design.strategy
 * Company: com.yinhai
 * date 2021/1/2

 */
public class CashFactory {
    public static CashSuper createCashAccept(String type) {
        CashSuper cashSuper = null;
        switch (type) {
            case "正常收费":
                cashSuper = new CashNormal();
                break;
            case "满300返100":
                cashSuper = new CashReturn(BigDecimal.valueOf(300L), BigDecimal.valueOf(100.0));
                break;
            case "打8折":
                cashSuper = new CashRebate(BigDecimal.valueOf(0.8));
                break;
            default:
        }
        return cashSuper;
    }
}
