package rpc;

import java.io.EOFException;
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
            System.out.println("Listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                new Thread(() -> {
                    try {
                        Connector connector = new Connector(socket);
                        try {
                            while (true) {
                                RemoteCall call = (RemoteCall) connector.receive();
                                invoke(call);
                                connector.send(call);
                            }
                        } catch (EOFException e) {
                            System.out.println("Client disconnected: " + socket.getRemoteSocketAddress());
                        }
                        connector.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }
    }

    private void invoke(RemoteCall call) throws Exception {
        System.out.println("[Server] Received: " + call.getClassName() + "." + call.getMethodName());
        Class<?> clazz = Class.forName(call.getClassName());
        Method method = clazz.getMethod(call.getMethodName(), call.getParamTypes());

        Object instance = services.get(call.getClassName());
        Object result = method.invoke(instance, call.getParams());

        call.setResult(result);
        System.out.println("[Server] Result: " + call.getResult());
    }
}
