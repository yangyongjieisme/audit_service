package com.hcl.hackton.kaflka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.hackton.domain.Audit;
import com.hcl.hackton.domain.Instruments;
import com.hcl.hackton.mapper.AuditMapper;
import com.hcl.hackton.mapper.InstrumentsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;


@Component
@Slf4j
public class MessageReceiver {

    ObjectMapper mapper=new ObjectMapper();
    @Autowired
    AuditMapper auditMapper;

    @Autowired
    InstrumentsMapper instrumentsMapper;


    @KafkaListener(topics = "${spring.kafka.consumer.group-id}")
    public void processMessage(String content) throws JsonProcessingException {

        log.debug(content);
        AuditKafkaInput auditKafkaInput = mapper.readValue(content, AuditKafkaInput.class);
        Instruments instrumentbyId = instrumentsMapper.getById(auditKafkaInput.getInstrumentId());
        Audit audit=new Audit();
        audit.setId(UUID.randomUUID().toString());
        audit.setCustomerId(auditKafkaInput.getCustomerId());
        audit.setInstrumentId(auditKafkaInput.getInstrumentId());
        audit.setInstrumentName(instrumentbyId.getInstrumentName());
        audit.setTranscationRef(auditKafkaInput.getTransactionRef());
        audit.setTradeType(auditKafkaInput.getTradeType());
        audit.setAuditDate(new Date());
        auditMapper.insert(audit);
    }

}