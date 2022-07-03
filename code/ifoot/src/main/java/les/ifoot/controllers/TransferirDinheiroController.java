package les.ifoot.controllers;

import java.text.ParseException;
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
import les.ifoot.model.TransferirDinheiro;
import les.ifoot.services.TransferirDinheiroService;
import les.ifoot.services.exceptions.ConstraintException;

@RestController
@RequestMapping(value = "/transferenciasDeDinheiro")
public class TransferirDinheiroController {
    @Autowired
    private TransferirDinheiroService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<TransferirDinheiro>> findAll() {
        Collection<TransferirDinheiro> Collection = service.findAll();
        return ResponseEntity.ok().body(Collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TransferirDinheiro> find(@PathVariable Integer id) {
        TransferirDinheiro obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TransferirDinheiro> insert(@Valid @RequestBody TransferirDinheiro obj,
            BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        try {
            obj = service.insert(obj);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TransferirDinheiro> update(@Valid @RequestBody TransferirDinheiro obj,
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
