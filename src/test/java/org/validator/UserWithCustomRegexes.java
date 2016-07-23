package org.validator;

import org.validation.FieldTypes;
import org.validation.annotation.Validate;
import org.validation.entities.Verifiable;

/**
 * 23.07.2016
 * Created by Rodion.
 */
public class UserWithCustomRegexes implements Verifiable {

    @Validate(regexp = "[a-zA-Zа-яА-Я]{3,30}")
    private String name;

    @Validate(regexp = "[a-zA-Zа-яА-Я]{3,30}")
    private String lastname;

    @Validate(regexp = "[A-Za-z0-9._%-]+@[A-Za-z0-9._%-]+\\.[A-Za-z]{2,4}")
    private String email;

    @Validate(regexp = "[^!\"№;%:?*()_]{8,30}")
    private String password;

    public UserWithCustomRegexes(String name, String lastname, String email, String password) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
