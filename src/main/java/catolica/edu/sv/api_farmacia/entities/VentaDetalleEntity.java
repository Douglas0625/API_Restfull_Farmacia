package catolica.edu.sv.api_farmacia.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ventadetalle")

public class VentaDetalleEntity {

    @EmbeddedId
    private VentaDetalleId id;

    @ManyToOne
    @MapsId("idVenta")
    @JoinColumn(name = "IdVenta", referencedColumnName = "IdVenta", foreignKey = @ForeignKey(name = "fk_ventadetalle_venta"))
    private VentaEntity venta;

    @ManyToOne
    @MapsId("idProducto")
    @JoinColumn(name = "IdProducto", referencedColumnName = "IdProducto", foreignKey = @ForeignKey(name = "fk_ventadetalle_producto"))
    private ProductoEntity producto;

    @Column(columnDefinition = "INT")
    private int cantidad;

    @Column(columnDefinition = "DECIMAL(10,2)")
    private double precio;
}
