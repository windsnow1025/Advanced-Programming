package reflection;

import java.lang.reflect.Field;

public class FieldDemo {
    static void main() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        User user = new User("Alice", 25, "user");
        System.out.println("before: " + user);

        Class<?> clazz = Class.forName("reflection.User");

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(user, "Bob");

        System.out.println("after:  " + user);
    }
}
