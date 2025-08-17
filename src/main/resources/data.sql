-- market 샘플 데이터 삽입
INSERT INTO market (name, phone_number, address, open_time, market_img, market_logo, food_menu_img, info, color, category, created_date, last_modified_date)
VALUES ('포항대게',
        '054-246-3739',
        '포항시 북구 칠성로 68',
        '월~일 10:50 – 21:00',
        'https://market-summer-back.s3.ap-southeast-2.amazonaws.com/imgi_4_+(2).jpg',
        'https://market-summer-back.s3.ap-southeast-2.amazonaws.com/Group+73.png',
        'https://market-summer-back.s3.ap-southeast-2.amazonaws.com/imgi_4_+(1).png',
        'null',
        '#80ABBE','Fish', NOW(), NOW());

INSERT INTO market (name, phone_number, address, open_time, market_img, market_logo, food_menu_img, info, color,category, created_date, last_modified_date)
VALUES ('대화식당',
        '054-241-5955',
        '포항시 북구 죽도시장 11길 6-7',
        '월~토 06:00 – 16:00',
        'https://market-summer-back.s3.ap-southeast-2.amazonaws.com/imgi_4_+(2).png',
        'https://market-summer-back.s3.ap-southeast-2.amazonaws.com/Group+69.png',
        'https://market-summer-back.s3.ap-southeast-2.amazonaws.com/image+146.png',
        'null',
        '#F2712E', 'Food', NOW(), NOW());

INSERT INTO market (name, phone_number, address, open_time, market_img, market_logo, food_menu_img, info, color,category, created_date, last_modified_date)
VALUES ('옥수수',
        '0502-5550-9830',
        '포항시 북구 죽도시장 11길 3',
        '월~일 08:00 – 16:00',
        'https://market-summer-back.s3.ap-southeast-2.amazonaws.com/imgi_4_+(2).png',
        'https://market-summer-back.s3.ap-southeast-2.amazonaws.com/Group+79.png',
        'https://market-summer-back.s3.ap-southeast-2.amazonaws.com/image+147.png',
        'null',
        'null', 'Sujebi', NOW(), NOW());

INSERT INTO market (name, phone_number, address, open_time, market_img, market_logo, food_menu_img, info, color,category, created_date, last_modified_date)
VALUES ('죽도어시장 공영주차장',
        'null',
        '포항시 북구 해동로 193',
        '월~일 07:00 – 22:00',
        'https://market-summer-back.s3.ap-southeast-2.amazonaws.com/imgi_4_+(2).png',
        'https://market-summer-back.s3.ap-southeast-2.amazonaws.com/Group+81.png',
        'https://market-summer-back.s3.ap-southeast-2.amazonaws.com/image+148.png',
        '30분 700원 / 1시간 1,300원',
        '#725E51', 'Parking', NOW(), NOW());

-- (추가됨) history 샘플 데이터 삽입
INSERT INTO history (id, content, created_date, last_modified_date)
VALUES (1, '포항대게는 죽도어시장 내에서 오랜 전통과 신뢰를 쌓아 온 대게 전문점인데요, 직접적인 창업 연도나 설립 이야기는 기사에 명시되진 않았지만 시장 내 대게 거리 1위 맛집으로 손꼽히는 만큼 지역 관광객들 사이에서 입소문이 빠르게 퍼졌어요.

화려한 매장의 규모나 개별 홍보 기록은 적지만, 죽도시장을 찾는 이들에게 “대게” 하면 떠오르는 대표 경험 중 하나로 자리하고 있다는 점이 고무적이에요. 특히 겨울 제철이면 수많은 방문객이 대게 거리로 몰려들고, 과메기·대게 인기로 시장 전체가 활력을 띠는데, 포항대게도 이 흐름 속에서 자연스럽게 사랑받고 있어요', NOW(), NOW());

INSERT INTO history (id, content, created_date, last_modified_date)
VALUES (2, '대화식당은 죽도시장 한복판에서 오랜 세월 현지인과 관광객들에게 사랑받아 온 백반 전문점이에요. 원래 소박한 시장 밥집으로 시작했지만, 허영만의 《식객 백반기행》에 소개되면서 입소문이 빠르게 퍼졌답니다

이 가게는 보리밥정식과 고등어구이로 특히 유명해요. 5,500~8,000원대의 정식 메뉴에 된장찌개, 여러 나물 반찬, 쌈채소, 숭늉까지 포함된 한 상 푸짐한 구성으로, 저렴한 가격에 한 끼 든든히 해결할 수 있어서 가성비 끝판왕이에요

오전 6시부터 오후 4시까지 아침, 점심 시간에 특히 북적이며, 본관과 별관으로 나뉘어 끼니 때면 웨이팅도 생길 정도로 인기가 높아요
', NOW(), NOW());

INSERT INTO history (id, content, created_date, last_modified_date)
VALUES (3, '수제비 골목 안에 자리한 옥수수는 시장 속 소박한 노포 맛집이에요. 5,000원이라는 착한 가격에 수제비, 칼국수, 칼제비(수제비+칼국수)를 즐길 수 있고, 얇고 쫄깃한 면과 맑고 깊은 멸치 육수가 인상적이에요.

블로그 후기에서는 “국물은 맑고 깔끔하면서 깊은 맛”, “얇은 수제비가 정말 쫄깃쫄깃”, “청양고추 다대기와 양념장 조합이 끝내준다”는 평이 많아요.', NOW(), NOW());

INSERT INTO history (id, content, created_date, last_modified_date)
VALUES (4, '죽도어시장 공영주차장은 2018년 중소벤처기업부 주차환경개선 사업에 선정되면서 처음 계획됐어요. 약 80억 원의 예산이 투입돼 지상 2층, 총 173면 규모로 2022년 9월에 완공됐고요. 이후 하자 보수랑 편의시설을 손본 다음, 2023년 4월에 개통식을 열고 시범 운영에 들어갔어요. 이용자 반응이 괜찮아서 같은 해 6월 7일부터는 본격적으로 유료 운영을 시작했답니다.
', NOW(), NOW());

-- tmi 샘플 데이터 삽입
INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (1, '시장 A의 첫번째 TMI', '여기는 떡볶이가 맛있어요.', '리뷰', 10, 100, NOW(), NOW());

INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (1, '시장 A의 두번째 TMI', '주차장 들어가는 길이 좀 좁아요.', '팁', 5, 50, NOW(), NOW());