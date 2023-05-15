package dev.be.async.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AsyncService {

    private final EmailService emailService;

    public void asyncCall_1() { // bean 주입 테스트
        System.out.println("{asyncCall_1} :: " + Thread.currentThread().getName());
        emailService.sendMail();
        emailService.sendMailWithCustomThreadPool();
        /*
        - Spring 에서 비동기 하게 할수 있게 Proxy 를 사용해서 wrapping
        - 비동기로 동작할 수 있게 Sub Thread 에서 위임
        - emailService.sendMail();
         */
    }

    public void asyncCall_2() { // 인스턴스 메서드 테스트, 비동기 X
        System.out.println("{asyncCall_2} :: " + Thread.currentThread().getName());
        EmailService emailService2 = new EmailService();
        emailService2.sendMail();
        emailService2.sendMailWithCustomThreadPool();
    }

    public void asyncCall_3() { // 클래스 내 정의 테스트, 비동기 X
        System.out.println("{asyncCall_3} :: " + Thread.currentThread().getName());
        sendMail();
    }

    @Async
    public void sendMail() {
        System.out.println("{sendMail} :: " + Thread.currentThread().getName() );
    }
}
