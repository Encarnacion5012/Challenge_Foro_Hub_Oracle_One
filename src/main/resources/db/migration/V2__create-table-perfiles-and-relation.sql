create table perfiles(
id bigint not null auto_increment,
nombre varchar(100),

primary key(id)
);

create table usuarios_perfiles(
id_usuario bigint not null,
id_perfil bigint not null,

primary key(id_usuario ,id_perfil),
constraint fk_usuarios_perfiles_usuario_id foreign key(id_usuario) references usuarios(id),
constraint fk_usuarios_perfiles_perfil_id foreign key(id_perfil) references perfiles(id)
);
