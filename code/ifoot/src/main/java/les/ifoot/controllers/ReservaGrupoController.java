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
import les.ifoot.model.ReservaGrupo;
import les.ifoot.services.ReservaGrupoService;
import les.ifoot.services.exceptions.ConstraintException;

@RestController
@RequestMapping(value = "/reservasEmGrupo")
public class ReservaGrupoController {
    @Autowired
    private ReservaGrupoService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<ReservaGrupo>> findAll() {
        Collection<ReservaGrupo> Collection = service.findAll();
        return ResponseEntity.ok().body(Collection);
    }

    @RequestMapping(value = "/{campoId}/{horarioId}", method = RequestMethod.GET)
    public ResponseEntity<ReservaGrupo> find(@PathVariable Integer campoId, @PathVariable Integer horarioId ) {
        ReservaGrupo obj = service.findById(campoId, horarioId);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ReservaGrupo> insert(@Valid @RequestBody ReservaGrupo obj, BindingResult br) {
        if(br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{campoId}/{horarioId}", method = RequestMethod.PUT)
    public ResponseEntity<ReservaGrupo> update(@Valid @RequestBody ReservaGrupo obj, BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{campoId}/{horarioId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer campoId, @PathVariable Integer horarioId) {
        service.delete(campoId, horarioId);
        return ResponseEntity.noContent().build();
    }
}
