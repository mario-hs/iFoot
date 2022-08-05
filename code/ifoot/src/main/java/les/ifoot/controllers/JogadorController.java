package les.ifoot.controllers;

import java.util.ArrayList;
import java.util.Arrays;
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
import les.ifoot.model.Jogador;
import les.ifoot.services.JogadorService;
import les.ifoot.services.exceptions.ConstraintException;
import net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.Response;

@RestController
@RequestMapping(value = "/jogadores")
@CrossOrigin(origins = "http://localhost:3000")
public class JogadorController {
    @Autowired
    private JogadorService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Jogador>> findAll() {
        Collection<Jogador> Collection = service.findAll();
        return ResponseEntity.ok().body(Collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Jogador> find(@PathVariable Integer id) {
        Jogador obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}/reserva_em_grupo", method = RequestMethod.GET)
    public ResponseEntity<Collection<?>> findByJogadorInReservaGrupo(@PathVariable Integer id) {
        Collection<?> collection = service.findByJogadorInReservaGrupo(id);
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "{id}/dados/{mes}", method = RequestMethod.GET)
    public ResponseEntity<Collection<?>> findByIntervaloMes(@PathVariable Integer id,
            @PathVariable Integer mes) {
        Collection<?> collection = service.findByIntervaloMes(id, mes);
        System.out.println(collection);
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/ranking/assistencias", method = RequestMethod.GET)
    public ResponseEntity<Collection<?>> findRankingByAssistencias() {
        Collection<?> collection = service.findRankingByAssistencias();
        System.out.println(collection);
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/ranking/gols", method = RequestMethod.GET)
    public ResponseEntity<Collection<?>> findRankingByGols() {
        Collection<?> collection = service.findRankingByGols();
        System.out.println(collection);
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Jogador> insert(@Valid @RequestBody Jogador obj, BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Jogador> update(@Valid @RequestBody Jogador obj, BindingResult br) {
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

    @RequestMapping(value = "/{id}/score", method = RequestMethod.GET)
    public ResponseEntity<Float> findByMediaJogador(@PathVariable Integer id) {
        Float obj = service.findByMediaJogador(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}/amarelo", method = RequestMethod.GET)
    public ResponseEntity<Integer> findByAdvertenciaJogador(@PathVariable Integer id) {
        Integer obj = service.findByAdvertenciaJogador(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{email}/{senha}", method = RequestMethod.GET)
    public ResponseEntity<Jogador> findLoginJogador(@PathVariable String email, @PathVariable String senha) {
        Jogador obj = service.findLoginJogador(email, senha);
        return ResponseEntity.ok().body(obj);
    }
}
