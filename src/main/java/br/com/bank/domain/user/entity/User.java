package br.com.bank.domain.user.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.bank.domain.taxidentifier.entity.TaxIdentifier;
import br.com.bank.domain.transaction.entity.Transaction;
import br.com.bank.domain.usertype.entity.UserType;
import br.com.bank.domain.wallet.entity.Wallet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    
    private String id = UUID.randomUUID().toString();
    private String name;
    
    private String email;
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userId")
    private List<Transaction> transactions;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taxIdentifierId")
    private TaxIdentifier taxIdentifier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userTypeId")
    private UserType type;

    @OneToOne
    @JoinColumn(name = "walletId")
    private Wallet wallet;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist(){
        if(this.createdAt == null) this.createdAt = LocalDateTime.now();
        if(this.updatedAt == null) this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt = LocalDateTime.now();
    }

}
