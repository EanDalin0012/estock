package com.estock.api.event.listener;

import com.estock.api.common.exception.CustomException;
import com.estock.api.dto.DeviceInfoDTO;
import com.estock.api.event.DeviceLoginEvent;
import com.estock.api.util.Utility;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DeviceLoginEventListener implements ApplicationListener<DeviceLoginEvent> {
    private final static Logger log = Logger.getLogger(DeviceLoginEventListener.class.getName());

    @Override
    public void onApplicationEvent(DeviceLoginEvent event) {
        try {
            String deviceInfo = (String) event.getSource();
            DeviceInfoDTO deviceInfoDTO = Utility.readJSON(deviceInfo,DeviceInfoDTO.class );
            log.info("Device Info :"+ Utility.toJSON(deviceInfoDTO));

        }catch (Exception e) {
            e.printStackTrace();
        } catch (CustomException e) {
            e.printStackTrace();
        }


    }
}
