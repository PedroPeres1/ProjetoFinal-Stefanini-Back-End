drop table historico_projeto if exists;
drop table projeto if exists;
create table historico_projeto (id integer generated by default as identity, acao varchar(255), descricao varchar(20), primary key (id));
create table projeto (id integer generated by default as identity, descricao varchar(255), nome varchar(20), primary key (id));
