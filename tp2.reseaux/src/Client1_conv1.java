import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client1_conv1 {

    public static void main(String[] args) throws UnknownHostException, IOException
    {
        InetAddress adrslocal = InetAddress.getLocalHost();
        Socket cl = new Socket (adrslocal.getHostName(),124);

        Scanner scn = new Scanner (System.in);
        String s ;

        DataOutputStream out = new DataOutputStream ( cl.getOutputStream());



        DataInputStream in = new DataInputStream ( cl.getInputStream());

        while (true)
        {
            System.out.println("donnez votre message");
            s = scn.nextLine();
            out.writeUTF(s);  // envoie
            String moy = in.readUTF(); // recevoire
            System.out.println("message de client 2: "+moy);

        }
    }

}

