package com.desafiocruddeclientes.DesafioCrudDeClientes.repositories;

import com.desafiocruddeclientes.DesafioCrudDeClientes.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
