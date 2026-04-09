package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo {
    static void main() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User("Alice", 25, "admin");

        Class<?> clazz = Class.forName("reflection.User");

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        Method isAdult = clazz.getDeclaredMethod("isAdult");
        System.out.println("isAdult = " + isAdult.invoke(user));

        Method isAdmin = clazz.getDeclaredMethod("isAdmin");
        isAdmin.setAccessible(true);
        System.out.println("isAdmin = " + isAdmin.invoke(user));
    }
}
