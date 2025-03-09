package com.zihenzzz.interceptor;

import org.springframework.ai.chat.client.RequestResponseAdvisor;
import org.springframework.ai.chat.client.advisor.api.AdvisedRequest;

import java.util.Map;
<<<<<<< HEAD
=======

>>>>>>> master
//拦截用户输入的内容
public class LoggingAdvisor implements RequestResponseAdvisor {
    @Override
    public AdvisedRequest adviseRequest(AdvisedRequest request, Map<String, Object> adviseContext) {
<<<<<<< HEAD
        System.out.println("对方输入内容"+request);
=======
        System.out.println("对方输入内容" + request);
>>>>>>> master
        return request;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
