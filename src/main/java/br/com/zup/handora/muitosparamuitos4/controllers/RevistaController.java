package br.com.zup.handora.muitosparamuitos4.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.handora.muitosparamuitos4.models.Revista;
import br.com.zup.handora.muitosparamuitos4.models.RevistaDTO;
import br.com.zup.handora.muitosparamuitos4.repositories.RevistaRepository;
import br.com.zup.handora.muitosparamuitos4.repositories.TagRepository;

@RestController
@RequestMapping(RevistaController.BASE_URI)
public class RevistaController {

    public final static String BASE_URI = "/revistas";

    private final RevistaRepository revistaRepository;
    private final TagRepository tagRepository;

    public RevistaController(RevistaRepository revistaRepository, TagRepository tagRepository) {
        this.revistaRepository = revistaRepository;
        this.tagRepository = tagRepository;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid RevistaDTO revistaDTO,
                                       UriComponentsBuilder ucb) {
        Revista revista = revistaRepository.save(revistaDTO.toModel(tagRepository));

        URI location = ucb.path(BASE_URI + "/{id}").buildAndExpand(revista.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
