CREATE USER <conector name here> IDENTIFIED BY <password here!>;
GRANT CONNECT, RESOURCE TO expensedb;
GRANT DBA TO expensedb WITH ADMIN OPTION;

CREATE SEQUENCE u_id_sequence START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE r_id_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE userstable (
    user_id     NUMBER(10) DEFAULT u_id_sequence.NEXTVAL PRIMARY KEY,
    uname       VARCHAR(40) UNIQUE NOT NULL,
    pword       VARCHAR2(40) NOT NULL,
    firstname   VARCHAR(50) NOT NULL,
    lastname    VARCHAR(50) NOT NULL,
    usertype    NUMBER(2) DEFAULT 0 NOT NULL,   -- a switch for knowing what employees should have PERMISIONS rights, 1
    CONSTRAINT valid_usertype CHECK ( usertype BETWEEN 0 AND 1 )
);

insert into userstable(uname,pword,firstname,lastname,usertype) values('Mhaugh','pword','Michael','Haugh',1);

insert into userstable(uname,pword,firstname,lastname,usertype) values('Duser','pword','Dave','User',0);

CREATE TABLE requests (
    request_id      NUMBER(10) DEFAULT r_id_sequence.NEXTVAL PRIMARY KEY,
    u_id_fk         NUMBER(10) NOT NULL,
    request_type    NUMBER(2) NOT NULL,
    ammount         NUMBER(8) NOT NULL,
    date_submited   DATE NOT NULL,
    date_resolved   DATE,
    status          NUMBER DEFAULT 0 NOT NULL,
    descript        VARCHAR2(500) NOT NULL,
    CONSTRAINT valid_status CHECK ( status BETWEEN - 1 AND 1 ), -- -1 DENIED, 0 OPEN, 1 APPROVED
    CONSTRAINT valid_ammount CHECK ( ammount BETWEEN 10 AND 500 ),
    CONSTRAINT valid_type CHECK ( request_type BETWEEN 1 AND 4 ),
    CONSTRAINT request_fk FOREIGN KEY ( u_id_fk )
        REFERENCES userstable ( user_id )
            ON DELETE CASCADE
);



        