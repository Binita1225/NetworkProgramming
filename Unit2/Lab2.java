package Unit2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Lab2 {
    public static void main(String[] args) {
        try {
            // Initialize InetAddress using a hostname
            InetAddress inetAddress = InetAddress.getByName("www.google.com");
            System.out.println("InetAddress using hostname 'www.google.com': " + inetAddress);
            System.out.println("Host Name: " + inetAddress.getHostName());
            System.out.println("Canonical Host Name: " + inetAddress.getCanonicalHostName());
            System.out.println("Address (byte array): " + Arrays.toString(inetAddress.getAddress()));
            System.out.println("Host Address: " + inetAddress.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
