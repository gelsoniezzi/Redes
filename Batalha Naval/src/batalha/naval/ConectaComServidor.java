/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha.naval;

import java.io.*;
import java.net.*;

/**
 *
 * @author Wesley
 */
public class ConectaComServidor extends Thread{
    TelaPrincipal TP;
    TelaJogo  TJ;
    ObjectOutputStream saida;
    ObjectInputStream entrada;
    Socket SoqueteCliente;
    String Msgentrada; 
    String[] Msg;
    boolean Gameover = false;
    boolean Atirando = false;
    boolean Vencedor;
    public ConectaComServidor(TelaPrincipal TP,TelaJogo TJ) {
        
        
    }
    public void run(){
        try {
            
            ServerSocket soqueteTcpDoServidor = new ServerSocket(1235);
            SoqueteCliente = soqueteTcpDoServidor.accept();
            saida = new ObjectOutputStream(SoqueteCliente.getOutputStream());
            saida.flush();
            entrada = new ObjectInputStream(SoqueteCliente.getInputStream());
            while(true){
                
                
                
                Msgentrada = (String)entrada.readObject();
                 System.out.print("Mandou confirmaçao");
                Msg = Msgentrada.split(":");
                if(Msg[0].equals("Pronto")){
                    TJ.NomeInimigo("Capitão: " + Msg[1]);
                }
                while(!Gameover){
                    while(!Atirando){
                        int Linha,Coluna;
                        Msgentrada = (String)entrada.readObject();
                        String[] MsgTiro = Msgentrada.split(":");
                        if(MsgTiro[0].equals("Tiro")){
                            Linha = Integer.parseInt(MsgTiro[1]);
                            Coluna = Integer.parseInt(MsgTiro[2]);
                            if(TJ.MatrizPos[Linha][Coluna] == true ){
                                saida.writeObject("Resultado:Fogo:");
                                saida.flush();
                            }
                            else{
                                saida.writeObject("Resultado:Agua:");
                                saida.flush();
                                Atirando = true;
                            }
                        }
                    }
                    while(Atirando){
                        saida.writeObject("Tiro:"+TJ.Plinha+":"+ TJ.intColuna+":");
                        Msgentrada = (String)entrada.readObject();
                        String[] MsgTiro = Msgentrada.split(":");
                        if(MsgTiro[0].equals("Resultado")){
                            if(MsgTiro[1].equals("Fogo")){
                                TJ.DesenharTiro(TJ.Plinha, TJ.intColuna, true);
                            }
                            if(MsgTiro[1].equals("Agua")){
                                TJ.DesenharTiro(TJ.Plinha, TJ.intColuna, false);
                                Atirando =false;
                            }
                            if(MsgTiro[1].equals("Afundou")){
                                TJ.DesenharTiro(TJ.Plinha, TJ.intColuna, true);
                            }
                            if(MsgTiro[1].equals("Vitoria")){
                                TJ.DesenharTiro(TJ.Plinha, TJ.intColuna, true);
                                Vencedor = true;
                            }
                        }
                    }
                }
                /////encerra 
                saida.close();
                entrada.close();
                SoqueteCliente.close();
            }
        }catch(Exception ex){
            ex.printStackTrace();
            System.exit(1);
        }
    }
}
