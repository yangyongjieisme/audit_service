package com.hcl.hackton.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.hackton.domain.Audit;
import com.hcl.hackton.input.AuditSearchVO;
import com.hcl.hackton.service.impl.AuditServiceImpl;
import org.junit.BeforeClass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@SpringBootTest
@WebMvcTest(controllers = AuditController.class)
@AutoConfigureMybatis
public class AuditControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuditServiceImpl auditServiceImpl;

    ObjectMapper mapper=new ObjectMapper();

    @BeforeClass
    public static void setUp() {

    }

    @Test
    @DisplayName("Test list api")
    void testListApi() throws Exception {
        List<Audit> res = new ArrayList<>();
        Audit audit = new Audit();
        audit.setCustomerId("aaa");
        res.add(audit);

        AuditSearchVO vo=new AuditSearchVO();
        vo.setCustomerId("aaa");
        String json=mapper.writeValueAsString(vo);
        when(auditServiceImpl.list(any())).thenReturn(res);
        mockMvc.perform(post("/audit/list").content(json).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON,MediaType.APPLICATION_OCTET_STREAM))
                .andExpect(status().isOk()).andExpect(jsonPath("$.[0].customerId", is("aaa")));

    }

}
