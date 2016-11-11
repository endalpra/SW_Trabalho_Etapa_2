package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Livro;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Érico
 */
@Stateless
public class LivroDAO implements Serializable{
    private List<Livro> lista;
    @PersistenceContext(unitName = "SW_Trabalho_Etapa_2PU")
    private EntityManager em;
    
    public LivroDAO() {
        
    }
    
    public void adicionar(Livro obj) throws Exception{
        obj.setId(null);//Para a entityManager entender que tem que persistir dado
        em.persist(obj);
    }
    
    public void alterar(Livro obj) throws Exception{
        em.merge(obj);
    }
    
    public void remover(Integer id) throws Exception{
        Livro obj = em.find(Livro.class, id);
        em.remove(obj);
    }

    public List<Livro> getLista() throws Exception{
        return em.createQuery("from Livro order by id").getResultList();
    }

    public void setLista(List<Livro> lista) {
        this.lista = lista;
    }
    
    
}
