-- 테이블이 존재하면 삭제
DROP TABLE IF EXISTS tmi_comment;
DROP TABLE IF EXISTS tmi;
DROP TABLE IF EXISTS history;
DROP TABLE IF EXISTS market;

-- market 테이블 생성
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
    category           VARCHAR(255)          NULL,
    created_date       datetime              NULL,
    last_modified_date datetime              NULL,
    CONSTRAINT pk_market PRIMARY KEY (id)
);

-- history 테이블 생성
CREATE TABLE history
(
    id                 BIGINT NOT NULL,
    content            TEXT         NULL, -- VARCHAR(255)에서 TEXT로 변경
    created_date       datetime     NULL,
    last_modified_date datetime     NULL,
    CONSTRAINT pk_history PRIMARY KEY (id)
);

ALTER TABLE history ADD CONSTRAINT FK_HISTORY_ON_ID FOREIGN KEY (id) REFERENCES market (id);

-- tmi 테이블 생성
CREATE TABLE tmi
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    market_id          BIGINT                NULL,
    category           VARCHAR(255)          NULL,
    content            TEXT                  NULL, -- VARCHAR(200)에서 TEXT로 변경
    created_date       datetime              NULL,
    email              VARCHAR(255)          NULL,
    last_modified_date datetime              NULL,
    likes              BIGINT                NULL,
    title              VARCHAR(255)          NULL,
    views              BIGINT                NULL,
    CONSTRAINT pk_tmi PRIMARY KEY (id)
);

ALTER TABLE tmi ADD CONSTRAINT FK_TMI_ON_MARKET FOREIGN KEY (market_id) REFERENCES market (id);

-- tmi_comment 테이블 생성
CREATE TABLE tmi_comment
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    tmi_id             BIGINT                NULL,
    content            VARCHAR(100)          NULL,
    created_date       datetime              NULL,
    last_modified_date datetime              NULL,
    CONSTRAINT pk_tmicomment PRIMARY KEY (id)
);

ALTER TABLE tmi_comment ADD CONSTRAINT FK_TMICOMMENT_ON_TMI FOREIGN KEY (tmi_id) REFERENCES tmi (id);
