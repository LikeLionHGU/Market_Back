-- 기존 market 테이블 생성 구문
DROP TABLE IF EXISTS market;
CREATE TABLE market
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    name               VARCHAR(50)           NOT NULL,
    phone_number       VARCHAR(20)           NULL,
    address            VARCHAR(255)          NULL,
    open_time          VARCHAR(50)           NULL,
    market_img         VARCHAR(255)          NULL,
    market_logo        VARCHAR(255)          NULL,
    food_menu_img      VARCHAR(255)          NULL,
    info               VARCHAR(255)          NULL,
    color              VARCHAR(20)           NULL,
    created_date       datetime              NULL,
    last_modified_date datetime              NULL,
    CONSTRAINT pk_market PRIMARY KEY (id)
);

-- history 테이블 생성 구문
CREATE TABLE history
(
    id                 BIGINT NOT NULL,
    content            VARCHAR(255) NULL,
    created_date       datetime     NULL,
    last_modified_date datetime     NULL,
    CONSTRAINT pk_history PRIMARY KEY (id)
);

ALTER TABLE history ADD CONSTRAINT FK_HISTORY_ON_ID FOREIGN KEY (id) REFERENCES market (id);

-- 새로 추가할 tmi 테이블 생성 구문
CREATE TABLE tmi
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    market_id          BIGINT                NULL,
    category           VARCHAR(255)          NULL,
    content            VARCHAR(200)          NULL,
    created_date       datetime              NULL,
    email              VARCHAR(255)          NULL,
    last_modified_date datetime              NULL,
    likes              BIGINT                NULL,
    title              VARCHAR(255)          NULL,
    views              BIGINT                NULL,
    CONSTRAINT pk_tmi PRIMARY KEY (id)
);

-- market 테이블을 참조하는 외래 키(Foreign Key) 설정
ALTER TABLE tmi ADD CONSTRAINT FK_TMI_ON_MARKET FOREIGN KEY (market_id) REFERENCES market (id);