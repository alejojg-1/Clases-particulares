create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(45) not null,
 identificacion int(45) not null,
 primary key (id)
);

create table curso (
 id int(11) not null auto_increment,
 nombre varchar(45) not null,
 tipo varchar(45) not null,
 precio double not null,
 descripcion varchar(250),
 primary key (id)
);

create table agenda (
 id int(11) not null auto_increment,
 usuario_id int not null,
 curso_id int not null,
 fecha_inicio DATE not null,
 fecha_fin DATE not null,
 costo_total double not null,
 primary key (id)
);


