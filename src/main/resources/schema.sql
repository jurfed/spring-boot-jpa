DROP TABLE IF EXISTS mail;
DROP TABLE IF EXISTS Address;
DROP TABLE IF EXISTS Person;

DROP TABLE IF EXISTS post_comment;
DROP TABLE IF EXISTS post;


DROP SEQUENCE if exists person_id_seq;

CREATE SEQUENCE person_id_seq START 1 INCREMENT 1;


create table Person(
person_id int primary key,
person_name varchar(255)
);


create table Address(
    addr_id serial primary key,
    street varchar(255),
    personId int references Person(person_id) not null
);


create table mail(
    mail_id serial primary key,
    mail_name varchar(255),
    mail_person int references Person(person_id)  ON DELETE CASCADE null
);


