DROP TABLE IF EXISTS POSITIONS;
DROP TABLE IF EXISTS POSITION;
DROP TABLE IF EXISTS mail;
DROP TABLE IF EXISTS Address;
DROP TABLE IF EXISTS Person;

DROP TABLE IF EXISTS post_comment;
DROP TABLE IF EXISTS post;


DROP SEQUENCE if exists person_id_seq;

CREATE SEQUENCE person_id_seq START 1 INCREMENT 1;


create table Person(
person_id int primary key,
person_name varchar(255),
salary int
);

create table Position(
position_id serial primary key,
position_name varchar(255)
);

create table positions(
 person_id int REFERENCES Person (person_id) ON UPDATE CASCADE,
 pos_id    int REFERENCES Position (position_id) ON UPDATE CASCADE ON DELETE CASCADE,
 CONSTRAINT positions_pkey PRIMARY KEY (pos_id, person_id)
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



