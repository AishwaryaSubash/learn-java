import java.io.*;
import java.net.*;

public class DataTransfer {
    static final int PORT = 12345;

    public static void main(String[] args) {
        new Thread(new Sender()).start();
        new Thread(new Receiver()).start();
    }

    static class Sender implements Runnable {
        @Override
        public void run() {
            try (Socket socket = new Socket("localhost", PORT);
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {
                DataObject dataObject = new DataObject("Hello, receiver!");
                outputStream.writeObject(dataObject);
                System.out.println("Sent: " + dataObject);
                Thread.sleep(1000);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Receiver implements Runnable {
        @Override
        public void run() {
            try (ServerSocket serverSocket = new ServerSocket(PORT);
                    Socket socket = serverSocket.accept();
                    ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {
                DataObject receivedObject = (DataObject) inputStream.readObject();
                System.out.println("Received: " + receivedObject);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    static class DataObject implements Serializable {
        private String message;

        public DataObject(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "DataObject\n" +
                    "Message: " + message + "\n";
        }
    }
}
