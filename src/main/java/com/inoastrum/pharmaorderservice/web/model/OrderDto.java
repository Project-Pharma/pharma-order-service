package com.inoastrum.pharmaorderservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {

    @Null
    private UUID id;

    @Null
    private Integer version;

    @Null
    private OffsetDateTime createdDate;

    @Null
    private OffsetDateTime lastModifiedDate;

    @NotNull
    private UUID prescriptionId;

    @NotNull
    private UUID pharmacyId;

    @NotNull
    private UUID ownerId;

    @NotNull
    private DeliveryDetailsDto deliveryDetails;

    @NotNull
    private OrderStatus orderStatus;
}
