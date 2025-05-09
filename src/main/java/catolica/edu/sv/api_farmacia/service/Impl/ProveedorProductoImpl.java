package catolica.edu.sv.api_farmacia.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import catolica.edu.sv.api_farmacia.entities.ProveedorProductoEntity;
import catolica.edu.sv.api_farmacia.repository.ProveedorProductoRepository;
import catolica.edu.sv.api_farmacia.service.IProveedorProducto;

import java.util.List;

@Service
public class ProveedorProductoImpl implements IProveedorProducto {
    @Autowired
    private ProveedorProductoRepository proveedorProductoRepository;

    @Override
    public List<ProveedorProductoEntity> findAll(){
        return proveedorProductoRepository.findAll();
    }

    @Override
    public ProveedorProductoEntity save(ProveedorProductoEntity proveedorproducto) {
        return proveedorProductoRepository.save(proveedorproducto);
    }
}
