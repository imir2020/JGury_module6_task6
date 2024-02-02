package by.javagury.spring.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EntityFindListener {

    @EventListener(condition = "#p0.beforeRequest =='WILL FIND'")
    public void acceptEntityIfFind(EntityBeforeEvent entityEvent) {
        System.out.println("Entity before event FIND: " + entityEvent);
    }

    @EventListener(condition = "#p0.afterRequest =='WAS FIND'")
    public void acceptEntityIfFind(EntityAfterEvent entityEvent) {
        System.out.println("Entity after event FIND: " + entityEvent);
    }






}
