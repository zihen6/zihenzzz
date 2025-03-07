package com.zihenzzz;

import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DeepSeekChatApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeepSeekChatApplication.class,args);
    }
    @Bean
    public ChatMemory chatMemory(){
        return new InMemoryChatMemory();
    }
}
