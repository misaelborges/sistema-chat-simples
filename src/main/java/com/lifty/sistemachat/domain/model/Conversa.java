package com.lifty.sistemachat.domain.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
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

    @OneToMany(mappedBy = "conversa")
    private List<Mensagem> mensagems = new ArrayList<>();

    @CreationTimestamp
    private LocalTime criadaEm;

    public Conversa() {
    }

    public Conversa(Long id, User remetente, User destinatario, List<Mensagem> mensagems, LocalTime criadaEm) {
        this.id = id;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.mensagems = mensagems;
        this.criadaEm = criadaEm;
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

    public List<Mensagem> getMensagems() {
        return mensagems;
    }

    public void setMensagems(List<Mensagem> mensagems) {
        this.mensagems = mensagems;
    }

    public LocalTime getCriadaEm() {
        return criadaEm;
    }

    public void setCriadaEm(LocalTime criadaEm) {
        this.criadaEm = criadaEm;
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
