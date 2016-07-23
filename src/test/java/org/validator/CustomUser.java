package org.validator;

import org.validation.FieldTypes;
import org.validation.annotation.Validate;
import org.validation.entities.Verifiable;

/**
 * 23.07.2016
 * Created by Rodion.
 */
public class CustomUser implements Verifiable {

    @Validate(type = FieldTypes.NAME)
    private String name;

    @Validate(type = FieldTypes.NAME)
    private String lastname;

    @Validate(type = FieldTypes.EMAIL)
    private String email;

    @Validate(type = FieldTypes.PASSWORD)
    private String password;

    @Validate(regexp = "[0-9]*")
    private String age;

    public CustomUser(String name, String lastname, String email, String password, String age) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.age = age;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
