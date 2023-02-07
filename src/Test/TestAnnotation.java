package Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author : Ryans
 * Date : 2023/2/6
 * Introduction :
 */
public class TestAnnotation {

    public static void main(String[] args) {

    }

    @MyAnnotation
    private void test() {
        try {
            Class<?> aClass = Class.forName("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {

}
