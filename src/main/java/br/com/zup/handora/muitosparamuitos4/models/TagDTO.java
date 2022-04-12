package br.com.zup.handora.muitosparamuitos4.models;

import javax.validation.constraints.NotBlank;

public class TagDTO {

    @NotBlank
    private String nome;

    public TagDTO() {}

    public TagDTO(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
