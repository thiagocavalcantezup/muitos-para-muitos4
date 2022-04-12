package br.com.zup.handora.muitosparamuitos4.models;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.com.zup.handora.muitosparamuitos4.repositories.TagRepository;

public class RevistaDTO {

    @NotBlank
    @Size(max = 120)
    private String titulo;

    @NotNull
    @PastOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPublicacao;

    @NotEmpty
    @Size(min = 1)
    private Set<Long> tagIds;

    public RevistaDTO() {}

    public RevistaDTO(@NotBlank @Size(max = 120) String titulo,
                      @NotNull @PastOrPresent LocalDate dataPublicacao,
                      @NotEmpty @Size(min = 1) Set<Long> tagIds) {
        this.titulo = titulo;
        this.dataPublicacao = dataPublicacao;
        this.tagIds = tagIds;
    }

    public Revista toModel(TagRepository tagRepository) {
        Set<Tag> tags = tagIds.stream()
                              .map(
                                  id -> tagRepository.findById(id)
                                                     .orElseThrow(
                                                         () -> new ResponseStatusException(
                                                             HttpStatus.NOT_FOUND,
                                                             "Não existe uma tag com o id informado."
                                                         )
                                                     )
                              )
                              .collect(Collectors.toSet());
        Revista revista = new Revista(titulo, dataPublicacao);

        tags.forEach(revista::adicionar);

        return revista;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Set<Long> getTagIds() {
        return tagIds;
    }

}
