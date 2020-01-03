insert into Person(person_id, person_name) values (nextval('person_id_seq'), 'Ivan');
insert into Person(person_id, person_name) values (nextval('person_id_seq'),'Petya');
insert into Person(person_id, person_name) values (nextval('person_id_seq'), 'Vasia');

insert into Address(street, personId) values ('Pushkinskaya street 23',1);
