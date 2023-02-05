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

    @Transactional()
    public ClientDTO insert(ClientDTO clientDTO){
        Client clientEntity = new Client();
        copyDtoToEntity (clientDTO, clientEntity);
        clientEntity = clientRepository.save(clientEntity);
        return new ClientDTO(clientEntity);
    }

    @Transactional()
    public ClientDTO update(Long id, ClientDTO clientDTO){
        Client clientEntity = clientRepository.getReferenceById(id);
        copyDtoToEntity (clientDTO, clientEntity);
        clientEntity = clientRepository.save(clientEntity);
        return new ClientDTO(clientEntity);
    }

    private void copyDtoToEntity(ClientDTO clientDTO, Client clientEntity) {
        clientEntity.setName(clientDTO.getName());
        clientEntity.setCpf(clientDTO.getCpf());
        clientEntity.setIncome(clientDTO.getIncome());
        clientEntity.setBirthDate(clientDTO.getBirthDate());
        clientEntity.setChildren(clientDTO.getChildren());
    }


}
