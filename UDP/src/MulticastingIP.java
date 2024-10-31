import java.net.*;
import java.io.*;
class MulticastingIP {
    public static void main(String args[])
            throws SocketException, IOException{
        String msg="Bonjour le monde !!";
//on traveillera avec l’adress multicast 228.5.6.7
        InetAddress group= InetAddress.getByName("228.5.6.7");
//crée le socket utilise pour émettre et recevoir les datagrammes il utilisera le port 50000
        MulticastSocket s = new MulticastSocket(50000);
//s’abonne à l’adresse IP multicast
        s.joinGroup(group);
//crée l’objet qui stocke les données du datagramme à envoyer
        DatagramPacket envoi =new DatagramPacket(msg.getBytes(),msg.length(),group,50000);
//envoie le datagramme a tout le monde
        s.send(envoi);
        while(true){
            byte[] buf = new byte[1024];
            DatagramPacket reception =new DatagramPacket(buf,buf.length);
            s.receive(reception);
            String texte = new String(buf,0,reception.getLength());
            System.out.println("reception de la machine"+reception.getAddress().getHostName()+"sur le port "+reception.getPort()+":\n"+texte);
        }}}

