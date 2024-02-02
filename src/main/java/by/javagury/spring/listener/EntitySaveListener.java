package by.javagury.spring.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EntitySaveListener {

    @EventListener(condition = "#p0.beforeRequest =='WILL SAVE'")
    public void acceptEntityIfSave(EntityBeforeEvent entityEvent) {
        System.out.println("Entity before event SAVE: " + entityEvent);
    }

    @EventListener(condition = "#p0.afterRequest =='WAS SAVE'")
    public void acceptEntityIfSave(EntityAfterEvent entityEvent) {
        System.out.println("Entity after event SAVE: " + entityEvent);
    }
}
