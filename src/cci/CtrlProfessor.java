package cci;

import cdp.Coordenadoria;
import cdp.Professor;
import cdp.RestricaoProfessor;
import cgt.Constantes;
import cgt.GtProfessor;
import cih.professor.JDBuscarProfessor;
import cih.professor.JDCadastrarProfessor;
import java.awt.Frame;
import java.util.List;

public class CtrlProfessor {

    private GtProfessor gtProfessor;
    private JDBuscarProfessor buscaProf;
    private JDCadastrarProfessor cadastraProf;
    private CtrlPrincipal ctrlPrincipal;

    public CtrlProfessor(CtrlPrincipal ctrl) {
        gtProfessor = new GtProfessor();
        ctrlPrincipal = ctrl;
    }

    public void instanciarTelaBuscaProfessor(Frame pai) {
        buscaProf = new JDBuscarProfessor(pai, true, ctrlPrincipal);
        buscaProf.setVisible(true);
    }

    public void instanciarTelaCadastroProfessor(Professor prof, Frame pai) {
        cadastraProf = new JDCadastrarProfessor(pai, true, ctrlPrincipal, prof);
        cadastraProf.setVisible(true);
    }

    public List<Professor> buscar(String coluna, String texto) {
        return gtProfessor.buscar(coluna, texto);
    }

    public void cadastrar(String nome, String matricula, String cargaHoraria, Coordenadoria coordenadoria, List<RestricaoProfessor> listaRestricoes) {

        String resposta = gtProfessor.cadastrar(nome, matricula, cargaHoraria, coordenadoria, listaRestricoes);
        if (resposta.equals(Constantes.CADASTRADO))
            ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(cadastraProf, "Cadastrado com sucesso!");
        else
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(cadastraProf, resposta);
    }
    
    public void alterar(String nome, String matricula, String cargaHoraria, Coordenadoria coordenadoria, List<RestricaoProfessor> listaRestricoes, Professor professor) {

        String resposta = gtProfessor.alterar(nome, matricula, cargaHoraria, coordenadoria, listaRestricoes, professor);
        if (resposta.equals(Constantes.ALTERADO))
            ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(cadastraProf, "Alterado com sucesso!");
        else
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(cadastraProf, resposta);
    }

    public List<Professor> consultar() {
        return gtProfessor.consultar();
    }

    public void excluir(Professor professor) {
        
            String resposta = gtProfessor.excluir(professor);
            if(resposta.equals(Constantes.EXCLUIDO))
                ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(buscaProf, "Excluído com sucesso!");
            else
                ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(buscaProf, resposta);
    }
}
