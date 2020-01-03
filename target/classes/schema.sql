DROP TABLE IF EXISTS mail;
DROP TABLE IF EXISTS Address;
DROP TABLE IF EXISTS Person;

DROP TABLE IF EXISTS post_comment;
DROP TABLE IF EXISTS post;


DROP SEQUENCE if exists person_id_seq;
DROP SEQUENCE if exists addr_id_seq;
DROP SEQUENCE if exists post_comment_id;
DROP SEQUENCE if exists mail_seq_id;

CREATE SEQUENCE person_id_seq START 1 INCREMENT 1;
CREATE SEQUENCE addr_id_seq START 1 INCREMENT 1;
CREATE SEQUENCE post_comment_id START 1 INCREMENT 1;
CREATE SEQUENCE mail_seq_id START 1 INCREMENT 1;


create table Person(
person_id int primary key,
person_name varchar(255)
);


create table Address(
    addr_id int primary key,
    street varchar(255),
    personId int references Person(person_id) not null
);

create table post(
    id integer primary key,
    title varchar(255)
);

create table post_comment(
    id integer primary key,
    review varchar(255),
    post_Id int references post(id) ON DELETE CASCADE null
);

create table mail(
    mail_id integer primary key,
    mail_name varchar(255),
    mail_person int references Person(person_id) null
);


