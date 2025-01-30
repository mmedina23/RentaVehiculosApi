INSERT INTO PERSONAS(ID, NOMBRE, APELLIDOS, TIPO_IDENTIFICACION, IDENTIFICACION, TELEFONO, DIRECCION, ID_USUARIO)
              VALUES(1, 'Pedro', 'Martinez', 'DNI', '1234567', '654321', 'Madrid', 9);
INSERT INTO PERSONAS(ID, NOMBRE, APELLIDOS, TIPO_IDENTIFICACION, IDENTIFICACION, TELEFONO, DIRECCION, ID_USUARIO)
              VALUES(2, 'Aurora', 'Rivera', 'DNI', '2354789', '632587', 'Madrid', 10);
INSERT INTO PERSONAS(ID, NOMBRE, APELLIDOS, TIPO_IDENTIFICACION, IDENTIFICACION, TELEFONO, DIRECCION, ID_USUARIO)
              VALUES(5, 'Andres', 'Guadia', 'DNI', '8521456', '654789', 'Madrid', 11);
INSERT INTO PERSONAS(ID, NOMBRE, APELLIDOS, TIPO_IDENTIFICACION, IDENTIFICACION, TELEFONO, DIRECCION, ID_USUARIO)
              VALUES(6, 'Jose', 'Acosta', 'DNI', '52874', '654780', 'Valencia', 12);

INSERT INTO USUARIOS(ID, USUARIO, CONTRASENA, PERFIL, LLAVE, FECHA_EXP_LLAVE)
              VALUES(9, 'PMARTINEZ', '14789', 'CLIENTE', '', null);
INSERT INTO USUARIOS(ID, USUARIO, CONTRASENA, PERFIL, LLAVE, FECHA_EXP_LLAVE)
              VALUES(10, 'ARIVERA', '12345', 'CLIENTE', '', null);
INSERT INTO USUARIOS(ID, USUARIO, CONTRASENA, PERFIL, LLAVE, FECHA_EXP_LLAVE)
              VALUES(11, 'AGUADIA', '11111', 'CLIENTE', '', null);
INSERT INTO USUARIOS(ID, USUARIO, CONTRASENA, PERFIL, LLAVE, FECHA_EXP_LLAVE)
              VALUES(12, 'JACOSTA', '96321', 'ADMIN', '', null);


INSERT INTO VEHICULOS(ID, PLAZAS, DISPONIBLE, VALOR_DIA, CAMBIOS, CARROCERIA, COLOR, MARCA, TIPO_COMBUSTIBLE)
               VALUES(20, 5, true, 200.00, 'AUTOMATICO', 'TURISMO', 'ROJO', 'MAZDA', 'DIESEL');
INSERT INTO VEHICULOS(ID, PLAZAS, DISPONIBLE, VALOR_DIA, CAMBIOS, CARROCERIA, COLOR, MARCA, TIPO_COMBUSTIBLE)
               VALUES(21, 5, true, 550.00, 'AUTOMATICO', 'SUV 4X4', 'GRIS', 'MERCEDES-BENZ', 'DIESEL');
INSERT INTO VEHICULOS(ID, PLAZAS, DISPONIBLE, VALOR_DIA, CAMBIOS, CARROCERIA, COLOR, MARCA, TIPO_COMBUSTIBLE)
               VALUES(22, 5, true, 300.00, 'AUTOMATICO', 'DEPORTIVO', 'AZUL', 'TOYOTA', 'DIESEL');
INSERT INTO VEHICULOS(ID, PLAZAS, DISPONIBLE, VALOR_DIA, CAMBIOS, CARROCERIA, COLOR, MARCA, TIPO_COMBUSTIBLE)
               VALUES(23, 5, true, 400.00, 'MANUAL', 'SUV 4X4', 'BLANCO', 'RENAULT', 'GLP');
INSERT INTO VEHICULOS(ID, PLAZAS, DISPONIBLE, VALOR_DIA, CAMBIOS, CARROCERIA, COLOR, MARCA, TIPO_COMBUSTIBLE)
               VALUES(24, 5, true, 250.00, 'AUTOMATICO', 'SUV 4X4', 'ROJO', 'MAZDA', 'DIESEL');
INSERT INTO VEHICULOS(ID, PLAZAS, DISPONIBLE, VALOR_DIA, CAMBIOS, CARROCERIA, COLOR, MARCA, TIPO_COMBUSTIBLE)
               VALUES(25, 5, true, 300.00, 'MANUAL', 'TURISMO', 'GRIS', 'TOYOTA', 'GLP');


