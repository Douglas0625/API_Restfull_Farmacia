package catolica.edu.sv.api_farmacia.service;

import catolica.edu.sv.api_farmacia.entities.ClienteEntity;

import java.util.List;

public interface ICliente {

    List<ClienteEntity> findAll();

    ClienteEntity save(ClienteEntity cliente);

    List<ClienteEntity> findByIdCliente(long idCliente);
}
