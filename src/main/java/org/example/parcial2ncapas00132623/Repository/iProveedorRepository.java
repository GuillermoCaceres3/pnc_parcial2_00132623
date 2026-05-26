package org.example.parcial2ncapas00132623.Repository;

import org.example.parcial2ncapas00132623.Model.MagicArticle;
import org.example.parcial2ncapas00132623.Model.MagicProvider;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface iProveedorRepository extends JpaRepository<MagicProvider, Long> {

    Optional<MagicProvider> findById(Long id);
    Optional<MagicProvider> findByNameIgnoreCase(String name);
    boolean existsByNameIgnoreCase(String name);

}
