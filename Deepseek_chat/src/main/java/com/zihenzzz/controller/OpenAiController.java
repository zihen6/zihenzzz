package com.zihenzzz.controller;

import com.zihenzzz.interceptor.LoggingAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.print.DocFlavor;

import java.time.LocalDate;

import static org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor.CHAT_MEMORY_RETRIEVE_SIZE_KEY;

@RequestMapping("open")
@RestController
public class OpenAiController {

    private ChatClient chatClient;

    public OpenAiController(ChatClient.Builder chatClient, ChatMemory chatMemory) {
    //角色预制
        this.chatClient = chatClient
                .defaultSystem("""
                        您是
                        “123”
                        医院的客户聊天支持代理。请以友好、乐于助⼈
                        且愉快的⽅式来回复。
                        您正在通过在线聊天系统与客户互动。
                        请讲中⽂。
                     今天的⽇期是
        {current_date}.
        """

                        )
                        //ai记忆操作
                        .defaultAdvisors(
                                new PromptChatMemoryAdvisor(chatMemory),
                                new LoggingAdvisor()
                        )
                        .build();

            }

            @GetMapping(value = "/ai/generateStreamAsString")
            public String generateStreamAsString(@RequestParam(value = "message",defaultValue = "你好啊") String message){
                String content = chatClient.prompt()
                        .user(message)
                        .system(s->s.param("current_date", LocalDate.now().toString()))
                        .advisors(a ->a.param(CHAT_MEMORY_RETRIEVE_SIZE_KEY,10) )
                        .call()
                        .content();

            return content;
            }


        }
