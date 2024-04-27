package com.hcl.hackton.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Audit implements Serializable {

    private String id;
    private String customerId;
    private String transcationRef;
    private String instrumentId;
    private String instrumentName;
    private String tradeType;
    private Date auditDate;
}
