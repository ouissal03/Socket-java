import java.net.*;
import java.io.*;
class ReceptionDatagramme
{
    public static void main(String agrs[])
            throws SocketException,IOException
    {
        byte[] tampon = new byte[1000];
        String texte;
//crée un socket UDP qui attends des datagrammes sur le port 50000
        DatagramSocket socket=new DatagramSocket(50000);
//crée un objet pour stocker les données du datagramme attendu
        DatagramPacket reception =new DatagramPacket(tampon,tampon.length);
//attends puis récupère les données du datagramme
        socket.receive(reception);
//récupère la chaîne de caractère reçue
        texte=new String(tampon,0,reception.getLength());
        System.out.println("Reception de la machine"+reception.getAddress().getHostName()+"sur le port"+reception.getPort()+":\n"+texte);
    }}



