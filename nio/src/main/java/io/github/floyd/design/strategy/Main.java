package io.github.floyd.design.strategy;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

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
 * date 2021/1/3

 */
public class Main {
    public static void main(String[] args) {
        Context context;
        context = new Context(new ConcreteStrategyA());
        context.contextInterface();

        context = new Context(new ConcreteStrategyB());
        context.contextInterface();

        context = new Context(new ConcreteStrategyC());
        context.contextInterface();

        String[] memoArr = {"；开户名称：袁世碧3；银行行号：01；银行账号：4402218001003945118  ", "；开户名称：袁世碧；银行行号：01；银行账号：4402218001003945118", "银行行号：01；银行账号：6217214402035363708", "none；开户名称：纪光先；银行行号：02；银行账号：6214663800423497"};
        for (String memo: memoArr) {
            Pattern pattern = compile("(?<=开户名称：)(\\W|\\w)+(?=；)");
            Matcher matcher = pattern.matcher(memo);
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
            Pattern patternAae008 = compile("(?<=银行行号：)[a-zA-Z0-9-]+");
            Matcher aae008 = patternAae008.matcher(memo);
            while (aae008.find()) {
                System.out.println(aae008.group());
            }
            Pattern patternAae010 = compile("(?<=银行[账帐]号：)[a-zA-Z0-9-]+");
            Matcher aae0010 = patternAae010.matcher(memo);
            while (aae0010.find()) {
                System.out.println(aae0010.group());
            }
            System.out.println("=============================================");
        }
        System.out.println("0003".matches("^\\d+$"));

        // localDate 转 date
        Date date1 = Date.from(LocalDate.of(2019, 12, 25).atStartOfDay(ZoneOffset.ofHours(8)).toInstant());
        System.out.println(date1);
        Date date2 = new Date(LocalDate.of(2019, 12, 25).toEpochDay());
        System.out.println(date2);

        String a = new String("123");
        System.out.println(a);
    }
}
