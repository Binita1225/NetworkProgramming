package Networking;

import java.net.*;
import java.util.Enumeration;

public class InternetAddress {
    public static void main(String[] args) {

        try {
            //get by name
            InetAddress inetAddress = InetAddress.getByName("www.google.com");
            System.out.println(inetAddress);
            //Get Host Name
            InetAddress internetAddressList = InetAddress.getByName("142.250.194.68");
            System.out.println(inetAddress.getHostName());
            //get all by name
            InetAddress[] inetAddressList = InetAddress.getAllByName("www.google.com");
            for (int i = 0; i < inetAddressList.length; i++) {
                System.out.println("Address" + i + "" + inetAddressList[i]);
            }
            //getlocal host
            InetAddress inetAddressLocal = InetAddress.getLocalHost();
            System.out.println("Local host:" + inetAddressLocal);

            //get by address in byte form
            byte[] addressByte ={ 107,23, (byte) 216, (byte) 196};
            InetAddress inetbyte = InetAddress.getByAddress(addressByte);
            System.out.println("Get By address:"+ inetbyte.getHostAddress());

            InetAddress inetbyteHost = InetAddress.getByAddress("google.com",addressByte);
            System.out.println("Get By address and host:"+ inetbyteHost.getHostName());

            //get canonical host name
            InetAddress inetCanonical = InetAddress.getByName("142.250.194.68");
            System.out.println(inetCanonical.getCanonicalHostName());

            //get address
            InetAddress inetAdd = InetAddress.getByName("142.250.194.68");
            System.out.println(inetAdd.getAddress());

            //address type
            InetAddress inetAddressType = InetAddress.getByName("192.168.102.39");
            System.out.println(inetAddressType.isAnyLocalAddress());
            System.out.println(inetAddressType.isLoopbackAddress());
            System.out.println(inetAddressType.isLinkLocalAddress());
            System.out.println(inetAddressType.isSiteLocalAddress());
            System.out.println(inetAddressType.isMulticastAddress());
            System.out.println(inetAddressType.isMCGlobal());
            System.out.println(inetAddressType.isMCNodeLocal());
            System.out.println(inetAddressType.isMCLinkLocal());
            System.out.println(inetAddressType.isMCSiteLocal());
            System.out.println(inetAddressType.isMCOrgLocal());

            //isreachable for checking reachability
            System.out.println("Is reachable: " + inetAddressType.isReachable(600));
            //equals check
            InetAddress inetAddressEquql1 = InetAddress.getByName("192.168.102.39");
            InetAddress inetAddressEqual2 = InetAddress.getByName("192.168.102.39");
            System.out.println("Is equals: " + inetAddressEquql1.equals(inetAddressEqual2));
            System.out.println("To hash code "+ inetAddressEquql1.hashCode());
            System.out.println("To String "+ inetAddressEquql1.toString());

            Inet4Address inet4Address = (Inet4Address)Inet4Address.getByName("www.google.com");
            System.out.println("Inet4Address :"+ inet4Address);

            InetAddress inet6Address = Inet6Address.getByName("www.google.com");
            System.out.println("Inet6Address :"+ inet6Address);

            NetworkInterface networkInterface = NetworkInterface.getByName("eth0");
            System.out.println("NIC : "+ networkInterface);

            Enumeration enumerationAddress = networkInterface.getInetAddresses();
            while (enumerationAddress.hasMoreElements()){
                System.out.println("enumeration address :" + enumerationAddress.nextElement());
            }
            System.out.println(networkInterface.getName());
            System.out.println(networkInterface.getDisplayName());

            NetworkInterface networkInterface2 = NetworkInterface.getByInetAddress(inet4Address);
            System.out.println("Get by Inet : "+ networkInterface2);

            Enumeration networkInterface3 = NetworkInterface.getNetworkInterfaces();

            while (networkInterface3.hasMoreElements()){
                System.out.println("Network Interface: " + networkInterface3.nextElement());
            }
            System.out.println("Get by Enumeration : "+ networkInterface3);



        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }}
