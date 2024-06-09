package Chapter4;

import java.net.*;

public class CookieTest {
    public static void main(String[] args) {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(cookieManager);

        CookieStore cookieStore = cookieManager.getCookieStore();
        try {
            cookieStore.add(new URI("www.google.com"), new HttpCookie("firstName", "Binita"));
            cookieStore.add(new URI("www.google.com"), new HttpCookie("lastName", "Sapkota"));
            System.out.println(cookieStore.getCookies().get(0));
            System.out.println(cookieStore.getCookies().get(1));
            System.out.println(cookieStore.get (new URI("www.google.com")));

            //use of remove
            cookieStore.remove(new URI("www.google.com"), cookieStore.getCookies().get(0));
            System.out.println(cookieStore.get(new URI("www.google.com")));

            //use of removeAll
            cookieStore.removeAll();
            System.out.println(cookieStore.get(new URI("www.google.com")));

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
