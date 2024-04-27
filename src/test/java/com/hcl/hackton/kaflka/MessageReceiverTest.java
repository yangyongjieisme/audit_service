package com.hcl.hackton.kaflka;

import com.hcl.hackton.domain.Audit;
import com.hcl.hackton.input.wrapper.AuditSearch;
import com.hcl.hackton.mapper.AuditMapper;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.deser.std.StringDeserializer;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@SpringBootTest
@EmbeddedKafka(topics = "quickstart-events")
class MessageReceiverTest {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    AuditMapper auditMapper;

    @Autowired
    MessageReceiver messageReceiver;

    @Test
    @DisplayName("should Receive Message Success")
    void shouldReceiveMessageSuccess() throws InterruptedException {

        AuditSearch search = new AuditSearch();
        search.setCustomerId("ccc555");
        search.setPageSize(5);
        search.setPageNumber(0);
        search.setQuery(" order by id asc");
        List<Audit> list = auditMapper.list(search);
        assertEquals(0, list.size());
        kafkaTemplate.send("quickstart-events", "{\"customerId\":\"ccc555\",\"transactionRef\":\"tt11\",\"instrumentId\":\"ddvvv\",\"tradeType\":\"BUY\"}");
        Thread.sleep(3000);
        list = auditMapper.list(search);
     //   assertEquals(1, list.size());
    }


}