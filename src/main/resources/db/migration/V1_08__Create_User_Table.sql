create table if not exists public.users (
    id              bigserial      not null,
    role_id         bigserial      not null,
    name            varchar (200)  not null,
    email           varchar (50)   not null,
    password        varchar (255)  not null,
    address         varchar (255)  not null,
    phone           varchar (12)   not null,
    avatar          text,
    remember_token  varchar (255),
    created_at      timestamp without time zone,
    modified_at     timestamp without time zone,
    constraint  users_pk primary key (id),
    constraint  users_uk unique (email, phone),
    constraint  users_role_fk foreign key (role_id) references public.role (id)
);