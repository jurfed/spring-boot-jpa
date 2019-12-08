DROP TABLE IF EXISTS Email;
DROP TABLE IF EXISTS Person;
DROP SEQUENCE if exists person_id_seq;
DROP SEQUENCE if exists email_id_seq;

CREATE SEQUENCE person_id_seq START 1 INCREMENT 1;
CREATE SEQUENCE email_id_seq START 1 INCREMENT 1;

create table Person(
person_id serial primary key,
person_name varchar(255)
);

create table Email(
    emailId serial primary key,
    address varchar(255),
    personId int references Person(person_id) not null
);

