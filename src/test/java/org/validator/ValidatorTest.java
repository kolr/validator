package org.validator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.validation.ValidationManager;

/**
 * 15.07.2016
 * Created by Rodion.
 */
public class ValidatorTest {
    private static final String CORRECT_EMAIL = "john.doe@example.com";
    private static final String CORRECT_NAME = "John";
    private static final String CORRECT_LASTNAME = "Doe";
    private static final String CORRECT_PASSWORD = "password1";

    private static final String INCORRECT_EMAIL = "john.doe@example";
    private static final String INCORRECT_NAME = "John1";
    private static final String INCORRECT_LASTNAME = "Do1e";
    private static final String INCORRECT_PASSWORD = "pass";

    private static ValidationManager validationManager;

    @BeforeClass
    public static void setUp() {
        validationManager = new ValidationManager();
    }

    @Test
    public void test() {
        User correctUser = new User(CORRECT_NAME, CORRECT_LASTNAME, CORRECT_EMAIL, CORRECT_PASSWORD);
        boolean result = validationManager.validate(correctUser, User.class);

        Assert.assertTrue(result);
    }

    @Test
    public void incorrectEmailTest() {
        User correctUser = new User(CORRECT_NAME, CORRECT_LASTNAME, INCORRECT_EMAIL, CORRECT_PASSWORD);
        boolean result = validationManager.validate(correctUser, User.class);

        Assert.assertFalse(result);
    }

    @Test
    public void incorrectNameTest() {
        User correctUser = new User(INCORRECT_NAME, CORRECT_LASTNAME, CORRECT_EMAIL, CORRECT_PASSWORD);
        boolean result = validationManager.validate(correctUser, User.class);

        Assert.assertFalse(result);
    }

    @Test
    public void incorrectLastNameTest() {
        User correctUser = new User(CORRECT_NAME, INCORRECT_LASTNAME, CORRECT_EMAIL, CORRECT_PASSWORD);
        boolean result = validationManager.validate(correctUser, User.class);

        Assert.assertFalse(result);
    }

    @Test
    public void incorrectPasswordTest() {
        User correctUser = new User(CORRECT_NAME, CORRECT_LASTNAME, CORRECT_EMAIL, INCORRECT_PASSWORD);
        boolean result = validationManager.validate(correctUser, User.class);

        Assert.assertFalse(result);
    }

    @Test
    public void incorrectAllTest() {
        User correctUser = new User(INCORRECT_NAME, INCORRECT_LASTNAME, INCORRECT_EMAIL, INCORRECT_PASSWORD);
        boolean result = validationManager.validate(correctUser, User.class);

        Assert.assertFalse(result);
    }
}

