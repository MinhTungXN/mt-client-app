create table if not exists public.brand (
	id			bigserial not null,
	name		varchar(200) not null,
	link		varchar(255) not null,
	constraint 	brand_pk primary key (id),
	constraint 	brand_uk unique (link)
);