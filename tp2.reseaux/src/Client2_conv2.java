
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2_conv2 {

    public static void main(String[] args) throws UnknownHostException, IOException
    {
        InetAddress adrslocal = InetAddress.getLocalHost();
        Socket cl = new Socket (adrslocal.getHostName(),12456);

        while (true)
        {
            DataInputStream in = new DataInputStream ( cl.getInputStream());
            String moy = in.readUTF();
            System.out.println(moy);

            Scanner scn = new Scanner (System.in);
            String s = scn.nextLine();

            DataOutputStream out = new DataOutputStream ( cl.getOutputStream());
            out.writeUTF(s);  // envoie du dimenssion

        }



    }

}
