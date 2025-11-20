package com.lifty.sistemachat.domain.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "tbl_conversa")
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

    @CreationTimestamp
    private LocalTime criada_em;

    public Conversa() {
    }

    public Conversa(Long id, User remetente, User destinatario, LocalTime criada_em) {
        this.id = id;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.criada_em = criada_em;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getRemetente() {
        return remetente;
    }

    public void setRemetente(User remetente) {
        this.remetente = remetente;
    }

    public User getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(User destinatario) {
        this.destinatario = destinatario;
    }

    public LocalTime getCriada_em() {
        return criada_em;
    }

    public void setCriada_em(LocalTime criada_em) {
        this.criada_em = criada_em;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Conversa conversa = (Conversa) o;
        return Objects.equals(id, conversa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
