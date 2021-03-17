package io.github.floyd.design.factory;

import io.github.floyd.design.simpleFactory.Operation;
import io.github.floyd.design.simpleFactory.OperationDiv;

/**
 * 此类的主要功能是： <br/>
 * 1. 处理<br/>
 * 此类提供的主要方法有：<br/>
 * 1.
 *
 * @author chengmiao
 * @version 1.0
 * ClassName io.github.floyd.design.factory
 * Company: com.yinhai
 * date 2021/2/5
 * @see *#
 */
public class DivFactory implements Factory {
    /**
     * 创建运算操作
     *
     * @return
     */
    @Override
    public Operation createOperation() {
        return new OperationDiv();
    }
}
