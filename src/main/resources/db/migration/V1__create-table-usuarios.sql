create table usuarios(
    id bigint auto_increment not null,
    nombre varchar(100) not null,
    email varchar(100) not null,
    clave varchar(255) not null,
    primary key(id)
);