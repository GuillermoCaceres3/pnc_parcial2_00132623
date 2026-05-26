package org.example.parcial2ncapas00132623.Service.ServiceImpl;

import org.example.parcial2ncapas00132623.Model.DTOs.Requests.MagicProviderRequestDTO;
import org.example.parcial2ncapas00132623.Model.MagicArticle;
import org.example.parcial2ncapas00132623.Model.MagicProvider;
import org.example.parcial2ncapas00132623.Repository.iArticuloRepository;
import org.example.parcial2ncapas00132623.Repository.iProveedorRepository;
import org.example.parcial2ncapas00132623.Service.iProveedorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements iProveedorService {

    private final iProveedorRepository proveedorRepository;
    private final iArticuloRepository articuloRepository;

    public ProveedorServiceImpl(iProveedorRepository proveedorRepository, iArticuloRepository articuloRepository) {
        this.proveedorRepository = proveedorRepository;
        this.articuloRepository = articuloRepository;
    }

    @Override
    public MagicProvider createProveedor(MagicProviderRequestDTO request){
        if(proveedorRepository.existsByNameIgnoreCase(request.getName())){
            throw new RuntimeException("El proveedor ya existe");
        }

        MagicProvider proveedor = MagicProvider.builder()
                .name(request.getName())
                .type(request.getType())
                .isActive(request.isActive())
                .build();

        MagicProvider proveedorAGuardar = proveedorRepository.save(proveedor);

        return proveedorAGuardar;
    }

    @Override
    public MagicProvider updateProveedor(Long id, MagicProviderRequestDTO request) {
        MagicProvider proveedorExistente = proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        proveedorExistente.setName(request.getName());
        proveedorExistente.setType(request.getType());
        proveedorExistente.setActive(request.isActive());

        MagicProvider proveedorUpdate = proveedorRepository.save(proveedorExistente);

        return proveedorUpdate;
    }

    @Override
    public void deleteProveedor(Long id) {

        List<MagicArticle> lista = articuloRepository.findByProvider(proveedorRepository.findById(id));
        if (lista.size() > 0){
            throw new RuntimeException("El proveedor cuenta con articulos asociados");
        }

        proveedorRepository.deleteById(id);


    }
}
