/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package artemis.sa.controllers;

import artemis.sa.dto.ClientDTO;
import artemis.sa.entities.Client;
import artemis.sa.services.ClientService;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.http.HttpStatus;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author code
 */
@RestController
@RequestMapping(path = "client" )
public class ClientController {
    
    private ClientService ClientService ;

    public ClientController(ClientService ClientService) {
        this.ClientService = ClientService;
    }
    
    
    
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Client client){
        this.ClientService.create(client);
    }
    
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Stream<ClientDTO> list(){
        return this.ClientService.list();
    }
    
    @GetMapping(path = "{id}",produces = APPLICATION_JSON_VALUE)
    public Client lire(@PathVariable int id){
        return this.ClientService.lire(id) ;
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path ="{id}", consumes = APPLICATION_JSON_VALUE)
    public void modifier(@PathVariable int id , @RequestBody Client client){
        this.ClientService.modifier(id,client);
    }
    
   
}
