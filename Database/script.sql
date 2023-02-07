CREATE TABLE proveedores (
    id_proveedor int NOT NULL AUTO_INCREMENT,
    nombre varchar(30),
    num_identificacion varchar(15) NOT NULL,
    direccion varchar(50),
    email varchar(50),
    num_vehic_disponibles int,
    PRIMARY KEY (id_proveedor)
);   

CREATE TABLE vehiculos (
    id_vehiculo int NOT null AUTO_INCREMENT,
    placa varchar(10) NOT NULL,
    marca varchar(15),
    modelo varchar(15),
    id_proveedor int not null,
    estado varchar(15),
    PRIMARY KEY (id_vehiculo),
    FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor)
);


CREATE TABLE conductores (
    id_conductor int NOT null AUTO_INCREMENT,
    num_identificacion varchar(15) NOT NULL,
    nombre varchar(30),
    id_proveedor int,
    PRIMARY KEY (id_conductor),
    FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor)
);


CREATE TABLE conductores_vehiculos (
    conductor_id int NOT NULL,
    vehiculo_id int NOT NULL,
    proveedor_id int not null,
    PRIMARY KEY (conductor_id, vehiculo_id),
    FOREIGN KEY (conductor_id) REFERENCES conductores(id_conductor),
    FOREIGN KEY (vehiculo_id) REFERENCES vehiculos(id_vehiculo),
    FOREIGN KEY (proveedor_id) REFERENCES proveedores(id_proveedor)
);


CREATE TRIGGER tr_vehiculos_disponibles_insert
AFTER
INSERT 
  ON vehiculos FOR EACH ROW begin
update
  proveedores
set
  num_vehic_disponibles = (
    select
      COUNT(id_vehiculo)
    from
      vehiculos
    where
      estado = 'DISPONIBLE'
      and id_proveedor = new.id_proveedor);
     end;
     
    
CREATE TRIGGER tr_vehiculos_disponibles_update
AFTER
UPDATE  
  ON vehiculos FOR EACH ROW begin
update
  proveedores
set
  num_vehic_disponibles = (
    select
      COUNT(id_vehiculo)
    from
      vehiculos
    where
      estado = 'DISPONIBLE'
      and id_proveedor = new.id_proveedor);
     end;
    
  