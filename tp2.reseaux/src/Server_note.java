import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_note {

    public static void main(String[] args) throws Exception
    {
        ServerSocket sr = new ServerSocket (1234);
        System.out.println("\nEn attendant une connextion ...\n");
        Socket sr_connexion = sr.accept();
        System.out.println("la connexion a ete etablie\n");


        DataInputStream in = new DataInputStream ( sr_connexion.getInputStream());
        int tab,n = in.readInt();

        System.out.println("Dimenssion recu : "+n);
        float [] tab_note = new float [n];
        float somme=0,moy;
        System.out.println();
        for (tab=0;tab<n;tab++)
        {
            tab_note [tab] = in.readFloat();
            somme += tab_note [tab];
            System.out.println("tab_note["+tab+"] recu : "+tab_note [tab]);
            System.out.println();
        }

        System.out.println("\nentrain de calculer la moyenne ... "+somme+"  "+n+"\n");
        moy = somme/n;

        System.out.println("Envoie de la moyenne ."+moy);
        DataOutputStream out = new DataOutputStream ( sr_connexion.getOutputStream());
        out.writeFloat(moy);

        /*System.out.println("la chaine de caractere recu du client est : "+s);
        s = s.toUpperCase();

        DataOutputStream out = new DataOutputStream ( sr_connexion.getOutputStream());
        out.writeUTF(s);*/
    }

}


