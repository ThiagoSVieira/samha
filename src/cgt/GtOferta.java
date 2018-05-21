package cgt;

import cdp.Oferta;
import cdp.Turma;
import java.sql.SQLException;
import java.util.List;

public class GtOferta {

    private GtPrincipal gtPrincipal;
    private Oferta ofertaSelecionada;
    
    public GtOferta(GtPrincipal gt) {
        gtPrincipal = gt;
    }
    
    public void identificarOferta(int ano, int semestre, int tempoMaximo, int intervaloMinimo, String turno, Turma turma){
        
        Oferta oferta = gtPrincipal.getGdPrincipal().getGdOferta().filtrarOferta(ano, semestre, turma.getId());
        
        if(oferta == null)
            oferta = gerarOferta(ano, semestre, tempoMaximo, intervaloMinimo, turma);
        
        oferta.setIntervaloMinimo(intervaloMinimo);
        oferta.setTempoMaximoTrabalho(tempoMaximo);

        setOfertaSelecionada(oferta);
        gtPrincipal.getGtAula().gerarEstruturasArmazenamento();
        
        if(oferta != null){
            List aulas = gtPrincipal.getGdPrincipal().getGdAula().filtrarAulasTurno(turno, oferta.getId());
            gtPrincipal.getGtAula().preencherMatrizOferta(aulas);
        }
    }
    
    public Oferta gerarOferta(int ano, int semestre, int tempoMaximo, int intervaloMinimo, Turma turma){
        
        try {
            Oferta oferta = new Oferta();

            oferta.setAno(ano);
            oferta.setIntervaloMinimo(intervaloMinimo);
            oferta.setSemestre(semestre);
            oferta.setTempoMaximoTrabalho(tempoMaximo);
            oferta.setTurma(turma);
            gtPrincipal.getGdPrincipal().getGdOferta().cadastrar(oferta);
            return oferta;
        } catch (SQLException | ClassNotFoundException ex) {
            return null;
        }   
    }    

    public Oferta getOfertaSelecionada() {
        return ofertaSelecionada;
    }

    public void setOfertaSelecionada(Oferta ofertaSelecionada) {
        this.ofertaSelecionada = ofertaSelecionada;
    }
}
