package io.github.floyd.design.factory;

import io.github.floyd.design.simpleFactory.Operation;

/**
 * 此类的主要功能是： <br/>
 * 1. 创建运算操作接口<br/>
 * 此类提供的主要方法有：<br/>
 * 1.
 *
 * @author chengmiao
 * @version 1.0
 * ClassName io.github.floyd.design.factory
 * Company: com.yinhai
 * date 2021/2/3
 * @see *#
 */
public interface Factory {
    /**
     * 创建运算操作
     * @return
     */
    Operation createOperation();
}
