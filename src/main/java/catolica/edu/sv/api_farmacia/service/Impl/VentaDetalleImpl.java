package catolica.edu.sv.api_farmacia.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import catolica.edu.sv.api_farmacia.entities.VentaDetalleEntity;
import catolica.edu.sv.api_farmacia.repository.VentaDetalleRepository;
import catolica.edu.sv.api_farmacia.service.IVentaDetalle;

import java.util.List;
@Service
public class VentaDetalleImpl implements IVentaDetalle {

    @Autowired
    private VentaDetalleRepository ventaDetalleRepository;

    @Override
    public List<VentaDetalleEntity> findAll(){

        return ventaDetalleRepository.findAll();
    }

    @Override
    public VentaDetalleEntity save(VentaDetalleEntity ventaDetalle) {
        return ventaDetalleRepository.save(ventaDetalle);
    }
}
