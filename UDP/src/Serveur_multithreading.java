import java.net.*;
import java.io.*;
public class Serveur_multithreading {
    public static void  main(String args[]){
        try{
            ServerSocket ecoute= new ServerSocket(18000,5);
            while(true){
                new NouvelleConnexion(ecoute.accept());
            }}
        catch  (Exception e){}
    }
}
class NouvelleConnexion implements Runnable {
    Thread t;
    Socket sck;
    PrintWriter sortie;
    BufferedReader entree;
    NouvelleConnexion(Socket sck){
        t=new Thread(this,sck.getInetAddress().getHostName()+"/"+sck.getPort());
        this.sck=sck;
        try{
            sortie = new PrintWriter(this.sck.getOutputStream());
            entree=new BufferedReader(new InputStreamReader(this.sck.getInputStream()));

        }catch (IOException e){

        }
        t.start();

    }
    public void run(){
        System.out.println("Nouvelle Connexion acceptee :"+t.getName());
        try{
            System.out.println("Recu:"+entree.readLine()+"sur  "+t.getName());
            sortie.println("Ravie de vous entendre ");
            sortie.flush();
            sck.close();
        }




        catch(IOException e){}}}

