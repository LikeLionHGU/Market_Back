-- market 샘플 데이터 삽입
INSERT INTO market (name, phone_number, address, open_time, market_img, market_logo, food_menu_img, info, color, category, created_date, last_modified_date)
VALUES ('전통시장A',
        '010-1234-5678',
        '서울특별시 강남구 어딘가 123',
        '09:00 - 22:00',
        'https://example.com/images/marketA.jpg',
        'https://example.com/images/logoA.png',
        'https://example.com/images/menuA.jpg',
        '공영주차장 이용 가능',
        '#FF5733','FOOD_BEVERAGE', NOW(), NOW());

INSERT INTO market (name, phone_number, address, open_time, market_img, market_logo, food_menu_img, info, color,category, created_date, last_modified_date)
VALUES ('전통시장B',
        '010-9876-5432',
        '부산광역시 해운대구 어딘가 456',
        '10:00 - 20:00',
        'https://example.com/images/marketB.jpg',
        'https://example.com/images/logoB.png',
        'https://example.com/images/menuB.jpg',
        '공영주차장 없음',
        '#33C1FF', 'FASHION_ACCESSORIES', NOW(), NOW());

INSERT INTO market (name, phone_number, address, open_time, market_img, market_logo, food_menu_img, info, color,category, created_date, last_modified_date)
VALUES ('전통시장C',
        '010-1111-2222',
        '대구광역시 중구 어딘가 789',
        '08:00 - 21:00',
        'https://example.com/images/marketC.jpg',
        'https://example.com/images/logoC.png',
        'https://example.com/images/menuC.jpg',
        '공영주차장 이용 가능',
        '#75FF33', 'ETC', NOW(), NOW());

-- (추가됨) history 샘플 데이터 삽입
INSERT INTO history (id, content, created_date, last_modified_date)
VALUES (1, '전통시장A는 1980년부터 시작된 유서 깊은 시장입니다.', NOW(), NOW());

-- tmi 샘플 데이터 삽입
INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (1, '시장 A의 첫번째 TMI', '여기는 떡볶이가 맛있어요.', '리뷰', 10, 100, NOW(), NOW());

INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (1, '시장 A의 두번째 TMI', '주차장 들어가는 길이 좀 좁아요.', '팁', 5, 50, NOW(), NOW());