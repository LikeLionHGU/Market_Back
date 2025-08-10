package org.example.marketback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling  // 스케줄링을 위해 (특정 시간에 자동으로 TMI + history 바꿔야하니까)
public class MarketBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketBackApplication.class, args);
    }

}
