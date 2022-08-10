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
import les.ifoot.model.Campo;
import les.ifoot.services.CampoService;
import les.ifoot.services.exceptions.ConstraintException;

@RestController
@RequestMapping(value = "/campos")
@CrossOrigin(origins = "http://localhost:3000")
public class CampoController {
    @Autowired
    private CampoService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Campo>> findAll() {
        Collection<Campo> Collection = service.findAll();
        return ResponseEntity.ok().body(Collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Campo> find(@PathVariable Integer id) {
        Campo obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Campo> insert(@Valid @RequestBody Campo obj, BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Campo> update(@Valid @RequestBody Campo obj, BindingResult br) {
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

    @RequestMapping(value = "/tipo_campo/{tipo_campo}", method = RequestMethod.GET)
    public ResponseEntity<Collection<Campo>> findByTipoPiso(@PathVariable Integer tipo_campo) {
        Collection<Campo> collection;
        if (tipo_campo == 0) {
            collection = service.findByTipoPisoAll();
        } else {
            collection = service.findByTipoPiso(tipo_campo);
        }
        System.out.println(collection);
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/espaco/{id_espaco}", method = RequestMethod.GET)
    public ResponseEntity<Collection<Campo>> findAllCampoEspaco(@PathVariable Integer id_espaco) {
        Collection<Campo> collection = service.findAllCampoEspaco(id_espaco);
        System.out.println(collection);
        return ResponseEntity.ok().body(collection);
    }
}
