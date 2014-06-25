/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha.naval;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Wesley
 */
public class Cliente extends Thread {
    String NomeUsuario;
    TelaPrincipal TP;
    TelaJogo TJ;
    ObjectOutputStream saida;
    ObjectInputStream entrada;
    boolean bloqueio = true;
     
    public Cliente(TelaPrincipal TP,TelaJogo TJ) {
        this.TP = TP;
        this.NomeUsuario = TP.NomePlayer;
        this.TJ = TJ;
    }
    
     public void run(){
        try {
            System.out.println("TIOTIO");
            // Criando o soquete UDP para o grupo multicast
            MulticastSocket soqueteMulticast = new MulticastSocket(5555);
            // Criando grupo Multicast
            InetAddress grupoMulticast = InetAddress.getByName("239.0.0.1");
            // Entrando no grupo Multicast
            soqueteMulticast.joinGroup(grupoMulticast);

            String prefixo;
            byte[] dados;
            // Cria o pacote de recebimento 
            DatagramPacket pacoteRecebido;
            String msg;

            dados = new byte[5000];
            
            pacoteRecebido = new DatagramPacket(dados, dados.length);
            // Recebe o pacote
            soqueteMulticast.receive(pacoteRecebido);
            // Converte o pacote em String
            msg = new String(pacoteRecebido.getData());
            
            //prefixo = msg.substring(0, 9);
            String[] descoberta = msg.split(":");
            
            
            
            // Se a String começar com descoberta
            if(descoberta[0].equals("Enviando"))
            {
                System.out.println(descoberta[1]);
                
                // Criando Soquete TCP
                Socket soqueteTcp = new Socket(InetAddress.getByName(descoberta[1]), 1234);
                // Criando Objeto e saida e entrada
                saida = new ObjectOutputStream(soqueteTcp.getOutputStream());
                saida.flush();
                entrada = new ObjectInputStream(soqueteTcp.getInputStream());
                
                saida.writeObject(NomeUsuario);
                System.out.print(soqueteTcp.getLocalAddress().getHostAddress());
                Cliente.GerenciaSaida gerenciaEntrada = new GerenciaSaida();
                (new Thread(gerenciaEntrada)).start();
                while(true){
                     String Msg = ((String) entrada.readObject());
                     System.out.print("Sou bloqueante");
                     String[] MsgEntrada = Msg.split(":");
                     if(MsgEntrada[0].equals("Lista")){
                        TP.NomePlayer = MsgEntrada[1];
                        TP.AtualizarListaEntrada(MsgEntrada);
                    }
                    if(MsgEntrada[0].equals("ListaAtual")){
                        TP.AtualizarListaEntrada(MsgEntrada);
                    }
                    if(MsgEntrada[0].equals("Join")){
                        System.out.print("Graças a Deus");
                        if(JOptionPane.showConfirmDialog(TP,"Deseja jogar com o Capitão: "+MsgEntrada[1])== 0){
                            saida.writeObject("ACK:" +MsgEntrada[1]+":" );
                            ConectaComServidor conectaComServidor = new ConectaComServidor(TP, TJ);
                            TP.setVisible(false);
                            TJ = new TelaJogo(TP);
                            TJ.setVisible(true);
                            conectaComServidor.start();
                        }
                    }
                    if(MsgEntrada[0].equals("IP")){
                        ConectaComCliente conectaComCliente = new ConectaComCliente(MsgEntrada[1],TP,TJ);
                        TP.setVisible(false);
                        TJ = new TelaJogo(TP);
                        TJ.setVisible(true);
                        conectaComCliente.start();
                    }
                    
                }
                
                
            }      
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
            
        }
     }   
    public class GerenciaSaida implements Runnable{
        
        public GerenciaSaida(){
            
        }
        public  void run(){
            try{
                while(true){
                    if(TP.Start){
                        System.out.print("             GerenciaSaida ");
                        saida.writeObject("Join:"+ TP.ElementoList +":");
                        TP.Start = false;
                        System.out.print("GerenciaSaida        Enviou");
                    }
                    sleep(2000);
                }
                
            }catch(Exception ex){
                ex.printStackTrace();
                System.exit(1);
            }
        }
    }
     
}

