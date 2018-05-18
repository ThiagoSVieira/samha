package cgd;

import cdp.Oferta;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GdOferta extends GdGenerico{
    
    private GdPrincipal gdPrincipal;
    
    public GdOferta(GdPrincipal gdPrincipal){
        this.gdPrincipal = gdPrincipal;
    }
    
    public Oferta filtrarOferta(int ano, int semestre, int idTurma) {
        Criteria crit = criarSessao().createCriteria(Oferta.class);
        sessao.beginTransaction();
        crit.add( Restrictions.eq("ano", ano));
        crit.add( Restrictions.eq("semestre", semestre));
        crit.add( Restrictions.eq("turma.id", idTurma));
        crit.setMaxResults(1);
        Oferta oferta = (Oferta) crit.uniqueResult();
        sessao.getTransaction().commit();
        sessao.close();
        return oferta;
    }
}
