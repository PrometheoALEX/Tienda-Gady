INSERT INTO rol (id, nombre, activo) VALUES (1, 'ROLE_ADMIN', true) ON CONFLICT (id) DO NOTHING;
INSERT INTO rol (id, nombre, activo) VALUES (2, 'ROLE_USUARIO', true) ON CONFLICT (id) DO NOTHING;