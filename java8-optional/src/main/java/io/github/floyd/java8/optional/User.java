package io.github.floyd.java8.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor
public class User {

    @NonNull
    private String userName;
    private String password;
    @NonNull
    private Integer age;
    private Address address;
    @NonNull
    private Optional<Address> optAddress;

    public static String getStreet(Optional<User> user,
                                   int minAge) {
        return user
                .filter(user1 -> user1.getAge() >= minAge)
                .flatMap(User::getOptAddress)
                .map(Address::getStreet)
                .orElse("没有地址");
    }
}
