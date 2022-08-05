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
import les.ifoot.model.CampoHorario;
import les.ifoot.services.CampoHorarioService;
import les.ifoot.services.exceptions.ConstraintException;

@RestController
@RequestMapping(value = "/campo_horarios")
@CrossOrigin(origins = "http://localhost:3000")
public class CampoHorarioController {
    @Autowired
    private CampoHorarioService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<CampoHorario>> findAll() {
        Collection<CampoHorario> Collection = service.findAll();
        return ResponseEntity.ok().body(Collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CampoHorario> find(@PathVariable Integer id) {
        CampoHorario obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CampoHorario> insert(@Valid @RequestBody CampoHorario obj, BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CampoHorario> update(@Valid @RequestBody CampoHorario obj, BindingResult br) {
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

    @RequestMapping(value = "/espaco/{id_espaco}", method = RequestMethod.GET)
    public ResponseEntity<Collection<CampoHorario>> findAllDataEspaco(@PathVariable Integer id_espaco) {
        Collection<CampoHorario> collection = service.findAllDataEspaco(id_espaco);
        System.out.println(collection);
        return ResponseEntity.ok().body(collection);
    }

}
