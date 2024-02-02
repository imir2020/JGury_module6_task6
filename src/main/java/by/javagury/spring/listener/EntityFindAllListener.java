package by.javagury.spring.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EntityFindAllListener {

    @EventListener(condition = "#p0.beforeRequest =='WILL FIND_ALL'")
    public void acceptEntityIfFindAll(EntityBeforeEvent entityEvent) {
        System.out.println("Entity before event FIND_ALL: " + entityEvent);
    }

    @EventListener(condition = "#p0.afterRequest =='WAS FIND_ALL'")
    public void acceptEntityIfFindAll(EntityAfterEvent entityEvent) {
        System.out.println("Entity after event FIND_ALL: " + entityEvent);
    }
}
