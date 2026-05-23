--laputagamalamami
------------ Usuarios ------------
CREATE TABLE usuarios(
id_Usuario serial PRIMARY KEY,
nombre text NOT NULL,
pass text NOT NULL,
email text	UNIQUE NOT NULL
);

------------ CARDS CREDITO ------------ 
CREATE TABLE cardsCredito(
id_CardCredito serial PRIMARY KEY,
id_Usuario integer,
noTargeta integer NOT NULL,
banco text NOT NULL,
fecha_Vencimiento date NOT NULL,
estado text CONSTRAINT validar_Estado CHECK (estado in ('pagado','espera','vencido')),
saldo_Actual numeric CONSTRAINT validar_SaldoActual CHECK (saldo_Actual >= 0),
limite_Credito numeric,
fecha_Corte integer CONSTRAINT validar_fechaCorte CHECK (fecha_Corte BETWEEN 1 AND 31),

-------------------REATRICCIONE------------------- 
CONSTRAINT fk_CardCredito_Ususrio FOREIGN KEY (id_Usuario) REFERENCES usuarios(id_Usuario) ON DELETE CASCADE

);

------------- CARDS DEBITO -------------
CREATE TABLE cardsDebito(
id_CardDebito serial PRIMARY KEY,
id_Usuario integer, 
noTargeta integer NOT NULL,
banco text NOT NULL,
fecha_Vencimiento date NOT NULL,
saldo_Actual numeric CONSTRAINT validar_Saldo CHECK(saldo_Actual>=0),
-------------------REATRICCIONE------------------- 
CONSTRAINT fk_CardDebito_Ususrio FOREIGN KEY (id_Usuario) REFERENCES usuarios(id_Usuario) ON DELETE CASCADE

);
------------- CATEGORIAS -------------
CREATE TABLE categorias(
id_Categorias serial PRIMARY KEY,
nombreCategoria text CONSTRAINT validar_Categoria CHECK (nombreCategoria in ('Super','etc'))--ARRAY ENUM?
);
------------- MOVIMIENTOSS DEBITO -------------
CREATE TABLE movimientos_Debito(
id_Movimiento serial PRIMARY KEY,
id_CardDebito integer,
id_Categorias integer,
fecha_movieminto date NOT NULL,
concepto text NOT NULL DEFAULT ('Transferencia'),
monto numeric,
tipo_Movimiento text CONSTRAINT validad_tipoMovimiento CHECK (tipo_Movimiento in ('egreso','ingreso')),
CONSTRAINT fk_CardDebito FOREIGN KEY (id_CardDebito) REFERENCES cardsDebito(id_CardDebito) ON DELETE CASCADE,
CONSTRAINT fk_Categorias FOREIGN KEY (id_Categorias) REFERENCES categorias(id_Categorias) ON DELETE CASCADE
);
------------- MOVIENTOS CREDITO -------------
CREATE TABLE movimientos_Credito(
id_Movimiento serial PRIMARY KEY,
id_CardCredito integer,
id_Categorias integer,
fecha_movieminto date NOT NULL,
concepto text NOT NULL,
monto numeric NOT NULL,
tipo_Movimiento text CONSTRAINT validad_tipoMovimiento CHECK (tipo_Movimiento in ('retiro','compra','servicio','otro')),
CONSTRAINT fk_CardCredito FOREIGN KEY (id_CardCredito) REFERENCES cardsCredito(id_CardCredito) ON DELETE CASCADE,
CONSTRAINT fk_Categorias FOREIGN KEY (id_Categorias) REFERENCES categorias(id_Categorias) ON DELETE CASCADE
);

------------- NOTIFICACIONES -------------
CREATE TABLE notificaciones(
id_notificaciones serial PRIMARY KEY,
id_Usuario integer,
mensaje text,
fecha_programada date NOT NULL,
CONSTRAINT fk_Usuario FOREIGN KEY (id_Usuario) REFERENCES usuarios(id_Usuario) ON DELETE CASCADE
);
------------- ESTADO DE CUENTA -------------
CREATE TABLE estadDeCuesta(
id_Estado serial PRIMARY KEY,
id_CardCredito integer,
periodo date NOT NULL,
fecha_Lim date NOT NULL,
saldo_Corte numeric NOT NULL,
pago_min numeric NOT NULL,
pago_SinInteres numeric NOT NULL,
CONSTRAINT fk_CardCredito FOREIGN KEY (id_CardCredito) REFERENCES cardsCredito(id_CardCredito) ON DELETE CASCADE
);


/*CREATE TABLE presupuestos(
id_Presupuesto serial PRIMARY KEY,
id_Usuario integer,
id_Categoria integer,
montoLimite numeric CONSTRAINT validar_montoLimite CHECK (montoLimite >=0),
periodo date
);*/
