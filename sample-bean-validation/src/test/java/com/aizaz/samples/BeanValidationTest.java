package com.aizaz.samples;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import com.aizaz.samples.dto.User;

import static org.junit.Assert.assertEquals;

public class BeanValidationTest {

    private static Validator validator;

    @BeforeClass
    public static void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void validateFirstName() {
        User user = new User(null, "Lastname", "gender", 10);
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertEquals(1, violations.size());
        assertEquals("may not be null", violations.iterator().next().getMessage());
    }

    @Test
    public void validateLastName() {
        User user = new User("Firstname", null, "gender", 10);
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertEquals(1, violations.size());
        assertEquals("may not be null", violations.iterator().next().getMessage());
    }

    @Test
    public void validateGender() {
        User user = new User("Firstname", "Lastname", null, 10);
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertEquals(1, violations.size());
        assertEquals("may not be null", violations.iterator().next().getMessage());
    }

    @Test
    public void ageTooSmall() {
        User user = new User("Firstname", "Lastname", "gender", 0);
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertEquals(1, violations.size());
        assertEquals("must be greater than or equal to 1", violations.iterator().next().getMessage());
    }

    @Test
    public void ageTooBig() {
        User user = new User("Firstname", "Lastname", "gender", 121);
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertEquals(1, violations.size());
        assertEquals("must be less than or equal to 120", violations.iterator().next().getMessage());
    }
}
