package rpc;

import java.lang.reflect.Proxy;

public class DynamicProxyFactory {
    public static Object getProxy(Class<?> serviceClass, String host, int port) {
        return Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class<?>[] { serviceClass },
                (_, method, args) -> {
                    Connector connector = new Connector(host, port);
                    RemoteCall call = new RemoteCall(
                            serviceClass.getName(),
                            method.getName(),
                            method.getParameterTypes(),
                            args
                    );
                    connector.send(call);
                    call = (RemoteCall) connector.receive();
                    connector.close();
                    return call.getResult();
                }
        );
    }
}
