package com.aizaz.samples.builder;

import javax.validation.Valid;

import com.aizaz.samples.dto.User;

public class UserBuilder {

    private String firstName;
    private String lastName;
    private String gender;
    private int age;

    public UserBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public UserBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    @Valid
    public User build() {
        return new User(firstName, lastName, gender, age);
    }

}
