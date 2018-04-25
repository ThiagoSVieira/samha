package cci;

import cdp.Alocacao;
import cdp.Coordenadoria;
import cdp.Curso;
import cdp.Disciplina;
import cdp.Eixo;
import cdp.MatrizCurricular;
import cgt.Constantes;
import cgt.GtAlocacao;
import cih.alocacao.JDAlocacao;
import cih.alocacao.JDCargaHoraria;
import java.awt.Frame;
import java.awt.Image;
import java.lang.reflect.Method;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JTable;

public class CtrlAlocacao extends CtrlGenerica{
    
    private CtrlPrincipal ctrlPrincipal;
    private JDAlocacao cadastraAlocacao;
    private JDCargaHoraria jdCargaHoraria;
    private GtAlocacao gtAlocacao;
    private List listaCoordenadorias;
    private Coordenadoria coordenadoriaSelecionada;

    public CtrlAlocacao(CtrlPrincipal ctrl) {
        ctrlPrincipal = ctrl;
        gtAlocacao = new GtAlocacao();
    }
    
    public Image setarIconeJanela() {
        ImageIcon icone = new ImageIcon("build/classes/cih/img/alocacao.png");
        return icone.getImage();
    }
    
    public void instanciarTelaAlocacao(Frame pai) {
        cadastraAlocacao = new JDAlocacao(pai, true, ctrlPrincipal);
        cadastraAlocacao.setIconImage(setarIconeJanela());
        preencherCombos();
        cadastraAlocacao.setVisible(true);
    }
    
    public void instanciarTelaCargaHoraria(Frame pai){
        
        if(jdCargaHoraria == null)
            jdCargaHoraria = new JDCargaHoraria(pai, true, ctrlPrincipal);
        jdCargaHoraria.setIconImage(setarIconeJanela());
        
        jdCargaHoraria.setVisible(true);
            
    }
    
    public void cadastrar(JList lstProfessores, JList lstDisciplinas, JSpinner spnAno, JSpinner spnSemestre) {
        
        List professores = lstProfessores.getSelectedValuesList();
        Disciplina disciplina = (Disciplina) lstDisciplinas.getSelectedValue();
        int ano = (int) spnAno.getValue();
        int semestre = (int) spnSemestre.getValue();
        
        String resposta = gtAlocacao.cadastrar(professores, disciplina, ano, semestre);

        if (resposta.equals(Constantes.CADASTRADO)) {
            cadastraAlocacao.atualizarTabela();
        } else {
            CtrlMensagem.exibirMensagemErro(cadastraAlocacao, resposta);
        }
    }
    
    public void listarAlocacoes(int ano, int semestre, JTable tabela){
        List listaAlocacoes = gtAlocacao.filtrarPorAnoSemestre(ano, semestre);
        listarEmTabela(listaAlocacoes, tabela, cadastraAlocacao);
    }
    
    public void listarCargaHorariaProfessores(Coordenadoria coordenadoria, JTable tabela){
        
        if(coordenadoria != null){
            List listaProfessores = ctrlPrincipal.getCtrlProfessor().filtrarPorCoordenadoria(coordenadoria.getId());
            int ano = cadastraAlocacao.getAno();
            int semestre = cadastraAlocacao.getSemestre();
            List listaCargasHorarias = gtAlocacao.calcularCargaHorariaProfessor(ano, semestre, listaProfessores);
            listarEmTabelaCargaHoraria(listaCargasHorarias, tabela, jdCargaHoraria);
        }else
            CtrlMensagem.exibirMensagemErro(jdCargaHoraria, "Selecione uma coordenadoria");
    }
    
    public void listarEmTabelaCargaHoraria(List lista, JTable tabela, JDialog janela){
        
        JTableUtil.limparTabela(tabela);
        
        if(lista.size() > 0){
   
            try {
                preencherTabelaCargaHoraria(lista, tabela);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public static void preencherTabelaCargaHoraria(List lista, JTable tabela) throws Exception{
     
        Method metodo;

        for(Object obj : lista){
            metodo = obj.getClass().getMethod("toArrayCargaHoraria", null);
            JTableUtil.addLinha(tabela, (Object[]) metodo.invoke(obj, null));  
        }            
    }
    
    public void excluir(JTable tabela) {
        
        try {
            Alocacao alocacao = (Alocacao) JTableUtil.getDadosLinhaSelecionada(tabela);
            int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(this.cadastraAlocacao, "Confirmar Remoção ?");
            if (confirmacao == 0) {
                String resposta = gtAlocacao.excluir(alocacao);
                if (resposta.equals(Constantes.EXCLUIDO)){ 
                    cadastraAlocacao.atualizarTabela();
                }else 
                    CtrlMensagem.exibirMensagemErro(this.cadastraAlocacao, resposta);   
            }    
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            CtrlMensagem.exibirMensagemErro(cadastraAlocacao, "Selecione uma alocação");
        }
    }
    
    public void preencherCombos(){
        cadastraAlocacao.preencherComboCurso();
        cadastraAlocacao.preencherComboEixo();
    }
    
    public void preencherComboCurso(JComboBox cbxCurso, JComboBox cbxMatriz){ 
        
        List listaCursos = ctrlPrincipal.getCtrlCurso().listar();
        preencherCombo(cbxCurso, listaCursos);
        
        if(listaCursos.size() > 0){
            Curso curso = (Curso) cbxCurso.getSelectedItem();
            preencherComboMatriz(curso.getId(), cbxMatriz);
            cadastraAlocacao.setarPeriodoMaximo(curso.getQtPeriodos());
        }
    }

    public void preencherComboMatriz(int id, JComboBox cbxMatriz) {
        
        List listaMatriz = ctrlPrincipal.getCtrlMatriz().filtrarMatrizCurso(id);
        if(listaMatriz.size() > 0)
            preencherCombo(cbxMatriz, listaMatriz);   
    }
    
    public void preencherComboEixos(JComboBox cbxEixo, JComboBox cbxCoordenadoria){ 
        
        List listaEixos = ctrlPrincipal.getCtrlEixo().consultar();
        preencherCombo(cbxEixo, listaEixos);
        
        if(listaEixos.size() > 0){
            Eixo eixo = (Eixo) cbxEixo.getSelectedItem();
            preencherComboCoordenadorias(eixo.getId(), cbxCoordenadoria);
        }
    }

    public void preencherComboCoordenadorias(int id, JComboBox cbxCoordenadoria) {
        List listaCoordenadorias = ctrlPrincipal.getCtrlCoordenadoria().filtrarCoordenadoriasEixo(id);
        setListaCoordenadorias(listaCoordenadorias);
        preencherCombo(cbxCoordenadoria, listaCoordenadorias);   
    }
    
    public void preencherListaDisciplinas(JComboBox cbxMatriz, JList lstDisciplinas, JSpinner spnPeriodo) {
        
        int periodo = (int) spnPeriodo.getValue();
        MatrizCurricular matriz = (MatrizCurricular) cbxMatriz.getSelectedItem();
        List listaDisciplinas = ctrlPrincipal.getCtrlDisciplina().filtrarPorMatrizPeriodo(matriz.getId(), periodo);
        preencherJList(listaDisciplinas, lstDisciplinas);   
    }
    
    public void preencherListaProfessores(JComboBox cbxCoordenadoria, JList lstProfessores) {
        
        Coordenadoria coordenadoria = (Coordenadoria) cbxCoordenadoria.getSelectedItem();
        setCoordenadoriaSelecionada(coordenadoria);
        List listaProfessores = ctrlPrincipal.getCtrlProfessor().buscar("coordenadoria", String.valueOf(coordenadoria.getId()));
        preencherJList(listaProfessores, lstProfessores);   
    }
    
    public void setarCoordenadoria(JComboBox cbxCoordenadoria){
        
        List listaCoordenadorias = getListaCoordenadorias();
        Coordenadoria coordenadoria;
        
        for (int i = 0; i < listaCoordenadorias.size(); i++) {

            coordenadoria = (Coordenadoria) listaCoordenadorias.get(i);
            if (coordenadoria.getId() == getCoordenadoriaSelecionada().getId()) {
                cbxCoordenadoria.setSelectedIndex(i);
                break;
            }
        }
    }

    public Coordenadoria getCoordenadoriaSelecionada() {
        return coordenadoriaSelecionada;
    }

    public void setCoordenadoriaSelecionada(Coordenadoria coordenadoriaSelecionada) {
        this.coordenadoriaSelecionada = coordenadoriaSelecionada;
    }

    public List getListaCoordenadorias() {
        return listaCoordenadorias;
    }

    public void setListaCoordenadorias(List listaCoordenadorias) {
        this.listaCoordenadorias = listaCoordenadorias;
    } 
}
