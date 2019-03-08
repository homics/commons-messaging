package com.homics.messaging.config;

import com.homics.messaging.model.ImpactStockMessage;
import com.homics.messaging.model.OrderPayedMessage;
import com.homics.messaging.model.StockAcknowledgmentMessage;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

import static com.homics.messaging.config.KafkaConfig.BOOTSRTAP_SERVER;
import static com.homics.messaging.config.KafkaConfig.GROUP_ID;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    public static final String STATS_MESSAGE_FACTORY = "statsMessageFactory";
    public static final String STOCK_ACKNOWLEDGMENT_FACTORY = "stockAcknowledgmentFactory";
    public static final String IMPACT_STOCK_MESSAGE_FACTORY = "impactStockMessageFactory";

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSRTAP_SERVER);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return props;
    }


    @Bean(IMPACT_STOCK_MESSAGE_FACTORY)
    public ConcurrentKafkaListenerContainerFactory<String, ImpactStockMessage> impactStockMessageFactory() {
        ConcurrentKafkaListenerContainerFactory<String, ImpactStockMessage> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
                new JsonDeserializer<>(ImpactStockMessage.class)));
        return factory;
    }

    @Bean(STOCK_ACKNOWLEDGMENT_FACTORY)
    public ConcurrentKafkaListenerContainerFactory<String, StockAcknowledgmentMessage> stockAcknowledgmentFactory() {
        ConcurrentKafkaListenerContainerFactory<String, StockAcknowledgmentMessage> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
                new JsonDeserializer<>(StockAcknowledgmentMessage.class)));

        return factory;
    }

    @Bean(STATS_MESSAGE_FACTORY)
    public ConcurrentKafkaListenerContainerFactory<String, OrderPayedMessage> orderPayedMessageFactory() {
        ConcurrentKafkaListenerContainerFactory<String, OrderPayedMessage> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
                new JsonDeserializer<>(OrderPayedMessage.class)));

        return factory;
    }

}
