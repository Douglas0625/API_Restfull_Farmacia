package catolica.edu.sv.api_farmacia.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class VentaDetalleId implements Serializable {

    @Column(name = "IdVenta")
    private Long idVenta;

    @Column(name = "IdProducto")
    private Long idProducto;
}
