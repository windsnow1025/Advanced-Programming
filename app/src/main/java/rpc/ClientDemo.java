package rpc;

import java.util.Scanner;

public class ClientDemo {
    static void main() throws Exception {
        try (Client client = new Client("localhost", 8000);
             Scanner scanner = new Scanner(System.in)) {
            RPCService service = (RPCService) client.getService(RPCService.class);

            System.out.println("Type a message (or 'exit' to quit):");
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if ("exit".equals(input)) break;
                System.out.println(service.request(input));
            }
        }
    }
}