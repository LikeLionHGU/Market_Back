package org.example.marketback.config;

import lombok.RequiredArgsConstructor;
import org.example.marketback.entity.History;
import org.example.marketback.entity.Image;
import org.example.marketback.entity.Market;
import org.example.marketback.entity.WorkingDate;
import org.example.marketback.repository.MarketRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(MarketRepository marketRepository) {
        return args -> {
            // Create sample market 1
            Market market1 = Market.builder()
                    .name("맛있는 치킨집")
                    .history("20년 전통의 치킨 전문점입니다.")
                    .address("서울시 강남구 역삼동 123-45")
                    .contact("02-1234-5678")
                    .build();

            // Add working dates
            WorkingDate wd1 = WorkingDate.builder()
                    .day(DayOfWeek.MONDAY)
                    .start(LocalTime.of(10, 0))
                    .end(LocalTime.of(22, 0))
                    .market(market1)
                    .build();
            
            WorkingDate wd2 = WorkingDate.builder()
                    .day(DayOfWeek.TUESDAY)
                    .start(LocalTime.of(10, 0))
                    .end(LocalTime.of(22, 0))
                    .market(market1)
                    .build();

            market1.getDates().addAll(Arrays.asList(wd1, wd2));

            // Add images
            Image img1 = Image.builder()
                    .fileName("chicken1.jpg")
                    .imageURL("https://example.com/images/chicken1.jpg")
                    .market(market1)
                    .build();

            market1.getImages().add(img1);

            // Add TMI (History)
            History tmi1 = History.builder()
                    .content("이 집 치킨은 특제 소스가 정말 맛있어요!")
                    .countLike(15)
                    .viewCount(120)
                    .market(market1)
                    .build();

            History tmi2 = History.builder()
                    .content("사장님이 정말 친절하시고 서비스도 좋아요.")
                    .countLike(8)
                    .viewCount(85)
                    .market(market1)
                    .build();

            market1.getHistoryList().addAll(Arrays.asList(tmi1, tmi2));

            // Create sample market 2
            Market market2 = Market.builder()
                    .name("전통 한식당")
                    .history("할머니 손맛을 그대로 재현한 한식당입니다.")
                    .address("서울시 종로구 인사동 678-90")
                    .contact("02-9876-5432")
                    .build();

            // Add TMI for market2
            History tmi3 = History.builder()
                    .content("김치찌개가 정말 시원하고 맛있어요!")
                    .countLike(25)
                    .viewCount(200)
                    .market(market2)
                    .build();

            market2.getHistoryList().add(tmi3);

            // Save markets
            marketRepository.save(market1);
            marketRepository.save(market2);
        };
    }
}