package rpc;

import java.lang.reflect.Proxy;

public class ClientProxy {
    public static Object getProxy(Class<?> serviceClass, Connector connector) {
        return Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class<?>[] { serviceClass },
                (_, method, args) -> {
                    System.out.println("[Client] Calling: " + method.getName());
                    RemoteCall call = new RemoteCall(
                            serviceClass.getName(),
                            method.getName(),
                            method.getParameterTypes(),
                            args
                    );
                    connector.send(call);
                    call = (RemoteCall) connector.receive();
                    System.out.println("[Client] Result: " + call.getResult());
                    return call.getResult();
                }
        );
    }
}
