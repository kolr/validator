package org.validator;

import org.validation.FieldTypes;
import org.validation.annotation.Validate;
import org.validation.entities.Verifiable;

/**
 * 15.07.2016
 * Created by Rodion.
 * <p>
 * Entity was created just for tests.
 */
public class User implements Verifiable {

    @Validate(type = FieldTypes.NAME)
    private String name;

    @Validate(type = FieldTypes.NAME)
    private String lastname;

    @Validate(type = FieldTypes.EMAIL)
    private String email;

    @Validate(type = FieldTypes.PASSWORD)
    private String password;

    public User(String name, String lastname, String email, String password) {
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
