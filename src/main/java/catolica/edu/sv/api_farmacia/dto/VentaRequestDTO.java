package catolica.edu.sv.api_farmacia.dto;
import lombok.*;
import java.time.LocalDateTime;

@Data
public class VentaRequestDTO {
    private Long idCliente;
    private Long idEmpleado;
    private LocalDateTime fechaVenta;
}
