create table if not exists public.role (
	id              bigserial not null,
    name            varchar (50) not null,
    description     varchar (100),
    constraint  role_pk primary key (id)
);