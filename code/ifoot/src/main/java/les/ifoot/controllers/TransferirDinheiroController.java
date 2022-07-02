package les.ifoot.controllers;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import les.ifoot.model.TransferirDinheiro;
import les.ifoot.services.TransferirDinheiroService;

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
    public ResponseEntity<TransferirDinheiro> insert(@RequestBody TransferirDinheiro obj) {
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TransferirDinheiro> update(@RequestBody TransferirDinheiro obj) {
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
