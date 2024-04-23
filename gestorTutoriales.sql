DROP DATABASE IF EXISTS tutoriales;
CREATE DATABASE tutoriales CHARACTER SET utf8mb4;
USE tutoriales;

CREATE TABLE categoria (
  idCategoria INT (10) PRIMARY KEY AUTO_INCREMENT NOT NULL,
  nombreCat VARCHAR (50)
);

INSERT INTO categoria(nombreCat) VALUES
('Logica de programacion'),
('Flutter'),
('Node.js');           
      
CREATE TABLE tutorial (
  idTutorial INT (10) PRIMARY KEY AUTO_INCREMENT NOT NULL,
  nombre VARCHAR (200) NOT NULL,
  prioridad INT (2) NOT NULL,
  url TEXT NOT NULL,
  estado VARCHAR(50),
  categori VARCHAR (50)
);

/* se insertan datos en la tabla tutorial */
INSERT INTO tutorial (nombre, prioridad, url, estado, categori) 
VALUES 
('curso desde cero', 5, 'https://programar', 'revisado', 'Logica de programacion'),
('primera calculadora', 5, 'https://calculadora', 'revisado', 'Logica de programacion');


DELIMITER //
CREATE PROCEDURE agregarTutorial (
  IN tut_idTutorial INT,
  IN tut_nombre VARCHAR(200),
  IN tut_prioridad INT, 
  IN tut_url TEXT,
  IN tut_estado VARCHAR(50),
  IN tut_categori VARCHAR(50)
)
BEGIN
  INSERT INTO tutorial (idTutorial, nombre, prioridad, url, estado, categori)
  VALUES (tut_idTutorial, tut_nombre, tut_prioridad, tut_url, tut_estado, tut_categori);
END //

CREATE PROCEDURE eliminarTutorial(
    IN tut_id INT(10)
)
BEGIN
    DELETE FROM tutorial WHERE idTutorial = tut_id;
END //

-- Restaura el delimitador predeterminado
DELIMITER ;