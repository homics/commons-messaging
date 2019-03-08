package com.homics.messaging.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({KafkaConsumerConfig.class, KafkaProducerConfig.class, KafkaTopicConfig.class})
public class KafkaConfig {
    public static final String GROUP_ID = "homics";
    public static final String BOOTSRTAP_SERVER = "localhost:9092";
}
