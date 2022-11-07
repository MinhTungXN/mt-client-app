create table if not exists public.product (
	id 				bigserial not null,
	category_id		bigserial not null,
	name			varchar(200) not null,
	link			varchar(255) not null,
	price			float not null,
	image			varchar(255) not null,
	description		text,
	keyword			varchar(200) not null,
	status			varchar(50) not null,
	quantity		integer not null,
	active			integer not null,
	created_at		timestamp without time zone,
	modified_at		timestamp without time zone,
	constraint 		product_pk primary key (id),
	constraint 		product_uk unique (link),
	constraint 		product_category_id_fk foreign key (category_id) references public.category (id)	
);