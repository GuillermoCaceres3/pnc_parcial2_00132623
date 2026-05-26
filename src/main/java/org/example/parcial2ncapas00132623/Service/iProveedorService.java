package org.example.parcial2ncapas00132623.Service;

import org.example.parcial2ncapas00132623.Model.DTOs.Requests.MagicProviderRequestDTO;
import org.example.parcial2ncapas00132623.Model.MagicProvider;

import java.util.Optional;

public interface iProveedorService {
    MagicProvider createProveedor(MagicProviderRequestDTO request);
    MagicProvider updateProveedor(Long id, MagicProviderRequestDTO request);
    void deleteProveedor(Long id);
}
