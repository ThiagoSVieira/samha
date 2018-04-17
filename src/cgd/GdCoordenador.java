package cgd;

import cdp.Coordenador;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GdCoordenador extends GdGenerico{
     
    public List buscar(String coluna, String texto) {
        Criteria crit = criarSessao().createCriteria(Coordenador.class);
        crit.add( Restrictions.like(coluna, "%"+texto+"%") );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.close();
        return lista;
    }
    
    public List filtrarPorTipo(String coluna, String texto) {
        Criteria crit = criarSessao().createCriteria(Coordenador.class);
        crit.add( Restrictions.eq(coluna, texto) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.close();
        return lista;
    }
}
