package catolica.edu.sv.api_farmacia.dto;

import lombok.Data;

@Data
public class VentaDetalleRequestDTO {
    private Long idVenta;
    private Long idProducto;
    private int cantidad;
    private double precio;
}
