package org.chen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class LotteryWebServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LotteryWebServerApplication.class, args);
    }

    /**
     * 一个简单的 WebFlux 端点，返回一个字符串
     * @return 包含 "Hello, WebFlux!" 的 Mono 对象
     */
    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("Hello, WebFlux!");
    }
}