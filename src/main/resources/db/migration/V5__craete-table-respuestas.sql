create table respuestas(
id bigint not null auto_increment,
mensaje varchar(200),
topico varchar(50),
fecha_Creacion date not null,
id_usuario bigint not null,
id_topico bigint not null,
solucion varchar(150),

primary key(id),

constraint fk_respuestas_usuarios_id foreign key(id_usuario) references usuarios(id),
constraint fk_respuestas_topicos_id foreign key(id_topico) references topicos(id)
);