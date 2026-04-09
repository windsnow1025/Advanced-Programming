package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public class TestConstructor {
    static void main() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName("java.math.BigDecimal");

        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
        }

        Constructor<?> constructor = clazz.getConstructor(String.class);
        BigDecimal bigDecimal = (BigDecimal) constructor.newInstance("3.14");
        System.out.println(bigDecimal);
    }
}
