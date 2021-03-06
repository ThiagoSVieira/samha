package cih.principal;

import cci.CtrlPrincipal;
import java.awt.event.KeyEvent;

public class FrmValidarAcesso extends javax.swing.JFrame {

    private CtrlPrincipal ctrlPrincipal;

    public FrmValidarAcesso(CtrlPrincipal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
        initComponents();
        setarBackground();
        jTextFieldLogin.requestFocus();
   }

    private void setarBackground(){
        pnlExterior.setBackground(ctrlPrincipal.setarCorPanelExterior());
    }
    
    public void limparCampos(){
        jTextFieldLogin.setText("");
        jPasswordFieldSenha.setText("");
    }
    
    private void validarAcesso(){
        String login = jTextFieldLogin.getText();
        String senha = jPasswordFieldSenha.getText();

        ctrlPrincipal.validarAcesso(login, senha);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlExterior = new javax.swing.JPanel();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldLogin = new javax.swing.JTextField();
        jLabelSenha = new javax.swing.JLabel();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        pnlExterior.setBackground(new java.awt.Color(0, 153, 102));
        pnlExterior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelUsuario.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(204, 204, 204));
        jLabelUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/user-white.png"))); // NOI18N
        jLabelUsuario.setToolTipText("Usuário");

        jTextFieldLogin.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        jLabelSenha.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabelSenha.setForeground(new java.awt.Color(204, 204, 204));
        jLabelSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/lock-white.png"))); // NOI18N
        jLabelSenha.setToolTipText("Senha");

        jPasswordFieldSenha.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jPasswordFieldSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldSenhaKeyPressed(evt);
            }
        });

        btnEntrar.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("Entrar");
        btnEntrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEntrar.setContentAreaFilled(false);
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/logoValidarAcesso.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SAMHA");

        jLabel3.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Desenvolvido por...");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlExteriorLayout = new javax.swing.GroupLayout(pnlExterior);
        pnlExterior.setLayout(pnlExteriorLayout);
        pnlExteriorLayout.setHorizontalGroup(
            pnlExteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExteriorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(pnlExteriorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlExteriorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExteriorLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(pnlExteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlExteriorLayout.createSequentialGroup()
                        .addGroup(pnlExteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlExteriorLayout.createSequentialGroup()
                                .addComponent(jLabelUsuario)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlExteriorLayout.createSequentialGroup()
                                .addComponent(jLabelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(btnEntrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );
        pnlExteriorLayout.setVerticalGroup(
            pnlExteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExteriorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlExteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlExteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSenha, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(28, 28, 28)
                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlExterior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlExterior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordFieldSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldSenhaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            validarAcesso();
        }
    }//GEN-LAST:event_jPasswordFieldSenhaKeyPressed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        validarAcesso();
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        ctrlPrincipal.instanciarFrameAutor();
    }//GEN-LAST:event_jLabel3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldLogin;
    private javax.swing.JPanel pnlExterior;
    // End of variables declaration//GEN-END:variables
}
