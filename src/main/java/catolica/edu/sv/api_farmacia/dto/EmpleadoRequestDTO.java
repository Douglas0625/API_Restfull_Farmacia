package catolica.edu.sv.api_farmacia.dto;

import lombok.Data;

@Data
public class EmpleadoRequestDTO {
    private long IdEmpleado;
    private String Nombre;
    private String Apellido;
    private String Cargo;
    private double Salario;


}
