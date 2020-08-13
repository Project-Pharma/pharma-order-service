package com.inoastrum.pharmaorderservice.web.controller;

import com.inoastrum.pharmaorderservice.services.DeliveryDetailsService;
import com.inoastrum.pharmaorderservice.web.model.DeliveryDetailsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1/deliveryDetails")
@Slf4j
@RestController
public class DeliveryDetailsController {

    private final DeliveryDetailsService deliveryDetailsService;

    @GetMapping("/{deliveryDetailsId}")
    public ResponseEntity<DeliveryDetailsDto> getDeliveryDetails(@PathVariable UUID deliveryDetailsId) {
        return new ResponseEntity<>(deliveryDetailsService.findDeliveryDetailsDtoById(deliveryDetailsId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UUID> createNewDeliveryDetails(@RequestBody @Validated DeliveryDetailsDto deliveryDetailsDto) {
        return new ResponseEntity<>(deliveryDetailsService.createNewDeliveryDetails(deliveryDetailsDto).getId(), HttpStatus.CREATED);
    }

    @PutMapping("/{deliveryDetailsId}")
    public void updateDeliveryDetails(@PathVariable UUID deliveryDetailsId, @RequestBody @Validated DeliveryDetailsDto deliveryDetailsDto) {
        deliveryDetailsService.updateDeliveryDetails(deliveryDetailsId, deliveryDetailsDto);
    }
}
