package by.javagury.spring.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EntityDeleteListener {
    @EventListener(condition = "#p0.beforeRequest =='WILL DELETE'")
    public void acceptEntityIfDelete(EntityBeforeEvent entityEvent) {
        System.out.println("Entity before event DELETE: " + entityEvent);
    }

    @EventListener(condition = "#p0.afterRequest =='WAS DELETE'")
    public void acceptEntityIfDelete(EntityAfterEvent entityEvent) {
        System.out.println("Entity after event DELETE: " + entityEvent);
    }
}
