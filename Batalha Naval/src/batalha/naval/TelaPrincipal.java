/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha.naval;
import com.sun.security.ntlm.Client;
import java.net.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/**
 *
 * @author Wesley
 */
public class TelaPrincipal extends javax.swing.JFrame {

    Cliente C;
    String NomePlayer;
    boolean ACK =false;
    boolean Vitoria;
    public boolean Start = false;
    public String ElementoList = null;
    DefaultListModel model;
    TelaJogo TJ;
    public TelaPrincipal() {
        initComponents();
        jPanel1.setVisible(false);
        
        this.setSize(650, 425);
        this.setLocationRelativeTo(null);
        
        
    }
    
    public void AtualizaTela(){
        this.remove(Login);
        this.remove(Titulo);
        this.remove(LoginText);
        this.remove(nomeUsuarioJText);
        repaint();
        jPanel1.setVisible(true);
    }
    public void AtualizarListaEntrada(String[] Lista){
        String Espaço = "                                        ";
        model = new DefaultListModel();
        ListaUsuarios.removeAll();
        for(int i=2;i<Lista.length; i=i+4){
            String DadosPlayer = Lista[i] + Espaço + Lista[i+1] + Espaço
                                 + Lista[i+2]+ Espaço + Lista[i+3];
            model.addElement(DadosPlayer);
        }
        ListaUsuarios.setModel(model); 
        ListaUsuarios.setVisibleRowCount(5);
        ListaUsuarios.setVisible(true);
       
        ListaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListaUsuarios.addListSelectionListener(
          new ListSelectionListener() {

             @Override
             public void valueChanged(ListSelectionEvent event) {
                String aux = (String)ListaUsuarios.getSelectedValue();
                String[] aux2 = aux.split(" ");
                ElementoList = aux2[0];
                System.out.print(ElementoList);
            }
        } );
        if(NameUserFinal.getText()==""){
            NameUserFinal.setText("Capitão: "+NomePlayer); 
        }
         
        
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        NameUserFinal = new javax.swing.JLabel();
        Users1 = new java.awt.Label();
        Status1 = new java.awt.Label();
        Batalhas1 = new java.awt.Label();
        Victoria1 = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListaUsuarios = new javax.swing.JList();
        Join = new javax.swing.JButton();
        Quit = new javax.swing.JButton();
        Login = new javax.swing.JButton();
        Titulo = new java.awt.Label();
        nomeUsuarioJText = new javax.swing.JTextField();
        LoginText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NameUserFinal.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N

        Users1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        Users1.setText("Usuários");

        Status1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        Status1.setText("Status");

        Batalhas1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        Batalhas1.setText("Batalhas");

        Victoria1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        Victoria1.setText("Vitórias");

        jScrollPane2.setViewportView(ListaUsuarios);

        Join.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        Join.setText("Join");
        Join.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JoinButton(evt);
            }
        });

        Quit.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        Quit.setText("Quit");
        Quit.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Users1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(Status1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(Batalhas1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Victoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(NameUserFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(Join)
                        .addGap(157, 157, 157)
                        .addComponent(Quit)))
                .addContainerGap(188, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NameUserFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Batalhas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Users1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Status1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Victoria1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Join)
                    .addComponent(Quit))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        Login.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        Login.setText("Login");
        Login.setToolTipText("");
        Login.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        Titulo.setAlignment(java.awt.Label.CENTER);
        Titulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Titulo.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        Titulo.setText("Batalha Naval");

        LoginText.setText("Login:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LoginText)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                            .addComponent(Login, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nomeUsuarioJText))
                        .addGap(202, 202, 202))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(LoginText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeUsuarioJText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Login)
                .addGap(142, 142, 142))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
       //TelaLogin tl = new TelaLogin(this, true, this);
       //tl.setVisible(true);
        NameUserFinal.setText("");
        if(!nomeUsuarioJText.getText().equals("")) {
            NomePlayer = nomeUsuarioJText.getText();
            C = new Cliente(this,TJ);
           
            try{
                C.start();
                System.out.print("rererereererr");
            }catch(Exception e){
                Logger.getLogger( TelaPrincipal.class.getName()).log(Level.SEVERE, null, e);
            System.out.print("eeeeeeeeeeeee");   
            }
            AtualizaTela();
        }
    }//GEN-LAST:event_LoginActionPerformed

    private void JoinButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JoinButton
        // TODO add your handling code here:
        if(Start == false && ElementoList != null){
            Start = true;
            System.out.print("Apertei");
            if(this.ACK)
                TJ = new TelaJogo(this);
        }
    }//GEN-LAST:event_JoinButton

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              TelaPrincipal telaPrincipal = new TelaPrincipal();
              telaPrincipal.setVisible(true);
               
                
              
                
            }
        });
  
        
}
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label Batalhas1;
    private javax.swing.JButton Join;
    private javax.swing.JList ListaUsuarios;
    private javax.swing.JButton Login;
    private javax.swing.JLabel LoginText;
    private javax.swing.JLabel NameUserFinal;
    private javax.swing.JButton Quit;
    private java.awt.Label Status1;
    private java.awt.Label Titulo;
    private java.awt.Label Users1;
    private java.awt.Label Victoria1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nomeUsuarioJText;
    // End of variables declaration//GEN-END:variables
}
