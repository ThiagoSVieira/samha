package cih.professor;

import cci.CtrlPrincipal;
import cdp.Coordenadoria;
import cdp.Professor;
import cdp.RestricaoProfessor;
import java.awt.event.KeyEvent;
import java.util.List;

public class JDCadastrarProfessor extends javax.swing.JDialog {

    private CtrlPrincipal ctrlPrincipal;
    private Professor professor;
    private List<RestricaoProfessor> listaRestricoes;
    private List<Coordenadoria> listaCoordenadorias;

    public JDCadastrarProfessor(java.awt.Frame parent, boolean modal, CtrlPrincipal ctrl, Professor professor) {
        super(parent, modal);
        initComponents();
        this.ctrlPrincipal = ctrl;
        this.professor = professor;
        setarBackground();
    }
    
    private void setarBackground(){
        pnlGeral.setBackground(ctrlPrincipal.setarCorPanelExterior());
        pnlAulas.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlDadosPessoais.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlDescricao.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlPrioridade.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlRestricoes.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlRodape.setBackground(ctrlPrincipal.setarCorPanelInterior());
        chxAula1.setBackground(ctrlPrincipal.setarCorPanelInterior());
        chxAula2.setBackground(ctrlPrincipal.setarCorPanelInterior());
        chxAula3.setBackground(ctrlPrincipal.setarCorPanelInterior());
        chxAula4.setBackground(ctrlPrincipal.setarCorPanelInterior());
        chxAula5.setBackground(ctrlPrincipal.setarCorPanelInterior());
        chxAula6.setBackground(ctrlPrincipal.setarCorPanelInterior());
        rbtnAlta.setBackground(ctrlPrincipal.setarCorPanelInterior());
        rbtnBaixa.setBackground(ctrlPrincipal.setarCorPanelInterior());
        rbtnMedia.setBackground(ctrlPrincipal.setarCorPanelInterior());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupPrioridade = new javax.swing.ButtonGroup();
        pnlGeral = new javax.swing.JPanel();
        pnlDadosPessoais = new javax.swing.JPanel();
        lblCargaHoraria = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        lblNome1 = new javax.swing.JLabel();
        lblMatricula1 = new javax.swing.JLabel();
        lblCoordenadoria = new javax.swing.JLabel();
        cbxCoordenadoria = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        spnCargaHoraria = new javax.swing.JSpinner();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        chxAtivo = new javax.swing.JCheckBox();
        pnlRodape = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlRestricoes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstRestricoes = new javax.swing.JList<>();
        lblDia = new javax.swing.JLabel();
        cbxDias = new javax.swing.JComboBox<>();
        lblTurno = new javax.swing.JLabel();
        cbxTurnos = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        pnlAulas = new javax.swing.JPanel();
        chxAula1 = new javax.swing.JCheckBox();
        chxAula2 = new javax.swing.JCheckBox();
        chxAula3 = new javax.swing.JCheckBox();
        chxAula4 = new javax.swing.JCheckBox();
        chxAula5 = new javax.swing.JCheckBox();
        chxAula6 = new javax.swing.JCheckBox();
        btnRemover = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        pnlDescricao = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaDescricao = new javax.swing.JTextArea();
        lblNomeRestricao = new javax.swing.JLabel();
        txtNomeRestricao = new javax.swing.JTextField();
        pnlPrioridade = new javax.swing.JPanel();
        rbtnBaixa = new javax.swing.JRadioButton();
        rbtnMedia = new javax.swing.JRadioButton();
        rbtnAlta = new javax.swing.JRadioButton();
        btnLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Professor");
        setResizable(false);

        pnlGeral.setBackground(new java.awt.Color(0, 153, 102));

        pnlDadosPessoais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        lblCargaHoraria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblCargaHoraria.setText("C.H.:");

        txtMatricula.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        txtNome.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        lblNome1.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblNome1.setText("Nome:");

        lblMatricula1.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblMatricula1.setText("Matrícula:");

        lblCoordenadoria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblCoordenadoria.setText("Coordenadoria:");

        cbxCoordenadoria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxCoordenadoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel1.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel1.setText("Horas.");

        spnCargaHoraria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        spnCargaHoraria.setModel(new javax.swing.SpinnerNumberModel(40, 20, 40, 5));

        lblEmail.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblEmail.setText("Email:");

        txtEmail.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        chxAtivo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        chxAtivo.setSelected(true);
        chxAtivo.setText("Ativo");

        javax.swing.GroupLayout pnlDadosPessoaisLayout = new javax.swing.GroupLayout(pnlDadosPessoais);
        pnlDadosPessoais.setLayout(pnlDadosPessoaisLayout);
        pnlDadosPessoaisLayout.setHorizontalGroup(
            pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCoordenadoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNome1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosPessoaisLayout.createSequentialGroup()
                        .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome)
                            .addComponent(txtEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMatricula1)
                            .addComponent(lblCargaHoraria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlDadosPessoaisLayout.createSequentialGroup()
                                .addComponent(spnCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(pnlDadosPessoaisLayout.createSequentialGroup()
                        .addComponent(cbxCoordenadoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(chxAtivo)))
                .addContainerGap())
        );
        pnlDadosPessoaisLayout.setVerticalGroup(
            pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosPessoaisLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMatricula1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosPessoaisLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDadosPessoaisLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chxAtivo))
                .addContainerGap())
        );

        pnlRodape.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSalvar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/save.png"))); // NOI18N
        btnSalvar.setToolTipText("Salvar");
        btnSalvar.setBorder(null);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        btnSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSalvarKeyPressed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/close.png"))); // NOI18N
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.setBorder(null);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnlRodapeLayout = new javax.swing.GroupLayout(pnlRodape);
        pnlRodape.setLayout(pnlRodapeLayout);
        pnlRodapeLayout.setHorizontalGroup(
            pnlRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRodapeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlRodapeLayout.setVerticalGroup(
            pnlRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRodapeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlRestricoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Restrições", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        lstRestricoes.setBackground(new java.awt.Color(204, 255, 204));
        lstRestricoes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lstRestricoes.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        lstRestricoes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstRestricoes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstRestricoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstRestricoesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstRestricoes);

        lblDia.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblDia.setText("Dia:");

        cbxDias.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxDias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SEGUNDA-FEIRA", "TERÇA-FEIRA", "QUARTA-FEIRA", "QUINTA-FEIRA", "SEXTA-FEIRA" }));

        lblTurno.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblTurno.setText("Turno:");

        cbxTurnos.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxTurnos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MATUTINO", "VESPERTINO", "NOTURNO" }));

        pnlAulas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aulas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        chxAula1.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        chxAula1.setText("Aula 1");

        chxAula2.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        chxAula2.setText("Aula 2");

        chxAula3.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        chxAula3.setText("Aula 3");

        chxAula4.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        chxAula4.setText("Aula 4");

        chxAula5.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        chxAula5.setText("Aula 5");

        chxAula6.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        chxAula6.setText("Aula 6");

        javax.swing.GroupLayout pnlAulasLayout = new javax.swing.GroupLayout(pnlAulas);
        pnlAulas.setLayout(pnlAulasLayout);
        pnlAulasLayout.setHorizontalGroup(
            pnlAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAulasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlAulasLayout.createSequentialGroup()
                        .addComponent(chxAula4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chxAula5))
                    .addGroup(pnlAulasLayout.createSequentialGroup()
                        .addComponent(chxAula1)
                        .addGap(18, 18, 18)
                        .addComponent(chxAula2)))
                .addGap(18, 18, 18)
                .addGroup(pnlAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chxAula3)
                    .addComponent(chxAula6)))
        );
        pnlAulasLayout.setVerticalGroup(
            pnlAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAulasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chxAula1)
                    .addComponent(chxAula2)
                    .addComponent(chxAula3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chxAula4)
                    .addComponent(chxAula5)
                    .addComponent(chxAula6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRemover.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/trash.png"))); // NOI18N
        btnRemover.setText("Remover");
        btnRemover.setToolTipText("Remover");
        btnRemover.setBorder(null);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnAdicionar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/plus.png"))); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.setToolTipText("Adicionar");
        btnAdicionar.setBorder(null);
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        pnlDescricao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descrição", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 14))); // NOI18N

        txtAreaDescricao.setColumns(20);
        txtAreaDescricao.setLineWrap(true);
        txtAreaDescricao.setRows(5);
        jScrollPane2.setViewportView(txtAreaDescricao);

        javax.swing.GroupLayout pnlDescricaoLayout = new javax.swing.GroupLayout(pnlDescricao);
        pnlDescricao.setLayout(pnlDescricaoLayout);
        pnlDescricaoLayout.setHorizontalGroup(
            pnlDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnlDescricaoLayout.setVerticalGroup(
            pnlDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        lblNomeRestricao.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblNomeRestricao.setText("Nome:");

        txtNomeRestricao.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        pnlPrioridade.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Prioridade", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        btnGroupPrioridade.add(rbtnBaixa);
        rbtnBaixa.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnBaixa.setMnemonic('b');
        rbtnBaixa.setSelected(true);
        rbtnBaixa.setText("Baixa");

        btnGroupPrioridade.add(rbtnMedia);
        rbtnMedia.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnMedia.setMnemonic('m');
        rbtnMedia.setText("Média");

        btnGroupPrioridade.add(rbtnAlta);
        rbtnAlta.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnAlta.setMnemonic('a');
        rbtnAlta.setText("Alta");

        javax.swing.GroupLayout pnlPrioridadeLayout = new javax.swing.GroupLayout(pnlPrioridade);
        pnlPrioridade.setLayout(pnlPrioridadeLayout);
        pnlPrioridadeLayout.setHorizontalGroup(
            pnlPrioridadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrioridadeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrioridadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnBaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbtnMedia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbtnAlta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlPrioridadeLayout.setVerticalGroup(
            pnlPrioridadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrioridadeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbtnBaixa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnMedia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnAlta)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        btnLimpar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/eraser.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.setToolTipText("Limpar");
        btnLimpar.setBorder(null);
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRestricoesLayout = new javax.swing.GroupLayout(pnlRestricoes);
        pnlRestricoes.setLayout(pnlRestricoesLayout);
        pnlRestricoesLayout.setHorizontalGroup(
            pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRestricoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRestricoesLayout.createSequentialGroup()
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlRestricoesLayout.createSequentialGroup()
                        .addComponent(lblNomeRestricao)
                        .addGap(18, 18, 18)
                        .addComponent(txtNomeRestricao))
                    .addGroup(pnlRestricoesLayout.createSequentialGroup()
                        .addComponent(lblTurno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblDia, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlRestricoesLayout.createSequentialGroup()
                        .addGroup(pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pnlDescricao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlAulas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlPrioridade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlRestricoesLayout.setVerticalGroup(
            pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRestricoesLayout.createSequentialGroup()
                .addGroup(pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRestricoesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlRestricoesLayout.createSequentialGroup()
                            .addGroup(pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNomeRestricao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNomeRestricao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbxDias, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pnlPrioridade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnlAulas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlRestricoesLayout.createSequentialGroup()
                                    .addGap(4, 4, 4)
                                    .addComponent(pnlDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRestricoesLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(23, 23, 23))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlGeralLayout = new javax.swing.GroupLayout(pnlGeral);
        pnlGeral.setLayout(pnlGeralLayout);
        pnlGeralLayout.setHorizontalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDadosPessoais, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlRestricoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlGeralLayout.setVerticalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRestricoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void setarCamposComInstancia(Professor professor) {
        txtNome.setText(professor.getNome());
        txtMatricula.setText(professor.getMatricula());
        txtEmail.setText(professor.getEmail());
        int ch = (int) professor.getCargaHoraria();
        spnCargaHoraria.setValue(ch);
        chxAtivo.setSelected(professor.isAtivo());
    }
    
    public void setarCoordenadoria(){
        ctrlPrincipal.getCtrlProfessor().setarCoordenadoria(cbxCoordenadoria);
    }
    
    private void setarRestricaoTela(){
        
        if (lstRestricoes.isEnabled()) {
            
            if (!listaRestricoes.isEmpty()) {
                
                int posicao = lstRestricoes.getSelectedIndex();
                RestricaoProfessor restricao = listaRestricoes.get(posicao);

                if (restricao != null) {
                    txtNomeRestricao.setText(restricao.getNome());
                    chxAula1.setSelected(restricao.isAula1());
                    chxAula2.setSelected(restricao.isAula2());
                    chxAula3.setSelected(restricao.isAula3());
                    chxAula4.setSelected(restricao.isAula4());
                    chxAula5.setSelected(restricao.isAula5());
                    chxAula6.setSelected(restricao.isAula6());
                    txtAreaDescricao.setText(restricao.getDescricao());

                    String turno = restricao.getTurno();

                    switch (turno) {
                        case "MATUTINO":
                            cbxTurnos.setSelectedIndex(0);
                            break;
                        case "VESPERTINO":
                            cbxTurnos.setSelectedIndex(1);
                            break;
                        default:
                            cbxTurnos.setSelectedIndex(2);
                            break;
                    }

                    int dia = restricao.getDia();

                    switch (dia) {
                        case 0:
                            cbxDias.setSelectedIndex(0);
                            break;
                        case 1:
                            cbxDias.setSelectedIndex(1);
                            break;
                        case 2:
                            cbxDias.setSelectedIndex(2);
                            break;
                        case 3:
                            cbxDias.setSelectedIndex(3);
                            break;
                        default:
                            cbxDias.setSelectedIndex(4);
                            break;
                    }

                    String prioridade = restricao.getPrioridade();

                    switch (prioridade) {
                        case "BAIXA":
                            rbtnBaixa.setSelected(true);
                            break;
                        case "MÉDIA":
                            rbtnMedia.setSelected(true);
                            break;
                        default:
                            rbtnAlta.setSelected(true);
                            break;
                    }
                }
            }
        }
    }

    public void preencherComboCoordenadorias() {
        ctrlPrincipal.getCtrlProfessor().preencherComboCoordenadorias(cbxCoordenadoria);
    }

    public void preencherListaRestricoes() {
        ctrlPrincipal.getCtrlProfessor().preencherListaRestricoes(lstRestricoes);
    }

    public void desabilitarCamposProfessor(boolean opcao) {
        txtNome.setEnabled(opcao);
        txtMatricula.setEnabled(opcao);
        txtEmail.setEnabled(opcao);
        spnCargaHoraria.setEnabled(opcao);
        cbxCoordenadoria.setEnabled(opcao);
        chxAtivo.setEnabled(opcao);
        btnSalvar.setEnabled(opcao);
        btnCancelar.setText("Sair");
    }

    public void habilitarCamposRestricao(boolean opcao) {
        txtNomeRestricao.setEnabled(opcao);
        cbxTurnos.setEnabled(opcao);
        cbxDias.setEnabled(opcao);
        lstRestricoes.setEnabled(opcao);
        chxAula1.setEnabled(opcao);
        chxAula2.setEnabled(opcao);
        chxAula3.setEnabled(opcao);
        chxAula4.setEnabled(opcao);
        chxAula5.setEnabled(opcao);
        chxAula6.setEnabled(opcao);
        rbtnAlta.setEnabled(opcao);
        rbtnBaixa.setEnabled(opcao);
        rbtnMedia.setEnabled(opcao);
        btnAdicionar.setEnabled(opcao);
        btnRemover.setEnabled(opcao);
        btnLimpar.setEnabled(opcao);
        txtAreaDescricao.setEnabled(opcao);
    }
    
    public void limparTelaRestricao(){
        txtNomeRestricao.setText("");
        cbxTurnos.setSelectedIndex(0);
        cbxDias.setSelectedIndex(0);
        chxAula1.setSelected(false);
        chxAula2.setSelected(false);
        chxAula3.setSelected(false);
        chxAula4.setSelected(false);
        chxAula5.setSelected(false);
        chxAula6.setSelected(false);
        rbtnBaixa.setSelected(true);
        txtAreaDescricao.setText("");
    }
    
    public void adicionarRestricao(){
        
        String nome = txtNomeRestricao.getText();
        String turno = cbxTurnos.getSelectedItem().toString();
        int dia = cbxDias.getSelectedIndex();
        String descricao = txtAreaDescricao.getText();
        String prioridade;
        char priori = (char) btnGroupPrioridade.getSelection().getMnemonic();

        switch (priori) {
            case 'B':
                prioridade = "BAIXA";
                break;
            case 'M':
                prioridade = "MÉDIA";
                break;
            default:
                prioridade = "ALTA";
                break;
        }

        boolean aula1 = chxAula1.isSelected();
        boolean aula2 = chxAula2.isSelected();
        boolean aula3 = chxAula3.isSelected();
        boolean aula4 = chxAula4.isSelected();
        boolean aula5 = chxAula5.isSelected();
        boolean aula6 = chxAula6.isSelected();

        ctrlPrincipal.getCtrlProfessor().adicionarRestricao(nome, turno, dia, descricao, prioridade, 
                aula1, aula2, aula3, aula4, aula5, aula6, professor);
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<RestricaoProfessor> getListaRestricoes() {
        return listaRestricoes;
    }

    public void setListaRestricoes(List<RestricaoProfessor> listaRestricoes) {
        this.listaRestricoes = listaRestricoes;
    }

    public List<Coordenadoria> getListaCoordenadorias() {
        return listaCoordenadorias;
    }

    public void setListaCoordenadorias(List<Coordenadoria> listaCoordenadorias) {
        this.listaCoordenadorias = listaCoordenadorias;
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        String nome = txtNome.getText();
        String matricula = txtMatricula.getText();
        String email = txtEmail.getText();
        int cargaHoraria = (int) spnCargaHoraria.getValue();
        boolean ativo = chxAtivo.isSelected();
        
        Coordenadoria coordenadoria = null;
        
        if(listaCoordenadorias.size() > 0)
            coordenadoria = (Coordenadoria) cbxCoordenadoria.getSelectedItem();
        
        ctrlPrincipal.getCtrlProfessor().validarOperacao(nome, matricula, cargaHoraria, coordenadoria, email, ativo);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalvarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnSalvarActionPerformed(null);
        }
    }//GEN-LAST:event_btnSalvarKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        adicionarRestricao();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        ctrlPrincipal.getCtrlProfessor().removerRestricao(lstRestricoes);
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparTelaRestricao();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void lstRestricoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstRestricoesMouseClicked
        setarRestricaoTela();
    }//GEN-LAST:event_lstRestricoesMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup btnGroupPrioridade;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxCoordenadoria;
    private javax.swing.JComboBox<String> cbxDias;
    private javax.swing.JComboBox<String> cbxTurnos;
    private javax.swing.JCheckBox chxAtivo;
    private javax.swing.JCheckBox chxAula1;
    private javax.swing.JCheckBox chxAula2;
    private javax.swing.JCheckBox chxAula3;
    private javax.swing.JCheckBox chxAula4;
    private javax.swing.JCheckBox chxAula5;
    private javax.swing.JCheckBox chxAula6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCargaHoraria;
    private javax.swing.JLabel lblCoordenadoria;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblMatricula1;
    private javax.swing.JLabel lblNome1;
    private javax.swing.JLabel lblNomeRestricao;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JList<String> lstRestricoes;
    private javax.swing.JPanel pnlAulas;
    private javax.swing.JPanel pnlDadosPessoais;
    private javax.swing.JPanel pnlDescricao;
    private javax.swing.JPanel pnlGeral;
    private javax.swing.JPanel pnlPrioridade;
    private javax.swing.JPanel pnlRestricoes;
    private javax.swing.JPanel pnlRodape;
    private javax.swing.JRadioButton rbtnAlta;
    private javax.swing.JRadioButton rbtnBaixa;
    private javax.swing.JRadioButton rbtnMedia;
    private javax.swing.JSpinner spnCargaHoraria;
    private javax.swing.JTextArea txtAreaDescricao;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeRestricao;
    // End of variables declaration//GEN-END:variables
}
