package com.estock.api.event;

import org.springframework.context.ApplicationEvent;

public class DeviceLoginEvent extends ApplicationEvent {
    public DeviceLoginEvent(String device) {
        super(device);
    }
}
