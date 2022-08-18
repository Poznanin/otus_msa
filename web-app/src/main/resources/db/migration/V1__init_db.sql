create table "user"
(
    id         uuid    not null
        constraint user_pk
            primary key,
    name       varchar,
    first_name varchar,
    last_name  varchar,
    mail       varchar not null,
    phone      varchar
);

alter table "user"
    owner to postgres;

create unique index user_id_uindex
    on "user" (id);

create unique index user_mail_uindex
    on "user" (mail);

