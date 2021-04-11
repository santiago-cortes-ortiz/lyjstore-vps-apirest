package lyjstoreapirest.demo.general_service;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Repositorio {
    @AliasFor(
            annotation = Component.class
    )
    String value() default "";
}
