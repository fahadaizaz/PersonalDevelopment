package com.aizaz.samples.dto;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String gender;

    @Min(1)
    @Max(120)
    private int age;

    // @Valid annotation is not required for builderPattern validation example
    // Its only used here to show that bean validation is not triggered when
    // the instanced is managed by JVM instead of container.
    @Valid
    public User(String firstName, String lastName, String gender, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
