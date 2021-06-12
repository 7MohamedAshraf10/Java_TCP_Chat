package tcp_chat_20190421;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MohamedAshraf
 */
public class Client_TCP_Chat_20190421 {

    Client_TCP_Chat_20190421() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println(ip);
            Socket other = new Socket(ip, 22000);

            Scanner scan = new Scanner(System.in);

            DataInputStream otherReadSource = new DataInputStream(other.getInputStream());
            DataOutputStream otherWriteSource = new DataOutputStream(other.getOutputStream());

            String str = "";
            while (true) {
                str = otherReadSource.readUTF();
                System.out.println(str);
                str = otherReadSource.readUTF();
                System.out.println(str);

                str = scan.nextLine();
                otherWriteSource.writeUTF(str);
                if (str.equalsIgnoreCase("exit")) {
                    break;
                }
                str = otherReadSource.readUTF();
                System.out.println(str);
            }
            otherWriteSource.close();
            otherReadSource.close();
            other.close();

        } catch (IOException ex) {
            Logger.getLogger(Client_TCP_Chat_20190421.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
