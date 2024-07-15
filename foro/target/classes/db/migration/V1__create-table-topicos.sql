CREATE TABLE topicos(
    id bigint not null auto_increment,
    mensaje varchar(255) not null unique,
    titulo varchar(100) not null unique,
    fecha_creacion DATETIME not null,
    curso varchar(50) not null,
    nombre_usuario varchar (40) not null,
    correo_electronico varchar(30) not null,
    contrasenia varchar(20) not null,
    primary key(id)
);


