/*
Empresa        :  Comunidad Cristiana Agua Viva
Software       :  Sistema de Control de Asistencias
DBMS           :  Oracle XE
Base de Datos  :  ndr
Script         :  Crea la Base de Datos
Responsable    :  Erick Ore
Email          :  erick989@gmail.com
*/


-- =============================================
-- CARGAR DATOS DE PRUEBA
-- =============================================

-- Tabla: Aula

insert into aula values ( '01', '4 a 6 años' );
insert into aula values ( '02', '7 a 9 años' );
insert into aula values ( '03', '10 a 12 años' );

-- Tabla: Sede

insert into sede values ( '01', 'RISSO', 'LIMA' );
insert into sede values ( '02', 'AMAUTA', 'LIMA' );

-- Tabla: Escuela

insert into escuela values ( '01', 'CABRERA', '01');
insert into escuela values ( '02', 'LEGUIA', '01');

-- Tabla: Maestro

insert into maestro values ( '21234561', 'ORE', 'BUSTAMANTE', 'ERICK', 'JESUS MARIA', '4896768', 'INGENIERO', 'eore', 'oracle', '01');
insert into maestro values ( '21234562', 'MENDOZA', 'DAVILA', 'DIANA', 'JESUS MARIA', '4896768', 'MAESTRA', 'dmendoza', 'oracle', '01');
insert into maestro values ( '21234563', 'MARQUEZ', 'DAVILA', 'MERCEDES', 'SAN BORJA', '4567898', 'MEDICO', 'mmarquez', 'oracle', '02');

-- Tabla: Apoderado

INSERT INTO APODERADO VALUES ( '01234561', 'PEREZ', 'HINOJOSA', 'PEDRO', '01');
INSERT INTO APODERADO VALUES ( '01234562', 'MENDOZA', 'VILCHEZ', 'JOANNA', '02');
INSERT INTO APODERADO VALUES ( '01234563', 'RAMOS', 'RAMOS', 'JUAN', '01');

-- Tabla: Estudiante

insert into estudiante values ( '12345670', 'PEREZ', 'ARANIBAR', 'JUAN', '7', 'JESUS MARIA', '01234561');
insert into estudiante values ( '12345671', 'MORENO', 'MENDOZA', 'CARLOS', '8', 'LA MOLINA', '01234562');
insert into estudiante values ( '12345672', 'RAMOS', 'BUSTAMANTE', 'FRANCISCO', '5', 'SAN BORJA', '01234563');

-- Tabla: Curso

insert into curso values ( '01', '01', '01', '21234561', 'Verano');
insert into curso values ( '02', '01', '02', '21234562', 'Regular I');
insert into curso values ( '03', '01', '03', '21234563', 'Regular I');

-- Asistencia

insert into asistencia values ( '01', '12345670', to_date('20160314','YYYYMMDD') );
insert into asistencia values ( '01', '12345671', to_date('20160314','YYYYMMDD') );
insert into asistencia values ( '01', '12345670', to_date('20160228','YYYYMMDD') );
insert into asistencia values ( '02', '12345672', to_date('20160307','YYYYMMDD') );

--  Tabla: Contador

insert into Contador Values( 'Aula', 3, 3 );
insert into Contador Values( 'Sede', 2, 3 );
insert into Contador Values( 'Maestro', 3, 3 );
insert into Contador Values( 'Escuela', 3, 3 );
insert into Contador Values( 'Apoderado', 3, 3 );
insert into Contador Values( 'Estudiante', 3, 3 );
insert into Contador Values( 'Curso', 3, 3 );
insert into Contador Values( 'Asistencia', 4, 3 );

-- Actualizar Contadores
  
update contador
set int_contitem = (select count(*) from aula)
where vch_conttabla = 'Aula';

update contador
set int_contitem = (select count(*) from sede)
where vch_conttabla = 'Sede';

update contador
set int_contitem = (select count(*) from maestro)
where vch_conttabla = 'Maestro';

update contador
set int_contitem = (select count(*) from escuela)
where vch_conttabla = 'Escuela';

update contador
set int_contitem = (select count(*) from apoderado)
where vch_conttabla = 'Apoderado';

update contador
set int_contitem = (select count(*) from estudiante)
where vch_conttabla = 'Estudiante';

update contador
set int_contitem = (select count(*) from curso)
where vch_conttabla = 'Curso';

update contador
set int_contitem = (select count(*) from asistencia)
where vch_conttabla = 'Asistencia';

commit;
