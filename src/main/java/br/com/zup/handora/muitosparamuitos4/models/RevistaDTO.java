package br.com.zup.handora.muitosparamuitos4.models;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

public class RevistaDTO {

    @NotBlank
    @Size(max = 120)
    private String titulo;

    @NotNull
    @PastOrPresent
    private LocalDate dataPublicacao;

    public RevistaDTO() {}

    public RevistaDTO(@NotBlank @Size(max = 120) String titulo,
                      @NotNull @PastOrPresent LocalDate dataPublicacao) {
        this.titulo = titulo;
        this.dataPublicacao = dataPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

}
