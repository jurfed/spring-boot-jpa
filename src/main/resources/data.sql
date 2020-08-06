insert into Address(addr_id, street) values (1, 'Pushkinskaya street 23');
insert into Address(addr_id, street) values (2, 'Kuzminskaya 12');
insert into Address(addr_id, street) values (3, 'Prospect Slavy');

insert into Person(person_id, person_name, salary, address_id) values (nextval('person_id_seq'), 'Ivan', 1000, 1);
insert into Person(person_id, person_name, salary, address_id) values (nextval('person_id_seq'), 'Petya', 600, 2);
insert into Person(person_id, person_name, salary, address_id) values (nextval('person_id_seq'), 'Vasia', 200, 3);
insert into Person(person_id, person_name, salary) values (nextval('person_id_seq'), 'Katerina Ivanova', 500);
insert into Person(person_id, person_name, salary, address_id) values (nextval('person_id_seq'), 'Mr. Smit', 500,3);

insert into Position(position_name) values ('position 1');
insert into Position(position_name) values ('position 2');


