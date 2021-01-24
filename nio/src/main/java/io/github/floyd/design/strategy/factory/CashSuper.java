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
public abstract class CashSuper {
    /**
     * 商场促销打折类
     * @param money
     * @return
     */
    public abstract BigDecimal acceptCash(BigDecimal money);
}
