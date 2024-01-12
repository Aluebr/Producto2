INSERT INTO tipo (descripcion, nombre) VALUES ('Hamburguesa con queso, lechuga y tomate', 'Hamburguesa');
INSERT INTO tipo (descripcion, nombre) VALUES ('Rodajas de pescado crudo con arroz', 'Sushi');
INSERT INTO tipo (descripcion, nombre) VALUES ('Plato de carne, vegetales y pan de pita', 'Kebab');
INSERT INTO tipo (descripcion, nombre) VALUES ('Base de masa con tomate y queso', 'Pizza');
INSERT INTO tipo (descripcion, nombre) VALUES ('Comida asiatica ', 'Comida china');
INSERT INTO tipo (descripcion, nombre) VALUES ('Tortilla enrollada', 'Burrito');
INSERT INTO tipo (descripcion, nombre) VALUES ('Plato de pasta', 'Spaghetti con albóndigas');

INSERT INTO producto (kcal, tipo_id_tipo, descripcion, nombre) VALUES (500, 1, 'Hamburguesa con queso, lechuga y tomate', 'Hamburguesa Clásica');
INSERT INTO producto (kcal, tipo_id_tipo, descripcion, nombre) VALUES (600, 1, 'Hamburguesa con tomate y bacon', 'Hamburguesa con Bacon');
INSERT INTO producto (kcal, tipo_id_tipo, descripcion, nombre) VALUES (700, 1, 'Hamburguesa con bacon y huevo', 'Hamburguesa con Bacon y Huevo');
INSERT INTO producto (kcal, tipo_id_tipo, descripcion, nombre) VALUES (800, 3, 'Kebab mixto con patatas', 'Kebab Mixto');

INSERT INTO menu (precio,nombre) VALUES (9,'Kebab Plato + Patatas');
INSERT INTO menu (precio,nombre) VALUES (5.5,'Durum + Bebida');
INSERT INTO menu (precio,nombre) VALUES (10,'Hamburgesa con queso + Bebida');

INSERT INTO menu_has_producto (menu_id_menu, producto_id_producto) VALUES (1, 4);
INSERT INTO menu_has_producto (menu_id_menu, producto_id_producto) VALUES (1, 3);
