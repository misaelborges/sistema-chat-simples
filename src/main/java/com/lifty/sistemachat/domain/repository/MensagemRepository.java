package com.lifty.sistemachat.domain.repository;

import com.lifty.sistemachat.domain.model.Mensagem;
import com.lifty.sistemachat.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Long> {

    List<Mensagem> findByConversaIdOrderByDataHoraAsc(Long conversaId);
    User findRemetenteById(Long remetenteid);
}
