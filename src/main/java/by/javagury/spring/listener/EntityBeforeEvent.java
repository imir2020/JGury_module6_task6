package by.javagury.spring.listener;

import org.springframework.context.ApplicationEvent;

public class EntityBeforeEvent extends ApplicationEvent {

    private final String beforeRequest;

    public EntityBeforeEvent(Object entity, String beforeRequest) {
        super(entity);
        this.beforeRequest = beforeRequest;
    }

    public String getBeforeRequest() {
        return beforeRequest;
    }
}
