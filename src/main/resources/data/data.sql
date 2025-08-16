-- 샘플 데이터 삽입
INSERT INTO market (name, phone_number, address, open_time, market_img, market_logo, food_menu_img, info, color, created_date, last_modified_date)
VALUES ('전통시장A',
        '010-1234-5678',
        '서울특별시 강남구 어딘가 123',
        '09:00 - 22:00',
        'https://example.com/images/marketA.jpg',
        'https://example.com/images/logoA.png',
        'https://example.com/images/menuA.jpg',
        '공영주차장 이용 가능',
        '#FF5733', NOW(), NOW());

INSERT INTO market (name, phone_number, address, open_time, market_img, market_logo, food_menu_img, info, color, created_date, last_modified_date)
VALUES ('전통시장B',
        '010-9876-5432',
        '부산광역시 해운대구 어딘가 456',
        '10:00 - 20:00',
        'https://example.com/images/marketB.jpg',
        'https://example.com/images/logoB.png',
        'https://example.com/images/menuB.jpg',
        '공영주차장 없음',
        '#33C1FF', NOW(), NOW());

INSERT INTO market (name, phone_number, address, open_time, market_img, market_logo, food_menu_img, info, color, created_date, last_modified_date)
VALUES ('전통시장C',
        '010-1111-2222',
        '대구광역시 중구 어딘가 789',
        '08:00 - 21:00',
        'https://example.com/images/marketC.jpg',
        'https://example.com/images/logoC.png',
        'https://example.com/images/menuC.jpg',
        '공영주차장 이용 가능',
        '#75FF33', NOW(), NOW());


-- data.sql 파일에 추가할 예시
INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (1, '시장 A의 첫번째 TMI', '여기는 떡볶이가 맛있어요.', '사건사고', 10, 100, NOW(), NOW());