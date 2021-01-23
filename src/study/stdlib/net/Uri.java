package study.stdlib.net;
import java.net.URI;
import java.net.URISyntaxException;

public class Uri {
    public static void main(String... args) {
        try {
            print(new URI("http://test.com/#test"));
            print(new URI("//localhost/"));
            print(new URI("//localhost:80/"));
            print(new URI("localhost:80/test?test=test#test"));
            print(new URI("/test?test=test#test"));
            print(new URI("hoge@gmail.com"));
            print(new URI("mailto:hoge@gmail.com"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    public static void print(URI uri) {
        System.out.printf("%s; %s; %s; %s; %s; %s; %s; %s\n"
                , uri.isOpaque()
                , uri.isAbsolute()
                , uri.getScheme()
                , uri.getSchemeSpecificPart()
                , uri.getPort()
                , uri.getPath()
                , uri.getAuthority()
                , uri.getFragment());
    }
}