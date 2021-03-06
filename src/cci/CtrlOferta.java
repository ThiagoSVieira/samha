package cci;

import cdp.Alocacao;
import cdp.Aula;
import cdp.Curso;
import cdp.Disciplina;
import cdp.Oferta;
import cdp.Professor;
import cdp.Turma;
import cgt.Constantes;
import cgt.Horarios;
import cih.oferta.JDOferta;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JToggleButton;

public class CtrlOferta extends CtrlGenerica{
    
    private CtrlPrincipal ctrlPrincipal;
    private JDOferta jdOferta;
    private List listaAlocacoes;
    private boolean abrindoTela = true;
    private boolean[] vetorProfessores;
    private String nomeProfessor;
    private RenderizadorCelulas renderTabelaProfessor;

    public CtrlOferta(CtrlPrincipal ctrl) {
        ctrlPrincipal = ctrl;
        renderTabelaProfessor = new RenderizadorCelulas(ctrlPrincipal, 2);
    }
    
    public void instanciarTelaOferta(Frame pai) {
        jdOferta = new JDOferta(pai, true, ctrlPrincipal);
        jdOferta.setIconImage(setarIconeJanela());
        jdOferta.preencherComboCurso();
        jdOferta.identificarUltimaOfertaTurma();
        jdOferta.setarPeriodo();
        jdOferta.atualizarTela();
        jdOferta.setVisible(true);
    }
    
    public Image setarIconeJanela() {
        ImageIcon icone = new ImageIcon("src/cih/img/oferta-white.png");
        return icone.getImage();
    }
    
    public void preencherComboCurso(JComboBox cbxCurso, JComboBox cbxTurma){ 
       
        List listaCursos = ctrlPrincipal.getCtrlCurso().listar();
        preencherCombo(cbxCurso, listaCursos);
        
        if(listaCursos.size() > 0)
            preencherComboTurma(cbxCurso, cbxTurma, false);
            
    }
    
    public void preencherComboTurma(JComboBox cbxCurso, JComboBox cbxTurma, boolean alterandoAnoSemestre) {
        
        Turma turmaSelecionada = (Turma) cbxTurma.getSelectedItem();
        
        jdOferta.setarTurma("");
        Curso curso = (Curso) cbxCurso.getSelectedItem();
        if(curso != null){
            jdOferta.setarPeriodoMaximo(curso.getQtPeriodos());
            List<Turma> listaTurmas = ctrlPrincipal.getCtrlTurma().buscar("curso", String.valueOf(curso.getId()));
            listaTurmas = ctrlPrincipal.getGtPrincipal().getGtTurma().filtrarTurmasAtivas(listaTurmas, jdOferta.getAno(), jdOferta.getSemestre());
            preencherCombo(cbxTurma, listaTurmas);
            ctrlPrincipal.getCtrlTurma().setarTurmaSelecionada(turmaSelecionada, listaTurmas, cbxTurma, alterandoAnoSemestre); 
        }  
    }
    
    public void identificarUltimaOfertaValidaTurma(JComboBox cbxTurma){
        Turma turma = (Turma) cbxTurma.getSelectedItem();
        if(turma != null){
            Oferta oferta = ctrlPrincipal.getGtPrincipal().getGtOferta().filtrarUltimaOfertaValidaTurma(turma.getId());
            atualizarAnoSemestreEmTela(oferta);
        }    
    }
    
    public void atualizarAnoSemestreEmTela(Oferta oferta){
        if(oferta != null){
            jdOferta.getSpnAno().setEnabled(false);
            jdOferta.getSpnAno().setValue(oferta.getAno());
            jdOferta.getSpnAno().setEnabled(true);

            jdOferta.getSpnSemestre().setEnabled(false);
            jdOferta.getSpnSemestre().setValue(oferta.getSemestre());
            jdOferta.getSpnSemestre().setEnabled(true);    
        }
    }
    
    public void atualizarTela(int ano, int semestre, int tempoMaximo, int intervaloMinimo, int periodo,
            JComboBox cbxTurma, JComboBox cbxTurno, JList lstAlocacoes, JTable tblTurma, JToggleButton btnCQD){
        
        verificarAulasPendentes();
        limparTela(tblTurma);
        
        Turma turma = (Turma) cbxTurma.getSelectedItem();
        
        if(turma != null){
            
            if(isAbrindoTela()){
                setarTurno(turma.getTurno(), cbxTurno);
                setAbrindoTela(false);
            }    
            String turno = (String) cbxTurno.getSelectedItem(); 
            identificarOferta(ano, semestre, tempoMaximo, intervaloMinimo, turma, tblTurma, turno);
            validarOferta(tblTurma, btnCQD);
        }
        
        preencherListaAlocacoes(ano, semestre, periodo, turma, lstAlocacoes, tblTurma);
        setarAlocacao();
    }
    
    public void setarPeriodoTurma(int ano, int semestre, JComboBox cbxTurma){
        
        Turma turma = (Turma) cbxTurma.getSelectedItem();
        jdOferta.getSpnPeriodo().setEnabled(false);
        
        if(turma != null){
            int periodo = ctrlPrincipal.getGtPrincipal().getGtTurma().obterInteiroAnoSemestreAtual(ano, semestre, turma);
            jdOferta.getSpnPeriodo().setValue(periodo);
        }else
            jdOferta.getSpnPeriodo().setValue(1);
        
        jdOferta.getSpnPeriodo().setEnabled(true);
    }
    
    public void atualizarListaAulasAnoSemestre(int ano, int semestre){
        ctrlPrincipal.getGtPrincipal().getGtAula().preencherListaAulasAnoSemestre(ano, semestre);
    }
    
    public void verificarAulasPendentes(){
        
        if(ctrlPrincipal.getCtrlAula().isTemAlteracoes()){
            String mensagem = "Deseja salvar as alterações feitas ?";
            int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(jdOferta, mensagem);
            if (confirmacao == 0) {
                jdOferta.salvarAulas();
                ctrlPrincipal.getCtrlAula().setTemAlteracoes(false);
            }
        }
    }
    
    public void limparTela(JTable tabela){
        
        ctrlPrincipal.getCtrlConflito().limparCorCelulasTabelaTurma();
        limparCorCelulasTabelaProfessor();
        
        JTableUtil.limparCelulasTabela(tabela);
        jdOferta.limparNotificacoes();
        jdOferta.setarMensagem("");
    }
    
    public void atualizarOferta(int tempoMaximo, int intervaloMinimo){
        ctrlPrincipal.getGtPrincipal().getGtOferta().atualizarOferta(tempoMaximo, intervaloMinimo);
    }
    
    public void preencherListaAlocacoes(int ano, int semestre, int periodo, Turma turma, JList lstAlocacoes, JTable tblTurma){
        
        List listaAlocacoes = null;
        setListaAlocacoes(listaAlocacoes);
        if(turma != null){ 
            
            listaAlocacoes = ctrlPrincipal.getGtPrincipal().getGtAlocacao().filtrarPorAnoSemestreMatriz(ano, semestre, periodo, turma.getMatriz().getId());
            setListaAlocacoes(listaAlocacoes);
            
            iniciarVetorProfessores(listaAlocacoes.size());
            
            if(listaAlocacoes.isEmpty())
                jdOferta.setarMensagem("Nenhuma alocação encontrada.");
            
        }else{
            ctrlPrincipal.getGtPrincipal().getGtAula().limparEstruturasArmazenamento();
            jdOferta.setarMensagem("Nenhuma turma encontrada.");
        }
        
        preencherJList(listaAlocacoes, lstAlocacoes); 
    }
    
    public void setarAlocacao(){
        if(listaAlocacoes != null && !listaAlocacoes.isEmpty()){
            jdOferta.getLstAlocacoes().setSelectedIndex(0);
            jdOferta.preencherHorarioProfessor();
        }else
            zerarTabelaProfessor();   
    }
    
    public void identificarOferta(int ano, int semestre, int tempoMaximo, int intervaloMinimo, Turma turma, JTable tblTurma, String turno){
        
        jdOferta.validarOferta(false);
        ctrlPrincipal.getGtPrincipal().getGtOferta().identificarOferta(ano, semestre, tempoMaximo, intervaloMinimo, turno, turma);
        
        jdOferta.setarTurma(turma.getNome());
        
        Oferta oferta = ctrlPrincipal.getGtPrincipal().getGtOferta().getOfertaSelecionada();
        
        if(oferta != null){
            atualizarTempoMaximoIntervaloMinimo(oferta);
            ctrlPrincipal.getCtrlAula().preencherTabelaAulas(tblTurma, turno);
        }
    }
    
    public void atualizarTempoMaximoIntervaloMinimo(Oferta oferta){
        
        jdOferta.getSpnTempoMaximo().setEnabled(false);
        jdOferta.setarTempoMaximo((int) oferta.getTempoMaximoTrabalho());
        jdOferta.getSpnTempoMaximo().setEnabled(true);

        jdOferta.getSpnIntervalo().setEnabled(false);
        jdOferta.setarIntervaloMinimo((int) oferta.getIntervaloMinimo());
        jdOferta.getSpnIntervalo().setEnabled(true);
        
    }
    
    public void setarTurno(String turno, JComboBox cbxTurno){
        switch(turno){
            case Constantes.MATUTINO: cbxTurno.setSelectedIndex(0); break;
            case Constantes.VESPERTINO: cbxTurno.setSelectedIndex(1); break;
            default: cbxTurno.setSelectedIndex(2); break;
        }   
    }
    
    public void alterarTurno(String turno, JTable tblTurma){
     
        switch(turno){
            
            case Constantes.MATUTINO: 
                tblTurma.getColumnModel().getColumn(0).setHeaderValue(Horarios.MATUTINO_1);
                tblTurma.getColumnModel().getColumn(1).setHeaderValue(Horarios.MATUTINO_2);
                tblTurma.getColumnModel().getColumn(2).setHeaderValue(Horarios.MATUTINO_3);
                tblTurma.getColumnModel().getColumn(3).setHeaderValue(Horarios.MATUTINO_4);
                tblTurma.getColumnModel().getColumn(4).setHeaderValue(Horarios.MATUTINO_5);
                tblTurma.getColumnModel().getColumn(5).setHeaderValue(Horarios.MATUTINO_6);
                break;
                
            case Constantes.VESPERTINO: 
                tblTurma.getColumnModel().getColumn(0).setHeaderValue(Horarios.VESPERTINO_1);
                tblTurma.getColumnModel().getColumn(1).setHeaderValue(Horarios.VESPERTINO_2);
                tblTurma.getColumnModel().getColumn(2).setHeaderValue(Horarios.VESPERTINO_3);
                tblTurma.getColumnModel().getColumn(3).setHeaderValue(Horarios.VESPERTINO_4);
                tblTurma.getColumnModel().getColumn(4).setHeaderValue(Horarios.VESPERTINO_5);
                tblTurma.getColumnModel().getColumn(5).setHeaderValue(Horarios.VESPERTINO_6);
                break;
                
            default:
                tblTurma.getColumnModel().getColumn(0).setHeaderValue(Horarios.NOTURNO_1);
                tblTurma.getColumnModel().getColumn(1).setHeaderValue(Horarios.NOTURNO_2);
                tblTurma.getColumnModel().getColumn(2).setHeaderValue(Horarios.NOTURNO_3);
                tblTurma.getColumnModel().getColumn(3).setHeaderValue(Horarios.NOTURNO_4);
                tblTurma.getColumnModel().getColumn(4).setHeaderValue(Horarios.NOTURNO_5);
                tblTurma.getColumnModel().getColumn(5).setHeaderValue(Horarios.NOTURNO_6);
                break;
        } 
    }    
    
    public void validarOferta(JTable tabela, JToggleButton btnCQD){
        
        if(ctrlPrincipal.getGtPrincipal().getGtOferta().getOfertaSelecionada() != null){
            
            ctrlPrincipal.getCtrlConflito().validarOferta(tabela, jdOferta);
            if(btnCQD.isSelected()){
                btnCQD.setBackground(Color.BLUE);
                ctrlPrincipal.getCtrlConflito().validarQuantidadeAulasDisciplina();
            }else
                btnCQD.setBackground(new Color(240, 240, 240));
        }
    }

    public List getListaAlocacoes() {
        return listaAlocacoes;
    }

    public void setListaAlocacoes(List listaAlocacoes) {
        this.listaAlocacoes = listaAlocacoes;
    }

    public boolean isAbrindoTela() {
        return abrindoTela;
    }

    public void setAbrindoTela(boolean abrindoTela) {
        this.abrindoTela = abrindoTela;
    }

    public JDOferta getJdOferta() {
        return jdOferta;
    }

    //================================================= TABELA DE PROFESSOR ================================================================
    
    public void preencherHorarioProfessor(JList lstAlocacoes, JTable tblProfessor, JComboBox cbxQuantidadeProfessor){
        
        if (listaAlocacoes != null && !listaAlocacoes.isEmpty()) {
            
            int indice = lstAlocacoes.getSelectedIndex();
            Alocacao alocacao = (Alocacao) listaAlocacoes.get(indice);
            
            Disciplina disciplina = alocacao.getDisciplina();
            habilitarComboProfessor(disciplina, cbxQuantidadeProfessor);
            identificarProfessorSelecionado(lstAlocacoes, tblProfessor, cbxQuantidadeProfessor);
        }
    }
    
    public void habilitarComboProfessor(Disciplina disciplina, JComboBox cbxProfessor){
        if(disciplina.getTipo().equals(Constantes.ESPECIAL))
            cbxProfessor.setEnabled(true);
        else{
            cbxProfessor.setEnabled(false);
            cbxProfessor.setSelectedIndex(0);
        }
    }
    
    public void identificarProfessorSelecionado(JList lstAlocacoes, JTable tblProfessor, JComboBox cbxQuantidadeProfessor){
        
        int numero = cbxQuantidadeProfessor.getSelectedIndex();
        int indice = lstAlocacoes.getSelectedIndex();
        
        if(indice >= 0){
            
            Alocacao alocacao = (Alocacao) listaAlocacoes.get(indice);
            Professor professor = alocacao.getProfessor1();
            
            if(numero == 1)
                professor = alocacao.getProfessor2();
            
            List listaAulas = ctrlPrincipal.getGtPrincipal().getGtAula().filtrarAulasProfessorLista(professor.getId());
            
            jdOferta.setarProfessor(professor.getNome());
            setNomeProfessor(professor.getNome());
            
            preencherTabelaProfessor(tblProfessor, listaAulas, indice, professor.getId());
        } 
    }
    
    public void preencherTabelaProfessor(JTable tblProfessor, List listaAulas, int indice, int idProfessor){
 
        Color corErro = new Color(255, 73, 73);
        renderTabelaProfessor.gerarMatrizCores();
        JTableUtil.limparCelulasTabela(tblProfessor);

        Aula aula;        
        for(int i = 0; i < listaAulas.size(); i++){
            aula = (Aula) listaAulas.get(i);
            
            tblProfessor.setValueAt(aula.getOferta().getTurma().getNome(), aula.getDia(), aula.getNumero());
            
            if(identificarConflitoAulaProfessor(aula, idProfessor))
                pintarCelulaTabelaProfessor(aula.getDia(), aula.getNumero(), corErro);
            else
                pintarCelulaTabelaProfessor(aula.getDia(), aula.getNumero(), Color.WHITE);
        }
        
        if(!vetorProfessores[indice])
            exibirMensagemProfessorDesatualizado();
    }
    
    public boolean identificarConflitoAulaProfessor(Aula aula, int idProfessor){
        
        int numero = identificarNumeroProfessor(aula, idProfessor);
        
        String conflitoTurma = ctrlPrincipal.getGtPrincipal().getGtConflito().identificarConflitoTurma(aula, idProfessor);
        if(conflitoTurma != null)
            return true;
         
        String conflitoRestricaoProfessor = ctrlPrincipal.getGtPrincipal().getGtConflito().identificarConflitoRestricaoProfessor(aula, idProfessor);
        if(conflitoRestricaoProfessor != null)
            return true;
        
        ctrlPrincipal.getGtPrincipal().getGtInstituicao().setValidacaoGeral(true);
        List conflitoInstituicao = ctrlPrincipal.getGtPrincipal().getGtInstituicao().identificarConflitoRestricaoInstituicao(aula, numero);
        ctrlPrincipal.getGtPrincipal().getGtInstituicao().setValidacaoGeral(false);
        
        if(!conflitoInstituicao.isEmpty())
            return true;
        
        return false;
    }
    
    public int identificarNumeroProfessor(Aula aula, int idProfessor){
     
        if(aula.getAlocacao().getProfessor1().getId() == idProfessor)
            return 1;
        return 2;
    }

    public void pintarCelulaTabelaProfessor(int linha, int coluna, Color cor){
        renderTabelaProfessor.setColorMatriz(linha, coluna, cor);
        if(jdOferta != null)
            jdOferta.getTblProfessor().repaint();
    }

    public void limparCorCelulasTabelaProfessor(){
        for(int linha = 0; linha < Constantes.LINHA; linha++){  
            for(int coluna = 0; coluna < Constantes.COLUNA; coluna++){
                pintarCelulaTabelaProfessor(linha, coluna, Color.WHITE);
            }   
        }
    }
    
    public void zerarTabelaProfessor(){
        jdOferta.setarProfessor("");
        jdOferta.getCbxQuantidadeProfessor().setSelectedIndex(0);
        jdOferta.getCbxQuantidadeProfessor().setEnabled(false);
        JTableUtil.limparCelulasTabela(jdOferta.getTblProfessor());
    }
    
    public void desatualizarVetorProfessor(int indice){  
        if(indice >= 0){
            vetorProfessores[indice] = false;
            exibirMensagemProfessorDesatualizado();
        }
    }
    
    public void exibirMensagemProfessorDesatualizado(){
        String nomeProfessor = getNomeProfessor();
        jdOferta.setarProfessor(nomeProfessor + " - Aulas desatualizadas", Color.RED); 
    }
    
    public void identificarProfessor(Aula aula){
        
        Alocacao alocacao;
        for(int indice = 0; indice < listaAlocacoes.size(); indice++){
            alocacao = (Alocacao) listaAlocacoes.get(indice);
            if(alocacao.getProfessor1().getId() == aula.getAlocacao().getProfessor1().getId()){
                setNomeProfessor(alocacao.getProfessor1().getNome());
                desatualizarVetorProfessor(indice);
                jdOferta.getLstAlocacoes().setSelectedIndex(indice);
            }
        }  
    }
    
    public void iniciarVetorProfessores(int tam){
        vetorProfessores = new boolean[tam];
        limparVetorProfessores();
    }
    
    public void limparVetorProfessores(){
        
        if(vetorProfessores != null){
            for(int i = 0; i < vetorProfessores.length; i++)
                vetorProfessores[i] = true;     
        }
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public RenderizadorCelulas getRenderTabelaProfessor() {
        return renderTabelaProfessor;
    }
}
