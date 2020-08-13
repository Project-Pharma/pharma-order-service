package com.inoastrum.pharmaorderservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrescriptionDto {

    @Null
    private UUID id;

    @Null
    private Integer version;

    @Null
    private OffsetDateTime createdDate;

    @Null
    private OffsetDateTime lastModifiedDate;

    @NotNull
    private UUID orderId;

    private List<URI> prescriptionImages;

    private Long nationalIdNo;

    private Long ePrescriptionNo;

    private Long traceNo;
    
    private OffsetDateTime prescriptionDate;

    @NotNull
    private Boolean approved;
}
