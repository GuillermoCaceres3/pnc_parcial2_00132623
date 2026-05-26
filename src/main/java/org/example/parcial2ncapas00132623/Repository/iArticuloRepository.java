package org.example.parcial2ncapas00132623.Repository;


import org.example.parcial2ncapas00132623.Enums.Type;
import org.example.parcial2ncapas00132623.Model.MagicArticle;
import org.example.parcial2ncapas00132623.Model.MagicProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface iArticuloRepository extends JpaRepository<MagicArticle, Long> {
    Optional<MagicArticle> findByNameIgnoreCase(String name);
    boolean existsByNameIgnoreCase(String name);
    List<MagicArticle> findByTypeAndPriceAndProvider(Type type, BigDecimal price, MagicProvider provider);
    List<MagicArticle> findByProvider(Optional<MagicProvider> provider);

}
