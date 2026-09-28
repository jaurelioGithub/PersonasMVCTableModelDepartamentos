
CREATE DATABASE Personas;

use Personas;

create table EstadoCivil (
       codigo  varchar(10)  not null,
       descripcion varchar(30) not null,  
       Primary Key (codigo)         
     );

create table Departamento (
       codigo  varchar(10)  not null,
       nombre varchar(30) not null,  
       Primary Key (codigo)         
     );
	 
create table Persona (
    id varchar(10)  not null,
    nombre varchar(30) not null,
    sexo char (1) not null,
    estadoCivil varchar(10) not null,
	departamento varchar(10) not null,
    pasatiempoMusica boolean,
    pasatiempoCine boolean,
    pasatiempoDeporte boolean,
    pasatiempoVideoJuegos boolean,
    pasatiempoCocina boolean,
    pasatiempoOtro boolean,
    pasatiempoOtroTexto varchar(30),    
    Primary Key (id)
);

ALTER TABLE Persona ADD Foreign Key (estadoCivil) REFERENCES EstadoCivil(codigo);
ALTER TABLE Persona ADD Foreign Key (departamento) REFERENCES Departamento(codigo);

insert into EstadoCivil (codigo ,descripcion) values('001','Soltero');
insert into EstadoCivil (codigo ,descripcion) values('002','Casado');
insert into EstadoCivil (codigo ,descripcion) values('003','Viudo');
insert into EstadoCivil (codigo ,descripcion) values('004','Divorciado');
insert into EstadoCivil (codigo ,descripcion) values('005','Union Libre');

insert into Departamento (codigo ,nombre) values('001','Recursos Humanos');
insert into Departamento (codigo ,nombre) values('002','Tecnología');
insert into Departamento (codigo ,nombre) values('003','Finanzas');
insert into Departamento (codigo ,nombre) values('004','Marketing');

insert into Persona (id, nombre, sexo, estadoCivil, departamento, pasatiempoMusica, pasatiempoCine, pasatiempoDeporte, pasatiempoVideoJuegos, pasatiempoCocina, pasatiempoOtro,pasatiempoOtroTexto) values('111','Juan','M','001','001',false, true, false, true, false, true, 'Trompo');

insert into Persona (id, nombre, sexo, estadoCivil, departamento, pasatiempoMusica, pasatiempoCine, pasatiempoDeporte, pasatiempoVideoJuegos, pasatiempoCocina, pasatiempoOtro,pasatiempoOtroTexto) values('222','Maria','F','002','001', true, false, true, false, false,false, '');
