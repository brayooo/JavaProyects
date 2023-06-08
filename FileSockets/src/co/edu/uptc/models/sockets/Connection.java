package co.edu.uptc.models.sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Connection {

    private ServerSocket serverSocket;
    private Socket socket;
    private String host;
    private int port;
    private String role;

    public Connection(String role) {
        this.role = role;
    }

    public void connection() {
        switch (role) {
            case "server" -> {
                try {
                    serverSocket = new ServerSocket(port);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            case "client" -> {
                try {
                    socket = new Socket(host, port);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public String getHost() {
        return host;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}
