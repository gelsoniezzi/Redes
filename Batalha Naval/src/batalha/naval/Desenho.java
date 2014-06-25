/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha.naval;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import sun.java2d.loops.DrawRect;

/**
 *
 * @author Wesley
 */
public class Desenho extends JPanel {
    private Point posiçao;
    private boolean Clicado = false;
    TelaJogo TelaJ;
    public Desenho(  final TelaJogo TelaJ) {
        setLayout(null);
        addMouseListener(
                new MouseAdapter() 
                {  
                    public void mouseClicked( MouseEvent event){
                        posiçao = event.getPoint();
                        //System.out.print(posiçao.x+" ");
                        //System.out.print(posiçao.y+" ");
                        if(posiçao.x>20 && posiçao.y>20 && TelaJ.ContLabel<25){
                           Clicado = true;
                           TelaJ.posx= posiçao.x;
                           TelaJ.posy = posiçao.y;
                           TelaJ.DesenharNavios(TelaJ.Tipo, TelaJ.ContLabel);
                        } else{
                            Clicado = false;
                        }
                    }
                });
        
        
    }

    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawString("  A    B    C    D    E    F    G    H    I      J    K    L    M    N    O", 20, 20);
        String A = null;
        for(int i=0;i<15;i++){
            A = i+1+""; 
            g.setColor(Color.BLACK);
            g.drawString(A, 5, i*20+35);
            for(int j=0;j<15;j++){
                g.setColor(Color.BLACK);
                g.drawRect(j*20+20, i*20+20, j*20+20, i*20+20);
            }
        }
        
     }
    public boolean PosTrue(){
        return this.Clicado;
    }
    
}
    
    
    
    
    
   /* public void DesenharMatriz(Graphics g,int x, int y){
        super.paint(g);
        
        
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                g.setColor(Color.BLACK);
                g.drawRect(j*20 + x, i*20 + y, j*20+20 + x,i*20+20 + y);
            }
        }
    }
    public void Porta_Aviao(Graphics P, int x, int y, boolean Direçao){
        if(Direçao){
            for(int i=0;i<5;i++){
                P.setColor(Color.GREEN);
                P.fillRect(x, y + i*20, x+20 ,y + i*20 + 20);
            }
        }else{
            for(int i=0;i<5;i++){
                P.setColor(Color.GREEN);
                P.fillRect(x + i*20, y ,x + i*20+20 ,y + 20);
            }
        }
    }
    public void Encouraçado(Graphics P, int x, int y, boolean Direçao){
        if(Direçao){
            for(int i=0;i<4;i++){
                P.setColor(Color.GREEN);
                P.fillRect(x, y + i*20, x+20 ,y + i*20 + 20);
            }
        }else{
            for(int i=0;i<4;i++){
                P.setColor(Color.GREEN);
                P.fillRect(x + i*20, y ,x + i*20+20 ,y + 20);
            }
        }
    }
    public void Cruzador(Graphics P, int x, int y, boolean Direçao){
        if(Direçao){
            for(int i=0;i<2;i++){
                P.setColor(Color.GREEN);
                P.fillRect(x, y + i*20, x+20 ,y + i*20 + 20);
            }
        }else{
            for(int i=0;i<2;i++){
                P.setColor(Color.GREEN);
                P.fillRect(x + i*20, y ,x + i*20+20 ,y + 20);
            }
        }
    }
    public void Submarino(Graphics P, int x, int y){
        P.setColor(Color.GREEN);
        P.fillRect(x, y, x+20, y+20);
    }
    public void Hidro_Aviao(Graphics P, int x, int y){
        P.setColor(Color.GREEN);
        P.fillRect(x, y, x+20, y+20);
        P.fillRect(x+20, y+20, x+40, y+40);
        P.fillRect(x-20, y+20, x, y+40);
    }
   */ 

