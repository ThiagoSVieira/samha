package cih.principal;

import cci.CtrlPrincipal;
import cdp.Coordenador;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FrmInicio extends javax.swing.JFrame {

    private CtrlPrincipal ctrlPrincipal;
    
    public FrmInicio(CtrlPrincipal ctrlPrincipal){
        this.ctrlPrincipal = ctrlPrincipal;
        initComponents();
        setarBackground();
    } 
    
     private void setarBackground(){
         pnlPrincipal.setBackground(ctrlPrincipal.setarCorPanelExterior());
         toolBar.setBackground(ctrlPrincipal.setarCorPanelExterior());
     }
    
    public void atualizarInfoSistema(){
        Coordenador coord = ctrlPrincipal.getGtPrincipal().getCoordAtual();
        Date dataAtual = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String data = formatter.format(dataAtual);
        if(coord != null){
            lblNomeCoordenador.setText(coord.getNome());
            lblDataAtual.setText(data);
        }
    }
    
    public void identificarUsuario(int permissao){
        
        if(permissao == 2){
            btnCoordenador.setEnabled(false);
            btnCurso.setEnabled(false); 
        }else if(permissao == 3){
            btnAlocar.setEnabled(false);
            btnCoordenador.setEnabled(false);
            btnCurso.setEnabled(false);
            btnDisciplina.setEnabled(false);
            btnProfessor.setEnabled(false);
            btnTurma.setEnabled(false);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolBar = new javax.swing.JToolBar();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnProfessor = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnCoordenador = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnCurso = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        btnDisciplina = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        btnTurma = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        btnAlocar = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        btnOferta = new javax.swing.JButton();
        jSeparator15 = new javax.swing.JToolBar.Separator();
        btnSair = new javax.swing.JButton();
        jSeparator13 = new javax.swing.JSeparator();
        pnlPrincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblNomeCoordenador = new javax.swing.JLabel();
        lblDataAtual = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Apoio à Montagem de Horários Acadêmicos");
        setPreferredSize(new java.awt.Dimension(800, 400));

        toolBar.setBackground(new java.awt.Color(0, 153, 102));
        toolBar.setBorder(null);
        toolBar.setFloatable(false);
        toolBar.setRollover(true);
        toolBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        toolBar.add(jSeparator12);
        toolBar.add(jSeparator3);

        btnProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/professor.png"))); // NOI18N
        btnProfessor.setToolTipText("Professores");
        btnProfessor.setFocusable(false);
        btnProfessor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProfessor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfessorActionPerformed(evt);
            }
        });
        toolBar.add(btnProfessor);
        toolBar.add(jSeparator2);

        btnCoordenador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/coordenador.png"))); // NOI18N
        btnCoordenador.setToolTipText("Coordenadores");
        btnCoordenador.setFocusable(false);
        btnCoordenador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCoordenador.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCoordenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCoordenadorActionPerformed(evt);
            }
        });
        toolBar.add(btnCoordenador);
        toolBar.add(jSeparator4);

        btnCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/curso.png"))); // NOI18N
        btnCurso.setToolTipText("Curso");
        btnCurso.setFocusable(false);
        btnCurso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCurso.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCursoActionPerformed(evt);
            }
        });
        toolBar.add(btnCurso);
        toolBar.add(jSeparator7);

        btnDisciplina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/matriz_curricular.png"))); // NOI18N
        btnDisciplina.setToolTipText("Disciplina");
        btnDisciplina.setFocusable(false);
        btnDisciplina.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDisciplina.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisciplinaActionPerformed(evt);
            }
        });
        toolBar.add(btnDisciplina);
        toolBar.add(jSeparator8);

        btnTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/turma.png"))); // NOI18N
        btnTurma.setToolTipText("Turma");
        btnTurma.setFocusable(false);
        btnTurma.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTurma.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTurmaActionPerformed(evt);
            }
        });
        toolBar.add(btnTurma);
        toolBar.add(jSeparator9);

        btnAlocar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/alocacao.png"))); // NOI18N
        btnAlocar.setToolTipText("Alocação");
        btnAlocar.setFocusable(false);
        btnAlocar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlocar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAlocar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlocarActionPerformed(evt);
            }
        });
        toolBar.add(btnAlocar);
        toolBar.add(jSeparator10);

        btnOferta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/oferta.png"))); // NOI18N
        btnOferta.setToolTipText("Oferta");
        btnOferta.setFocusable(false);
        btnOferta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOferta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOfertaActionPerformed(evt);
            }
        });
        toolBar.add(btnOferta);
        toolBar.add(jSeparator15);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/sair.png"))); // NOI18N
        btnSair.setToolTipText("Sair");
        btnSair.setFocusable(false);
        btnSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        toolBar.add(btnSair);
        toolBar.add(jSeparator13);

        getContentPane().add(toolBar, java.awt.BorderLayout.PAGE_START);

        pnlPrincipal.setBackground(new java.awt.Color(0, 153, 102));
        pnlPrincipal.setPreferredSize(new java.awt.Dimension(800, 400));
        pnlPrincipal.setLayout(new javax.swing.OverlayLayout(pnlPrincipal));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel1.setLayout(null);

        lblNomeCoordenador.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        lblNomeCoordenador.setForeground(new java.awt.Color(240, 240, 240));
        lblNomeCoordenador.setText("User");
        jPanel1.add(lblNomeCoordenador);
        lblNomeCoordenador.setBounds(1540, 900, 40, 20);

        lblDataAtual.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        lblDataAtual.setForeground(new java.awt.Color(240, 240, 240));
        lblDataAtual.setText("00/00/0000");
        jPanel1.add(lblDataAtual);
        lblDataAtual.setBounds(1500, 930, 80, 20);

        pnlPrincipal.add(jPanel1);

        getContentPane().add(pnlPrincipal, java.awt.BorderLayout.CENTER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/background.jpg"))); // NOI18N
        getContentPane().add(jLabel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfessorActionPerformed
        ctrlPrincipal.getCtrlProfessor().instanciarTelaBuscaProfessor(this);
    }//GEN-LAST:event_btnProfessorActionPerformed

    private void btnCoordenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCoordenadorActionPerformed
        ctrlPrincipal.getCtrlCoordenador().instanciarTelaBuscaCoordenador(this);
    }//GEN-LAST:event_btnCoordenadorActionPerformed

    private void btnCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCursoActionPerformed
        ctrlPrincipal.getCtrlCurso().instanciarTelaBuscaCurso(this);
    }//GEN-LAST:event_btnCursoActionPerformed

    private void btnDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisciplinaActionPerformed
        ctrlPrincipal.getCtrlDisciplina().instanciarTelaBuscaDisciplina(this);
    }//GEN-LAST:event_btnDisciplinaActionPerformed

    private void btnOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOfertaActionPerformed
        ctrlPrincipal.instanciarFrameOferta();
    }//GEN-LAST:event_btnOfertaActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        ctrlPrincipal.encerrarSessao();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurmaActionPerformed
        ctrlPrincipal.getCtrlTurma().instanciarTelaBuscaTurma(this);
    }//GEN-LAST:event_btnTurmaActionPerformed

    private void btnAlocarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlocarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlocarActionPerformed
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlocar;
    private javax.swing.JButton btnCoordenador;
    private javax.swing.JButton btnCurso;
    private javax.swing.JButton btnDisciplina;
    private javax.swing.JButton btnOferta;
    private javax.swing.JButton btnProfessor;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnTurma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JToolBar.Separator jSeparator15;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JLabel lblDataAtual;
    private javax.swing.JLabel lblNomeCoordenador;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
}
