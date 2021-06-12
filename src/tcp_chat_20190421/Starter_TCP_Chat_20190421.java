package tcp_chat_20190421;

import java.util.Scanner;

/**
 *
 * @author MohamedAshraf
 */
public class Starter_TCP_Chat_20190421 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        if (scan.next().equalsIgnoreCase("server")) {

            Server_TCP_Chat_20190421 s = new Server_TCP_Chat_20190421();
        } else {

            Client_TCP_Chat_20190421 c = new Client_TCP_Chat_20190421();
        }
    }
}
