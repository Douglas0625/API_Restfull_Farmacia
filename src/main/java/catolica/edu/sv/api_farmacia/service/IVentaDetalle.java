package catolica.edu.sv.api_farmacia.service;

import catolica.edu.sv.api_farmacia.entities.VentaDetalleEntity;
import catolica.edu.sv.api_farmacia.entities.VentaDetalleId;

import java.util.List;
import java.util.Optional;

public interface IVentaDetalle {

    List<VentaDetalleEntity> findAll();

    VentaDetalleEntity save(VentaDetalleEntity ventaDetalle);

    Optional<VentaDetalleEntity> findById(VentaDetalleId id);

    void deleteById(VentaDetalleId id);

}
