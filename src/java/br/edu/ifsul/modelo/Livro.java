package br.edu.ifsul.modelo;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Érico
 */
@Entity
@Table(name="livro")
public class Livro {
    @Id
    @SequenceGenerator(name = "seq_livro", sequenceName = "seq_livro_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_livro", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "titulo", length = 50, nullable = false)
    private String titulo;    
    @Column(name = "editora", length = 50, nullable = false)
    private String editora; 
    @Column(name = "qtd_paginas", length = 15, nullable = false)
    private String qtd_paginas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getQtd_paginas() {
        return qtd_paginas;
    }

    public void setQtd_paginas(String qtd_paginas) {
        this.qtd_paginas = qtd_paginas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Livro other = (Livro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
     
}
