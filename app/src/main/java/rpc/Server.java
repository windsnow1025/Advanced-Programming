package rpc;

import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private final Map<String, Object> services = new HashMap<>();

    public void register(String className, Object instance) {
        services.put(className, instance);
    }

    public void start(int port) throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            Socket socket = serverSocket.accept();
            Connector connector = new Connector(socket);

            RemoteCall call = (RemoteCall) connector.receive();
            invoke(call);
            connector.send(call);

            connector.close();
        }
    }

    private void invoke(RemoteCall call) throws Exception {
        Class<?> clazz = Class.forName(call.getClassName());
        Method method = clazz.getMethod(call.getMethodName(), call.getParamTypes());

        Object instance = services.get(call.getClassName());
        Object result = method.invoke(instance, call.getParams());

        call.setResult(result);
    }
}
