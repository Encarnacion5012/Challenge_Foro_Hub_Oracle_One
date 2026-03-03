create table topicos(
id bigint not null auto_increment,
titulo varchar(50) not null,
mensaje varchar(200),
fecha_Creacion date not null,
status varchar(50) not null,
id_autor bigint not null,
id_curso bigint not null,

primary key(id),

constraint fk_topicos_usuarios_id foreign key(id_autor) references usuarios(id),
constraint fk_topicos_curso_id foreign key(id_curso) references cursos(id)
)