package com.hcl.hackton.domain;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Instruments {

    private String instrumentId;
    private String instrumentName;
    private String instrumentValue;
    private String instrumentType;
}
