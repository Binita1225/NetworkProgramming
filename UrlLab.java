package Chapter3;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class UrlLab {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.lolcats.com/");

            URL url2 =new URL("http", "www.google.com", "/abc.html");

            URL url3 = new URL("http","www.google.com", 81, "/abc.html");

            URL url4 = new URL(url, "/abc.html");

            System.out.println(url);
            System.out.println(url2);
            System.out.println(url3);
            System.out.println(url4);

                InputStream inputStream =  url.openStream();
                int c;
                while ((c = inputStream.read()) != -1){
               //     System.out.println(c);
                }
                inputStream.close();

            URLConnection urlConnection = url.openConnection();

            InputStream inputStream2 =  urlConnection.getInputStream();
            int d;
            while ((d = inputStream2.read()) != -1){
            //    System.out.println(d);
            }

            Object o = url.getContent();
            System.out.println(o.toString());

            Class<InputStream>[] classes = new Class[3];
            classes[0] = InputStream.class;
            InputStream inputStream3 = (InputStream) url.getContent(classes);
            System.out.println(inputStream3);

            int e;
            while ((e = inputStream3.read()) != -1){
                    //System.out.println(e);
            }

            //url into pieces

            URL urlPieces = new URL("http://www.ibiblio.org/javafaq/books/jnp/index.html?isbn=1565922069#toc");
            System.out.println("protocol :" + urlPieces.getProtocol());
            System.out.println("port :" + urlPieces.getPort());
            System.out.println("host :" + urlPieces.getHost());
            System.out.println("file :" + urlPieces.getFile());
            System.out.println("ref :" +urlPieces.getRef());
            System.out.println("query :" +urlPieces.getQuery());
            System.out.println("path :" +urlPieces.getPath());
            System.out.println("user info :" +urlPieces.getUserInfo());
            System.out.println("authority :" +urlPieces.getAuthority());

            System.out.println(url.equals(url2));
            System.out.println(url.hashCode());
            System.out.println(url.toString());

            //URI uri = new URI("\"http://www.ibiblio.org/javafaq/books/jnp/index.html?isbn=1565922069#toc,\"");

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
