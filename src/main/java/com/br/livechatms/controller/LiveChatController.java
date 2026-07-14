package com.br.livechatms.controller;

import com.br.livechatms.domain.ChatInput;
import com.br.livechatms.domain.ChatOutput;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LiveChatController {

    @MessageMapping("/new-message")
    @SendTo("/topics/livechat")
    public ChatOutput newMssage(ChatInput input){
        return new ChatOutput(HtmlUtils.htmlEscape(input.user() + ": " + input.message()));
    }

}
