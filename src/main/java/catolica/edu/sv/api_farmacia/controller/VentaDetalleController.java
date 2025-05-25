package catolica.edu.sv.api_farmacia.controller;

import catolica.edu.sv.api_farmacia.dto.VentaDetalleRequestDTO;
import catolica.edu.sv.api_farmacia.entities.*;
import catolica.edu.sv.api_farmacia.entities.payload.MessageResponse;
import catolica.edu.sv.api_farmacia.repository.ProductoRepository;
import catolica.edu.sv.api_farmacia.repository.VentaRepository;
import catolica.edu.sv.api_farmacia.service.IVentaDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/process")
public class VentaDetalleController {

    @Autowired
    private IVentaDetalle iVentaDetalle;

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Transactional(readOnly = true)
    @GetMapping("/ventadetalles")
    public ResponseEntity<?> getVentaDetalles() {
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Proceso realizado con exito.")
                .data(iVentaDetalle.findAll())
                .build(), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/ventadetalle")
    public ResponseEntity<?> saveVentaDetalles(@RequestBody VentaDetalleRequestDTO dto) {
        VentaEntity venta = ventaRepository.findById(dto.getIdVenta())
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        ProductoEntity producto = productoRepository.findById(dto.getIdProducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        VentaDetalleId id = new VentaDetalleId(dto.getIdVenta(), dto.getIdProducto());

        VentaDetalleEntity detalle = new VentaDetalleEntity();
        detalle.setId(id);
        detalle.setVenta(venta);
        detalle.setProducto(producto);
        detalle.setCantidad(dto.getCantidad());
        detalle.setPrecio(dto.getPrecio());

        iVentaDetalle.save(detalle);

        return new ResponseEntity<>(MessageResponse.builder()
                .message("Detalle de venta registrado correctamente.")
                .data(detalle)
                .build(), HttpStatus.CREATED);
    }

    @PutMapping("/ventadetalle/{idVenta}/{idProducto}")
    public ResponseEntity<?> updateVentaDetalle(
            @PathVariable Long idVenta,
            @PathVariable Long idProducto,
            @RequestBody VentaDetalleRequestDTO dto) {

        VentaDetalleId id = new VentaDetalleId(idVenta, idProducto);
        VentaDetalleEntity detalleExistente = iVentaDetalle.findById(id)
                .orElse(null);

        if (detalleExistente == null) {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Detalle de venta no encontrado con idVenta: " + idVenta + " y idProducto: " + idProducto)
                    .build(), HttpStatus.NOT_FOUND);
        }

        detalleExistente.setCantidad(dto.getCantidad());
        detalleExistente.setPrecio(dto.getPrecio());

        VentaDetalleEntity actualizado = iVentaDetalle.save(detalleExistente);

        return new ResponseEntity<>(MessageResponse.builder()
                .message("Detalle de venta actualizado correctamente.")
                .data(actualizado)
                .build(), HttpStatus.OK);
    }

}

