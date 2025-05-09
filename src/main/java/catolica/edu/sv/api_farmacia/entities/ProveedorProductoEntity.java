package catolica.edu.sv.api_farmacia.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ProveedorProducto")

public class ProveedorProductoEntity {

    @EmbeddedId
    private ProveedorProductoId id;

    @ManyToOne
    @MapsId("idProveedor")
    @JoinColumn(name = "IdProveedor", referencedColumnName = "IdProveedor", foreignKey = @ForeignKey(name = "fk_proveedorproducto_proveedor"))
    private ProveedorEntity proveedor;

    @ManyToOne
    @MapsId("idProducto")
    @JoinColumn(name = "IdProducto", referencedColumnName = "IdProducto", foreignKey = @ForeignKey(name = "fk_proveedorproducto_producto"))
    private ProductoEntity producto;
}
