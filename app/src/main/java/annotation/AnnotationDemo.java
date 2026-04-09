package annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

class MyClass {
    @MyAnnotation
    public void myMethod() {
        System.out.println("Execute method myMethod");
    }
}

class MyAnnotationProcessor {
    public static void process(Object object) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                System.out.println(LocalDateTime.now() + " method" + method.getName() + " execution started");
                method.invoke(object);
                System.out.println(LocalDateTime.now() + " method" + method.getName() + " execution completed");
            }
        }
    }
}

public class AnnotationDemo {
    static void main() throws InvocationTargetException, IllegalAccessException {
        MyClass myClass = new MyClass();
        MyAnnotationProcessor.process(myClass);
    }
}
