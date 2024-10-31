import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur_cof {

    public static void main(String[] args) throws Exception
    {
        ServerSocket sr = new ServerSocket (12345);
        System.out.println("\nEn attendant une connextion ...\n");
        Socket sr_connexion = sr.accept();
        System.out.println("la connexion a ete etablie\n");


        DataInputStream in = new DataInputStream ( sr_connexion.getInputStream());
        int tab,n = in.readInt();
        int som_cof = 0;
        System.out.println("Dimenssion recu : "+n);
        float [] tab_note = new float [n];
        int [] tab_cof = new int [n];
        float somme=0,moy;
        System.out.println();
        for (tab=0;tab<n;tab++)
        {
            tab_note [tab] = in.readFloat();
            tab_cof [tab] = in.readInt();
            somme += tab_note [tab]*tab_cof[tab];
            System.out.println("tab_note["+tab+"] recu : "+tab_note [tab]);
            System.out.println();


            som_cof+= tab_cof [tab];
            System.out.println("tab_cof["+tab+"] recu : "+tab_cof [tab]);
            System.out.println();
        }

        System.out.println("\nentrain de calculer la moyenne ... "+somme+"  "+n+"\n");
        moy = somme/som_cof;

        System.out.println("Envoie de la moyenne ."+moy);
        DataOutputStream out = new DataOutputStream ( sr_connexion.getOutputStream());
        out.writeFloat(moy);

        /*System.out.println("la chaine de caractere recu du client est : "+s);
        s = s.toUpperCase();

        DataOutputStream out = new DataOutputStream ( sr_connexion.getOutputStream());
        out.writeUTF(s);*/
    }

}


