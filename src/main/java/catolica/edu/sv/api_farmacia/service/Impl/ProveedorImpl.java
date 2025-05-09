package catolica.edu.sv.api_farmacia.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import catolica.edu.sv.api_farmacia.entities.ProveedorEntity;
import catolica.edu.sv.api_farmacia.repository.ProveedorRepository;
import catolica.edu.sv.api_farmacia.service.IProveedor;

import java.util.List;

@Service
public class ProveedorImpl implements IProveedor {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<ProveedorEntity> findAll(){
        return proveedorRepository.findAll();
    }

    @Override
    public ProveedorEntity save(ProveedorEntity proveedor) {
        return proveedorRepository.save(proveedor);
    }
}
