package com.example.workflow.message;

import javax.jms.ConnectionFactory;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class MessagingConfig {

    @Bean
    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
                            DefaultJmsListenerContainerFactoryConfigurer configurer) {
      DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
      // This provides all boot's default to this factory, including the message converter
      //factory.setPubSubDomain(true); // pubsub 설정시 
      configurer.configure(factory, connectionFactory);
      // You could still override some of Boot's default if necessary.
      return factory;
    }

    @Bean // Serialize message content to json using TextMessage
    public MessageConverter jacksonJmsMessageConverter() {
      MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
      converter.setTargetType(MessageType.TEXT);
      converter.setTypeIdPropertyName("_type");
      return converter;
    }
// 
//    
//    @Bean
//    public MappingJackson2MessageConverter messageConverter() {
//      MappingJackson2MessageConverter messageConverter =
//                              new MappingJackson2MessageConverter();
//      messageConverter.setTypeIdPropertyName("_typeId");
//
//      Map<String, Class<?>> typeIdMappings = new HashMap<String, Class<?>>();
//      typeIdMappings.put("email", Email.class);
//      messageConverter.setTypeIdMappings(typeIdMappings);
//
//      return messageConverter;
//    }
}