package io.github.floyd.java8.nio.overload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Supplier;

/**
 * @author chengmiao
 * @version 1.0
 * ClassName io.github.floyd.java8.nio.overload
 * Description: 描述 使用反射调用，参数是一个接口，一个接口的实现类，一个抽象类，一个抽象类的继承抽象类，一个抽象类的实现类，都符合重载吗
 * Company: com.yinhai
 * date 2019/3/14
 */
public class ReflectRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectRepository.class);

    void haHa(Supplier<String> stringSupplier) {
        LOGGER.debug(stringSupplier.get());
    }

    private void haHa(StringSupplier stringSupplier) {
        LOGGER.debug("stringSupplier, Supplier的继承类{}", stringSupplier.get());
    }

    public static class StringSupplier implements Supplier<String> {

        /**
         * Gets a result.
         *
         * @return a result
         */
        @Override
        public String get() {
            return "这是supplier的继承类，虽然时继承了supplier, 但是和参数列表为supplier的方法不同，是重载overload的方法";
        }
    }

    public static void main(String... args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Class.forName("io.github.floyd.java8.nio.overload.ReflectRepository").getDeclaredMethod("haHa", Supplier.class);
        method.invoke(new ReflectRepository(), (Supplier<String>) () -> "根据接口调用");

        Method method1 = Class.forName("io.github.floyd.java8.nio.overload.ReflectRepository").getDeclaredMethod("haHa", io.github.floyd.java8.nio.overload.ReflectRepository.StringSupplier.class);
        method1.invoke(new ReflectRepository(), new StringSupplier());
    }
}
