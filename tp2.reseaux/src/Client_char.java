
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client_char {

    public static void main(String[] args) throws Exception
    {
        InetAddress adrslocal = InetAddress.getLocalHost();

        Socket cl = new Socket (adrslocal.getHostName(),1234);

        Scanner scn = new Scanner (System.in);

        System.out.print("\nDonner la dimension du tableau : ");
        int tab,n = scn.nextInt();
        char [] tab_char = new char [n];

        DataOutputStream out = new DataOutputStream ( cl.getOutputStream());
        out.writeInt(n);  // envoie du dimenssion

        System.out.println("\nInitalisation du tableau et l envoie au serveur pour le tri");
        System.out.println();
        for (tab=0;tab<n;tab++)
        {
            System.out.print("tab_char["+tab+"] = ");
            tab_char [tab] = scn.next().charAt(0);
            out.writeChar(tab_char [tab]);
            System.out.println();
        }



        System.out.println("\nle recoie du tableau :");
        DataInputStream in = new DataInputStream ( cl.getInputStream());
        for (tab=0;tab<n;tab++)
        {
            tab_char [tab] = in.readChar();
        }

        System.out.print("\n tab_char : ");
        System.out.println(tab_char);
        //s= in.readUTF();
        // System.out.println("la chaine de caractere recu par le serveur est (MAJ) : "+s);

    }

}
