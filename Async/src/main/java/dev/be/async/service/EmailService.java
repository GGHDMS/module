package dev.be.async.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    @Async("defaultTaskExecutor")
    public void sendMail() {
        System.out.println("{sendMail} :: " + Thread.currentThread().getName() );
    }

    @Async("massagingTaskExecutor")
    public void sendMailWithCustomThreadPool() {
        System.out.println("{massagingTaskExecutor} :: " + Thread.currentThread().getName() );
    }
}
