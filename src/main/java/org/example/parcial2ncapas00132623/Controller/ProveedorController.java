package org.example.parcial2ncapas00132623.Controller;

import jakarta.validation.Valid;
import org.example.parcial2ncapas00132623.Model.DTOs.Requests.MagicProviderRequestDTO;
import org.example.parcial2ncapas00132623.Model.DTOs.Responses.GenericResponse;
import org.example.parcial2ncapas00132623.Model.MagicProvider;
import org.example.parcial2ncapas00132623.Repository.iProveedorRepository;
import org.example.parcial2ncapas00132623.Service.iProveedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/providers")
public class ProveedorController {

    private final iProveedorService proveedorService;
    private final iProveedorRepository proveedorRepository;

    public ProveedorController(iProveedorService productoService, iProveedorRepository proveedorRepository) {
        this.proveedorService = productoService;
        this.proveedorRepository = proveedorRepository;
    }

    @PostMapping
    public ResponseEntity<GenericResponse> createProveedor(@RequestBody @Valid MagicProviderRequestDTO requestDTO){
        return GenericResponse.builder()
                .message("Proveedor creado con éxito")
                .data(proveedorService.createProveedor(requestDTO))
                .status(HttpStatus.CREATED)
                .build().buildResponse();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<MagicProvider>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(proveedorRepository.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse> updateProveedor(@PathVariable Long id, @RequestBody @Valid MagicProviderRequestDTO requestDTO){
        return GenericResponse.builder()
                .message("Se edito con exito")
                .data(proveedorService.updateProveedor(id, requestDTO))
                .status(HttpStatus.OK)
                .build().buildResponse();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse> deleteProveedor(@PathVariable Long id){

        proveedorService.deleteProveedor(id);

        return GenericResponse.builder()
                .message("Se elimino con exito")
                .data(null)
                .status(HttpStatus.OK)
                .build().buildResponse();

    }

}
