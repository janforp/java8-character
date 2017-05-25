package com.janita.annotation;

import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

/**
 * Created by Janita on 2017-05-25 19:44
 */
@Repeatable(MyAnnotationContainer.class)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "atguigu";
}
