package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingHandler implements InvocationHandler {
    private final Object target;

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Loggable.class)) {
            System.out.println("[LOG] before " + method.getName());
            Object result = method.invoke(target, args);
            System.out.println("[LOG] after " + method.getName());
            return result;
        }
        return method.invoke(target, args);
    }
}
