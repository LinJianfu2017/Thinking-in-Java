package com.linjianfu.chapter20;

import java.lang.annotation.*;

/**
 * 注解类以‘@interface’关键字定义，定义的同时可自注解（参考元注解）
 * I.4个元注解：专门负责注解其他的注解，用法：
 * . .@Target,表示该注解可用于什么地方。可能的ElementType参数包括：
 * .......CONSTRUCTOR/FIELD/METHOD/PACKAGE/PARAMETER/TYPE/LOCAL_VARIABLE等。
 * . .@Retention，表示需要在什么级别保存该注解信息。可选的RetentionPolicy参数包括：
 * .......SOURCE:注解将在编译阶段被丢弃；CLASS：注解保留到class文件，但会被VM丢弃；
 * .......RUNTIME：VM在运行期也保留注解，此时可通过反射机制读取注解信息。
 * . .@Documented，此注解将包含在Javadoc中。
 * . .@Inherited，表明允许子类继承父类中的注解。注解类本身不支持继承(到目前为止)。
 * II.注解元素：可用类型限于以下：
 * . .所有基本类型
 * . .String
 * . .Class
 * . .Enum类
 * . .Annotation
 * . .以及以上类型的数组
 * 如果使用了其他类型，编译器就会报错，此外，也不允许使用任何包装器类型。
 * 注解元素不能有不确定的值，要么default要么注解时提供。
 * 对于非基本类型的元素，不能以null作为其值。
 * III.Java内置的标准注解：
 * . .@Override
 * . .@Deprecated
 * . .@SuppressWarnings
 * . .其他未知
 */

//eg:

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Twenty1 {
    public String name() default "";

    int value() default 0;

    Test test() default @Test;
}
