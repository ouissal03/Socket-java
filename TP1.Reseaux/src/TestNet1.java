import com.sun.source.tree.TryTree;

import java.net.*;
public class TestNet1 {
    public static void main(String[] args){
        try{
            InetAddress adrLocale=InetAddress.getLocalHost();
            System.out.println("Adresse locale="+adrLocale.getHostAddress());
            System.out.println("Host name="+adrLocale.getHostName());

        }
        catch(Exception e){
            System.out.println("HostLocalinnaccessible");
        }
    }
}
