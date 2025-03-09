package com.zihenzzz;


import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.zihenzzz")

@EnableFeignClients(basePackages = "com.zihenzzz")
public class DeepSeekChatApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeepSeekChatApplication.class,args);
    }
    @Bean
    public ChatMemory chatMemory(){
        return new InMemoryChatMemory();
    }
}
