package com.lifty.sistemachat.domain.repositorie;

import com.lifty.sistemachat.domain.model.Conversa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversaRepository extends JpaRepository<Conversa, Long> {
    
}
