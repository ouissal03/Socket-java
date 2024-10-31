import java.net.*;
import java.io.*;
class EnvoiDatagramme{
    public static void main (String args[])
            throws SocketException, IOException,UnknownHostException{
        String message="bonjour le mond!";
        byte[] tampon=message.getBytes();
        DatagramSocket socket;
        // recupère l’adresse ip de la machine marine
        InetAddress adresse = InetAddress.getByName("LocalHost");
//crée objet stockera les données du datagramme à envoyer
        DatagramPacket envoi= new DatagramPacket(tampon,tampon.length,adresse,50000);
//crée un socket UDP le port est choisi par le système
        socket=new DatagramSocket();
//envoie le datagramme UDP
        socket.send(envoi);
    }
}


