package catolica.edu.sv.api_farmacia.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto")

public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Idproducto")
    private Long IdProducto;

    @Column(columnDefinition = "VARCHAR(100)")
    private String Nombre;

    @Column(columnDefinition = "DECIMAL(10,2)")
    private double Precio;

    @Column(columnDefinition = "INT")
    private int Stock;

    @Column(columnDefinition = "DATE")
    private Date FechaCaducidad;

    @Column(columnDefinition = "VARCHAR(150)")
    private String Descripcion;

}
