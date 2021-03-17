package io.github.floyd.design.proxy;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;

/**
 * 此类的主要功能是： <br/>
 * 1. 处理<br/>
 * 此类提供的主要方法有：<br/>
 * 1.
 *
 * @author chengmiao
 * @version 1.0
 * ClassName io.github.floyd.design.proxy
 * Company: com.yinhai
 * date 2021/2/1
 * @see *#
 */
public class ProxyMain {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();

        LocalDate a = LocalDate.now();
        System.out.println(a.isLeapYear());

        for (int i = 0; i < 2050; ++i) {
            System.out.println(new StringBuilder(30)
                    .append("数字:").append(i)
                    .append(",对应2进制：")
                    .append(Integer.toBinaryString(i)).append(", 能被4整除").append(i % 4 == 0)
                    .append(",是闰年：").append(IsoChronology.INSTANCE.isLeapYear(i)).toString());
        }
    }
}
