package com.hcl.hackton.mapper;

import com.hcl.hackton.domain.Audit;
import com.hcl.hackton.input.wrapper.AuditSearch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuditMapperTest {

    @Autowired
    AuditMapper auditMapper;

    @Test
    @DisplayName("should List Success")
    void shouldListSuccess() {
        AuditSearch search = new AuditSearch();
        search.setCustomerId("aaa");
        search.setPageSize(2);
        search.setPageNumber(0);
        List<Audit> list = auditMapper.list(search);
        assertEquals(2, list.size());
        search.setPageSize(5);
        List<Audit> list1 = auditMapper.list(search);
        assertEquals(4, list1.size());


    }

    @Test
    @DisplayName("should insert success")
    void shouldInsertSuccess() {

        Audit audit = new Audit();
        audit.setCustomerId("aaa");
        audit.setAuditDate(new Date());
        audit.setTradeType("BUY");
        audit.setInstrumentId("iiiii5");
        audit.setInstrumentName("nnn5");
        audit.setTranscationRef("rrrr55");
        audit.setId(UUID.randomUUID().toString());

        AuditSearch search = new AuditSearch();
        search.setCustomerId("aaa");
        search.setPageSize(5);
        search.setPageNumber(0);
        List<Audit> list = auditMapper.list(search);

        assertEquals(4, list.size());
        auditMapper.insert(audit);
        list = auditMapper.list(search);

        assertEquals(5, list.size());
    }


}