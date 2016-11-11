package br.edu.ifsul.servicos;

import br.edu.ifsul.dao.LivroDAO;
import br.edu.ifsul.modelo.Livro;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author Érico
 */
@Stateless
@Path("/livro")
public class ServicoLivro implements Serializable {

    @EJB
    private LivroDAO dao;

    public ServicoLivro() {
    }

    @GET
    @Produces({"application/json"})
    @Path("listar")
    public List<Livro> listaLivro() {
        try {
            return dao.getLista();
        } catch (Exception e) {
            throw new WebApplicationException(404);
        }
    }

    @POST
    @Consumes({"application/json"})
    public void adicionar(Livro obj) {
        try {
            dao.adicionar(obj);
        } catch (Exception e) {
            throw new WebApplicationException(404);
        }
    }

    @PUT
    @Consumes({"application/json"})
    public void alterar(Livro obj) {
        try {
            dao.alterar(obj);
        } catch (Exception e) {
            throw new WebApplicationException(404);
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        try {
            dao.remover(id);
        } catch (Exception e) {
            throw new WebApplicationException(404);
        }
    }
}
