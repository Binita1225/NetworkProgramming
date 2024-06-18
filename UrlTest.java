package Chapter5;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.Permission;
import java.util.Date;

public class UrlTest {
    public static void main(String[] args) {

        try {
            //url object
            URL url = new URL("https://www.google.com");
            //url connection
            URLConnection urlConnection = url.openConnection();
            urlConnection.setAllowUserInteraction(true);
            //urlConnection.setDoInput(true);
            //urlConnection.setDoOutput(true);
            urlConnection.setUseCaches(false);
            urlConnection.setConnectTimeout(30000);
            urlConnection.setReadTimeout(45000);

            urlConnection.setRequestProperty("Accept", "text/html, image/jpeg, image/gif");



            //Read data
            InputStream inputStream = urlConnection.getInputStream();
            InputStream bufferedInputStream = new BufferedInputStream(inputStream);
            Reader reader = new InputStreamReader(bufferedInputStream);
            int c;
            while ((c = reader.read()) != -1){
                //System.out.println((char) c);
            }
            System.out.println("Content type: " + urlConnection.getContentType());
            System.out.println("Content Length: " + urlConnection.getContentLength());
            System.out.println("Content Encoding: " + urlConnection.getContentEncoding());

            Date date = new Date(urlConnection.getDate());
            System.out.println("Content Date: " + date);

            Date date1 = new Date(urlConnection.getLastModified());
            System.out.println("Content Modified: " + date1);

            System.out.println(urlConnection.getHeaderField("connection"));

            System.out.println(urlConnection.getHeaderFieldKey(1));
            System.out.println(urlConnection.getHeaderField(1));
            System.out.println(new Date( urlConnection.getHeaderFieldDate("date", 0)));
            System.out.println(urlConnection.getHeaderFieldInt("content-type", -1 ));

            //url config
            //getUrl
            System.out.println("url is: " + urlConnection.getURL());

            System.out.println("Is user interaction allowed? " + urlConnection.getAllowUserInteraction());
            System.out.println("DO input: " + urlConnection.getDoInput());
            System.out.println("DO output: " + urlConnection.getDoOutput());
            System.out.println("If Modified since: " + urlConnection.getIfModifiedSince());
            System.out.println("use cache: " + urlConnection.getUseCaches());

            System.out.println(urlConnection.getRequestProperty("accept"));

            Permission permission = urlConnection.getPermission();
            System.out.println("Name: " + permission.getName());
            System.out.println("Action: " + permission.getActions());

            URL url1 = new URL("https://google.com");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url1.openConnection();
            httpURLConnection.setRequestMethod("TRACE");
            System.out.println(httpURLConnection.getRequestMethod());

            System.out.println("Response code: " + httpURLConnection.getResponseCode());
            System.out.println("Response Message: " + httpURLConnection.getResponseMessage());
            System.out.println("Proxy: " + httpURLConnection.usingProxy());

            httpURLConnection.setChunkedStreamingMode(10);

            httpURLConnection.disconnect();


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
