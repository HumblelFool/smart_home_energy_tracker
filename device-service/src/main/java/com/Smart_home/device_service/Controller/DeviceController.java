package com.Smart_home.device_service.Controller;


import com.Smart_home.device_service.dto.DeviceDto;
import com.Smart_home.device_service.entity.Device;
import com.Smart_home.device_service.service.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/device")
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService){
        this.deviceService=deviceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceDto> getDeviceId(@PathVariable Long id){
        DeviceDto deviceDto=deviceService.getDeviceById(id);
        return ResponseEntity.ok(deviceDto);
    }

    @PostMapping("/create")
    public ResponseEntity<DeviceDto>createDevice(@RequestBody DeviceDto deviceDto){
        DeviceDto createDevice=deviceService.createDevice(deviceDto);
        return ResponseEntity.ok(createDevice);
    }

   @PutMapping ("/update/{id}")
    public ResponseEntity<DeviceDto>updateDevice(@PathVariable Long id,@RequestBody DeviceDto deviceDto){
        DeviceDto updatedDevice=deviceService.updateDevice(id,deviceDto);
        return ResponseEntity.ok(updatedDevice);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void>deleteDevice(@PathVariable Long id){
        deviceService.deleteDevice(id);
        return ResponseEntity.noContent().build();
    }
}
