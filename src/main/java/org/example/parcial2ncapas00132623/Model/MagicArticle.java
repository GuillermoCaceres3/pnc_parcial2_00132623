package org.example.parcial2ncapas00132623.Model;

import jakarta.persistence.*;
import lombok.*;
import org.example.parcial2ncapas00132623.Enums.Type;

import java.math.BigDecimal;


@Entity
@Table(name="MagicArticle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MagicArticle {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="MagicArticle_id")
    private Long id;

    @Column(name="name", nullable = false, unique = true)
    private String name;

    @Column(name="type", nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name="price", nullable = false)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_provider", nullable = false)
    private MagicProvider provider;

}
