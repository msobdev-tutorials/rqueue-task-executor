package com.msobdev.controller;

import com.github.sonus21.rqueue.core.RqueueMessageSender;
import com.msobdev.subscription.Email;
import com.msobdev.subscription.Invoice;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RqueueController {
    private @NonNull RqueueMessageSender rqueueMessageSender;

    @Value("${email.queue.name}")
    private String emailQueueName;

    @Value("${invoice.queue.name}")
    private String invoiceQueueName;

    @Value("${invoice.queue.delay}")
    private Long invoiceDelay;

    @GetMapping("email")
    public String sendEmail(@RequestParam String email,
                            @RequestParam String subject,
                            @RequestParam String content) {
        log.info("Sending mail");
        rqueueMessageSender.enqueue(emailQueueName, new Email(email, subject, content));
        return "Check inbox";
    }

    @GetMapping("email")
    public String sendInvoice(@RequestParam String id,
                            @RequestParam String type) {
        log.info("Sending invoice");
        rqueueMessageSender.enqueue(emailQueueName, new Invoice(id, type));
        return "Invoice will be generated in: " + invoiceDelay;
    }
}
