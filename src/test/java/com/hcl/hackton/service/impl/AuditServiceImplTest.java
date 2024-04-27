package com.hcl.hackton.service.impl;

import com.hcl.hackton.domain.Audit;
import com.hcl.hackton.input.AuditSearchVO;
import com.hcl.hackton.mapper.AuditMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class AuditServiceImplTest {

    @MockBean
    AuditMapper auditMapper;

    @Autowired
    AuditServiceImpl auditService;
    @Test
    @DisplayName("shouldListSuccess")
    void shouldListSuccess() {

        List<Audit> res = new ArrayList<>();
        Audit audit = new Audit();
        audit.setCustomerId("aaa");
        res.add(audit);
        when(auditMapper.list(any())).thenReturn(res);
        AuditSearchVO searchVO = new AuditSearchVO();
        List<Audit> list = auditService.list(searchVO);
        assertEquals("aaa",list.get(0).getCustomerId());
    }
}