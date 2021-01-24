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
public class OperationAdd extends Operation {
    /**
     * 计算
     *
     * @return 返回计算结果
     */
    @Override
    double getResult() {
        double res = 0;
        res = getNumberA() + getNumberB();
        return res;
    }
}
