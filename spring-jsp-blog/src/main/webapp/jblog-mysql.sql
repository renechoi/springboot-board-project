
-- 시퀀스 만들기
create TABLE SEQUENCES(
                          name varchar(32),
                          currval BIGINT unsigned
)
    engine = innoDB;


-- 시퀀스로 사용할 프로시저 생성
-- 'IN' 으로 시퀀스 명을 받음
-- call [프로시저명]('[시퀀스명]')
delimiter $$
create procedure `create_sequence` (IN the_name text)
    modifies sql data
    deterministic
begin
    delete from SEQUENCES where name = the_name;
    insert into SEQUENCES values(the_name, 0);
end;


-- 생성한 시퀀스(테이블)의 다음 값을 가져오는 함수
delimiter $$
create function `nextval` (the_name VARCHAR(32))
    RETURNS BIGINT unsigned
    MODIFIES SQL DATA
    Deterministic
begin
    declare ret BIGINT unsigned;
    update SEQUENCES set currval = currval +1 where name = the_name;
    select currval into ret from SEQUENCES where name = the_name limit 1;
    return ret;
end;


CREATE TABLE users (
                       userNo    INT,
                       id        VARCHAR(50)  NOT NULL Unique,
                       userName  VARCHAR(100) NOT NULL,
                       password  VARCHAR(50)  NOT NULL,
                       joinDate  DATE          NOT NULL,
                       PRIMARY KEY(userNo)
);








CREATE TABLE blog (
                      userId        VARCHAR(50),
                      blogTitle VARCHAR(200)   NOT NULL,
                      logoFile  VARCHAR(200),
                      PRIMARY KEY(userId),
                      CONSTRAINT c_blog_fk FOREIGN KEY (userId)
                          REFERENCES users(id)
);






CREATE TABLE category (
                          categoryNo        INT,
                          userId            VARCHAR(200) ,
                          categoryName      VARCHAR(200)   NOT NULL,
                          categoryDescription   VARCHAR(500),
                          regDate       DATE            NOT NULL,
                          PRIMARY KEY(categoryNo),
                          CONSTRAINT c_category_fk FOREIGN KEY (userId)
                              REFERENCES blog(userId)
);


CREATE TABLE article (
                      articleNo        INT,
                      categoryNo        INT,
                      articleTitle     VARCHAR(300)   NOT NULL,
                      articleContent   VARCHAR(4000),
                      regDate       DATE            NOT NULL,
                      PRIMARY KEY(articleNo),
                      CONSTRAINT c_post_fk FOREIGN KEY (categoryNo)
                          REFERENCES category(categoryNo)
);




CREATE TABLE comments (
                          commentNo         INT,
                          articleNo        INT,
                          commentContent    VARCHAR(300)   NOT NULL,
                          regDate       DATE            NOT NULL,
                          PRIMARY KEY(commentNo),
                          CONSTRAINT c_comment_fk FOREIGN KEY (articleNo)
                              REFERENCES article(articleNo)
);





drop table blog;
drop table category;
DROP TABLE article;
drop table comments;

ALTER TABLE blog DROP FOREIGN KEY c_blog_fk;
ALTER TABLE blog ADD CONSTRAINT FOREIGN KEY (userId) REFERENCES users(id) ON DELETE CASCADE;

ALTER TABLE category DROP FOREIGN KEY c_category_fk;
ALTER TABLE category ADD CONSTRAINT FOREIGN KEY (userId) REFERENCES blog(userId) ON DELETE CASCADE;

ALTER TABLE article DROP FOREIGN KEY c_post_fk;
ALTER TABLE article ADD CONSTRAINT FOREIGN KEY (categoryNo) REFERENCES category(categoryNo) ON DELETE CASCADE;

ALTER TABLE comments DROP FOREIGN KEY c_comment_fk;
ALTER TABLE comments ADD CONSTRAINT FOREIGN KEY (articleNo) REFERENCES article(articleNo) ON DELETE CASCADE;



#
# call create_sequence('INTEREST_SEQ');   -- 'INTEREST_SEQ' 라는 이름을 가진 시퀀스 생성
#
# insert into INTERESTS(interest_no, category_code, name)
# values (
#            (select nextval('INTEREST_SEQ') from dual),
#            '10000000',
#            '아웃도어/여행'
#        );