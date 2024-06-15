package Unit2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Lab3 {
    public static void main(String[] args) {
        try {
            InetAddress inetaddtype = InetAddress.getByName("224.0.0.2");
            System.out.println("Any local address: "+inetaddtype.isAnyLocalAddress());
            System.out.println("loopback address: "+inetaddtype.isLoopbackAddress());
            System.out.println("link local address: "+inetaddtype.isLinkLocalAddress());
            System.out.println("site local address: "+inetaddtype.isSiteLocalAddress());
            System.out.println("multicast address: "+inetaddtype.isMulticastAddress());
            System.out.println("MC global address: "+inetaddtype.isMCGlobal());
            System.out.println("MC node address: "+inetaddtype.isMCNodeLocal());
            System.out.println("MC link local address: "+inetaddtype.isMCLinkLocal());
            System.out.println("MC site address: "+inetaddtype.isMCSiteLocal());
            System.out.println("MC org local address: "+inetaddtype.isMCOrgLocal());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
