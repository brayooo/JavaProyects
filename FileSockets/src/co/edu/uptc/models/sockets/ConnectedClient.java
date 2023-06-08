package co.edu.uptc.models.sockets;

import java.net.Socket;

public class ConnectedClient {

    private Socket socket;

    public ConnectedClient(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
