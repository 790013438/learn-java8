package io.github.floyd.java8.optional;

import lombok.Data;

import java.util.Optional;

@Data
public class User {

    private String userName;
    private String password;
    private Integer age;
    private Address address;
    private Optional<Address> optAddress;
}
