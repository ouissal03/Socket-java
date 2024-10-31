import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server_conv2 {

    public static void main(String[] args) throws IOException {

        ServerSocket sr = new ServerSocket (12456);
        System.out.println("\nEn attendant une connextion ...\n");
        Socket cl = sr.accept();
        System.out.println("1 - la connexion a ete etablie\n");

        Socket cl2 = sr.accept();
        System.out.println("2 - la connexion a ete etablie\n");

        Scanner scn = new Scanner (System.in);


        while ( true)
        {
            DataInputStream in = new DataInputStream ( cl.getInputStream());
            String moy = in.readUTF();
            System.out.println("recoi from client 1");
            System.out.println("envoie au client 2\n\n");

            DataOutputStream out = new DataOutputStream ( cl2.getOutputStream());
            out.writeUTF(moy);  // envoie du dimenssion

            DataInputStream in2 = new DataInputStream ( cl2.getInputStream());
            moy = in2.readUTF();
            System.out.println("recoi from client 2");
            System.out.println("envoie au client 1\n\n");

            DataOutputStream out2 = new DataOutputStream ( cl.getOutputStream());
            out2.writeUTF(moy);
        }
    }}
