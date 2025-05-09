package catolica.edu.sv.api_farmacia.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable

public class ProveedorProductoId implements Serializable {
    @Column(name = "IdProveedor")
    private Long idProveedor;

    @Column(name = "IdProducto")
    private Long idProducto;
}
