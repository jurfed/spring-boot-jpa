insert into Person(person_id, person_name, salary) values (nextval('person_id_seq'), 'Ivan', 1000);
insert into Person(person_id, person_name, salary) values (nextval('person_id_seq'),'Petya', 600);
insert into Person(person_id, person_name, salary) values (nextval('person_id_seq'), 'Vasia', 200);

insert into Position(position_name) values ('position 1');
insert into Position(position_name) values ('position 2');

insert into Address(street, personId) values ('Pushkinskaya street 23',1);
