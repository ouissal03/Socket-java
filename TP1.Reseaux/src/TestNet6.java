

import java.net.*;
import java.util.Arrays;

public class TestNet6 {
    public static void main(String[] args){
        try{
            InetAddress[] add = InetAddress.getAllByName(112.0.0.0);
            System.out.println(Arrays.toString(add.));
            System.out.println("adresse ");

            for (int i = 0; i < add.length; i++) {
                System.out.println(" "+add[i].getHostAddress());

            }
        }
        catch(Exception e){
            System.out.println("N'existe pas!");
        }
    }
}
