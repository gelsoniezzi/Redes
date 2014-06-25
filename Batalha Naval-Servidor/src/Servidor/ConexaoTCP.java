/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Wesley
 */
public class ConexaoTCP extends Thread{
    boolean rodando = true;
    
   
    ArrayList<Socket> ListaSockets;
    ArrayList<Jogador> Jogadores;
    ArrayList<ObjectInputStream> ListaEntrada;
    ArrayList<ObjectOutputStream> ListaSaida;
    
    ObjectOutputStream saida;
    ObjectInputStream entrada;
     public ConexaoTCP(ArrayList<Socket> ListaSockets, ArrayList<Jogador> Jogadores ,ArrayList<ObjectInputStream> ListaEntrada,ArrayList<ObjectOutputStream> ListaSaida){
        this.ListaSockets = ListaSockets;
        this.ListaEntrada = ListaEntrada;
        this.ListaSaida = ListaSaida;
        this.Jogadores = Jogadores;
    }
    
    public  void run(){
        try {
            // Criando Soquete Servidor TCP com a Porta 1234
            ServerSocket soqueteTcpDoServidor = new ServerSocket(1234);
            
            while (rodando) {
                // Aguarda até algum cliente se conectar
                System.out.print("Vai rodar");
                ListaSockets.add(soqueteTcpDoServidor.accept());
                System.out.print("Já rodou");
                ConexaoTCP.GerenciaEntrada gerenciaEntrada = new GerenciaEntrada(ListaSockets, Jogadores, ListaEntrada, ListaSaida);
                (new Thread(gerenciaEntrada)).start();
             
            }
            
        } catch(Exception e){
            e.printStackTrace();
            
        }
    }
    
    public class GerenciaEntrada implements Runnable{
        ArrayList<Socket> ListaSockets;
        ArrayList<Jogador> Jogadores;
        ArrayList<ObjectInputStream> ListaEntrada;
        ArrayList<ObjectOutputStream> ListaSaida;
        
        ObjectOutputStream saida;
        ObjectInputStream entrada;
        Jogador jogador;
        public GerenciaEntrada(ArrayList<Socket> ListaSockets, ArrayList<Jogador> Jogadores,ArrayList<ObjectInputStream> ListaEntrada,ArrayList<ObjectOutputStream> ListaSaida){
            this.ListaSockets = ListaSockets;
            this.Jogadores = Jogadores;
            this.ListaEntrada = ListaEntrada;
            this.ListaSaida = ListaSaida;
        }
        public  void run(){
            try {
                    int PosiçaoSoquete = ListaSockets.size()-1;
                    saida = new ObjectOutputStream(ListaSockets.get(ListaSockets.size()-1).getOutputStream());
                    saida.flush();
                    entrada = new ObjectInputStream(ListaSockets.get(ListaSockets.size()-1).getInputStream());
                    jogador = new Jogador();
                    String nomeJogador = (String) entrada.readObject();
                    String aux = "";
                    int id = 1;
                    for(int i = 0; i < Jogadores.size(); i++) {
                        if(Jogadores.get(i).NomeUsuario.equals(nomeJogador +aux))
                            aux = "0" + id;
                            id++;
                    }
                    String Nomefinal = nomeJogador + aux;
                    jogador.SetName(Nomefinal);
                    
                    Jogadores.add(jogador);
                    ListaEntrada.add(entrada);
                    ListaSaida.add(saida);

                    for(int i=0; i<ListaSockets.size();i++){
                        String Msg ="Lista:"+Jogadores.get(i).NomeUsuario+":"; 
                        for(int j = 0; j<ListaSockets.size();j++){
                            if(i!=j){
                                Msg = Msg + Jogadores.get(j).NomeUsuario+":"+Jogadores.get(j).Status+":"
                                          + Jogadores.get(j).Batalhas+":"+Jogadores.get(j).Vitorias +":";
                            }
                        }
                        ListaSaida.get(i).writeObject(Msg);
                    }
                    while(true){
                        String Msgentrada = (String)entrada.readObject();
                        String[] Msg = Msgentrada.split(":");
                        System.out.print("GerenciaServer2");
                        if(Msg[0].equals("Join")){
                            System.out.print("Eu recebi");
                            for(int j =0; j<Jogadores.size(); j++){
                                if(Msg[1].equals(Jogadores.get(j).NomeUsuario)){
                                    String MsgEnviada = "Join:" + Nomefinal + ":";
                                    ListaSaida.get(j).writeObject(MsgEnviada);
                                    }
                                }  
                            }
                        if(Msg[0].equals("ACK")){
                            String IP = "";
                            for(int j = 0 ; j<Jogadores.size(); j++){
                                if(Msg[1].equals(Jogadores.get(j).NomeUsuario)){
                                    Jogadores.get(j).SetStatus(false);
                                    Jogadores.get(PosiçaoSoquete).SetStatus(false);
                                    IP = ListaSockets.get(PosiçaoSoquete).getLocalAddress().getHostAddress();
                                        ReenviarLista();
                                        ListaSaida.get(j).writeObject("IP:"+ IP + ":");
                                        //ReenviarLista();
                                    }
                                }
                            } 
                    }
                
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            
            }
        public void ReenviarLista() throws IOException{
            for(int i = 0; i<Jogadores.size();i++){
                String Msg = "ListaAtual:.:";
                for(int j = 0; j<Jogadores.size();j++ ){
                    if(i!=j && Jogadores.get(i).Status.equals("Online")){
                        Msg = Msg + Jogadores.get(j).NomeUsuario+":"+Jogadores.get(j).Status+":"
                                  + Jogadores.get(j).Batalhas+":"+Jogadores.get(j).Vitorias +":";
                        
                    }
                }
                if(Jogadores.get(i).Status.equals("Online")){
                    ListaSaida.get(i).writeObject(Msg);   
                }
                
            }
        }
    }  
}
