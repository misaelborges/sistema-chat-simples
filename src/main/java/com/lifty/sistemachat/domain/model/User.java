package com.lifty.sistemachat.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_user")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nome;
}
