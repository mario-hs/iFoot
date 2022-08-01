package les.ifoot.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import les.ifoot.model.TransferenciaEspaco;
import les.ifoot.services.TransferenciaEspacoService;
import les.ifoot.services.exceptions.ConstraintException;

@RestController
@RequestMapping(value = "/transferencias_espaco")
@CrossOrigin(origins = "http://localhost:3000")
public class TransferenciaEspacoController {
    @Autowired
    private TransferenciaEspacoService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<TransferenciaEspaco>> findAll() {
        Collection<TransferenciaEspaco> Collection = service.findAll();
        return ResponseEntity.ok().body(Collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TransferenciaEspaco> find(@PathVariable Integer id) {
        TransferenciaEspaco obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TransferenciaEspaco> insert(@Valid @RequestBody TransferenciaEspaco obj,
            BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TransferenciaEspaco> update(@Valid @RequestBody TransferenciaEspaco obj,
            BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
