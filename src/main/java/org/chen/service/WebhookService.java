package org.chen.service;

import jakarta.servlet.http.HttpServletRequest;

public interface WebhookService {
    void handleMessage();
    void sendMessage(String recipientId);
    boolean validateSignature(HttpServletRequest request, String payload) throws Exception;
}
