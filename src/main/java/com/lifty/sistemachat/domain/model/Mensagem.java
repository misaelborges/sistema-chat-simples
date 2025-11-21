package com.lifty.sistemachat.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_mensagem")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_conversa", nullable = false)
    private Conversa conversa;

    @ManyToOne
    @JoinColumn(name = "id_remetente", nullable = false)
    private User remetente;

    @ManyToOne
    @JoinColumn(name = "id_destinatario", nullable = false)
    private User destinatario;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String msg;

    @Column(name = "data_hora", nullable = false)
    @CreationTimestamp
    private LocalDateTime dataHora;
}
