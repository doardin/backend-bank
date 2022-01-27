package br.com.bank.domain.taxidentifier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bank.domain.taxidentifier.entity.TaxIdentifier;

@Repository
public interface TaxIdentifierRepository extends JpaRepository<TaxIdentifier, String> {
    
}
