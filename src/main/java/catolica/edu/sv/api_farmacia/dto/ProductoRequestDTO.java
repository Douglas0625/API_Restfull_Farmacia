package catolica.edu.sv.api_farmacia.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProductoRequestDTO {
    private String nombre;
    private Double precio;
    private int stock;
    private Date fecha_caducidad;
    private String descripcion;
}
