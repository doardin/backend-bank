package br.com.bank.core.init;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.bank.domain.movementtype.entity.MovementType;
import br.com.bank.domain.movementtype.repository.MovementTypeRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MovementTypeInitializer implements ApplicationListener<ContextRefreshedEvent> {
    
    private Boolean isReady = false;
    private MovementTypeRepository movementTypeRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(isReady)
        return;

        this.initializer();

        this.isReady = true;
    }

    public void initializer(){
        MovementType cashIn = new MovementType();
        cashIn.setName("CASH_IN");
        this.movementTypeRepository.save(cashIn);

        MovementType cashOut = new MovementType();
        cashOut.setName("CASH_OUT");
        this.movementTypeRepository.save(cashOut);
    }


}
