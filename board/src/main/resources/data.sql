# root 계정으로 접속하여 db 생성 후 특정 유저에게 권한 부여하기
CREATE DATABASE bootboard;
GRANT ALL PRIVILEGES ON bootboard.* TO rene@localhost;
FLUSH PRIVILEGES;


-- 시퀀스 만들기
CREATE TABLE SEQUENCES
(
    name    varchar(32),
    currval BIGINT UNSIGNED
)
    ENGINE = innoDB;


-- 시퀀스로 사용할 프로시저 생성
-- 'IN' 으로 시퀀스 명을 받음
-- call [프로시저명]('[시퀀스명]')
DELIMITER $$
CREATE PROCEDURE `create_sequence`(IN the_name text)
    MODIFIES SQL DATA
    DETERMINISTIC
BEGIN
    DELETE FROM SEQUENCES WHERE name = the_name;
    INSERT INTO SEQUENCES VALUES (the_name, 0);
END;


-- 생성한 시퀀스(테이블)의 다음 값을 가져오는 함수
DELIMITER $$
CREATE FUNCTION `nextval`(the_name VARCHAR(32))
    RETURNS BIGINT UNSIGNED
    MODIFIES SQL DATA
    DETERMINISTIC
BEGIN
    DECLARE ret BIGINT UNSIGNED;
    UPDATE SEQUENCES SET currval = currval + 1 WHERE name = the_name;
    SELECT currval INTO ret FROM SEQUENCES WHERE name = the_name LIMIT 1;
    RETURN ret;
END;


# 테이블 생성 예시

CREATE TABLE users
(
    userNo   INT,
    id       VARCHAR(50)  NOT NULL UNIQUE,
    userName VARCHAR(100) NOT NULL,
    password VARCHAR(50)  NOT NULL,
    joinDate DATE         NOT NULL,
    PRIMARY KEY (userNo)
);



CREATE TABLE blog
(
    userId    VARCHAR(50),
    blogTitle VARCHAR(200) NOT NULL,
    logoFile  VARCHAR(200),
    PRIMARY KEY (userId),
    CONSTRAINT c_blog_fk FOREIGN KEY (userId)
        REFERENCES users (id)
);



CREATE TABLE category
(
    categoryNo          INT,
    userId              VARCHAR(200),
    categoryName        VARCHAR(200) NOT NULL,
    categoryDescription VARCHAR(500),
    regDate             DATE         NOT NULL,
    PRIMARY KEY (categoryNo),
    CONSTRAINT c_category_fk FOREIGN KEY (userId)
        REFERENCES blog (userId)
);


CREATE TABLE article
(
    articleNo      INT,
    categoryNo     INT,
    articleTitle   VARCHAR(300) NOT NULL,
    articleContent VARCHAR(4000),
    regDate        DATE         NOT NULL,
    PRIMARY KEY (articleNo),
    CONSTRAINT c_post_fk FOREIGN KEY (categoryNo)
        REFERENCES category (categoryNo)
);



CREATE TABLE comments
(
    commentNo      INT,
    articleNo      INT,
    commentContent VARCHAR(300) NOT NULL,
    regDate        DATE         NOT NULL,
    PRIMARY KEY (commentNo),
    CONSTRAINT c_comment_fk FOREIGN KEY (articleNo)
        REFERENCES article (articleNo)
);



DROP TABLE blog;
DROP TABLE category;
DROP TABLE article;
DROP TABLE comments;

ALTER TABLE blog
    DROP FOREIGN KEY c_blog_fk;
ALTER TABLE blog
    ADD CONSTRAINT FOREIGN KEY (userId) REFERENCES users (id) ON DELETE CASCADE;

ALTER TABLE category
    DROP FOREIGN KEY c_category_fk;
ALTER TABLE category
    ADD CONSTRAINT FOREIGN KEY (userId) REFERENCES blog (userId) ON DELETE CASCADE;

ALTER TABLE article
    DROP FOREIGN KEY c_post_fk;
ALTER TABLE article
    ADD CONSTRAINT FOREIGN KEY (categoryNo) REFERENCES category (categoryNo) ON DELETE CASCADE;

ALTER TABLE comments
    DROP FOREIGN KEY c_comment_fk;
ALTER TABLE comments
    ADD CONSTRAINT FOREIGN KEY (articleNo) REFERENCES article (articleNo) ON DELETE CASCADE;



CREATE TABLE Board
(
    no       INT(11) NOT NULL AUTO_INCREMENT,
    title    VARCHAR(50),
    content  VARCHAR(100),
    hit      INT,
    reg_date DATE,
    user_no  INT(11),
    PRIMARY KEY (no)
);

DROP TABLE Board;

SELECT *
FROM Board;
SELECT LAST_INSERT_ID();


CREATE TABLE Article
(
    idx        INT                                  NOT NULL AUTO_INCREMENT,
    title      VARCHAR(100)                         NOT NULL,
    content    VARCHAR(3000)                        NOT NULL,
    writer     VARCHAR(100)                         NOT NULL,
    view_cnt   INT        DEFAULT 0                 NOT NULL,
    notice_yn  VARCHAR(1) DEFAULT 'N'               NOT NULL,
    secret_yn  VARCHAR(1) DEFAULT 'N'               NOT NULL,
    delete_yn  VARCHAR(1) DEFAULT 'N'               NOT NULL,
    createdAt  DATETIME       DEFAULT CURRENT_TIMESTAMP NOT NULL,
    modifiedAt DATE,
    deletedAt  DATE,
    user_no    INT,
    user_name  VARCHAR(100),
    user_id    VARCHAR(100),
    CONSTRAINT PK_Board PRIMARY KEY (idx)
);




ALTER TABLE ARTICLE COMMENT '게시글';
ALTER TABLE ARTICLE MODIFY COLUMN idx INT COMMENT '번호(PK)';
ALTER TABLE ARTICLE MODIFY COLUMN title VARCHAR(100) COMMENT '제목';
ALTER TABLE ARTICLE MODIFY COLUMN content VARCHAR(3000) COMMENT '내용';
ALTER TABLE ARTICLE MODIFY COLUMN writer VARCHAR(100) COMMENT '작성자';
ALTER TABLE ARTICLE MODIFY COLUMN view_cnt INT COMMENT '조회 수';
ALTER TABLE ARTICLE MODIFY COLUMN notice_yn VARCHAR(1) COMMENT '공지글 여부';
ALTER TABLE ARTICLE MODIFY COLUMN secret_yn VARCHAR(1) COMMENT '비밀글 여부';
ALTER TABLE ARTICLE MODIFY COLUMN delete_yn VARCHAR(1) COMMENT '삭제 여부';
ALTER TABLE ARTICLE MODIFY COLUMN createdAt DATE COMMENT '등록일';
ALTER TABLE ARTICLE MODIFY COLUMN modifiedAt DATE COMMENT '수정일';
ALTER TABLE ARTICLE MODIFY COLUMN deletedAt DATE COMMENT '삭제일';
ALTER TABLE ARTICLE MODIFY COLUMN user_no INT COMMENT '회원번호';
ALTER TABLE ARTICLE MODIFY COLUMN user_name VARCHAR(100) COMMENT '회원이름';
ALTER TABLE ARTICLE MODIFY COLUMN user_id VARCHAR(100) COMMENT '회원아이디';
