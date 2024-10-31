
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2_conv1 {

    public static void main(String[] args) throws UnknownHostException, IOException
    {
        ServerSocket sr = new ServerSocket (124);
        System.out.println("\nEn attendant une connextion ...\n");
        Socket cl = sr.accept();
        System.out.println("la connexion a ete etablie\n");
        Scanner scn = new Scanner (System.in);

        String s="",moy;

        DataInputStream in = new DataInputStream ( cl.getInputStream());

        DataOutputStream out = new DataOutputStream ( cl.getOutputStream());


        while (true){
            moy = in.readUTF();  // recevoire
            System.out.println("message de client 1: "+moy);
            System.out.println("donnez votre message");
            s = scn.nextLine();

            out.writeUTF(s);  // envoie
        }

    }

}
