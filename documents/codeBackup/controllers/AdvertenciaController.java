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
import les.ifoot.model.Advertencia;
import les.ifoot.services.AdvertenciaService;
import les.ifoot.services.exceptions.ConstraintException;

// @RestController
// @RequestMapping(value = "/advertencias")
// public class AdvertenciaController {
//     @Autowired
//     private AdvertenciaService service;

//     @RequestMapping(method = RequestMethod.GET)
//     public ResponseEntity<Collection<Advertencia>> findAll() {
//         Collection<Advertencia> Collection = service.findAll();
//         return ResponseEntity.ok().body(Collection);
//     }

//     @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//     public ResponseEntity<Advertencia> find(@PathVariable Integer id) {
//         Advertencia obj = service.findById(id);
//         return ResponseEntity.ok().body(obj);
//     }

//     @RequestMapping(method = RequestMethod.POST)
//     public ResponseEntity<Advertencia> insert(@RequestBody Advertencia obj) {
//         obj = service.insert(obj);
//         return ResponseEntity.ok().body(obj);
//     }

//     @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//     public ResponseEntity<Advertencia> update(@RequestBody Advertencia obj) {
//         obj = service.update(obj);
//         return ResponseEntity.ok().body(obj);
//     }

//     @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//     public ResponseEntity<Void> delete(@PathVariable Integer id) {
//         service.delete(id);
//         return ResponseEntity.noContent().build();
//     }
// }

@RestController
@RequestMapping(value = "/advertencias")
public class AdvertenciaController {

    @Autowired
    private AdvertenciaService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Advertencia>> findAll() {
        Collection<Advertencia> collection = service.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/{jogadorId}/{peladaId}", method = RequestMethod.GET)
    public ResponseEntity<Advertencia> find(@PathVariable Integer jogadorId, @PathVariable Integer peladaId) {
        Advertencia obj = service.findById(jogadorId, peladaId);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Advertencia> insert(@Valid @RequestBody Advertencia obj, BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{jogadorId}/{peladaId}", method = RequestMethod.PUT)
    public ResponseEntity<Advertencia> update(@Valid @RequestBody Advertencia obj, BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{jogadorId}/{peladaId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer jogadorId, @PathVariable Integer peladaId) {
        service.delete(jogadorId, peladaId);
        return ResponseEntity.noContent().build();
    }

}