package by.javagury.spring.listener;

import org.springframework.context.ApplicationEvent;

public class EntityAfterEvent extends ApplicationEvent {
    private final String afterRequest;

    public EntityAfterEvent(Object source, String afterRequest) {
        super(source);
        this.afterRequest = afterRequest;
    }

    public String getAfterRequest() {
        return afterRequest;
    }
}
