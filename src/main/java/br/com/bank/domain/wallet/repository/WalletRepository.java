package br.com.bank.domain.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bank.domain.wallet.entity.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, String> {
    
}