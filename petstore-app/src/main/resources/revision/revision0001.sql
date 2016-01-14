create table pet (
	id int AUTO_INCREMENT primary key,
	name varchar(255) not null,
    category varchar(255),
	status varchar(255) not null
);
alter table pet add constraint ck_status check (status in ('available','sold','pending'));