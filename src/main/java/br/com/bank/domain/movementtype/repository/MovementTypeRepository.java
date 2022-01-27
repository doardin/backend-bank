package br.com.bank.domain.movementtype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bank.domain.movementtype.entity.MovementType;

@Repository
public interface MovementTypeRepository extends JpaRepository<MovementType, String> {
    
}
