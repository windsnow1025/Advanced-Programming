package rpc;

import java.io.IOException;

public class Client implements AutoCloseable {
    private final Connector connector;

    public Client(String host, int port) throws IOException {
        this.connector = new Connector(host, port);
    }

    public Object getService(Class<?> serviceClass) {
        return ClientProxy.getProxy(serviceClass, connector);
    }

    @Override
    public void close() throws Exception {
        connector.close();
    }
}
