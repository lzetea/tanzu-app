DROP TABLE IF EXISTS hello;
DROP TABLE IF EXISTS choice;

create table choice (id bigint not null, name varchar(255), url varchar(255), primary key (id));
create table hello (id bigint not null, a_id bigint, b_id bigint, primary key (id));

alter table hello add constraint fk_hello_choice_a foreign key (a_id) references choice;
alter table hello add constraint fk_hello_choice_b foreign key (b_id) references choice;

insert into choice(id, name, url) values 
(1, 'Cat', '/images/cat.gif'),
(2, 'Dog', '/images/dog.gif'),
(3, 'Ski', '/images/ski.gif'),
(4, 'Snowboard', '/images/snowboard.gif'),
(5, 'Beach', '/images/beach.gif'),
(6, 'Mountain', '/images/mountain.gif');

insert into hello(id, a_id, b_id) values 
(1, 1, 2),
(2, 3, 4),
(3, 5, 6);