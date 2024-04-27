package com.hcl.hackton.mapper;

import com.hcl.hackton.domain.Instruments;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class InstrumentsMapperTest {

    @Autowired
    InstrumentsMapper instrumentsMapper;

    @Test
    @DisplayName("should getById success")
    void shouldGetByIdSuccess() {

        Instruments ins = instrumentsMapper.getById("ddvvv");
        assertEquals("ABC1",ins.getInstrumentName());
    }
}