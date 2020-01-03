insert into Person(person_id, person_name) values (nextval('person_id_seq'), 'Ivan');
insert into Person(person_id, person_name) values (nextval('person_id_seq'),'Petya');
insert into Person(person_id, person_name) values (nextval('person_id_seq'), 'Vasia');

insert into Position(position_name) values ('position 1');
insert into Position(position_name) values ('position 2');

insert into Address(street, personId) values ('Pushkinskaya street 23',1);
