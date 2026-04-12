package rpc;

public class RPCServiceImpl implements RPCService {
    @Override
    public String request(String message) {
        return "Received: " + message;
    }
}
