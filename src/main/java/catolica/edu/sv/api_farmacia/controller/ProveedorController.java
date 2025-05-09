package catolica.edu.sv.api_farmacia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import catolica.edu.sv.api_farmacia.entities.ProveedorEntity;
import catolica.edu.sv.api_farmacia.service.IProveedor;

import java.util.List;
@RestController
@RequestMapping("/process")
public class ProveedorController {

    @Autowired
    private IProveedor IProveedor;


    @Transactional(readOnly = true)
    @GetMapping("/proveedores")
    public List<ProveedorEntity> getProveedor() {
        return IProveedor.findAll();
    }

    @Transactional
    @PostMapping("/proveedores")
    public ProveedorEntity saveProveedores(@RequestBody ProveedorEntity proveedores) {
        return IProveedor.save(proveedores);
    }
}
