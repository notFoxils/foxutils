package me.foxils.foxutils.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@SuppressWarnings("unused")
public @interface YamlDocumentPath {
    String documentPath() default "";
}
