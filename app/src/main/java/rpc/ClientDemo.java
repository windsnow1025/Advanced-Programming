package rpc;

public class ClientDemo {
    static void main() {
        RPCService service = (RPCService) DynamicProxyFactory.getProxy(
                RPCService.class, "localhost", 8000
        );
        System.out.println(service.request("hello"));
    }
}
