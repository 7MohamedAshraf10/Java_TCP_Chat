package tcp_chat_20190421;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MohamedAshraf
 */
public class Server_TCP_Chat_20190421 {

    Server_TCP_Chat_20190421() {
        try {
            ServerSocket server = new ServerSocket(22000);

            while (true) {
                Socket client = server.accept();

                DataInputStream clientReadSource = new DataInputStream(client.getInputStream());
                DataOutputStream clientWriteSource = new DataOutputStream(client.getOutputStream());
                
                while(true){
                
                clientWriteSource.writeUTF("Your connected but not for long!");
                clientWriteSource.writeUTF("You can only ask me once!");

                String str = clientReadSource.readUTF();
                System.out.println("Client said: " + str);
                if (str.equalsIgnoreCase("exit")) {
                    break;
                }
                clientWriteSource.writeUTF("We have no services right now!");
            
                }
            clientWriteSource.close();
            clientReadSource.close();
            client.close();
        }
        } catch (IOException ex) {
            Logger.getLogger(Server_TCP_Chat_20190421.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
