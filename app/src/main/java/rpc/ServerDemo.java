package rpc;

public class ServerDemo {
    static void main() throws Exception {
        Server server = new Server();
        server.register("rpc.RPCService", new RPCServiceImpl());
        server.start(8000);
    }
}
