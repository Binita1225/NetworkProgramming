package Unit2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Lab4 {
    public static void main(String[] args) {
        try {
            InetAddress inet1 = InetAddress.getByName("www.ibiblio.org");
            InetAddress inet2 = InetAddress.getByName("helios.ibiblio.org");
            System.out.println("is equals: "+ inet1.equals(inet2));
            System.out.println("hash code: "+ inet1.hashCode());
            System.out.println("string: " + Integer.toString(inet1.hashCode()));
            System.out.println("hash code: "+ inet2.hashCode());
            System.out.println("hash code as string: " + Integer.toString(inet2.hashCode()));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
