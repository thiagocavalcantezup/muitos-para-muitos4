package br.com.zup.handora.muitosparamuitos4.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.PastOrPresent;

@Entity
@Table(name = "revistas")
public class Revista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String titulo;

    @Column(nullable = false)
    @PastOrPresent
    private LocalDate dataPublicacao;

    public Revista() {}

    public Revista(String titulo, @PastOrPresent LocalDate dataPublicacao) {
        this.titulo = titulo;
        this.dataPublicacao = dataPublicacao;
    }

    public Long getId() {
        return id;
    }

}
