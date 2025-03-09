package com.zihenzzz.interceptor;

import org.springframework.ai.chat.client.RequestResponseAdvisor;
import org.springframework.ai.chat.client.advisor.api.AdvisedRequest;

import java.util.Map;

//拦截用户输入的内容
public class LoggingAdvisor implements RequestResponseAdvisor {
    @Override
    public AdvisedRequest adviseRequest(AdvisedRequest request, Map<String, Object> adviseContext) {
        System.out.println("对方输入内容" + request);
        return request;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
