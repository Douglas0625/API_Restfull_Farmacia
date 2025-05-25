package catolica.edu.sv.api_farmacia.service;

import catolica.edu.sv.api_farmacia.entities.VentaEntity;

import java.util.List;

public interface IVenta {
    List<VentaEntity> findAll();

    //post
    VentaEntity save(VentaEntity venta);

    List<VentaEntity> findByIdVenta(long idVenta);
}
