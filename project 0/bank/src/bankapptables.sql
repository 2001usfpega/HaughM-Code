CREATE USER bankdb IDENTIFIED BY p4ssw0rd;

GRANT CONNECT, RESOURCE TO bankdb;
GRANT DBA TO bankdb WITH ADMIN OPTION ;

CREATE SEQUENCE u_id_sequence START WITH 1 INCREMENT BY 1;
create sequence a_id_sequence start with 10001 increment by 1;
create sequence r_id_sequence start with 1 increment by 1;

CREATE TABLE userstable (
    user_id    number(10) DEFAULT u_id_sequence.NEXTVAL PRIMARY KEY,
    username   VARCHAR(40) UNIQUE NOT NULL,
    pword   VARCHAR2(40) NOT NULL,
    fullname   VARCHAR(200),
    usertype   VARCHAR2(10) NOT NULL,
    CONSTRAINT validtypes CHECK ( usertype IN (
        'customer',
        'admin',
        'employee'
    ) )
);
select * from userstable;
create table accounts(
    AccountId number(10) default a_id_sequence.nextval primary key
    , balence number(20) not null
);

create table accountownership (
    A_id_fk number(10),
    u_id_fk number(10),
    PRIMARY KEY (a_id_fk, u_id_fk),
    FOREIGN KEY (U_ID_FK) REFERENCES Userstable(user_id) on delete cascade,
    FOREIGN KEY (A_ID_FK) REFERENCES accounts(accountID) on delete cascade
);

--create table userrequests (
--    requestid number(20) default r_id_sequence.nextval  primary key ,
--    u_id_fk number(10),
--    requesttext varchar(1000) not null,
--    FOREIGN KEY (U_ID_FK) REFERENCES Userstable(user_id)
--
--);


insert into userstable (username, pword, fullname, usertype) values('SU','root','default admin','admin');
commit;

create view accountlookup as select userstable.username, accounts.AccountId, accounts.balence from 
accountownership inner join userstable on userstable.user_id = accountownership.u_id_fk
inner join accounts on accounts.AccountId = accountownership.a_ID_FK;

insert into userstable (username, pword, fullname, usertype) values('SU','root','default admin','admin');
desc accounts;
commit;
