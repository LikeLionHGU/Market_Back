-- 각 가게별 TMI 2개씩 INSERT문

-- 1. 포항대게 (market_id: 1)
INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (1, '대게의 선별법', '대게를 고를 때는 배 부분이 하얗고 단단한 것을 선택하세요. 또한 다리가 모두 붙어있고 무거운 것이 살이 많습니다.', '팁', 15, 120, NOW(), NOW());

INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (1, '포항대게 특별 서비스', '매일 오전 10시부터 신선한 대게를 직접 보고 선택할 수 있어요. 사장님이 직접 맛있는 대게 고르는 법도 알려주십니다!', '리뷰', 25, 180, NOW(), NOW());

-- 2. 대화식당 (market_id: 2)
INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (2, '보리밥 맛있게 먹는 법', '된장찌개에 보리밥을 살짝 말아서 드시면 더욱 고소하고 맛있어요. 김치와 함께 먹으면 금상첨화!', '팁', 20, 95, NOW(), NOW());

INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (2, '대화식당 웨이팅 꿀팁', '점심시간 12-1시는 웨이팅이 길어요. 오전 11시나 오후 2시쯤 방문하시면 여유롭게 식사할 수 있습니다.', '팁', 18, 75, NOW(), NOW());

-- 3. 옥수수 (market_id: 3)
INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (3, '칼제비 추천!', '수제비와 칼국수를 반반 섞은 칼제비가 이곳의 시그니처 메뉴예요. 쫄깃한 식감과 담백한 맛이 일품입니다.', '리뷰', 12, 65, NOW(), NOW());

INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (3, '청양고추 다대기 필수', '테이블에 있는 청양고추 다대기를 꼭 넣어서 드세요. 매운맛이 국물의 깊은 맛을 더욱 살려줍니다.', '팁', 8, 45, NOW(), NOW());

-- 4. 죽도어시장 공영주차장 (market_id: 4)
INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (4, '주차요금 절약 꿀팁', '30분 이내로 시장 구경을 마치면 700원으로 저렴하게 이용 가능해요. 미리 동선을 계획하고 오세요!', '팁', 22, 150, NOW(), NOW());

INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (4, '주차장 이용 후기', '지상 2층 구조로 되어있어서 찾기 쉽고, 엘리베이터도 있어서 편리해요. 173면이라 웬만하면 주차 걱정 없어요.', '리뷰', 16, 88, NOW(), NOW());

-- 5. 영광회대게센타 (market_id: 5)
INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (5, '회와 대게의 조합', '이곳에서는 신선한 회와 함께 대게도 맛볼 수 있어요. 특히 겨울철에는 대게가 제철이라 더욱 맛있습니다.', '리뷰', 14, 72, NOW(), NOW());

INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (5, '영광회대게 시장 위치', '죽도시장 안쪽에 위치해 있어서 처음 오시는 분들은 찾기 어려울 수 있어요. 입구에서 물어보시면 친절하게 알려주십니다.', '팁', 10, 58, NOW(), NOW());

-- 6. 승리회맛집 (market_id: 6)
INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (6, '회 떠주시는 솜씨', '사장님이 회 떠주시는 솜씨가 정말 좋아요. 두께도 적당하고 신선도도 최고입니다!', '리뷰', 19, 92, NOW(), NOW());

INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (6, '포장도 가능해요', '회를 포장해가실 수도 있어요. 얼음과 함께 정성스럽게 포장해주셔서 집에서도 신선하게 드실 수 있습니다.', '팁', 13, 67, NOW(), NOW());

-- 7. 동양횟집 (market_id: 7)
INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (7, '동양횟집 숨은 메뉴', '메뉴판에는 없지만 사장님께 말씀드리면 계절 생선으로 특별한 회를 만들어주세요. 운이 좋으면 희귀한 생선도!', '팁', 17, 83, NOW(), NOW());

INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (7, '매운탕도 일품', '회를 드신 후 나오는 매운탕이 정말 맛있어요. 뼈와 머리로 우린 깊은 맛의 국물이 해장에 최고입니다.', '리뷰', 21, 105, NOW(), NOW());

-- 8. 장기식당 (market_id: 8)
INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (8, '장기식당 백반 구성', '반찬 가짓수가 10가지가 넘어요. 특히 콩나물무침과 시금치나물이 정말 맛있어서 밥도둑이에요!', '리뷰', 16, 74, NOW(), NOW());

INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (8, '리필 가능한 반찬들', '밑반찬들은 무료 리필이 가능해요. 특히 김치와 된장찌개는 리필해서 배불리 드실 수 있습니다.', '팁', 12, 56, NOW(), NOW());

-- 9. 죽도포포 (market_id: 9)
INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (9, '포포의 특별한 메뉴', '일반 분식점과 다르게 해물이 들어간 특별한 떡볶이를 만들어요. 오징어와 새우가 통통하게 들어있어요!', '리뷰', 18, 89, NOW(), NOW());

INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (9, '포포 매운맛 조절', '떡볶이 매운맛을 1단계부터 5단계까지 조절할 수 있어요. 매운 음식 못드시는 분도 1단계로 드시면 맛있게 드실 수 있어요.', '팁', 14, 62, NOW(), NOW());

-- 10. 부산밀면 (market_id: 10)
INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (10, '진짜 부산 스타일', '사장님이 부산 출신이셔서 정통 부산 밀면 맛을 그대로 재현하고 계세요. 면발의 쫄깃함이 일품입니다!', '리뷰', 20, 96, NOW(), NOW());

INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (10, '여름철 별미', '특히 여름철에 시원한 물밀면이 정말 좋아요. 얼음 동동 띄운 시원한 육수가 더위를 날려버립니다.', '팁', 15, 78, NOW(), NOW());

-- 11. 밀밭분식 (market_id: 11)
INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (11, '수제비 맛집', '손으로 직접 뜯어서 만든 수제비가 쫄깃쫄깃해요. 할머니가 만들어주시던 그 맛 그대로입니다!', '리뷰', 17, 85, NOW(), NOW());

INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (11, '푸짐한 양', '한 그릇이면 성인 남성도 배부르게 먹을 수 있을 정도로 양이 푸짐해요. 가성비 정말 좋습니다!', '팁', 11, 51, NOW(), NOW());

-- 12. 가족식당 (market_id: 12)
INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (12, '가족 운영의 정성', '3대가 함께 운영하는 가족식당이에요. 할머니의 레시피를 그대로 이어받아 깊은 맛이 일품입니다.', '리뷰', 19, 91, NOW(), NOW());

INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (12, '수제비 끓이는 비법', '멸치와 다시마로 우린 진한 육수에 정성스럽게 반죽한 수제비를 넣어서 끓여줘요. 집에서 만들기 힘든 그 맛!', '팁', 13, 64, NOW(), NOW());

-- 13. 진분식 (market_id: 13)
INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (13, '진분식의 특별함', '오래된 노포의 맛을 그대로 간직하고 있어요. 특히 김밥 속재료가 정말 푸짐해서 한 줄로도 든든해요!', '리뷰', 16, 77, NOW(), NOW());

INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (13, '조미료 최소화', '화학조미료를 최소화하고 자연 재료로만 맛을 내려고 노력하세요. 그래서 더욱 깔끔하고 담백한 맛이 나요.', '팁', 14, 69, NOW(), NOW());

-- 14. 죽도시장 공영주차장 (market_id: 14)
INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (14, '또 다른 주차 공간', '죽도어시장 공영주차장과는 다른 위치에 있는 추가 주차공간이에요. 첫 번째 주차장이 만차일 때 이용하세요.', '팁', 12, 58, NOW(), NOW());

INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (14, '접근성이 좋아요', '시장 입구에서 가까워서 접근성이 좋아요. 무거운 장보기 후에도 차까지의 거리가 짧아서 편리합니다.', '리뷰', 10, 42, NOW(), NOW());

-- 15. 포원청과 (market_id: 15)
INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (15, '싱싱한 과일', '매일 새벽에 직접 도매시장에서 가져오는 신선한 과일들이에요. 특히 사과와 배가 정말 달고 맛있어요!', '리뷰', 18, 84, NOW(), NOW());

INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (15, '과일 고르는 팁', '사장님께 물어보시면 가장 맛있는 과일을 골라주세요. 당도 측정기로 직접 재서 단 과일만 골라주신답니다!', '팁', 15, 71, NOW(), NOW());

-- 16. 태성청과 (market_id: 16)
INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (16, '계절 과일 전문', '제철 과일을 전문으로 취급해요. 봄에는 딸기, 여름에는 수박과 참외, 가을에는 사과와 배를 저렴하게!', '리뷰', 16, 79, NOW(), NOW());

INSERT INTO tmi (market_id, title, content, category, likes, views, created_date, last_modified_date)
VALUES (16, '대량 구매 할인', '가족 모임이나 회사에서 대량으로 과일을 구매하시면 할인해주세요. 미리 전화로 주문하시면 더욱 저렴하게!', '팁', 13, 66, NOW(), NOW());