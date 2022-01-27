package br.com.bank.domain.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bank.domain.transaction.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
    
}
