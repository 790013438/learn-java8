package io.github.floyd.design.strategy.factory;

import java.math.BigDecimal;

/**
 * 此类的主要功能是：满减 <br/>
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
public class CashReturn extends CashSuper {

    private BigDecimal moneyCondition = BigDecimal.ZERO;
    private BigDecimal moneyReturn = BigDecimal.ZERO;

    public CashReturn(BigDecimal moneyCondition, BigDecimal moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    /**
     * 商场促销打折类
     *
     * @param money 满减类型
     * @return 返回满减类型
     */
    @Override
    public BigDecimal acceptCash(BigDecimal money) {
        BigDecimal result = money;
        if (money.compareTo(moneyCondition) >= 0) {
            result = money.subtract(money.divide(moneyCondition, BigDecimal.ROUND_DOWN).multiply(moneyReturn));
        }
        return result;
    }
}
