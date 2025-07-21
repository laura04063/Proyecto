/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  arman
 * Created: 5 jul 2025
 */
CREATE DATABASE IF NOT EXISTS amvac_tienda_db;

USE amvac_tienda_db;

DROP TABLE IF EXISTS producto;
DROP TABLE IF EXISTS categoria;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS favorito;

CREATE TABLE usuario (
    id_usuario BIGINT NOT NULL AUTO_INCREMENT,
    correo VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id_usuario),
    UNIQUE KEY uk_correo (correo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE categoria (
    id_categoria BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255) NULL,
    PRIMARY KEY (id_categoria)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE producto (
    id_producto BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255) NULL,
    descripcion VARCHAR(1000) NULL,
    ruta_imagen VARCHAR(255) NULL,
    precio DOUBLE NULL,
    es_novedad BIT(1) NOT NULL,
    es_promocion BIT(1) NOT NULL,
    es_recomendacion BIT(1) NOT NULL,
    marca VARCHAR(255) NULL,
    tipo VARCHAR(255) NULL,
    formulacion VARCHAR(255) NULL,
    ingrediente_activo VARCHAR(255) NULL,
    id_categoria BIGINT NULL,
    PRIMARY KEY (id_producto),
    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE favorito (
    id_favorito BIGINT NOT NULL AUTO_INCREMENT,
    id_usuario BIGINT NOT NULL,
    id_producto BIGINT NOT NULL,
    PRIMARY KEY (id_favorito),
    UNIQUE KEY uk_usuario_producto (id_usuario, id_producto),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);
