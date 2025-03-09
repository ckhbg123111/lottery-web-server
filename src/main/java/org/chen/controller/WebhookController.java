package org.chen.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

@RestController
public class WebhookController {

    @PostMapping("/webhook")
    public DeferredResult<String> handleWebhook(@RequestBody String payload,
                                                HttpServletRequest request) throws IOException {
        // 验证签名逻辑

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(payload);

        if ("message".equals(rootNode.path("type").asText())) {
            String senderId = rootNode.path("entry").path(0).path("sender").path("id").asText();
            String messageId = rootNode.path("entry").path(0).path("message").path("message_id").asText();

            // 处理消息逻辑

            // 发送回复示例
            CompletableFuture<HttpResponse<String>> response = CompletableFuture.supplyAsync(() -> {
                // 发送消息逻辑
                return null;
            });

            return new DeferredResult<>(10000L);
        }

        return new DeferredResult<>(10000L);
    }
}
