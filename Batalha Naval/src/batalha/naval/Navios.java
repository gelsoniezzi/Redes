/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha.naval;
import java.awt.Color;  
import java.awt.Graphics;  
import java.awt.image.BufferedImage;  
import javax.swing.*; 

/**
 *
 * @author Wesley
 */
public class Navios {
    
    private BufferedImage Image;
    int X,Y,Tipo;
    boolean Direçao;
    
    public Navios(boolean direçao) {
       this.Direçao = direçao;
    }
    public void Porta_Avioes(){
        if(Direçao){
           Image = new BufferedImage(20,20*5,BufferedImage.TYPE_INT_RGB);
           Graphics G = Image.createGraphics();
           
           for(int i = 0; i<5 ; i++){
               G.setColor(Color.GREEN);
               G.fillRect( 0, i*20 ,20,20);
           }
           
        }else{
           Image = new BufferedImage(20*5,20,BufferedImage.TYPE_INT_RGB);
           Graphics G = Image.createGraphics();
           
           for(int i = 0; i<5 ; i++){
               G.setColor(Color.GREEN);
               G.fillRect( i*20, 0 ,20,20);
           } 
        }
        
        
    }
    public void Encouraçado(){
        if(Direçao){
           Image = new BufferedImage(20,20*4,BufferedImage.TYPE_INT_RGB);
           Graphics G = Image.createGraphics();
           
           for(int i = 0; i<4 ; i++){
               G.setColor(Color.GREEN);
               G.fillRect( 0, i*20 ,20,20);
           }
           
        }else{
           Image = new BufferedImage(20*4,20,BufferedImage.TYPE_INT_RGB);
           Graphics G = Image.createGraphics();
           
           for(int i = 0; i<4 ; i++){
               G.setColor(Color.GREEN);
               G.fillRect( i*20, 0 ,20,20);
           }
        }
    }
    public void Cruzador(){
        if(Direçao){
           Image = new BufferedImage(20,20*2,BufferedImage.TYPE_INT_RGB);
           Graphics G = Image.createGraphics();
           
           for(int i = 0; i<2 ; i++){
               G.setColor(Color.GREEN);
               G.fillRect( 0 , i*20 ,20,20);
           }
           
        }else{
           Image = new BufferedImage(20*2,20,BufferedImage.TYPE_INT_RGB);
           Graphics G = Image.createGraphics();
           
           for(int i = 0; i<2 ; i++){
               G.setColor(Color.GREEN);
               G.fillRect( i*20, 0 ,20,20);
           }
        }
    }
    public void Submarino(){
           Image = new BufferedImage(20*1,20,BufferedImage.TYPE_INT_RGB);
           Graphics G = Image.createGraphics();
           G.setColor(Color.GREEN);
           G.fillRect( 0, 0 ,20,20);
    }
    public void HidroAviao(){
           Image = new BufferedImage(20,20,BufferedImage.TYPE_INT_RGB);
           Graphics G = Image.createGraphics();
           G.setColor(Color.GREEN);
           G.fillRect(0, 0, 20, 20);
    }
    public void Tiro(boolean Acerto){
           Image = new BufferedImage(20,20,BufferedImage.TYPE_INT_RGB);
           Graphics G = Image.createGraphics();
           if(Acerto){
                G.setColor(Color.RED);
           }else{
                G.setColor(Color.BLUE);
           }
           G.fillRect(0, 0 ,20,20);
    }
    public ImageIcon getImageIcon() {  
        
        return new ImageIcon(Image);  
    }
    public BufferedImage getBufferedImage() {  
        
        return Image;  
    }
    
    
    
}
