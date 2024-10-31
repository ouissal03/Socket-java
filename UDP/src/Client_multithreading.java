import java.net.*;
import java.io.*;

public class Client_miltithreading{
    public static void main(String[] args){
        try {
            Socket connexion=new Socket("localhost",18000);
            PrintWriter sortie = new PrintWriter(connexion.getOutputStream());
            BufferedReader entree= new BufferedReader(new InputStreamReader(connexion.getInputStream()));
            sortie.println("Bonjour!!");
            sortie.flush();
            System.out.println(entree.readLine());
            connexion.close();
        }
        catch(Exception e){}
    }
}

