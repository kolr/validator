package org.validation.annotation;

import org.validation.FieldTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 12.07.2016
 * Created by Rodion.
 */

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {
    FieldTypes type();

    String regexp() default "";
}
