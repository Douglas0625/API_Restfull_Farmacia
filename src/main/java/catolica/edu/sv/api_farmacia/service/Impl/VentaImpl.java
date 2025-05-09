package catolica.edu.sv.api_farmacia.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import catolica.edu.sv.api_farmacia.entities.VentaEntity;
import catolica.edu.sv.api_farmacia.repository.VentaRepository;
import catolica.edu.sv.api_farmacia.service.IVenta;

import java.util.List;

@Service
public class VentaImpl implements IVenta{
    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public List<VentaEntity> findAll() {
        return ventaRepository.findAll();
    }

    //post
    @Override
    public VentaEntity save(VentaEntity venta) {
        return ventaRepository.save(venta);
    }
}
