package cgd;

import cdp.MatrizCurricular;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GdMatriz extends GdGenerico{
    
    private GdPrincipal gdPrincipal;
    
    public GdMatriz(GdPrincipal gdPrincipal){
        this.gdPrincipal = gdPrincipal;
    }
    
    public List filtrarMatrizCurso(int id) {
        Criteria crit = criarSessao().createCriteria(MatrizCurricular.class);
        sessao.beginTransaction();
        crit.add( Restrictions.eq("curso.id", id) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
    }
    
}
