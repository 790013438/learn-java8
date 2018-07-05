package io.github.floyd.java8.optional;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalDemo {

    /**
     * 1. 创建 Optional
     */
    public void createOptional() {
        // 声明一个空的Optional
        Optional<Address> optionalAddress = Optional.empty();

        // 依据一个非空值创建Optional
        Optional<Address> optionalAddress2 = Optional.of(new Address());

        // 可接受null的Optional
        Address address = null;
        Optional<Address> optionalAddress3 = Optional.ofNullable(address);
    }

    /**
     * 2. 使用 map 从 Optional 对象中提取和转换值
     */
    public void map() {
        Optional<Address> addressOptional = Optional.of(new Address("达尔文路", "88号"));
        Optional<String> street = addressOptional.map(Address::getStreet);
    }

    /**
     * 3. 使用 flatMap 链接 Optional 对象
     */
    public void flatMap() {
        User user = new User();
        Optional<User> userOptional = Optional.of(user);
        Optional<String> add = userOptional.flatMap(User::getOptAddress)
        .map(Address::getStreet);
    }

    /**
     * 4. 默认行为及解引用 Optional 对象
     */
    public void defaultValue() {
        Optional<Address> addressOptional = Optional.empty();
        String street = addressOptional.map(Address::getStreet)
            .orElse("北京二环");
        System.out.println(street);
    }

    public static void main(String[] args) {
        User user = new User();
        user.setUserName("floyd");
        user.setPassword("123456");
        user.setOptAddress(Optional.of(new Address("达尔文路", "88号")));

        /* 符合判断条件输出 */
        user.getOptAddress().filter(address -> address.getDoor().contains("88"))
            .ifPresent(System.out::println);

        /* 给出判断是否有符合过滤条件的情况 */
        boolean present = user.getOptAddress()
            .filter(address -> address.getDoor().contains("878"))
            .isPresent();
        System.out.println(present);

        /* 抛出异常 */
//        user.setOptAddress(Optional.empty());
//        Address address1 = null;
//        try {
//            address1 = user.getOptAddress()
//                    .filter(address -> address.getDoor().contains("878"))
//                    .orElseThrow((Supplier<Throwable>) () -> new Exception("挂了"));
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        System.out.println(address1);

        test();
    }

    private static void test() {
        Optional<User> optionalUser = Optional.of(User
                .of(
                        "古天乐",
                        12,
                        Optional.of(new Address("倪家桥", "5-1-2402"))));
        System.out.println(User.getStreet(optionalUser, 1));
        System.out.println(User.getStreet(optionalUser, 12));
        System.out.println(User.getStreet(optionalUser, 13));
    }
}
