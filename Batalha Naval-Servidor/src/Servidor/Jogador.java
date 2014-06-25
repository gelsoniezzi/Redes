/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

/**
 *
 * @author Wesley
 */
public class Jogador {
    public String NomeUsuario = "";
            public String Status = "Online"; 
            public int Batalhas = 0;
            public int Vitorias = 0;
            
            public Jogador(){
                
            }
            public void SetName(String Name){
                this.NomeUsuario = Name;
            }
            public void SetRank(boolean Vitoria){
                if(Vitoria){
                    this.Batalhas++;
                    this.Vitorias++;
                }else{
                    this.Batalhas++;
                }
            }
            public void SetStatus(boolean Status){
                if(Status){
                    this.Status = "Online";
                }else{
                    this.Status = "Jogando";
                }
            }
    
}
