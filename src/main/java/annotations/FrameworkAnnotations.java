package annotations;

import enums.CategoryType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FrameworkAnnotations {

    /**
     * Store the authors who created the tests in String[]
     * Mandatory to enter a value
     */
    String[] author();
    /**
     * Stores the category in form of Enum Array. Include the possible values in {..enums.CategoryType}
     * Optional to enter a value
     */
    CategoryType[] category() default {};

}
