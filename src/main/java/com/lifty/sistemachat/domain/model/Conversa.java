package com.lifty.sistemachat.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_conversa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conversa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario_remetente")
    private User remetente;

    @ManyToOne
    @JoinColumn(name = "id_usuario_destinatario")
    private User destinatario;

    @OneToMany(mappedBy = "conversa")
    private List<Mensagem> mensagems = new ArrayList<>();

    @CreationTimestamp
    private LocalTime criadaEm;
}
