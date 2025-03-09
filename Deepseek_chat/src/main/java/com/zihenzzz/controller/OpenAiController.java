package com.zihenzzz.controller;

import com.zihenzzz.interceptor.LoggingAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDate;

import static com.zihenzzz.constants.ChatConstants.CHAT_PRESET_WORDS;
import static org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor.CHAT_MEMORY_RETRIEVE_SIZE_KEY;

@RequestMapping("open")
@RestController
public class OpenAiController {


    private ChatClient chatClient;

    public OpenAiController(ChatClient.Builder chatClient, ChatMemory chatMemory) {
        //角色预制
        this.chatClient = chatClient.defaultSystem(CHAT_PRESET_WORDS

                )
                //ai记忆操作
                .defaultAdvisors(new PromptChatMemoryAdvisor(chatMemory), new LoggingAdvisor())
                .defaultFunctions("cancelBooking", "selectBooking", "registerBooking")

                .build();

    }

    @GetMapping(value = "/ai/generateStreamAsString")
    public String generateStreamAsString(@RequestParam(value = "message", defaultValue = "你好啊") String message) {
        String content = chatClient.prompt().user(message).system(s -> s.param("current_date", LocalDate.now().toString())).advisors(a -> a.param(CHAT_MEMORY_RETRIEVE_SIZE_KEY, 20)).call().content();

        return content;
    }

}


