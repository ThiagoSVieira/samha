package cgt;

import cdp.CoordenadorAcademico;
import cdp.CoordenadorCurso;
import cdp.Usuario;
import cgd.GdPrincipal;

public class GtPrincipal {

    private GdPrincipal gdPrincipal;
    private Usuario coordAtual;
    private int permissao;
    
    private GtAlocacao gtAlocacao;
    private GtCoordenador gtCoordenador;
    private GtCoordenadoria gtCoordenadoria;
    private GtCurso gtCurso;
    private GtDisciplina gtDisciplina;
    private GtEixo gtEixo;
    private GtMatriz gtMatriz;
    private GtOferta gtOferta;
    private GtProfessor gtProfessor;
    private GtRestricao gtRestricao;
    private GtTurma gtTurma;

    public GtPrincipal() {
        gdPrincipal = new GdPrincipal();
        gtAlocacao = new GtAlocacao(this);
        gtCoordenador = new GtCoordenador(this);
        gtCoordenadoria = new GtCoordenadoria(this);
        gtCurso = new GtCurso(this);
        gtDisciplina = new GtDisciplina(this);
        gtEixo = new GtEixo(this);
        gtMatriz = new GtMatriz(this);
        gtOferta = new GtOferta(this);
        gtProfessor = new GtProfessor(this);
        gtRestricao = new GtRestricao(this);
        gtTurma = new GtTurma(this);
        setPermissao(Constantes.PERMISSAO_NEGADA);
        setCoordAtual(null);
    }

    public int validarAcesso(String login, String senha) {

        try {
            validarCampos(login, senha);
            Usuario usuario = gdPrincipal.validarAcesso(login, senha);

            if (usuario == null) {
                return Constantes.PERMISSAO_NEGADA;
            } else {
                setCoordAtual(usuario);
                if(usuario instanceof CoordenadorCurso){
                    setPermissao(Constantes.PERMISSAO_COORD);
                    return Constantes.PERMISSAO_COORD;
                }else if(usuario instanceof CoordenadorAcademico){
                    setPermissao(Constantes.PERMISSAO_ADMIN);
                    return Constantes.PERMISSAO_ADMIN;
                }else{
                    setPermissao(Constantes.PERMISSAO_VIEW);
                    return Constantes.PERMISSAO_VIEW;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return Constantes.PERMISSAO_NEGADA;
        }
    }

    public void encerrarSessao() {
        setCoordAtual(null);
        setPermissao(Constantes.PERMISSAO_NEGADA);
    }

    public void validarCampos(String login, String senha) throws Exception {
        if (login.equals("")) {
            throw new SAMHAException(3);
        }
        if (senha.equals("")) {
            throw new SAMHAException(4);
        }
    }

    public Usuario getCoordAtual() {
        return coordAtual;
    }

    public void setCoordAtual(Usuario coordAtual) {
        this.coordAtual = coordAtual;
    }

    public int getPermissao() {
        return permissao;
    }

    public void setPermissao(int permissao) {
        this.permissao = permissao;
    }

    public GtAlocacao getGtAlocacao() {
        return gtAlocacao;
    }

    public GtCoordenador getGtCoordenador() {
        return gtCoordenador;
    }

    public GtCoordenadoria getGtCoordenadoria() {
        return gtCoordenadoria;
    }

    public GtCurso getGtCurso() {
        return gtCurso;
    }

    public GtDisciplina getGtDisciplina() {
        return gtDisciplina;
    }

    public GtEixo getGtEixo() {
        return gtEixo;
    }

    public GtMatriz getGtMatriz() {
        return gtMatriz;
    }

    public GtOferta getGtOferta() {
        return gtOferta;
    }

    public GtProfessor getGtProfessor() {
        return gtProfessor;
    }

    public GtRestricao getGtRestricao() {
        return gtRestricao;
    }

    public GtTurma getGtTurma() {
        return gtTurma;
    }

    public GdPrincipal getGdPrincipal() {
        return gdPrincipal;
    }
}
