package com.desafiocruddeclientes.DesafioCrudDeClientes.services;

import com.desafiocruddeclientes.DesafioCrudDeClientes.dto.ClientDTO;
import com.desafiocruddeclientes.DesafioCrudDeClientes.entities.Client;
import com.desafiocruddeclientes.DesafioCrudDeClientes.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Client client = clientRepository.findById(id).get();
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){
        Page<Client> clientPageList = clientRepository.findAll(pageable);
        return clientPageList.map(registry ->new ClientDTO(registry));
    }

}
