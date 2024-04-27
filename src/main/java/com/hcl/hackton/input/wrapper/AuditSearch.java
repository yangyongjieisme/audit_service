package com.hcl.hackton.input.wrapper;

import lombok.Data;

@Data
public class AuditSearch {

    private String customerId;
    private Integer pageNumber;
    private Integer pageSize;
    private String query;


}
