package com.desafiocruddeclientes.DesafioCrudDeClientes.controllers;

import com.desafiocruddeclientes.DesafioCrudDeClientes.dto.ClientDTO;
import com.desafiocruddeclientes.DesafioCrudDeClientes.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
        ClientDTO clientDTO = clientService.findById(id);
        return ResponseEntity.ok(clientDTO);
    }

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAll(Pageable pageable){
        Page<ClientDTO> clientDTO = clientService.findAll(pageable);
        return ResponseEntity.ok(clientDTO);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> insert(@Valid @RequestBody ClientDTO clientDTO){
        clientDTO = clientService.insert(clientDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(clientDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(clientDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Long id,@Valid @RequestBody ClientDTO clientDTO){
        clientDTO = clientService.update(id,clientDTO);
        return ResponseEntity.ok(clientDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id){
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
