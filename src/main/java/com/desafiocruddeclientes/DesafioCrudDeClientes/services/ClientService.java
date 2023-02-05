package com.desafiocruddeclientes.DesafioCrudDeClientes.services;

import com.desafiocruddeclientes.DesafioCrudDeClientes.dto.ClientDTO;
import com.desafiocruddeclientes.DesafioCrudDeClientes.entities.Client;
import com.desafiocruddeclientes.DesafioCrudDeClientes.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Client client = clientRepository.findById(id).get();
        return new ClientDTO(client);
    }

}
