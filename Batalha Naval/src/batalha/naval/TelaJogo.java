/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha.naval;

import java.awt.Event;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Label;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Wesley
 */
public class TelaJogo extends javax.swing.JFrame {

    TelaPrincipal TP;
    Desenho Matriz,MatrizInimigo;
    JLabel[] quadros = new JLabel[25];
    JLabel[] Tiros = new JLabel[225];
    JLabel[] TirosRecebidos = new JLabel[225];
    boolean[][] MatrizPos = new boolean[15][15];
    boolean[][] MatrizPosInimigo = new boolean[15][15];
    public int Tipo = 0;
    int Plinha;//posiçao tiro Linha;
    int intColuna; //posiçao tiro Coluna
    int posx;
    int posy;
    int ContaTiro = 0;
    int ContaTiroRecebido = 0;
    int ContLabel = 0;
    int Nportaaviao = 1;
    int Nencouraçado = 5;
    int Nsubmarino = 4;
    int NCruzadores = 3;
    int Nhidroaviao = 5;
    boolean Vertical = false;
    public TelaJogo(TelaPrincipal TP) {
        initComponents();
        InicializaMatrizes();
        NameUser.setText("Capitão: "+ TP.NomePlayer);
        Tiro.setVisible(false);
        this.setLocationRelativeTo(null);
        
        Matriz = new Desenho(this);
        Matriz.setBounds(20,30, 321, 321);
        Matriz.setVisible(true);
        this.add(Matriz);    
    }
    public void NomeUsuario(String name){
        this.NameUser.setText(name);
    }
    public void NomeInimigo(String Name){
        this.NameInimigo.setText(Name);
    }
    public void AtualizaTelaJogo(){
        this.NameInimigo.setText("");
        this.PosShot.setVisible(true);
        this.Tiro.setVisible(true);
        this.vertical.setVisible(false);
        this.Horizontal.setVisible(false);
        this.PortaAvião.setVisible(false);
        this.Encouraçado.setVisible(false);
        this.Submarino.setVisible(false);
        this.Cuzador.setVisible(false);
        this.HidroAvião.setVisible(false);
        MatrizInimigo = new Desenho(this);
        MatrizInimigo.setBounds(361, 30, 321, 321);
        MatrizInimigo.setVisible(true);
        this.add(MatrizInimigo);
        repaint();
        
    }

    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Abandonar = new javax.swing.JButton();
        NameUser = new javax.swing.JLabel();
        NameInimigo = new javax.swing.JLabel();
        PortaAvião = new javax.swing.JButton();
        Encouraçado = new javax.swing.JButton();
        Submarino = new javax.swing.JButton();
        Cuzador = new javax.swing.JButton();
        HidroAvião = new javax.swing.JButton();
        vertical = new javax.swing.JButton();
        Horizontal = new javax.swing.JButton();
        Pronto = new javax.swing.JButton();
        Tiro = new javax.swing.JButton();
        PosShot = new java.awt.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Abandonar.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        Abandonar.setForeground(new java.awt.Color(204, 0, 0));
        Abandonar.setText("Render-se");

        NameUser.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        NameUser.setForeground(new java.awt.Color(0, 0, 204));
        NameUser.setToolTipText("");

        NameInimigo.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        NameInimigo.setForeground(new java.awt.Color(204, 0, 0));
        NameInimigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameInimigo.setText("Navios");
        NameInimigo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        PortaAvião.setFont(new java.awt.Font("Algerian", 0, 12)); // NOI18N
        PortaAvião.setText("Porta-Aviões");
        PortaAvião.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PortaAviãoActionPerformed(evt);
            }
        });

        Encouraçado.setFont(new java.awt.Font("Algerian", 0, 12)); // NOI18N
        Encouraçado.setText("Encouraçado");
        Encouraçado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncouraçadoActionPerformed(evt);
            }
        });

        Submarino.setFont(new java.awt.Font("Algerian", 0, 12)); // NOI18N
        Submarino.setText("Submarino");
        Submarino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmarinoActionPerformed(evt);
            }
        });

        Cuzador.setFont(new java.awt.Font("Algerian", 0, 12)); // NOI18N
        Cuzador.setText("Cruzador");
        Cuzador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuzadorActionPerformed(evt);
            }
        });

        HidroAvião.setFont(new java.awt.Font("Algerian", 0, 12)); // NOI18N
        HidroAvião.setText("Hidro-Avião");
        HidroAvião.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HidroAviãoActionPerformed(evt);
            }
        });

        vertical.setFont(new java.awt.Font("Algerian", 0, 12)); // NOI18N
        vertical.setText("Vertical");
        vertical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verticalActionPerformed(evt);
            }
        });

        Horizontal.setFont(new java.awt.Font("Algerian", 0, 12)); // NOI18N
        Horizontal.setText("Horizontal");
        Horizontal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HorizontalActionPerformed(evt);
            }
        });

        Pronto.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        Pronto.setForeground(new java.awt.Color(0, 0, 153));
        Pronto.setText("Pronto");
        Pronto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProntoActionPerformed(evt);
            }
        });

        Tiro.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        Tiro.setForeground(new java.awt.Color(153, 0, 0));
        Tiro.setText("Atirar");
        Tiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TiroActionPerformed(evt);
            }
        });

        PosShot.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        PosShot.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        PosShot.setName("");
        PosShot.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Pronto)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(PosShot, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tiro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Abandonar)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(vertical)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Horizontal))
                                    .addComponent(NameInimigo, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(HidroAvião)
                                    .addComponent(PortaAvião)
                                    .addComponent(Encouraçado)
                                    .addComponent(Submarino)
                                    .addComponent(Cuzador))
                                .addGap(101, 101, 101))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NameUser, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(450, 450, 450))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NameInimigo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vertical)
                    .addComponent(Horizontal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PortaAvião)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Encouraçado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Submarino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cuzador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HidroAvião)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addComponent(PosShot, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Abandonar)
                    .addComponent(Pronto)
                    .addComponent(Tiro))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verticalActionPerformed
        // TODO add your handling code here:
        if(!Vertical)
            Vertical = true;
    }//GEN-LAST:event_verticalActionPerformed

    private void HorizontalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HorizontalActionPerformed
        // TODO add your handling code here:
        if(Vertical)
            Vertical = false;
    }//GEN-LAST:event_HorizontalActionPerformed

    private void PortaAviãoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PortaAviãoActionPerformed
        // TODO add your handling code here:
        if(ContLabel<25 &&(Tipo==0)){
            if(Nportaaviao>0){
                Tipo = 1;
            }
        } 
    }//GEN-LAST:event_PortaAviãoActionPerformed

    private void EncouraçadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncouraçadoActionPerformed
        // TODO add your handling code here:
        if(ContLabel<25 &&(Tipo==0)){
            if(Nencouraçado>0){
                Tipo = 2;
            }
        }
    }//GEN-LAST:event_EncouraçadoActionPerformed

    private void SubmarinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmarinoActionPerformed
        // TODO add your handling code here:
        if(ContLabel<25 &&(Tipo==0)){
            if(Nsubmarino>0){
                Tipo = 3;
            }
        }
    }//GEN-LAST:event_SubmarinoActionPerformed

    private void CuzadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuzadorActionPerformed
        // TODO add your handling code here:
        if(ContLabel<25 &&(Tipo==0)){
            if(NCruzadores>0){
                Tipo = 4;
            }
        }
    }//GEN-LAST:event_CuzadorActionPerformed

    private void HidroAviãoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HidroAviãoActionPerformed
        // TODO add your handling code here:
        if(ContLabel<25 &&(Tipo==0)){
            if(Nhidroaviao>0){
                Tipo = 5;
            }
        }
    }//GEN-LAST:event_HidroAviãoActionPerformed

    private void ProntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProntoActionPerformed
        // TODO add your handling code here:
        if(ContLabel>0){
            AtualizaTelaJogo();
            this.Pronto.setVisible(false);
        }else{
            System.out.print(ContLabel);
            JOptionPane.showMessageDialog(null,"Você não usou todas as enbarcações","Mensagem de erro",JOptionPane.PLAIN_MESSAGE);
            System.out.print(ContLabel);
        }
    }//GEN-LAST:event_ProntoActionPerformed

    private void TiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TiroActionPerformed
        // TODO add your handling code here:
        char[] linha = new char[1];
        String Posiçao = this.PosShot.getText();
        if(Posiçao.length()>3 || Posiçao.length()<2){
            this.PosShot.setText("");
            JOptionPane.showMessageDialog(null,"Posição inválida","Mensagem de erro",JOptionPane.PLAIN_MESSAGE);
        }else{
            Posiçao.getChars(0,1, linha,0);
            Plinha = linha[0];
            System.out.print(Plinha);
            if((Plinha>79 || Plinha<65)&&(Plinha>111 || Plinha<97)){
                this.PosShot.setText("");
                JOptionPane.showMessageDialog(null,"Posição inválida","Mensagem de erro:1",JOptionPane.PLAIN_MESSAGE);
            }else{
                if(Posiçao.length()==3){
                   String Coluna = Posiçao.substring(1, 3);
                   int intColuna = Integer.parseInt(Coluna);
                   if(intColuna>15){
                       this.PosShot.setText("");
                       JOptionPane.showMessageDialog(null,"Posição inválida","Mensagem de erro:2",JOptionPane.PLAIN_MESSAGE);
                   }else{
                       if(Plinha>=65 && Plinha<97){
                          Plinha-=65;
                          DesenharTiro(Plinha,intColuna, true);
                          this.PosShot.setText("");
                       }
                       else{
                          Plinha-=97;
                          DesenharTiro(Plinha,intColuna, true);
                          this.PosShot.setText("");
                       }
                   }
                }else{
                   String Coluna = Posiçao.substring(1, 2);
                   int intColuna = Integer.parseInt(Coluna);
                   if(intColuna<1){
                       JOptionPane.showMessageDialog(null,"Posição inválida","Mensagem de erro:3",JOptionPane.PLAIN_MESSAGE);
                   }else{
                       if(Plinha>=65 && Plinha<97){
                          Plinha-=65;
                          DesenharTiro(Plinha,intColuna, true);
                          this.PosShot.setText("");
                       }
                       else{
                          Plinha-=97;
                          DesenharTiro(Plinha,intColuna, true);
                          this.PosShot.setText("");
                       }      
                   }
                }   
            }
        }
    }//GEN-LAST:event_TiroActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abandonar;
    private javax.swing.JButton Cuzador;
    private javax.swing.JButton Encouraçado;
    private javax.swing.JButton HidroAvião;
    private javax.swing.JButton Horizontal;
    private javax.swing.JLabel NameInimigo;
    private javax.swing.JLabel NameUser;
    private javax.swing.JButton PortaAvião;
    private java.awt.TextField PosShot;
    private javax.swing.JButton Pronto;
    private javax.swing.JButton Submarino;
    private javax.swing.JButton Tiro;
    private javax.swing.JButton vertical;
    // End of variables declaration//GEN-END:variables

  public void InicializaMatrizes(){
      for(int i= 0; i<15 ; i++){
          for(int j = 0; j<15 ; j++){
              MatrizPos[i][j] = false;
              MatrizPosInimigo[i][i] = false;
          }
      }
  }
  public boolean VerificaPos(int TipoNvavio,int X, int Y){
      switch(TipoNvavio){
          case 1:
              if(Vertical){
                  if(X>10){
                      return false;
                  }else{
                      if((X>0 && X<9)&&(Y>0 && Y< 14)){
                          for(int i = X-1; i<X+6 ; i++){
                              for(int j = Y-1; j<Y+2 ; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+5; i++){
                              MatrizPos[i][Y]= true;
                          }
                          return true;
                      }else if(X==0 && Y==0){
                          for(int i = X; i<X+7 ; i++){
                              for(int j = Y; j<Y+2; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+5; i++){
                              MatrizPos[i][Y]= true;
                              
                          }
                          return true;
                      }else if(Y==0 && (X>0&&X<10)){
                          for(int i = X-1; i<X+6 ; i++){
                              for(int j = Y; j<Y+2; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+5; i++){
                              MatrizPos[i][Y]= true;
                          }
                          return true;
                      }else if(X==10 && Y==0){
                          for(int i = X-1; i<X+5 ; i++){
                              for(int j = Y; j<Y+2; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+5; i++){
                              MatrizPos[i][Y]= true;
                          }
                          return true;
                      }else if(X==0 && (Y>0 && Y<14)){
                          for(int i = X; i<X+6 ; i++){
                              for(int j = Y-1; j<Y+2; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+5; i++){
                              MatrizPos[i][Y]= true;
                          }
                          return true;
                      }else if(X==10 && (Y>0 && Y<14)){
                          for(int i = X-1; i<X+5 ; i++){
                              for(int j = Y-1; j<Y+2; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+5; i++){
                              MatrizPos[i][Y]= true;
                          }
                          return true;
                      }else if(X==0 && Y==14){
                          for(int i = X; i<X+6 ; i++){
                              for(int j = Y-1; j<Y+1; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+5; i++){
                              MatrizPos[i][Y]= true;
                          }
                          return true;
                      }else if((X>0&&X<10) && Y==14){
                          for(int i = X; i<X+7 ; i++){
                              for(int j = Y-1; j<Y+1; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+5; i++){
                              MatrizPos[i][Y]= true;
                          }
                          return true;
                      }else if(X==10 && Y==14){
                          for(int i = X-1; i<X+5 ; i++){
                              for(int j = Y-1; j<Y+1; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+5; i++){
                              MatrizPos[i][Y]= true;
                          }
                          return true;
                      }
                  } 
              }else{
                  if(Y>10)
                      return false;
                  else{
                    if((X>0 && X<14)&&(Y>0 && Y< 10)){
                            for(int i = X-1; i<X+2 ; i++){
                                for(int j = Y-1; j<Y+6 ; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+5; i++){
                                MatrizPos[X][i]= true;
                            }
                            System.out.print("caso1");
                            return true;
                        }else if( X==0 && Y==0){
                            for(int i = X; i<X+2 ; i++){
                                for(int j = Y; j<Y+6; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+5; i++){
                                MatrizPos[X][i]= true;
                            }
                            System.out.print("caso2");
                            return true;
                        }else if((X>0 && X<14)&& Y==0){
                            for(int i = X-1; i<X+2 ; i++){
                                for(int j = Y; j<Y+6; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+5; i++){
                                MatrizPos[X][i]= true;
                            }
                            System.out.print("caso3");
                            return true;
                        }else if(X==14 && Y==0){
                            for(int i = X-1; i<X+1 ; i++){
                                for(int j = Y; j<Y+6; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+5; i++){
                                MatrizPos[X][i]= true;
                            }
                            System.out.print("caso4");
                            return true;
                        }else if(X==0 &&(Y>0 && Y<10)){
                            for(int i = X; i<X+2 ; i++){
                                for(int j = Y-1; j<Y+6; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+5; i++){
                                MatrizPos[X][i]= true;
                            }
                            System.out.print("caso5");
                            return true;
                        }else if(X==14 && (Y>0&&Y<10)){
                            for(int i = X-1; i<X+1 ; i++){
                                for(int j = Y-1; j<Y+6 ; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+5; i++){
                                MatrizPos[X][i]= true;
                            }
                            System.out.print("caso6");
                            return true;
                        }else if(X==0 && Y==10){
                            for(int i = X; i<X+2 ; i++){
                                for(int j = Y-1; j<Y+5; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+5; i++){
                                MatrizPos[X][i]= true;
                            }
                            System.out.print("caso7");
                            return true;
                        }else if((X>0 && X<14) && Y==10){
                            for(int i = X-1; i<X+6 ; i++){
                                for(int j = Y; j<Y+2; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+5; i++){
                                MatrizPos[X][i]= true;
                            }
                            System.out.print("caso8");
                            return true;
                        }else if(X==14 && Y==10){
                            for(int i = X-1; i<X+1 ; i++){
                                for(int j = Y-1; j<Y+5; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+5; i++){
                                MatrizPos[X][i]= true;
                            }
                            System.out.print("caso9");
                            return true;
                        }
                  }
              }
              break;
          case 2:
              if(Vertical){
                  if(X>11){
                      return false;
                  }else{
                      if((X>0 && X<11)&&(Y>0 && Y<14)){
                          for(int i = X-1; i<X+5 ; i++){
                              for(int j = Y-1; j<Y+2 ; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+4; i++){
                              MatrizPos[i][Y]= true;
                          }
                          System.out.print("caso1");
                          return true;
                      }else if(X==0 && Y==0){
                          for(int i = X; i<X+5; i++){
                              for(int j = Y; j<Y+2; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+4; i++){
                              MatrizPos[i][Y]= true;
                          }
                          System.out.print("caso2");
                          return true;
                      }else if(Y==0 && (X>0&&X<11)){
                          for(int i = X-1; i<X+5 ; i++){
                              for(int j = Y; j<Y+2; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+4; i++){
                              MatrizPos[i][Y]= true;
                          }
                          System.out.print("caso3");
                          return true;
                      }else if(X==11 && Y==0){
                          for(int i = X-1; i<X+4 ; i++){
                              for(int j = Y; j<Y+2; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+4; i++){
                              MatrizPos[i][Y]= true;
                          }
                          return true;
                      }else if(X==0 && (Y>0 && Y<14)){
                          for(int i = X; i<X+5 ; i++){
                              for(int j = Y-1; j<Y+2; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+4; i++){
                              MatrizPos[i][Y]= true;
                          }
                          return true;
                      }else if(X==11 && (Y>0 && Y<14)){
                          for(int i = X-1; i<X+4 ; i++){
                              for(int j = Y-1; j<Y+2; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+4; i++){
                              MatrizPos[i][Y]= true;
                          }
                          return true;
                      }else if(X==0 && Y==14){
                          for(int i = X; i<X+5 ; i++){
                              for(int j = Y-1; j<Y+1; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+4; i++){
                              MatrizPos[i][Y]= true;
                          }
                          return true;
                      }else if((X>0&&X<11) && Y==14){
                          for(int i = X; i<X+6 ; i++){
                              for(int j = Y-1; j<Y+1; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+4; i++){
                              MatrizPos[i][Y]= true;
                          }
                          return true;
                      }else if(X==10 && Y==14){
                          for(int i = X-1; i<X+4 ; i++){
                              for(int j = Y-1; j<Y+1; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+4; i++){
                              MatrizPos[i][Y]= true;
                          }
                          return true;
                      }
                  } 
              }else{
                  if(Y>11)
                      return false;
                  else{
                    if((X>0 && X<14)&&(Y>0 && Y< 11)){
                            for(int i = X-1; i<X+2 ; i++){
                                for(int j = Y-1; j<Y+5 ; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+4; i++){
                                MatrizPos[X][i]= true;
                            }
                            return true;
                        }else if( X==0 && Y==0){
                            for(int i = X; i<X+2 ; i++){
                                for(int j = Y; j<Y+5; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+4; i++){
                                MatrizPos[X][i]= true;
                            }
                            return true;
                        }else if((X>0 && X<14)&& Y==0){
                            for(int i = X-1; i<X+2 ; i++){
                                for(int j = Y-1; j<Y+5; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+4; i++){
                                MatrizPos[X][i]= true;
                            }
                            System.out.print("caso3");
                            return true;
                        }else if(X==14 && Y==0){
                            for(int i = X-1; i<X+1 ; i++){
                                for(int j = Y; j<Y+5; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+4; i++){
                                MatrizPos[X][i]= true;
                            }
                            System.out.print("caso4");
                            return true;
                        }else if(X==0 &&(Y>0 && Y<11)){
                            for(int i = X; i<X+2 ; i++){
                                for(int j = Y-1; j<Y+5; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+4; i++){
                                MatrizPos[X][i]= true;
                            }
                            System.out.print("caso5");
                            return true;
                        }else if(X==14 && (Y>0&&Y<11)){
                            for(int i = X-1; i<X+1 ; i++){
                                for(int j = Y-1; j<Y+5 ; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+4; i++){
                                MatrizPos[X][i]= true;
                            }
                            System.out.print("caso6");
                            return true;
                        }else if(X==0 && Y==11){
                            for(int i = X; i<X+2 ; i++){
                                for(int j = Y-1; j<Y+4; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+4; i++){
                                MatrizPos[X][i]= true;
                            }
                            System.out.print("caso7");
                            return true;
                        }else if((X>0 && X<14) && Y==11){
                            for(int i = X-1; i<X+2 ; i++){
                                for(int j = Y-1; j<Y+4; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+4; i++){
                                MatrizPos[X][i]= true;
                            }
                            System.out.print("caso8");
                            return true;
                        }else if(X==14 && Y==11){
                            for(int i = X-1; i<X+1 ; i++){
                                for(int j = Y-1; j<Y+4; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+4; i++){
                                MatrizPos[X][i]= true;
                            }
                            System.out.print("caso9");
                            return true;
                        }
                  }
              }
              break;
          case 3:
              if(X==0 && Y==0){
                  for(int i = X; i<X+2; i++ ){
                      for(int j = Y; j<Y+2; j++ ){
                          if(MatrizPos[i][j]== true)
                              return false;
                      }
                  }
                  MatrizPos[X][Y] = true;
                  return true;
              }else if((X>0 && X<14) && Y==0){
                  for(int i = X-1; i<X+2; i++ ){
                      for(int j = Y; j<Y+2; j++ ){
                          if(MatrizPos[i][j]== true)
                              return false;
                      }
                  }
                  MatrizPos[X][Y] = true;
                  return true;
              }else if(X==14 && Y==0){
                  for(int i = X-1; i<X+1; i++ ){
                      for(int j = Y; j<Y+2; j++ ){
                          if(MatrizPos[i][j]== true)
                              return false;
                      }
                  }
                  MatrizPos[X][Y] = true;
                  return true;
              }else if(X==0 &&(Y>0 && Y<14) ){
                  for(int i = X; i<X+2; i++ ){
                      for(int j = Y-1; j<Y+2; j++ ){
                          if(MatrizPos[i][j]== true)
                              return false;
                      }
                  }
                  MatrizPos[X][Y] = true;
                  return true;
              }else if((X>0 && X<14) && (Y>0 && Y< 14)){
                  for(int i = X-1; i<X+2; i++ ){
                      for(int j = Y-1; j<Y+2; j++ ){
                          if(MatrizPos[i][j]== true)
                              return false;
                      }
                  }
                  MatrizPos[X][Y] = true;
                  return true;
              }else if(X==14 && (Y>0 && Y<14)){
                  for(int i = X-1; i<X+1; i++ ){
                      for(int j = Y-1; j<Y+2; j++ ){
                          if(MatrizPos[i][j]== true)
                              return false;
                      }
                  }
                  MatrizPos[X][Y] = true;
                  return true;
              }else if(X==0 && Y==14){
                  for(int i = X; i<X+2; i++ ){
                      for(int j = Y-1; j<Y+1; j++ ){
                          if(MatrizPos[i][j]== true)
                              return false;
                      }
                  }
                  MatrizPos[X][Y] = true;
                  return true;
              }else if((X>0 && X<14) && Y==14){
                  for(int i = X; i<X+3; i++ ){
                      for(int j = Y-1; j<Y+1; j++ ){
                          if(MatrizPos[i][j]== true)
                              return false;
                      }
                  }
                  MatrizPos[X][Y] = true;
                  return true;
              }else if(X==14 && Y==14){
                  for(int i = X-1; i<X+1; i++ ){
                      for(int j = Y-1; j<Y+1; j++ ){
                          if(MatrizPos[i][j]== true)
                              return false;
                      }
                  }
                  MatrizPos[X][Y] = true;
                  return true;
              }
              break;
          case 4:
               if(Vertical){
                  if(X>13){
                      return false;
                  }else{
                      if((X>0 && X<13)&&(Y>0 && Y<14)){
                          for(int i = X-1; i<X+3 ; i++){
                              for(int j = Y-1; j<Y+2 ; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+2; i++){
                              MatrizPos[i][Y]= true;
                          }
                          return true;
                      }else if(X==0 && Y==0){
                          for(int i = X; i<X+3; i++){
                              for(int j = Y; j<Y+2; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+2; i++){
                              MatrizPos[i][Y]= true;
                          }
                          System.out.print("caso2");
                          return true;
                      }else if(Y==0 && (X>0&&X<11)){
                          for(int i = X-1; i<X+3 ; i++){
                              for(int j = Y; j<Y+2; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+2; i++){
                              MatrizPos[i][Y]= true;
                          }
                          System.out.print("caso3");
                          return true;
                      }else if(X==13 && Y==0){
                          for(int i = X-1; i<X+2 ; i++){
                              for(int j = Y; j<Y+2; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+2; i++){
                              MatrizPos[i][Y]= true;
                          }
                          return true;
                      }else if(X==0 && (Y>0 && Y<14)){
                          for(int i = X; i<X+3 ; i++){
                              for(int j = Y-1; j<Y+2; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+2; i++){
                              MatrizPos[i][Y]= true;
                          }
                          return true;
                      }else if(X==13 && (Y>0 && Y<14)){
                          for(int i = X-1; i<X+2 ; i++){
                              for(int j = Y-1; j<Y+2; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+2; i++){
                              MatrizPos[i][Y]= true;
                          }
                          return true;
                      }else if(X==0 && Y==14){
                          for(int i = X; i<X+3 ; i++){
                              for(int j = Y-1; j<Y+1; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+2; i++){
                              MatrizPos[i][Y]= true;
                          }
                          return true;
                      }else if((X>0&&X<13) && Y==14){
                          for(int i = X-1; i<X+3 ; i++){
                              for(int j = Y-1; j<Y+1; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+2; i++){
                              MatrizPos[i][Y]= true;
                          }
                          return true;
                      }else if(X==13 && Y==14){
                          for(int i = X-1; i<X+2 ; i++){
                              for(int j = Y-1; j<Y+1; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          for(int i = X; i<X+2; i++){
                              MatrizPos[i][Y]= true;
                          }
                          return true;
                      }
                  } 
              }else{
                  if(Y>13)
                      return false;
                  else{
                    if((X>0 && X<14)&&(Y>0 && Y< 13)){
                            for(int i = X-1; i<X+2 ; i++){
                                for(int j = Y-1; j<Y+3 ; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+2; i++){
                                MatrizPos[X][i]= true;
                            }
                            return true;
                        }else if( X==0 && Y==0){
                            for(int i = X; i<X+2 ; i++){
                                for(int j = Y; j<Y+3; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+2; i++){
                                MatrizPos[X][i]= true;
                            }
                            return true;
                        }else if((X>0 && X<14)&& Y==0){
                            for(int i = X-1; i<X+2 ; i++){
                                for(int j = Y; j<Y+3; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+2; i++){
                                MatrizPos[X][i]= true;
                            }
                            System.out.print("caso3");
                            return true;
                        }else if(X==14 && Y==0){
                            for(int i = X-1; i<X+1 ; i++){
                                for(int j = Y; j<Y+3; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+2; i++){
                                MatrizPos[X][i]= true;
                            }
                            System.out.print("caso4");
                            return true;
                        }else if(X==0 &&(Y>0 && Y<13)){
                            for(int i = X; i<X+2 ; i++){
                                for(int j = Y-1; j<Y+3; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+2; i++){
                                MatrizPos[X][i]= true;
                            }
                            System.out.print("caso5");
                            return true;
                        }else if(X==14 && (Y>0&&Y<13)){
                            for(int i = X-1; i<X+1 ; i++){
                                for(int j = Y-1; j<Y+3 ; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+2; i++){
                                MatrizPos[X][i]= true;
                            }
                            System.out.print("caso6");
                            return true;
                        }else if(X==0 && Y==13){
                            for(int i = X; i<X+2 ; i++){
                                for(int j = Y-1; j<Y+2; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+2; i++){
                                MatrizPos[X][i]= true;
                            }
                            System.out.print("caso7");
                            return true;
                        }else if((X>0 && X<14) && Y==13){
                            for(int i = X-1; i<X+2 ; i++){
                                for(int j = Y-1; j<Y+2; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+2; i++){
                                MatrizPos[X][i]= true;
                            }
                            System.out.print("caso8");
                            return true;
                        }else if(X==14 && Y==13){
                            for(int i = X-1; i<X+1 ; i++){
                                for(int j = Y-1; j<Y+2; j++){
                                    if(MatrizPos[i][j]== true)
                                        return false;
                                }       
                            }
                            for(int i = Y; i<Y+2; i++){
                                MatrizPos[X][i]= true;
                            }
                            System.out.print("caso9");
                            return true;
                        }
                  }
              }
              break;
          case 5:
              if(X<1 && Y>12){
                      return false;
                  }else{
                      if((X>0 && X<14)&&(Y>0 && Y<12)){
                          for(int i = X-1; i<X+2 ; i++){
                              for(int j = Y-1; j<Y+4 ; j++){
                                  if((MatrizPos[i][j]== true) && (i!=X-2) && ((j!=Y-1)||(j!=Y+3)))
                                      return false;
                              }       
                          }
                          MatrizPos[X][Y] = true;
                          MatrizPos[X-1][Y+1] = true;
                          MatrizPos[X][Y+2] = true;
                          System.out.print("caso1");
                          return true;
                      }else if(X==1 && Y==0){
                          for(int i = X-1; i<X+2 ; i++){
                              for(int j = Y; j<Y+4; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          MatrizPos[X][Y] = true;
                          MatrizPos[X-1][Y+1] = true;
                          MatrizPos[X][Y+2] = true;
                          return true;
                      }else if((X>1 && X<14) && Y==0){
                          for(int i = X-2; i<X+2 ; i++){
                              for(int j = Y; j<Y+4; j++){
                                  if(MatrizPos[i][j]== true && (j!=Y+3) && (i!=X-2))
                                      return false;
                              }       
                          }
                          MatrizPos[X][Y] = true;
                          MatrizPos[X-1][Y+1] = true;
                          MatrizPos[X][Y+2] = true;
                          return true;
                      }else if(X==14 && Y==0){
                          for(int i = X-2; i<X+1 ; i++){
                              for(int j = Y; j<Y+4; j++){
                                  if(MatrizPos[i][j]== true && (j!=X+3) && (i!=Y-2))
                                      return false;
                              }       
                          }
                          MatrizPos[X][Y] = true;
                          MatrizPos[X-1][Y+1] = true;
                          MatrizPos[X][Y+2] = true;
                          return true;
                      }else if(X==1 && (Y>0 && Y<13)){
                          for(int i = X-1; i<X+2 ; i++){
                              for(int j = Y-1; j<Y+3; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          MatrizPos[X][Y] = true;
                          MatrizPos[X-1][Y+1] = true;
                          MatrizPos[X][Y+2] = true;
                          return true;
                      }else if( X==14 &&(Y>0 && Y<12)){
                          for(int i = X-2; i<X+1 ; i++){
                              for(int j = Y-1; j<Y+4; j++){
                                  if(MatrizPos[i][j]== true && ((j!=Y-1)||(j!=Y+3)) && (i!=X-2))
                                      return false;
                              }       
                          }
                          MatrizPos[X][Y] = true;
                          MatrizPos[X-1][Y+1] = true;
                          MatrizPos[X][Y+2] = true;
                          return true;
                      }else if(X==1 && Y==12){
                          for(int i = X-1; i<X+2 ; i++){
                              for(int j = Y-1; j<Y+3; j++){
                                  if(MatrizPos[i][j]== true)
                                      return false;
                              }       
                          }
                          MatrizPos[X][Y] = true;
                          MatrizPos[X-1][Y+1] = true;
                          MatrizPos[X][Y+2] = true;
                          return true;
                      }else if((X>1 && X<14)&& Y==12){
                          for(int i = X-2; i<X+2 ; i++){
                              for(int j = Y-1; j<Y+3; j++){
                                  if(MatrizPos[i][j]== true && (i!=X-2)&&(j!=Y-1))
                                      return false;
                              }       
                          }
                          MatrizPos[X][Y] = true;
                          MatrizPos[X-1][Y+1] = true;
                          MatrizPos[X][Y+2] = true;
                          return true;
                      }else if(X==14 && Y==12){
                          for(int i = X-2; i<X+1 ; i++){
                              for(int j = Y-1; j<Y+3; j++){
                                  if(MatrizPos[i][j]== true && (i!=X-2)&& (j!=Y-1))
                                      return false;
                              }       
                          }
                          MatrizPos[X][Y] = true;
                          MatrizPos[X-1][Y+1] = true;
                          MatrizPos[X][Y+2] = true;
                          return true;
                      }
                  }
      
              break;  
      }
      return false;
      
  }
  public void DesenharTiro(int posX, int posY,boolean Acerto){
      Navios Tiro = new Navios(Acerto);
      Tiro.Tiro(Acerto);
      Tiros[ContaTiro] = new JLabel(Tiro.getImageIcon());
      Tiros[ContaTiro].setBounds(posX*20+20, (posY-1)*20+20, 20, 20);
      Tiros[ContaTiro].setVisible(true);
      MatrizInimigo.add(Tiros[ContaTiro]);
      ContaTiro++;
      repaint();
  }
  public void DesenharNavios(int TNavio, int Label){
      switch(TNavio){
          case 1:
              if(Vertical){
                  if(Matriz.PosTrue()){
                      int PX = posx/20;
                      int PY = posy/20;
                      if(VerificaPos(TNavio, PY-1, PX-1)){
                        Navios PortaAviao = new Navios(true);
                        PortaAviao.Porta_Avioes();
                        quadros[Label] = new JLabel(PortaAviao.getImageIcon());
                        quadros[Label].setBounds(PX*20, PY*20, 20, 100);
                        quadros[Label].setVisible(true);
                        Matriz.add(quadros[Label]);
                        ContLabel++;
                        Nportaaviao--;
                        Tipo = 0;
                        repaint();
                      }
                  }
              }else{
                  if(Matriz.PosTrue()){
                      int PX = posx/20;
                      int PY = posy/20;
                      if(VerificaPos(TNavio, PY-1, PX-1)){
                        Navios PortaAviao = new Navios(false);
                        PortaAviao.Porta_Avioes();
                        quadros[Label] = new JLabel(PortaAviao.getImageIcon());
                        quadros[Label].setBounds(PX*20, PY*20, 100, 20);
                        quadros[Label].setVisible(true);
                        Matriz.add(quadros[Label]);
                        ContLabel++;
                        Nportaaviao--;
                        Tipo = 0;
                        repaint();
                      }
                  }
              }
              break;
          case 2:
              if(Vertical){
                  if(Matriz.PosTrue()){
                      int PX = posx/20;
                      int PY = posy/20;
                      if(VerificaPos(TNavio, PY-1, PX-1)){
                        Navios Encouraçado = new Navios(true);
                        Encouraçado.Encouraçado();
                        quadros[Label] = new JLabel(Encouraçado.getImageIcon());
                        quadros[Label].setBounds(PX*20, PY*20, 20, 80);
                        quadros[Label].setVisible(true);
                        Matriz.add(quadros[Label]);
                        ContLabel++;
                        Nencouraçado--;
                        Tipo = 0;
                        repaint();
                      }
                  }
              }else{
                  if(Matriz.PosTrue()){
                      int PX = posx/20;
                      int PY = posy/20;
                      if(VerificaPos(TNavio, PY-1, PX-1)){
                        Navios Encouraçado = new Navios(false);
                        Encouraçado.Encouraçado();
                        quadros[Label] = new JLabel(Encouraçado.getImageIcon());
                        quadros[Label].setBounds(PX*20, PY*20, 80, 20);
                        quadros[Label].setVisible(true);
                        Matriz.add(quadros[Label]);
                        ContLabel++;
                        Nencouraçado--;
                        Tipo = 0;
                        repaint();
                      }
                  }
              }
              break;
          case 3:
              if(Matriz.PosTrue()){
                 int PX = posx/20;
                 int PY = posy/20;
                 if(VerificaPos(TNavio, PY-1, PX-1)){
                    Navios Submarino = new Navios(true);
                    Submarino.Submarino();
                    quadros[Label] = new JLabel(Submarino.getImageIcon());
                    quadros[Label].setBounds(PX*20, PY*20, 20, 20);
                    quadros[Label].setVisible(true);
                    Matriz.add(quadros[Label]);
                    ContLabel++;
                    Nsubmarino--;
                    Tipo = 0;
                    repaint();
                 }
              }
              break;
          case 4:
              if(Vertical){
                  if(Matriz.PosTrue()){
                      int PX = posx/20;
                      int PY = posy/20;
                      if(VerificaPos(TNavio, PY-1, PX-1)){
                        Navios Cruzador = new Navios(true);
                        Cruzador.Cruzador();
                        quadros[Label] = new JLabel(Cruzador.getImageIcon());
                        quadros[Label].setBounds(PX*20, PY*20, 20, 40);
                        quadros[Label].setVisible(true);
                        Matriz.add(quadros[Label]);
                        ContLabel++;
                        NCruzadores--;
                        Tipo = 0;
                        repaint();
                      }
                  }
              }else{
                  if(Matriz.PosTrue()){
                      int PX = posx/20;
                      int PY = posy/20;
                      if(VerificaPos(TNavio, PY-1, PX-1)){
                        Navios Cruzador = new Navios(false);
                        Cruzador.Cruzador();
                        quadros[Label] = new JLabel(Cruzador.getImageIcon());
                        quadros[Label].setBounds(PX*20, PY*20, 40, 20);
                        quadros[Label].setVisible(true);
                        Matriz.add(quadros[Label]);
                        ContLabel++;
                        NCruzadores--;
                        Tipo = 0;
                        repaint();
                      }
                  }
              }
              break;
          case 5:
              if(Matriz.PosTrue()){
                      int PX = posx/20;
                      int PY = posy/20;
                      if(VerificaPos(TNavio, PY-1, PX-1)){
                        for(int i = Label; i< Label + 3; i++){
                            Navios Hidro = new Navios(true);
                            Hidro.HidroAviao();
                            quadros[i] = new JLabel(Hidro.getImageIcon());
                            if(i==Label){
                                quadros[i].setBounds(PX*20, PY*20, 20, 20); 
                            }else if(i==Label+1){
                                quadros[i].setBounds(PX*20+20, PY*20-20, 20, 20);
                            }else if(i==Label+2){
                                quadros[i].setBounds(PX*20+40, PY*20, 20, 20);
                            }
                            quadros[i].setVisible(true);
                            Matriz.add(quadros[i]);
                            ContLabel++;
                        }
                        Nhidroaviao--;
                        Tipo = 0;
                        repaint();
                      }
                  }
              break;
      }
  }
}

