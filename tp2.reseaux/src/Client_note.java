import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client_note {

    public static void main(String[] args) throws Exception
    {
        InetAddress adrslocal = InetAddress.getLocalHost();
        Socket cl = new Socket (adrslocal.getHostName(),1234);

        Scanner scn = new Scanner (System.in);

        System.out.print("\nDonner la dimension du tableau : ");
        int tab,n = scn.nextInt();
        float [] tab_note = new float [n];

        DataOutputStream out = new DataOutputStream ( cl.getOutputStream());
        out.writeInt(n);  // envoie du dimenssion

        System.out.println("\nInitalisation du tableau et l envoie au serveur pour claculer la moyenne");
        System.out.println();
        for (tab=0;tab<n;tab++)
        {
            System.out.print("tab_note["+tab+"] = ");
            tab_note [tab] = scn.nextFloat();
            out.writeFloat(tab_note [tab]);
            System.out.println();
        }



        System.out.println("\nle recoie la moyenne :");
        DataInputStream in = new DataInputStream ( cl.getInputStream());
        float moy = in.readFloat();
        System.out.println("\nla moyenne : "+moy);
    }

}
