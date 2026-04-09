package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// Dynamic Proxy
public class ProxyHandler implements InvocationHandler {
    Object object;

    public ProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Booking...");
        System.out.println("Booking confirmed...");
        // before
        System.out.println("Verifying ID...");
        Object result = method.invoke(object, args);
        // after
        System.out.println("Printing invoice...");
        System.out.println("Managing rewards...");

        return result;
    }
}
