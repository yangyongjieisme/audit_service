package com.hcl.hackton.input;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class AuditSearchVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "customer id cannot be null")
    private String customerId;
    private Integer pageNumber = 1;
    private Integer pageSize = 20;
    private String oder = "id desc";
    private List<SearchFiled> filters = new ArrayList();

}
