import java.io.*;
import java.net.*;
import java.util.Arrays;

public class Server_char {

    public static void main(String[] args) throws Exception
    {
        ServerSocket sr = new ServerSocket (1234);
        System.out.println("\nEn attendant une connextion ...\n");
        Socket sr_connexion = sr.accept();
        System.out.println("la connexion a ete etablie\n");


        DataInputStream in = new DataInputStream ( sr_connexion.getInputStream());
        int tab,n = in.readInt();

        System.out.println("Dimenssion recu : "+n);
        char [] tab_char = new char [n];

        System.out.println();
        for (tab=0;tab<n;tab++)
        {
            tab_char [tab] = in.readChar();
            System.out.println("tab_char["+tab+"] recu : "+tab_char [tab]);
            System.out.println();
        }

        System.out.println("\nentrain de trier le tableau ... \n");
        int i,j;
        char tmp;
        for (i=0;i<n;i++){
            {
                for (j=0;j<n-1;j++)
                {
                    if (tab_char [j] > tab_char [j+1])
                    {
                        tmp = tab_char [j];
                        tab_char [j] = tab_char [j+1];
                        tab_char [j+1] = tmp;
                    }
                }
            }
        }

        System.out.println("Envoie du tableau .");
        DataOutputStream out = new DataOutputStream ( sr_connexion.getOutputStream());
        for (tab=0;tab<n;tab++)
        {
            out.writeChar(tab_char [tab]);
        }


        /*System.out.println("la chaine de caractere recu du client est : "+s);
        s = s.toUpperCase();

        DataOutputStream out = new DataOutputStream ( sr_connexion.getOutputStream());
        out.writeUTF(s);*/
    }

}
