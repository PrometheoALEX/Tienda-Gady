-- =========================================================================
-- 1. LIMPIEZA TOTAL Y REINICIO DE SECUENCIAS (Evita duplicados y desorden)
-- =========================================================================
TRUNCATE TABLE producto RESTART IDENTITY CASCADE;
TRUNCATE TABLE categoria RESTART IDENTITY CASCADE;
TRUNCATE TABLE rol RESTART IDENTITY CASCADE;

-- =========================================================================
-- 2. INSERTAR ROLES
-- =========================================================================
INSERT INTO rol (id, nombre, activo) VALUES (1, 'ROLE_ADMIN', true);
INSERT INTO rol (id, nombre, activo) VALUES (2, 'ROLE_USUARIO', true);

-- =========================================================================
-- 3. INSERTAR CATEGORÍAS (Ordenadas del 1 al 10 de forma coherente)
-- =========================================================================
INSERT INTO categoria (id, nombre, activo) VALUES (1, 'Bebidas y Refrescos', true);
INSERT INTO categoria (id, nombre, activo) VALUES (2, 'Lácteos y Derivados', true);
INSERT INTO categoria (id, nombre, activo) VALUES (3, 'Abarrotes y Granos', true);
INSERT INTO categoria (id, nombre, activo) VALUES (4, 'Snacks y Golosinas', true);
INSERT INTO categoria (id, nombre, activo) VALUES (5, 'Embutidos y Carnes', true);
INSERT INTO categoria (id, nombre, activo) VALUES (6, 'Frutas y Verduras', true);
INSERT INTO categoria (id, nombre, activo) VALUES (7, 'Limpieza del Hogar', true);
INSERT INTO categoria (id, nombre, activo) VALUES (8, 'Cuidado Personal', true);
INSERT INTO categoria (id, nombre, activo) VALUES (9, 'Panadería y Tortillas', true);
INSERT INTO categoria (id, nombre, activo) VALUES (10, 'Congelados y Postres', true);

-- =========================================================================
-- 4. INSERTAR PRODUCTOS (Totalmente coherentes con las 10 categorías)
-- =========================================================================

-- Categoría 2: Lácteos y Derivados
INSERT INTO producto (id, id_categoria, nombre, descripcion, precio, stock, imagen, descuento, activo)
VALUES (1, 2, 'Sixpack Leche Gloria', 'Seis unidades de leche evaporada Gloria', 23.70, 50, 'lecheGloria', 0, true);

INSERT INTO producto (id, id_categoria, nombre, descripcion, precio, stock, imagen, descuento, activo)
VALUES (2, 2, 'Mantequilla', 'Mantequilla en barra', 16.06, 30, 'mantequilla', 0, true);

INSERT INTO producto (id, id_categoria, nombre, descripcion, precio, stock, imagen, descuento, activo)
VALUES (13, 2, 'Yogurt Griego', 'Yogurt griego natural o saborizado', 19.90, 25, 'yogurtGriego', 0, true);

INSERT INTO producto (id, id_categoria, nombre, descripcion, precio, stock, imagen, descuento, activo)
VALUES (16, 2, 'Pack 6 Yogurt Gloria', 'Pack ahorro yogurt fresa 6x180g', 13.50, 40, 'https://metroio.vtexassets.com/arquivos/ids/392679/YOGURT-GLORIA-PACK-AGORRO-FRESA-6X180G-1-351633040.jpg?v=638180611425030000', 0, true);

-- Categoría 3: Abarrotes y Granos
INSERT INTO producto (id, id_categoria, nombre, descripcion, precio, stock, imagen, descuento, activo)
VALUES (3, 3, 'Aceite', 'Aceite vegetal botella 1L', 15.50, 40, 'aceite', 0, true);

INSERT INTO producto (id, id_categoria, nombre, descripcion, precio, stock, imagen, descuento, activo)
VALUES (4, 3, 'Arroz', 'Arroz superior bolsa 5kg', 23.90, 60, 'arroz', 0, true);

INSERT INTO producto (id, id_categoria, nombre, descripcion, precio, stock, imagen, descuento, activo)
VALUES (5, 3, 'Fideos', 'Fideos tallarín paquete 500g', 4.50, 80, 'fideos', 0, true);

INSERT INTO producto (id, id_categoria, nombre, descripcion, precio, stock, imagen, descuento, activo)
VALUES (10, 3, 'Menestras', 'Lentejas o pallares bolsa 500g', 6.00, 45, 'menestras', 0, true);

INSERT INTO producto (id, id_categoria, nombre, descripcion, precio, stock, imagen, descuento, activo)
VALUES (11, 3, 'Atún', 'Atún en aceite vegetal lata 140g', 7.50, 60, 'atun', 0, true);

INSERT INTO producto (id, id_categoria, nombre, descripcion, precio, stock, imagen, descuento, activo)
VALUES (12, 3, 'Mayonesa', 'Salsa de mayonesa sachet o pomo', 8.50, 40, 'mayonesa', 0, true);

INSERT INTO producto (id, id_categoria, nombre, descripcion, precio, stock, imagen, descuento, activo)
VALUES (17, 3, 'Ajinomen', 'Sopa instantánea sabor gallina', 5.00, 70, 'https://metroio.vtexassets.com/arquivos/ids/405155-800-auto?v=638181137638930000&width=800&height=auto&aspect=true', 0, true);

-- Categoría 4: Snacks y Golosinas
INSERT INTO producto (id, id_categoria, nombre, descripcion, precio, stock, imagen, descuento, activo)
VALUES (6, 4, 'Galletas', 'Galletas surtidas', 3.50, 100, 'galletas', 0, true);

INSERT INTO producto (id, id_categoria, nombre, descripcion, precio, stock, imagen, descuento, activo)
VALUES (18, 4, 'De Todito', 'Piqueo snack original', 8.50, 50, 'https://metroio.vtexassets.com/arquivos/ids/532508/Piqueo-Snack-De-Todito-Original-50g-1-262297.jpg?v=638539944207000000', 0, true);

-- Categoría 1: Bebidas y Refrescos
INSERT INTO producto (id, id_categoria, nombre, descripcion, precio, stock, imagen, descuento, activo)
VALUES (7, 1, 'Gaseosa', 'Gaseosa Coca Cola 1.5L', 10.00, 50, 'gaseosaCocacola', 0, true);

INSERT INTO producto (id, id_categoria, nombre, descripcion, precio, stock, imagen, descuento, activo)
VALUES (8, 1, 'Gaseosa', 'Gaseosa Guaraná 1.5L', 8.00, 50, 'gaseosaGuarana', 0, true);

INSERT INTO producto (id, id_categoria, nombre, descripcion, precio, stock, imagen, descuento, activo)
VALUES (9, 1, 'Agua', 'Agua mineral sin gas 625ml', 2.50, 90, 'agua', 0, true);

-- Categoría 10: Congelados y Postres
INSERT INTO producto (id, id_categoria, nombre, descripcion, precio, stock, imagen, descuento, activo)
VALUES (14, 10, 'Hamburguesa de Pollo', 'Hamburguesas congeladas de pollo', 17.50, 30, 'https://metroio.vtexassets.com/arquivos/ids/559589-800-auto?v=638690386224130000&width=800&height=auto&aspect=true', 0, true);

INSERT INTO producto (id, id_categoria, nombre, descripcion, precio, stock, imagen, descuento, activo)
VALUES (15, 10, 'Nuggets de Pollo', 'Nuggets crocantes de pollo', 14.99, 35, 'https://metroio.vtexassets.com/arquivos/ids/638816-800-auto?v=639102297866470000&width=800&height=auto&aspect=true', 0, true);

INSERT INTO producto (id, id_categoria, nombre, descripcion, precio, stock, imagen, descuento, activo)
VALUES (19, 10, 'Helado Sublime', 'Helado sabor chocolate Sublime', 18.00, 20, 'https://metroio.vtexassets.com/arquivos/ids/351011-800-auto?v=638180578977300000&width=800&height=auto&aspect=true', 0, true);

-- Categoría 5: Embutidos y Carnes
INSERT INTO producto (id, id_categoria, nombre, descripcion, precio, stock, imagen, descuento, activo)
VALUES (20, 5, 'Pack Jamón - Queso', 'Pack de jamón inglés y queso Edam', 7.90, 25, 'https://wongfood.vteximg.com.br/arquivos/ids/594458-1000-1000/908062-1.jpg?v=638031806989070000', 0, true);

-- =========================================================================
-- 5. SINCRONIZAR SECUENCIAS DE POSTGRESQL
-- =========================================================================
SELECT setval(pg_get_serial_sequence('rol', 'id'), 2);
SELECT setval(pg_get_serial_sequence('categoria', 'id'), 10);
SELECT setval(pg_get_serial_sequence('producto', 'id'), 20);