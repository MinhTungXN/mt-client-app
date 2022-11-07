create table if not exists public.category (
	id			bigserial not null,
	brand_id	bigserial not null,
	name		varchar(200) not null,
	link		varchar(255) not null,
	type		varchar(45) not null,
	created_at	timestamp without time zone,
	modified_at timestamp without time zone,
	constraint 	category_pk primary key (id),
	constraint 	category_uk unique (link),
	constraint 	category_brand_id_fk foreign key (brand_id) references public.brand (id)
);