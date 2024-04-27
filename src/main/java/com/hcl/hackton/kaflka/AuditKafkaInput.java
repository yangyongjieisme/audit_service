package com.hcl.hackton.kaflka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuditKafkaInput {

    private String customerId;
    private String instrumentId;
    private String transactionRef;
    private String tradeType;
    private Date auditDate;


}
