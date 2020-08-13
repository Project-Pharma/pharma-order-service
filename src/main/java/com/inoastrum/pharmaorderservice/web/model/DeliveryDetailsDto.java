package com.inoastrum.pharmaorderservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryDetailsDto {

    @Null
    private UUID id;

    @Null
    private Integer version;

    @Null
    private OffsetDateTime createdDate;

    @Null
    private OffsetDateTime lastModifiedDate;

    @NotEmpty
    private UUID orderId;

    @NotEmpty
    private String name;

    @NotEmpty
    private String address;

    @NotNull
    private UUID provinceId;

    @NotNull
    private UUID districtId;

    @NotEmpty
    private String phoneNumber;
}
