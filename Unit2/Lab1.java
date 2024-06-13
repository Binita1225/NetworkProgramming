package Unit2;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Lab1 {

    public static void main(String[] args) {
        try {
            // Initialize InetAddress using a hostname
            InetAddress inetAddressByName = InetAddress.getByName("www.google.com");
            System.out.println("InetAddress using hostname 'www.google.com': " + inetAddressByName);

            // Initialize InetAddress using an IP address and get the hostname
            InetAddress inetAddressByIp = InetAddress.getByName("216.58.196.164");
            System.out.println("Hostname from IP address '216.58.196.164': " + inetAddressByIp.getHostName());

            // Get and display all IP addresses of the name "www.oreilly.com"
            InetAddress[] inetAddressesOReilly = InetAddress.getAllByName("www.oreilly.com");
            System.out.println("All IP addresses for 'www.oreilly.com':");
            for (InetAddress address : inetAddressesOReilly) {
                System.out.println(address);
            }

            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("Local address of the machine: " + localAddress);

            // Initialize InetAddress using the IP address 13.227.138.129
            InetAddress inetAddress = InetAddress.getByName("13.227.138.129");
            // Display the contents stored by the InetAddress object
            System.out.println("InetAddress object for IP 13.227.138.129: " + inetAddress);

            byte[] ipAddr = { (byte)202, (byte)25, (byte)1, (byte)152 };

            // Define InetAddress object using the IP address
            InetAddress inetAddress2 = InetAddress.getByAddress("www.xyz.com", ipAddr);

            // Display the contents stored by the InetAddress object
            System.out.println("InetAddress object for hostname 'www.xyz.com' and IP '202.25.1.152': " + inetAddress2);


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}