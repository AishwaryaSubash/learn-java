import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.*;

class Customer implements Serializable {
    private String name;
    private String email;
    private transient String password;

    public Customer(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "\n" +
                "Name : " + name + " \n" +
                "Email : " + email + " \n" +
                "Password : " + password;
    }
}

public class CustomerApp {
    private static final String SECRET_KEY = "ThisIsASecretKey";

    private static byte[] serializeAndEncrypt(Customer customer) {
        try {
            ByteArrayOutputStream opStream = new ByteArrayOutputStream();
            ObjectOutputStream objOpStream = new ObjectOutputStream(opStream);
            objOpStream.writeObject(customer);
            objOpStream.close();
            byte[] serData = opStream.toByteArray();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(SECRET_KEY.getBytes(), "AES"));
            return cipher.doFinal(serData);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Customer decryptAndDeserialize(byte[] encData) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(SECRET_KEY.getBytes(), "AES"));
            byte[] decData = cipher.doFinal(encData);
            ByteArrayInputStream ipStream = new ByteArrayInputStream(decData);
            ObjectInputStream objIpStream = new ObjectInputStream(ipStream);
            return (Customer) objIpStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Customer customer = new Customer("Aishwarya", "aishwarya@gmail.com", "pass123");
        byte[] serEncData = serializeAndEncrypt(customer);
        Customer decData = decryptAndDeserialize(serEncData);
        System.out.println("Decrypted Customer " + decData);
    }

}
