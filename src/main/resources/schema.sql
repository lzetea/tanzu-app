create table choice (id bigint not null, name varchar(255), url varchar(255), primary key (id));
create table hello (id bigint not null, a_id bigint, b_id bigint, primary key (id));

alter table hello add constraint fk_hello_choice_a foreign key (a_id) references choice;
alter table hello add constraint fk_hello_choice_b foreign key (b_id) references choice;