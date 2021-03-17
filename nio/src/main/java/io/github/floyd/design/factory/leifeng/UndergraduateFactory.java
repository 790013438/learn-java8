package io.github.floyd.design.factory.leifeng;

/**
 * 此类的主要功能是： <br/>
 * 1. 处理<br/>
 * 此类提供的主要方法有：<br/>
 * 1.
 *
 * @author chengmiao
 * @version 1.0
 * ClassName io.github.floyd.design.factory.leifeng
 * Company: com.yinhai
 * date 2021/2/12
 * @see *#
 */
public class UndergraduateFactory implements Factory {
    /**
     * 定义接口创建
     *
     * @return
     */
    @Override
    public Leifeng createLeifeng() {
        return new Undergraduate();
    }
}
