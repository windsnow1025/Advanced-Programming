package aop;

import java.lang.reflect.Proxy;

public class AOPDemo {
    static void main() {
        Vehicle vehicle = (Vehicle) Proxy.newProxyInstance(
                Train.class.getClassLoader(),
                Train.class.getInterfaces(),
                new LoggingHandler(new Train())
        );
        vehicle.drive();

        Accommodation accommodation = (Accommodation) Proxy.newProxyInstance(
                Inn.class.getClassLoader(),
                Inn.class.getInterfaces(),
                new LoggingHandler(new Inn())
        );
        accommodation.checkIn(3);
    }
}
