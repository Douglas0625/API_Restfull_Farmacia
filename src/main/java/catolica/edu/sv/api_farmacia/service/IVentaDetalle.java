package catolica.edu.sv.api_farmacia.service;

import catolica.edu.sv.api_farmacia.entities.VentaDetalleEntity;

import java.util.List;

public interface IVentaDetalle {

    List<VentaDetalleEntity> findAll();

    //post
    VentaDetalleEntity save(VentaDetalleEntity ventaDetalle);
}
