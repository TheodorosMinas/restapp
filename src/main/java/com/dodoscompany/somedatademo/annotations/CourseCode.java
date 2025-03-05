package com.dodoscompany.somedatademo.annotations;


import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
//@CourseCode(value="LUV", message="must start with LUV")
    public String value() default "LUV";
    public String message() default "must start with LUV";
    public Class<?>[] groups() default {};
    public Class<?>[] payload() default {};

}
