package cci;

import cdp.Aula;
import cdp.Curso;
import cdp.Eixo;
import cdp.Turma;
import cih.relatorio.JDRelatorioTurma;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;

public class CtrlRelatorioTurma {
    
    private CtrlPrincipal ctrlPrincipal;
    private String pastaRaiz = "Turmas";
    
    public CtrlRelatorioTurma(CtrlPrincipal ctrl){
        this.ctrlPrincipal = ctrl;
    }
    
    public void identificarFiltroRelatorioTurma(JComboBox cbxEixo, JComboBox cbxCurso, JComboBox cbxTurma, int ano, int semestre, char tipo, JDRelatorioTurma janela){
        
        Eixo eixo = (Eixo) cbxEixo.getSelectedItem();
        Curso curso = (Curso) cbxCurso.getSelectedItem();
        Turma turma = (Turma) cbxTurma.getSelectedItem();
        iniciarThreadRelatorioTurma(janela, turma, curso, eixo, ano, semestre, tipo);
    }
    
    public void iniciarThreadRelatorioTurma(JDRelatorioTurma janela, Turma turma, Curso curso, Eixo eixo, int ano, int semestre, char tipo){
        
        new Thread(){
            @Override
            public void run() {
                
                try{
            
                    janela.gerandoRelatorio();
                    switch(tipo){

                        case 'A': gerarRelatorioTodasTurmas(ano, semestre); break;
                        case 'E': gerarRelatorioPorEixo(eixo, ano, semestre); break;
                        case 'C': gerarRelatorioPorCurso(curso, ano, semestre); break;
                        case 'T': 

                            if(turma != null)
                               gerarRelatorioPorTurma(turma, ano, semestre); 
                            else
                                CtrlMensagem.exibirMensagemErro(janela, "Turma não encontrada.");
                            break;

                        default: break;    
                    }

                    janela.relatorioGerado();
                    CtrlMensagem.exibirMensagemSucesso(janela, "Relatório Gerado com Sucesso!");
                    
                }catch(JRException ex){
                    janela.relatorioGerado();
                    CtrlMensagem.exibirMensagemErro(janela, "Erro ao gerar Relatório: " + ex.getMessage());

                } catch (FileNotFoundException | JRRuntimeException e){
                    janela.relatorioGerado();
                    CtrlMensagem.exibirMensagemAviso(janela, "Feche todos os relatórios de Turmas antes de iniciar.");
                }  
            }
        }.start();
        
    }
    
    public void gerarRelatorioTodasTurmas(int ano, int semestre) throws JRException, FileNotFoundException{
        
        List<Turma> turmas = ctrlPrincipal.getCtrlTurma().listar();  
        for(Turma turma : turmas){
            gerarRelatorioPorTurma(turma, ano, semestre);
        }
    }
    
    public void gerarRelatorioPorEixo(Eixo eixo, int ano, int semestre) throws JRException, FileNotFoundException{
        
        if(eixo != null){
            
            List<Turma> turmas = ctrlPrincipal.getCtrlTurma().filtrarPorEixo(eixo.getId());
            for(Turma turma : turmas){
                gerarRelatorioPorTurma(turma, ano, semestre);
            }
               
        }else
            CtrlMensagem.exibirMensagemErro(null, "Eixo não encontrado."); 
    }
    
    public void gerarRelatorioPorCurso(Curso curso, int ano, int semestre) throws JRException, FileNotFoundException{
        
        if(curso != null){
            
            List<Turma> turmas = ctrlPrincipal.getCtrlTurma().filtrarPorCurso(curso.getId());
            for(Turma turma : turmas){
                gerarRelatorioPorTurma(turma, ano, semestre);
            }
        }else
            CtrlMensagem.exibirMensagemErro(null, "Curso não encontrado.");
    }
    
    public void gerarRelatorioPorTurma(Turma turma, int ano, int semestre) throws JRException, FileNotFoundException{

        if(turma != null){
            
            List[] aulas = ctrlPrincipal.getCtrlAula().filtrarOrdenarAulasTurmaDiaAnoSemestre(turma.getId(), ano, semestre);
            List lista = ctrlPrincipal.getCtrlRelatorio().preencherListaAulasVazias(aulas);
            
            List relatorio = new ArrayList();
            relatorio.add(new Aula());
            
            String nomeRelatorio = "relatorioGenerico";
            
            Map parametros = gerarHashTurma(turma, ano, semestre, lista);
            
            String diretorio = ctrlPrincipal.getCtrlRelatorio().obterDiretorioArquivamento(pastaRaiz, ano, semestre);
            String nomeExport = diretorio + turma.getNome() + "-" + ano + "-" + semestre + ".pdf";
            
            ctrlPrincipal.getCtrlRelatorio().gerarRelatorio(relatorio, parametros, nomeRelatorio, nomeExport);
        }else
            CtrlMensagem.exibirMensagemErro(null, "Turma não encontrada.");
    }
    
    public Map gerarHashTurma(Turma turma, int ano, int semestre, List lista){
        
        Map hash = new HashMap();
        
        String anoSemestre = ano + "/" + semestre;
        hash.put("nome", turma.getNome());
        hash.put("setor", turma.getMatriz().getCurso().getNome() + "\t" + anoSemestre);
        hash.putAll(transformarListaEmHash(lista));
        return hash;
    }
    
    public Map transformarListaEmHash(List<Aula> lista){
        
        Map hash = new HashMap();
        
        for(Aula aula: lista){
            
            String professor = aula.getAlocacao().getProfessor1().getPrimeiroNome();
            String key = String.valueOf(aula.getDia()) + String.valueOf(aula.getNumero());
            String sigla = aula.getAlocacao().getDisciplina().getSigla();
            
            if(aula.getAlocacao().getProfessor2() != null){
                professor = professor + "|" + aula.getAlocacao().getProfessor2().getPrimeiroNome();
            }  
            hash.put(key, sigla + "\n" + professor);
        }
        
        return hash;
    }
    
    public void abrirPastaTurma(int ano, int semestre, JDRelatorioTurma janela){
        
        String diretorio = ctrlPrincipal.getCtrlRelatorio().obterDiretorioArquivamento(pastaRaiz, ano, semestre);
        try {  
            Runtime.getRuntime().exec("explorer " + diretorio.replace("/", "\\"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            CtrlMensagem.exibirMensagemErro(janela, "Não foi possível encontrar a pasta especificada.");
        }
    }
}