package io.github.floyd.java8.nio.channel;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Supplier;

/**
 * @author 程淼
 * @version 1.0
 * ClassName io.github.floyd.java8.nio.channel
 * Description: 描述
 * Company: com.yinhai
 * date 2019/2/25
 */
public class Checkout {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        CheckInterface check2 = new Check2Impl();
        check2.print();
        ((Check2Impl) check2).getLogger().debug(check2.supply());
        Class t = Check2Impl.class;
        Class reflectClazz = Class.forName("io.github.floyd.java8.nio.overload.ReflectRepository");
        Method method = reflectClazz.getDeclaredMethod("haHa", java.util.function.Supplier.class);
        method.setAccessible(true);
        method.invoke(reflectClazz.newInstance(), (Supplier<String>)() -> "调用成功吗");
    }
}
