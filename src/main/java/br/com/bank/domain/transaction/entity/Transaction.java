package br.com.bank.domain.transaction.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.bank.domain.movementtype.entity.MovementType;
import br.com.bank.domain.user.entity.User;
import br.com.bank.domain.wallet.entity.Wallet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Transaction {
    
    @Id
    private String id = UUID.randomUUID().toString();

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "senderId")
    private Wallet sender;

    @ManyToOne
    @JoinColumn(name = "recipientId")
    private Wallet recipient;

    @ManyToOne
    @JoinColumn(name = "movementTypeId")
    private MovementType movementType;

    private BigDecimal amount;

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
