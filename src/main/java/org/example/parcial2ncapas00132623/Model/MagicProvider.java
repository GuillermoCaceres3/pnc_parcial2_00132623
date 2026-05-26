package org.example.parcial2ncapas00132623.Model;


import jakarta.persistence.*;
import lombok.*;
import org.example.parcial2ncapas00132623.Enums.Type;

@Entity
@Table(name="MagicProvider")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MagicProvider {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="MagicProvider_id")
    private Long id;

    @Column(name="name",  nullable=false, unique = true)
    private String name;

    @Column(name="type", nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name="isActive", nullable = false)
    boolean isActive;

}
