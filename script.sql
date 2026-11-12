CREATE DATABASE IF NOT EXISTS db_ecommerce_SuncionFabrizio;
USE db_ecommerce_SuncionFabrizio;

CREATE TABLE IF NOT EXISTS productos (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(150) NOT NULL,
  categoria VARCHAR(100) NOT NULL,
  precio_compra DECIMAL(10,2) NOT NULL,
  precio_venta DECIMAL(10,2) NOT NULL,
  stock INT NOT NULL,
  marca VARCHAR(100),
  codigo_barras VARCHAR(50),
  fecha_ingreso DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS usuarios (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  rol VARCHAR(30) NOT NULL DEFAULT 'ROLE_USER'
);

INSERT INTO productos (nombre, categoria, precio_compra, precio_venta, stock, marca, codigo_barras, fecha_ingreso) VALUES
('Laptop Lenovo IdeaPad', 'Computo', 1800.00, 2300.00, 10, 'Lenovo', '7750001', '2026-11-01'),
('Mouse Logitech M170', 'Accesorios', 25.00, 45.00, 50, 'Logitech', '7750002', '2026-11-02'),
('Teclado Redragon', 'Accesorios', 80.00, 130.00, 30, 'Redragon', '7750003', '2026-11-03');
