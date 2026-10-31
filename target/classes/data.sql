-- =========================================================================
-- 1. INSERTAR ROLES BÁSICOS
-- =========================================================================
INSERT INTO rol (id, nombre, activo) VALUES (1, 'ROLE_ADMIN', true) ON CONFLICT (id) DO NOTHING;
INSERT INTO rol (id, nombre, activo) VALUES (2, 'ROLE_USUARIO', true) ON CONFLICT (id) DO NOTHING;

-- =========================================================================
-- 2. INSERTAR USUARIO ADMINISTRADOR INICIAL
-- =========================================================================
INSERT INTO usuario (id, id_rol, nombre, apellidos, dni, celular, correo, contrasena, activo, fecha_registro)
VALUES (1, 1, 'Alexis', 'Izquierdo', '12345678', '987654321', 'alexis@gmail.com', '123456', true, CURRENT_TIMESTAMP)
    ON CONFLICT (id) DO NOTHING;

-- =========================================================================
-- 3. INSERTAR CATEGORÍAS TECNOLÓGICAS
-- =========================================================================
INSERT INTO categoria (id, nombre, activo) VALUES (1, 'Laptops', true) ON CONFLICT (id) DO NOTHING;
INSERT INTO categoria (id, nombre, activo) VALUES (2, 'Almacenamiento', true) ON CONFLICT (id) DO NOTHING;
INSERT INTO categoria (id, nombre, activo) VALUES (3, 'Componentes', true) ON CONFLICT (id) DO NOTHING;
INSERT INTO categoria (id, nombre, activo) VALUES (4, 'Memorias RAM', true) ON CONFLICT (id) DO NOTHING;
INSERT INTO categoria (id, nombre, activo) VALUES (5, 'Monitores', true) ON CONFLICT (id) DO NOTHING;
INSERT INTO categoria (id, nombre, activo) VALUES (6, 'Periféricos', true) ON CONFLICT (id) DO NOTHING;
INSERT INTO categoria (id, nombre, activo) VALUES (7, 'Refrigeración', true) ON CONFLICT (id) DO NOTHING;

-- =========================================================================
-- 4. PRODUCTOS DE PRUEBA LIGEROS (Para que el deploy pase al instante)
-- =========================================================================
INSERT INTO producto (id, id_categoria, nombre, descripcion, precio, stock, imagen, descuento, activo) VALUES
                                                                                                           (1, 1, 'Laptop Lenovo IdeaPad Slim 3', 'Equipo ultradelgado ideal para estudio y productividad diaria', 1899.90, 25, 'https://images.unsplash.com/photo-1496181133206-80ce9b88a853?auto=format&fit=crop&w=640&q=80', 0, true),
                                                                                                           (2, 1, 'Laptop ASUS Vivobook 15', 'Rendimiento equilibrado con pantalla amplia de alta definición', 2299.00, 25, 'https://images.unsplash.com/photo-1517336714731-489689fd1ca8?auto=format&fit=crop&w=640&q=80', 0, true),
                                                                                                           (9, 2, 'SSD NVMe Samsung 990 EVO 1 TB', 'Velocidades de lectura ultra rápidas con interfaz PCIe 4.0', 389.90, 30, 'https://images.unsplash.com/photo-1597872200969-2b65d56bd16b?auto=format&fit=crop&w=640&q=80', 0, true),
                                                                                                           (10, 2, 'SSD Kingston NV2 500 GB', 'Actualización eficiente de arranque y transferencia de archivos', 189.00, 40, 'https://images.unsplash.com/photo-1531492746076-161ca9bcad58?auto=format&fit=crop&w=640&q=80', 0, true),
                                                                                                           (17, 3, 'Procesador AMD Ryzen 5 5600', '6 núcleos y 12 hilos con arquitectura eficiente AM4', 599.90, 30, 'https://images.unsplash.com/photo-1518770660439-4636190af475?auto=format&fit=crop&w=640&q=80', 0, true),
                                                                                                           (27, 4, 'Memoria RAM DDR4 Corsair Vengeance 16 GB', 'Disipador de aluminio de perfil bajo con estabilidad probada', 159.90, 40, 'https://images.unsplash.com/photo-1541029071515-84cc54f84dc5?auto=format&fit=crop&w=640&q=80', 0, true),
                                                                                                           (31, 5, 'Monitor LG UltraGear 24 pulgadas 144 Hz', 'Panel IPS rápido con respuesta de 1ms para eSports', 799.90, 20, 'https://images.unsplash.com/photo-1527443224154-c4a3942d3acf?auto=format&fit=crop&w=640&q=80', 0, true),
                                                                                                           (36, 6, 'Teclado mecánico Logitech G413', 'Switches táctiles Romer-G con estructura de aluminio cepillado', 299.90, 30, 'https://images.unsplash.com/photo-1587829741301-dc798b83add3?auto=format&fit=crop&w=640&q=80', 0, true),
                                                                                                           (46, 7, 'Base ventiladora para laptop de 15.6 pulgadas', 'Malla metálica de disipación con altura regulable', 99.90, 35, 'https://images.unsplash.com/photo-1593642634367-d91a135587b5?auto=format&fit=crop&w=640&q=80', 0, true)
    ON CONFLICT (id) DO NOTHING;