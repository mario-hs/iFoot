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
import les.ifoot.model.Espaco;
import les.ifoot.services.EspacoService;
import les.ifoot.services.exceptions.ConstraintException;

@RestController
@RequestMapping(value = "/espacos")
@CrossOrigin(origins = "http://localhost:3000")
public class EspacoController {
    @Autowired
    private EspacoService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Espaco>> findAll() {
        Collection<Espaco> Collection = service.findAll();
        return ResponseEntity.ok().body(Collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Espaco> find(@PathVariable Integer id) {
        Espaco obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{ano}/{mes}", method = RequestMethod.GET)
    public ResponseEntity<Collection<?>> findByQTDTipoByAnoAndMes(@PathVariable Integer ano,
            @PathVariable Integer mes) {
        Collection<?> collection = service.findByQTDTipoByAnoAndMes(ano, mes);
        System.out.println(collection);
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/tipo_campo/{tipo_campo}", method = RequestMethod.GET)
    public ResponseEntity<Collection<?>> findByTipoPiso(@PathVariable Integer tipo_campo) {
        Collection<?> collection;
        if (tipo_campo == 0) {
            collection = service.findByTipoPisoAll();
        } else {
            collection = service.findByTipoPiso(tipo_campo);
        }
        System.out.println(collection);
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "{id_espaco}/lucro/{tipo_campo}/{mes}/{ano}", method = RequestMethod.GET)

    public ResponseEntity<Collection<?>> findLucroByMesAno(@PathVariable Integer id_espaco,
            @PathVariable Integer tipo_campo, @PathVariable Integer mes,
            @PathVariable Integer ano) {
        Collection<?> collection = service.findLucroByMesAno(id_espaco, tipo_campo, mes, ano);
        System.out.println(collection);
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Espaco> insert(@Valid @RequestBody Espaco obj, BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Espaco> update(@Valid @RequestBody Espaco obj, BindingResult br) {
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
