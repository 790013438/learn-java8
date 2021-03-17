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
public class SimpleFactory {
    /**
     * 简单工厂
     *
     * @param type 选择类型
     * @return 实用的类
     */
    public static Leifeng createLeifeng(String type) {
        Leifeng leifeng = null;
        switch (type) {
            case "学雷锋的大学生":
                leifeng = new Undergraduate();
                break;
            case "社区志愿者":
                leifeng = new Volunteer();
                break;
            default:
                throw new RuntimeException("不支持的类型");
        }
        return leifeng;
    }
}
