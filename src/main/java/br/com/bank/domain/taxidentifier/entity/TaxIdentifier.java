package br.com.bank.domain.taxidentifier.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.bank.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TaxIdentifier {
    
    @Id
    private String id = UUID.randomUUID().toString();
    
    private String taxId;

    @OneToOne(mappedBy = "taxIdentifier")
    private User user;

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
