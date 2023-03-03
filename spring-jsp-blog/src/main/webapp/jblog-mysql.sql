
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
                      id        VARCHAR(50),
                      blogTitle VARCHAR(200)   NOT NULL,
                      logoFile  VARCHAR(200),
                      PRIMARY KEY(id),
                      CONSTRAINT c_blog_fk FOREIGN KEY (id)
                          REFERENCES users(id)
);



CREATE TABLE category (
                          cateNo        INT,
                          id            VARCHAR(50),
                          categoryName      VARCHAR(200)   NOT NULL,
                          categoryDescription   VARCHAR(500),
                          regDate       DATE            NOT NULL,
                          PRIMARY KEY(cateNo),
                          CONSTRAINT c_category_fk FOREIGN KEY (id)
                              REFERENCES blog(id)
);


CREATE TABLE post (
                      postNo        INT,
                      cateNo        INT,
                      postTitle     VARCHAR(300)   NOT NULL,
                      postContent   VARCHAR(4000),
                      regDate       DATE            NOT NULL,
                      PRIMARY KEY(postNo),
                      CONSTRAINT c_post_fk FOREIGN KEY (cateNo)
                          REFERENCES category(cateNo)
);


CREATE TABLE comments (
                          cmtNo         INT,
                          postNo        INT,
                          cmtContent    VARCHAR(300)   NOT NULL,
                          regDate       DATE            NOT NULL,
                          PRIMARY KEY(cmtNo),
                          CONSTRAINT c_comment_fk FOREIGN KEY (postNo)
                              REFERENCES post(postNo)
);


#
# call create_sequence('INTEREST_SEQ');   -- 'INTEREST_SEQ' 라는 이름을 가진 시퀀스 생성
#
# insert into INTERESTS(interest_no, category_code, name)
# values (
#            (select nextval('INTEREST_SEQ') from dual),
#            '10000000',
#            '아웃도어/여행'
#        );