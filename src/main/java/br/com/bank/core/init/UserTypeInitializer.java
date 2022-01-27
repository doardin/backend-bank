package br.com.bank.core.init;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import br.com.bank.domain.usertype.entity.UserType;
import br.com.bank.domain.usertype.repository.UserTypeRepository;

public class UserTypeInitializer implements ApplicationListener<ContextRefreshedEvent> {
    
    private Boolean isReady = false;
    private UserTypeRepository userTypeRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(isReady)
        return;

        this.initializer();

        this.isReady = true;
    }
    
    public void initializer(){
        UserType person = new UserType();
        person.setName("PERSON");
        this.userTypeRepository.save(person);

        UserType corporate = new UserType();
        corporate.setName("CORPORATE");
        this.userTypeRepository.save(corporate);
    }

}
