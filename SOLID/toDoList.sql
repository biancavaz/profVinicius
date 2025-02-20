CREATE DATABASE db_to_do_list;

USE db_to_do_list;

CREATE TABLE tb_users (
	id int auto_increment primary key,
    nome varchar(50) not null,
    email varchar(100) not null,
    senha varchar(50) not null
);

CREATE TABLE tb_tarefas (
	id int auto_increment primary key,
    titulo varchar(100) not null,
    descricao varchar(150) not null,
    status varchar(50) not null,
    prioridade varchar(50) not null,
    id_users int,
    foreign key (id_users) references tb_users (id)
);