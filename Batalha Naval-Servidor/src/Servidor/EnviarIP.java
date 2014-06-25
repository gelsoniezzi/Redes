/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.net.*;

/**
 *
 * @author Wesley
 */
public class EnviarIP extends Thread{
        public EnviarIP() {               
            }
            
            public synchronized void run() {
                try {
                    
                    DatagramSocket soqueteUdP = new DatagramSocket(5552);
                   
                    InetAddress GrupoMulticast = InetAddress.getByName("239.0.0.1");
                    byte[] Dados;
                    String Msg;
                    
                    // Descobrindo IP do servidor
                    String IP = InetAddress.getLocalHost().getHostAddress();
                    
                    // Envia pacotes de mensagens para o grupo Multicast contendo 
                    // o IP do servidor até que todos os Clientes se conectem
                    while(true) {      
                        Msg = "Enviando:" + IP + ":.:";
                        System.out.println(Msg);
                        Dados = Msg.getBytes();
                        DatagramPacket pacote = new DatagramPacket(Dados, Dados.length, GrupoMulticast, 5555);
                        soqueteUdP.send(pacote);                        
                                         
                        this.wait(2000);
                    }
                    
                    
                } catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
            }
            
    
    
}
