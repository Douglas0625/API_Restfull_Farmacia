package catolica.edu.sv.api_farmacia.service.Impl;

import catolica.edu.sv.api_farmacia.entities.ProveedorProductoId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import catolica.edu.sv.api_farmacia.entities.ProveedorProductoEntity;
import catolica.edu.sv.api_farmacia.repository.ProveedorProductoRepository;
import catolica.edu.sv.api_farmacia.service.IProveedorProducto;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<ProveedorProductoEntity> findById(ProveedorProductoId id) {
        return proveedorProductoRepository.findById(id);
    }

    @Override
    public void deleteById(ProveedorProductoId id) {
        proveedorProductoRepository.deleteById(id);
    }
}
