/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.ArrayList;

/**
 *
 * @author Wesley
 */
public class Servidor {
       EnviarIP enviarIP;
       ConexaoTCP conexaoTCP;
       GerenciaES gerenciaES;
       ArrayList<Jogador> Jogadores = new ArrayList<Jogador>();
       ArrayList<Socket> ListaSockets = new ArrayList<Socket>();
       ArrayList<ObjectInputStream> ListaEntrada = new ArrayList<ObjectInputStream>();
       ArrayList<ObjectOutputStream> ListaSaida = new ArrayList<ObjectOutputStream>();
       public Servidor(){
           try{
                enviarIP = new EnviarIP();
                enviarIP.start();
                
                
                conexaoTCP = new ConexaoTCP(ListaSockets,Jogadores,ListaEntrada,ListaSaida);
                conexaoTCP.start();
                
                
           }catch(Exception e){
               e.printStackTrace();
               System.exit(1);
           }
       }
      public static void main(String args[]) throws Exception {
                  Servidor Tp = new Servidor();
 
    } 
    
    
}
