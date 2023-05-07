package dev.be.moduleapi.service;

import dev.be.moduleapi.exception.CustomException;
import dev.be.modulecommon.domain.Member;
import dev.be.modulecommon.enums.CodeEnum;
import dev.be.modulecommon.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {

    @Value("${profile-name}")
    private String name;

    private final MemberRepository memberRepository;

    public String save() {
        System.out.println("name: " + name);

        if (name == "local"){
            // aaaa
        } else if (name == "beta") {
            // bbbb
            // 간단하게 이 코드를 스킵한다.
        }

        memberRepository.save(Member.builder()
                .name(Thread.currentThread().getName())
                .build());
        return "save";
    }

    public String find() {
        int size = memberRepository.findAll().size();
        System.out.println("DB size : " + size);
        return "find";
    }

    public String exception() {
        if (true) {
            throw new CustomException(CodeEnum.UNKNOWN_ERROR); // 이런식으로 custom 하게 예외를 던진다.
        }
        return "exception";
    }
}
