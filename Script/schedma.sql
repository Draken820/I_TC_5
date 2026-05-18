
--Usuarios
CREATE TABLE usuarios(
id_Usuario serial PRIMARY KEY,
nombre text NOT NULL,
pass text NOT NULL,
email text	UNIQUE NOT NULL,
telefono text NOT NULL
);

--CARDS
CREATE TABLE cards(
idCard serial,
id_Usuario integer,
noTargeta integer NOT NULL,
banco text,
fecha_Vencimiento date,
tipo_Card text CONSTRAINT validar_tipoCard CHECK (tipo_Card IN('credito','debito')),
saldo_Actual numeric,
limite_Credito numeric,
fecha_Corte integer CONSTRAINT validar_fechaCorte CHECK (fecha_Corte BETWEEN 1 AND 31),

-------------------REATRICCIONE------------------- 
CONSTRAINT fk_CardUsusrio FOREIGN KEY (id_Usuario) REFERENCES usuarios(id_Usuario) ON DELETE CASCADE

);


CREATE TABLE ingresos(

);


CREATE TABLE movimientos(
id_Movimiento serial,
id_Card integer,
id_Categoria integer,
fecha_movieminto date,
concepto text,
monto numeric,
tipo_Movimiento text CONSTRAINT validad_tipoMovimiento CHECK (tipo_Movimiento in ('egreso','ingreso'))
);

CREATE TABLE presupuestos(
id_Presupuesto serial PRIMARY KEY,
id_Usuario integer,
id_Categoria integer,
montoLimite numeric CONSTRAINT validar_montoLimite CHECK (montoLimite >=0),
periodo date
);

CREATE TABLE categorias(
id_Categorias serial PRIMARY KEY,
nombreCategoria text CONSTRAINT validar_Categoria CHECK (nombreCategoria in ('Super','etc'))--ARRAY
);

CREATE TABLE notificaciones(
id_notificaciones serial PRIMARY KEY,
id_Usuario integer,
mensaje text,
fecha_programada date,
leido boolean
);

CREATE TABLE estadDeCuesta(
id_Estado serial,
id_Card integer,
periodo date,
fecha_Lim date,
saldo_Corte numeric ,
pago_min numeric ,
pago_SinInteres numeric --CONSTRAINT
);

CREATE TABLE pagosProgramados(
id_Programado serial,
id_Card integer,
id_Categoria integer,
monto numeric NOT NULL,
concepto text,
frecuencia text CONSTRAINT validar_Frecuencia CHECK (frecuencia in ('mensual','quisenal','semanal')) DEFAULT 'mensual'
);




