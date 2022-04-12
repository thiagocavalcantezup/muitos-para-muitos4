package br.com.zup.handora.muitosparamuitos4.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @ManyToMany(mappedBy = "tags")
    Set<Revista> revistas = new HashSet<>();

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Tag() {}

    public Tag(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public Set<Revista> getRevistas() {
        return revistas;
    }

}
