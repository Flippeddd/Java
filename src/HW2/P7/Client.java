package HW2.P7;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket =  new Socket("localhost", 3000);
        try (InputStream input = socket.getInputStream()) {
            try (OutputStream output = socket.getOutputStream()) {
                handle(input, output);
            }
        }
    }

    private static void handle(InputStream input, OutputStream output) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        System.out.println("Connected! \n");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("[Client]: ");
            String s = scanner.nextLine();
            writer.write(s);
            writer.newLine();
            writer.flush();
            String respond = reader.readLine();
            System.out.println("[Server]: " + respond);
            if (respond.equals("Server closed")) {
                break;
            }
        }
    }
}
