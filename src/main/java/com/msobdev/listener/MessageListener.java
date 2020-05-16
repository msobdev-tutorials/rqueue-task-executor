package com.msobdev.listener;

import com.github.sonus21.rqueue.annotation.RqueueListener;
import com.msobdev.subscription.Email;
import com.msobdev.subscription.Invoice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageListener {

    @RqueueListener(value = "${email.queue.name}")
    public void sendEmail(Email email) {
        log.info("Email {}", email);
    }

    @RqueueListener(value = "${invoice.queue.name}")
    public void sendInvoice(Invoice invoice) {
        log.info("Invoice {}", invoice);
    }
}
