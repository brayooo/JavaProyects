package co.edu.uptc.models.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Server {

    private Connection con;
    private Socket socket;
    private DataOutputStream outputStream;
    private DataInputStream inputStream;
    private List<ConnectedClient> connectedClients;

    public Server(String host, int port) {
        connectedClients = new ArrayList<>();
        init(host, port);
        acceptClients();
    }

    public void init(String host, int port) {
        con = new Connection("server");
        con.setHost(host);
        con.setPort(port);
        con.connection();
    }

    public void acceptClients() {
        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    socket = con.getServerSocket().accept();
                    ConnectedClient connectedClient = new ConnectedClient(socket);
                    connectedClients.add(connectedClient);
                }
            } catch (IOException e) {
                throw new RuntimeException();
            }
        });
        thread.start();
    }

    public void sendInfo(String info) {
            for (int i = 0; i < connectedClients.size(); i++) {
                try {
                Socket socket1 = connectedClients.get(i).getSocket();
                outputStream = new DataOutputStream(socket1.getOutputStream());
                outputStream.writeUTF(info);
                } catch (IOException e) {
                    System.out.println("Client " + connectedClients.get(i).getSocket() + " desconectado");
                    connectedClients.remove(connectedClients.get(i));
                    e.printStackTrace();
                    break;
                }
            }
    }

}
