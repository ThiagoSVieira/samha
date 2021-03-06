package cdp;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "alocacao")
public class Alocacao implements Serializable, Comparable<Object>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private int ano;
    
    @Column(nullable = false)
    private int semestre;
    
    @Transient
    private boolean completa;
    
    @Transient
    private Turma turma;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "disciplina_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Disciplina disciplina;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "professor1_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Professor professor1;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "professor2_id", nullable = true)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Professor professor2;

    public Alocacao() {
    }

    public Alocacao(int id, int ano, int semestre, Disciplina disciplina, Professor professor1, Professor professor2) {
        this.id = id;
        this.ano = ano;
        this.semestre = semestre;
        this.disciplina = disciplina;
        this.professor1 = professor1;
        this.professor2 = professor2;
    }

    public Alocacao(int ano, int semestre, Disciplina disciplina, Professor professor1, Professor professor2) {
        this.ano = ano;
        this.semestre = semestre;
        this.disciplina = disciplina;
        this.professor1 = professor1;
        this.professor2 = professor2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor1() {
        return professor1;
    }

    public void setProfessor1(Professor professor1) {
        this.professor1 = professor1;
    }

    public Professor getProfessor2() {
        return professor2;
    }

    public void setProfessor2(Professor professor2) {
        this.professor2 = professor2;
    }

    public boolean isCompleta() {
        return completa;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    
    @Override
    public String toString() {
        
        String retorno = disciplina.getSigla()+ " - " + professor1.obterNomeAbreviado();
        if(disciplina.getTipo().toUpperCase().equals("ESPECIAL")){
            retorno = retorno + "/" + professor2.obterNomeAbreviado();
        }
        return retorno;
    }
    
    public Object[] toArray() {
        return new Object[] { this, disciplina.getPeriodo(), isCompleta() };
    }
    
    public Object[] toArrayAlocacao() {
        return new Object[] { getDisciplina().getNome(), getTurma().getNome(), getDisciplina().getSigla(), 
            getDisciplina().getPeriodo(), getDisciplina().getMatriz().getCurso().getNome(), getDisciplina().getQtAulas(), 
            getDisciplina().getCargaHoraria(), isCompleta() };
    }

    @Override
    public int compareTo(Object o) {
        Alocacao other = (Alocacao) o;  
        return this.getDisciplina().getSigla().compareTo(other.getDisciplina().getSigla());
    }
}
