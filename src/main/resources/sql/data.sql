/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  arman
 * Created: 5 jul 2025
 */
USE amvac_tienda_db;

SET SQL_SAFE_UPDATES = 0;

DELETE FROM producto;
DELETE FROM categoria;
DELETE FROM usuario;
DELETE FROM favorito;

SET SQL_SAFE_UPDATES = 1;

ALTER TABLE categoria AUTO_INCREMENT = 1;
ALTER TABLE producto AUTO_INCREMENT = 1;
ALTER TABLE usuario AUTO_INCREMENT = 1;

INSERT INTO categoria (nombre) VALUES 
('Herbicidas'), 
('Fungicidas'), 
('Insecticidas');

INSERT INTO producto (
    nombre, descripcion, precio, ruta_imagen, id_categoria,
    marca, tipo, formulacion, ingrediente_activo,
    es_novedad, es_promocion, es_recomendacion
) VALUES 
( 'Herbicida Glyphosate Pro', 'Un potente herbicida no selectivo diseñado para el control total de malezas.', 12500, 'herbicida-1.jpg', 1, 'GreenField', 'Herbicida No Selectivo', 'Concentrado Soluble', 'Glifosato 48%', false, true, true),
( 'Fungicida Cobre Max', 'Fungicida y bactericida de amplio espectro a base de oxicloruro de cobre.', 9800, 'fungicida-1.jpg', 2, 'AgriProtect', 'Fungicida de Contacto', 'Polvo Mojable', 'Cobre Metálico 50%', true, false, true),
( 'Herbicida Selectivo 2,4-D Amina', 'Herbicida hormonal sistémico para el control efectivo de malezas de hoja ancha.', 11200, 'herbicida-2.jpg', 1, 'AMVAC', 'Herbicida Sistémico', 'Sal Amina', '2,4-D', true, true, false);

INSERT INTO usuario (correo, password) VALUES ('test@amvac.com', '123');
