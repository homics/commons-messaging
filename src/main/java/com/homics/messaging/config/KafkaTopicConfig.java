package com.homics.messaging.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

import static com.homics.messaging.config.KafkaConfig.BOOTSTRAP_SERVER;

@Configuration
public class KafkaTopicConfig {

    public static final String TOPIC_IMPACT_STOCK = "IMPACT_STOCK";
    public static final String TOPIC_ACKNOWLEDGE_STOCK = "ACKNOWLEDGE_STOCK";
    public static final String TOPIC_STATS = "STATS";

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic impactStockTopic() {
        return new NewTopic(TOPIC_IMPACT_STOCK, 1, (short) 1);
    }

    @Bean
    public NewTopic acknowledgeStockTopic() {
        return new NewTopic(TOPIC_ACKNOWLEDGE_STOCK, 1, (short) 1);
    }

    @Bean
    public NewTopic statsTopic() {
        return new NewTopic(TOPIC_STATS, 1, (short) 1);
    }
}
