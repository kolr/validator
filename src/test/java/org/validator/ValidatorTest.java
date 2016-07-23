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
    private static final String CORRECT_AGE = "22";

    private static final String INCORRECT_EMAIL = "john.doe@example";
    private static final String INCORRECT_NAME = "John1";
    private static final String INCORRECT_LASTNAME = "Do1e";
    private static final String INCORRECT_PASSWORD = "pass";
    private static final String INCORRECT_AGE = "ff1";

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

    @Test
    public void customUserTest() {
        CustomUser correctUser = new CustomUser(CORRECT_NAME, CORRECT_LASTNAME, CORRECT_EMAIL, CORRECT_PASSWORD, CORRECT_AGE);
        boolean result = validationManager.validate(correctUser, CustomUser.class);

        Assert.assertTrue(result);
    }

    @Test
    public void customUserIncorrectTest() {
        CustomUser correctUser = new CustomUser(CORRECT_NAME, CORRECT_LASTNAME, CORRECT_EMAIL, CORRECT_PASSWORD, INCORRECT_AGE);
        boolean result = validationManager.validate(correctUser, CustomUser.class);

        Assert.assertFalse(result);
    }

    // With custom regular expressions.

    @Test
    public void testWithCustomRegexes() {
        UserWithCustomRegexes correctUser = new UserWithCustomRegexes(CORRECT_NAME, CORRECT_LASTNAME, CORRECT_EMAIL, CORRECT_PASSWORD);
        boolean result = validationManager.validate(correctUser, UserWithCustomRegexes.class);

        Assert.assertTrue(result);
    }

    @Test
    public void incorrectEmailTestWithCustomRegexes() {
        UserWithCustomRegexes correctUser = new UserWithCustomRegexes(CORRECT_NAME, CORRECT_LASTNAME, INCORRECT_EMAIL, CORRECT_PASSWORD);
        boolean result = validationManager.validate(correctUser, UserWithCustomRegexes.class);

        Assert.assertFalse(result);
    }

    @Test
    public void incorrectNameTestWithCustomRegexes() {
        UserWithCustomRegexes correctUser = new UserWithCustomRegexes(INCORRECT_NAME, CORRECT_LASTNAME, CORRECT_EMAIL, CORRECT_PASSWORD);
        boolean result = validationManager.validate(correctUser, UserWithCustomRegexes.class);

        Assert.assertFalse(result);
    }

    @Test
    public void incorrectLastNameTestWithCustomRegexes() {
        UserWithCustomRegexes correctUser = new UserWithCustomRegexes(CORRECT_NAME, INCORRECT_LASTNAME, CORRECT_EMAIL, CORRECT_PASSWORD);
        boolean result = validationManager.validate(correctUser, UserWithCustomRegexes.class);

        Assert.assertFalse(result);
    }

    @Test
    public void incorrectPasswordTestWithCustomRegexes() {
        UserWithCustomRegexes correctUser = new UserWithCustomRegexes(CORRECT_NAME, CORRECT_LASTNAME, CORRECT_EMAIL, INCORRECT_PASSWORD);
        boolean result = validationManager.validate(correctUser, UserWithCustomRegexes.class);

        Assert.assertFalse(result);
    }

    @Test
    public void incorrectAllTestWithCustomRegexes() {
        UserWithCustomRegexes correctUser = new UserWithCustomRegexes(INCORRECT_NAME, INCORRECT_LASTNAME, INCORRECT_EMAIL, INCORRECT_PASSWORD);
        boolean result = validationManager.validate(correctUser, UserWithCustomRegexes.class);

        Assert.assertFalse(result);
    }

}

