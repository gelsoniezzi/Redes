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
public class ConectaComCliente extends Thread{
    TelaJogo TJ;
    TelaPrincipal TP;
    String IPcliente;
    ObjectInputStream entrada;
    ObjectOutputStream saida;
    String Msgentrada;
    String Msgsaida;
    boolean Vencedor = false;
    boolean Atirando = true;
    boolean GameOver;
    public ConectaComCliente(String IP, TelaPrincipal TP,TelaJogo TJ){
        this.TJ = TJ;
        this.IPcliente = IP;
        this.TP = TP;
    }
    public void run(){
        try {
            
            Socket soqueteTcp = new Socket(IPcliente, 1235);
            
            saida = new ObjectOutputStream(soqueteTcp.getOutputStream());
            saida.flush();
            entrada = new ObjectInputStream(soqueteTcp.getInputStream());
            
            while(TJ.ContLabel==0){
                 System.out.print("Em espera...");
            }
            saida.writeObject("Pronto:"+TP.NomePlayer + ":");
            System.out.print("Mandou confirmaçao");
            Msgentrada = (String)entrada.readObject();
            String[] Msg = Msgentrada.split(":");
            if(Msg[0].equals("Pronto")){
                TJ.NomeInimigo("Capitão: " + Msg[1]);
            }
            while(!GameOver){
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
                while(!Atirando){
                    int Linha,Coluna;
                    Msgentrada = (String)entrada.readObject();
                    String[] MsgTiro = Msgentrada.split(":");
                    if(MsgTiro[0].equals("Tiro")){
                        Linha = Integer.parseInt(MsgTiro[1]);
                        Coluna = Integer.parseInt(MsgTiro[2]);
                        if(TJ.MatrizPos[Linha][Coluna] == true ){
                            saida.writeObject("Resultado:Fogo:");
                        }
                        else{
                            saida.writeObject("Resultado:Agua:");
                            Atirando = true;
                        }
                    }  
                }
            }
            ///encerra 
            TP.Vitoria = Vencedor;
            entrada.close();
            saida.close();
            soqueteTcp.close();
        } catch(Exception ex){
            ex.printStackTrace();
            System.exit(1);
        }
    }
    
}
