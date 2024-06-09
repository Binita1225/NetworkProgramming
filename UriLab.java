package Chapter3;

import java.io.UnsupportedEncodingException;
import java.net.*;

public class UriLab {
    public static void main(String[] args) {
        URI uri;
        {
        try {
             uri = new URI("http://www.ibiblio.org/javafaq/books/jnp/index.html?isbn=1565922069#toc,");
            System.out.println("URI" + uri);

            URI absolute = new URI("http","//www.google.com", null);
            System.out.println("Absolute" + absolute);

            URI relative = new URI(null,"/abc/def",null);
            System.out.println("Relative" + relative);

            if (uri.isAbsolute()){
                System.out.println("This URI is absolute");

            } else if (uri.isOpaque()) {
                System.out.println("This URI is opaque");

            }

            System.out.println("Authority of uri " + uri.getAuthority());
            System.out.println("Fragment of uri " + uri.getFragment());
            System.out.println("Host of uri " + uri.getHost());
            System.out.println("path of uri " + uri.getPath());
            System.out.println("query of uri " + uri.getQuery());

            System.out.println("scheme of uri: " + uri.getScheme());
            System.out.println("scheme specific part of uri: " + uri.getSchemeSpecificPart());

            //resolving uri
            URI resolved = absolute.resolve(relative);
            System.out.println("A to R: " + resolved);
            URI relativize = relative.relativize(absolute);
            System.out.println("R to A: " + relativize );

            //Encoding decoding
            String encoding = URLEncoder.encode("Encoding is * Happening" , "UTF-8");
            System.out.println("Encoding: " + encoding);

            String decoding = URLDecoder.decode(encoding);
            System.out.println("decoding: " + decoding);

            //proxy server
            //system properties
            System.setProperty("http.proxyHost","192.168.245.245");
            System.setProperty("http.proxyPort","9000");

            //proxy class
            SocketAddress socketAddress = new InetSocketAddress("Proxy.example.com",80);
              Proxy proxy = new Proxy(Proxy.Type.HTTP, socketAddress);
            System.out.println("Proxy: " + proxy);

            //password authentication
            PasswordAuthentication passwordAuthentication = new PasswordAuthentication("abc", new char[]{'j', 'k'});
            System.out.println("Password: "+ passwordAuthentication.getPassword() );
            System.out.println("Username: "+ passwordAuthentication.getUserName());


        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        }}}


