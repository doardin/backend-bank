package br.com.bank.domain.usertype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bank.domain.usertype.entity.UserType;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, String> {
    
}
