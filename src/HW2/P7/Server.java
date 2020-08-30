package HW2.P7;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        System.out.println("Server is running");
        while (true) {
            Socket socket = serverSocket.accept();
            Thread t = new Handler(socket);
            t.start();
        }
    }
}

class Handler extends Thread {
    Socket socket;

    public Handler (Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream input = socket.getInputStream()) {
            try (OutputStream output = socket.getOutputStream()) {
                handle(input, output);
            }
        } catch (IOException e) {
            try {
                socket.close();
            } catch (IOException e1){
                 System.out.println("Client disconnected");
            }
        }
    }

    private void handle(InputStream input, OutputStream output) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
//        writer.write("Server start...\n");
//        writer.flush();
        while (true) {
            String s = reader.readLine();
            if (s.equals("Close")) {
                writer.write("Server closed\n");
                writer.flush();
                break;
            }
            writer.write(s + "\n");
            writer.flush();
        }
    }
}

