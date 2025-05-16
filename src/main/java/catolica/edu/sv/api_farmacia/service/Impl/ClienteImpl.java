package catolica.edu.sv.api_farmacia.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import catolica.edu.sv.api_farmacia.entities.ClienteEntity;
import catolica.edu.sv.api_farmacia.repository.ClienteRepository;
import catolica.edu.sv.api_farmacia.service.ICliente;

import java.util.List;

@Service
public class ClienteImpl implements ICliente {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteEntity> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public ClienteEntity save(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<ClienteEntity> findByIdCliente(long idCliente) {
        return clienteRepository.findByIdCliente(idCliente);
    }

}
