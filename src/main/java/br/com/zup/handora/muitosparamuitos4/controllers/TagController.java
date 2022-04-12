package br.com.zup.handora.muitosparamuitos4.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.handora.muitosparamuitos4.models.Tag;
import br.com.zup.handora.muitosparamuitos4.models.TagDTO;
import br.com.zup.handora.muitosparamuitos4.repositories.TagRepository;

@RestController
@RequestMapping(TagController.BASE_URI)
public class TagController {

    public final static String BASE_URI = "/tags";

    private final TagRepository tagRepository;

    public TagController(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid TagDTO tagDTO,
                                       UriComponentsBuilder ucb) {
        Tag tag = tagRepository.save(tagDTO.toModel());

        URI location = ucb.path(BASE_URI + "/{id}").buildAndExpand(tag.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
