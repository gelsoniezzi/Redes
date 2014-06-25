/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Wesley
 */
public class GerenciaES extends Thread{
    ArrayList<Socket> ListaSockets;
    ArrayList<String> NomesUsuarios;
    ArrayList<ObjectInputStream> ListaEntrada;
    ArrayList<ObjectOutputStream> ListaSaida;
    public GerenciaES(ArrayList<Socket> ListaSockets, ArrayList<String> NomesUsuarios,ArrayList<ObjectInputStream> ListaEntrada,ArrayList<ObjectOutputStream> ListaSaida){
        this.ListaSockets = ListaSockets;
        this.NomesUsuarios = NomesUsuarios;
        this.ListaEntrada = ListaEntrada;
        this.ListaSaida = ListaSaida;
    }
    public void run(){
        try {
            System.out.print("GerenciaServer");
            while(true){
                for(int i = 0; i<ListaEntrada.size(); i++){
                    System.out.print("GerenciaServer2");
                    String Msgentrada = ListaEntrada.get(i).readObject().toString();
                    String[] Msg = Msgentrada.split(":");
                    if(Msg[0].equals("Join")){
                        for(int j = 0 ; j<NomesUsuarios.size(); j++){
                            if(Msg[1].equals(NomesUsuarios.get(j))){
                                System.out.print("GerenciaServer Funciona!!!!!!!!!");
                                String MsgSaida="Join:"+ NomesUsuarios.get(i)+":";
                            }
                        }
                    }
                }
          }
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
