package Test;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * Author : Ryans
 * Date : 2023/2/6
 * Introduction : 测试反射
 */
public class TestReflect {

    public static void main(String[] args) {
        try {
            System.out.println(Class.forName("java.lang.String").hashCode());
            System.out.println(Class.forName("java.lang.String").hashCode());
            System.out.println(Class.forName("java.lang.String").hashCode());
            System.out.println("".getClass().hashCode());
            System.out.println(String.class.hashCode());
            System.out.println(Integer.TYPE);
            System.out.println(new Object().getClass().getSuperclass());
            System.out.println(String[].class);
            System.out.println(int[][].class);
            System.out.println(ElementType.class);
            System.out.println(void.class);
            System.out.println(Class.class);
            System.out.println("---------------反射获取注解-----------------------");
            Class c1 = Class.forName("Test.Student");
            Table table = (Table) c1.getDeclaredAnnotation(Table.class);
            System.out.println(table.value());
            Field[] fields = c1.getDeclaredFields();
            for (Field field : fields) {
                Column column = (Column) field.getAnnotation(Column.class);
                System.out.println("Name: " + column.value());
                System.out.println("Type: " + column.type());
                System.out.println("length: " + column.length());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

@Table("db_student")
class Student {

    @Column(value = "uid", type = "int", length = 10)
    private int id;
    @Column(value = "name", type = "varchar", length = 20)
    private String name;
    @Column(value = "age", type = "int", length = 2)
    private int age;
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table{
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Column{
    String value();
    String type();
    int length() default 10;
}
