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

    @Null
    private UUID prescriptionId;

    @NotNull
    private UUID pharmacyId;

    @NotNull
    private UUID ownerId;

    @Null
    private UUID deliveryDetailsId;

    @NotNull
    private OrderStatus orderStatus;
}
