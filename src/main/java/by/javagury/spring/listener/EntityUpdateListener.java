package by.javagury.spring.listener;


import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EntityUpdateListener {
    @EventListener(condition = "#p0.beforeRequest=='WILL UPDATE'")
    public void acceptEntityIfUpdate(EntityBeforeEvent entityEvent) {
        System.out.println("Entity before event UPDATE: " + entityEvent);
    }

    @EventListener(condition = "#p0.afterRequest=='WAS UPDATE'")
    public void acceptEntityIfUpdate(EntityAfterEvent entityEvent) {
        System.out.println("Entity after event UPDATE: " + entityEvent);
    }

}
