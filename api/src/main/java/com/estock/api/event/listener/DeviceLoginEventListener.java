package com.estock.api.event.listener;

import com.estock.api.common.exception.CustomException;
import com.estock.api.dto.DeviceInfoDTO;
import com.estock.api.event.DeviceLoginEvent;
import com.estock.api.util.Utility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DeviceLoginEventListener implements ApplicationListener<DeviceLoginEvent> {

    @Override
    public void onApplicationEvent(DeviceLoginEvent event) {
        try {
            Thread.sleep(10000);
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
