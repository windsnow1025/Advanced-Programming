package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyDemo {
    static void main() {
        Agent agent = new Agent(new Train());
        agent.drive();

        Accommodation accommodation = (Accommodation) Proxy.newProxyInstance(
                Inn.class.getClassLoader(),
                Inn.class.getInterfaces(),
                new ProxyHandler(new Inn())
        );
        accommodation.checkIn(3);
    }
}
