INSERT INTO rol (id, nombre, activo) VALUES (1, 'ROLE_ADMIN', true) ON CONFLICT (id) DO NOTHING;
INSERT INTO rol (id, nombre, activo) VALUES (2, 'ROLE_USUARIO', true) ON CONFLICT (id) DO NOTHING;


INSERT INTO categoria (id, nombre, activo) VALUES (1, 'Bebidas y Refrescos', true) ON CONFLICT (id) DO NOTHING;
INSERT INTO categoria (id, nombre, activo) VALUES (2, 'Lácteos y Derivados', true) ON CONFLICT (id) DO NOTHING;
INSERT INTO categoria (id, nombre, activo) VALUES (3, 'Abarrotes y Granos', true) ON CONFLICT (id) DO NOTHING;
INSERT INTO categoria (id, nombre, activo) VALUES (4, 'Snacks y Golosinas', true) ON CONFLICT (id) DO NOTHING;
INSERT INTO categoria (id, nombre, activo) VALUES (5, 'Embutidos y Carnes', true) ON CONFLICT (id) DO NOTHING;
INSERT INTO categoria (id, nombre, activo) VALUES (6, 'Frutas y Verduras', true) ON CONFLICT (id) DO NOTHING;
INSERT INTO categoria (id, nombre, activo) VALUES (7, 'Limpieza del Hogar', true) ON CONFLICT (id) DO NOTHING;
INSERT INTO categoria (id, nombre, activo) VALUES (8, 'Cuidado Personal', true) ON CONFLICT (id) DO NOTHING;
INSERT INTO categoria (id, nombre, activo) VALUES (9, 'Panadería y Tortillas', true) ON CONFLICT (id) DO NOTHING;
INSERT INTO categoria (id, nombre, activo) VALUES (10, 'Congelados y Postres', true) ON CONFLICT (id) DO NOTHING;