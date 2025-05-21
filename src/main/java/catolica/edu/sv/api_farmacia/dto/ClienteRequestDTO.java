package catolica.edu.sv.api_farmacia.dto;


import lombok.Data;

@Data
public class ClienteRequestDTO {
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private boolean membresia;

}
