package les.ifoot.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import les.ifoot.model.Avaliacao;
import les.ifoot.services.AvaliacaoService;
import les.ifoot.services.exceptions.ConstraintException;

@RestController
@RequestMapping(value = "/avaliacaos")
public class AvaliacaoController {
    @Autowired
    private AvaliacaoService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Avaliacao>> findAll() {
        Collection<Avaliacao> Collection = service.findAll();
        return ResponseEntity.ok().body(Collection);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Avaliacao> insert(@Valid @RequestBody Avaliacao obj, BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Avaliacao> update(@Valid @RequestBody Avaliacao obj, BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Avaliacao> update(@RequestBody Avaliacao obj) {
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
