package com.lifty.sistemachat.domain.repository;

import com.lifty.sistemachat.domain.model.Conversa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConversaRepository extends JpaRepository<Conversa, Long> {

    @Query("""
            SELECT c 
            FROM Conversa c
            WHERE (c.remetente.id = :idUsuario1 AND c.destinatario.id = :idUsuario2)
               OR (c.remetente.id = :idUsuario2 AND c.destinatario.id = :idUsuario1)
            """)
    Optional<Conversa> findConversaEntreUsuarios(@Param("idUsuario1") Long idUsuario1,
                                                 @Param("idUsuario2") Long idUsuario2);
    
}
