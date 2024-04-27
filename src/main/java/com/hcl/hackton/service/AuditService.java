package com.hcl.hackton.service;

import com.hcl.hackton.domain.Audit;
import com.hcl.hackton.input.AuditSearchVO;

import java.util.List;


public interface AuditService {
    List<Audit> list(AuditSearchVO searchVO);
}
