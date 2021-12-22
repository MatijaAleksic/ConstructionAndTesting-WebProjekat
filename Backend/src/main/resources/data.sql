INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('markoMarkovic@maildrop.cc','MarkoMarkovic12', false, '2012-12-12', 'Pera', 'Peric', 20000);
INSERT INTO _admins (user) VALUES (1);

INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('peraperic@maildrop.cc','peraperic', false, '2012-12-11', 'Marko', 'Peric', 20000);
INSERT INTO _admins (user) VALUES (2);

INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('milanmilanovic@maildrop.cc','milanmilanovic', false, '2012-12-12', 'Pera', 'Peric', 20000);
INSERT INTO _admins (user) VALUES (3);

INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('savosavic@maildrop.cc','MarkoMarkovic12', false, '2012-12-12', 'Pera' ,'Peric', 20000);
INSERT INTO _staff (user) VALUES (4);
INSERT INTO _barmen (staff) VALUES (4);


INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('pavlepavlovic@maildrop.cc','peraperic', false, '2012-12-12', 'Pera', 'Peric', 20000);
INSERT INTO _staff (user) VALUES (5);
INSERT INTO _barmen (staff) VALUES (5);

INSERT INTO _users(username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('luka@maildrop.cc','luka', false, '2012-12-12', 'Pera', 'Peric', 20000);
INSERT INTO _staff (user) VALUES (6);
INSERT INTO _cooks (staff) VALUES (6);

INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('petarpetrovic@maildrop.cc','petarpetrovic', false, '2012-12-12', 'Pera', 'Peric', 20000);
INSERT INTO _staff (user) VALUES (7);
INSERT INTO _cooks (staff) VALUES (7);



INSERT INTO _users(username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('jovan@maildrop.cc','jovan', false, '2012-12-12', 'Pera', 'Peric', 20000);
INSERT INTO _staff (user) VALUES (8);
INSERT INTO _cooks (staff) VALUES (8);
INSERT INTO _main_cooks (cook) VALUES (8);

INSERT INTO _users(username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('miladin@maildrop.cc','miladin', false, '2012-12-12', 'Pera', 'Peric', 20000);
INSERT INTO _staff (user) VALUES (9);
INSERT INTO _cooks (staff) VALUES (9);
INSERT INTO _main_cooks (cook) VALUES (9);



INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('nikolanikolic@maildrop.cc','nikolanikolic', false, '2012-12-12', 'Pera', 'Peric', 20000);
INSERT INTO _managers (user) VALUES (10);

INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('slavko@maildrop.cc','slavko', false, '2012-12-12', 'Pera', 'Peric', 20000);
INSERT INTO _managers (user) VALUES (11);


INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('ognjen@maildrop.cc','ognjen', false, '2012-12-12', 'Pera', 'Peric', 20000);
INSERT INTO _waiters (user) VALUES (12);

INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('todor@maildrop.cc','todor', false, '2012-12-12', 'Pera', 'eric', 20000);
INSERT INTO _waiters (user) VALUES (13);



INSERT INTO _items (description, is_deleted, name, item_status,price, priority, subcategory) VALUES ('Deskripcija1', false, 'Pice1', 'active',100, 1, 'subcategory1');
INSERT INTO _drinks (item) VALUES (1);
INSERT INTO _items (description, is_deleted, name, item_status,price, priority, subcategory) VALUES ('Deskripcija2', false, 'Pice2', 'active',100, 1, 'subcategory2');
INSERT INTO _drinks (item) VALUES (2);
INSERT INTO _items (description, is_deleted, name, item_status,price, priority, subcategory) VALUES ('Deskripcija3', false, 'Pice3', 'active',100, 1, 'subcategory3');
INSERT INTO _drinks (item) VALUES (3);

INSERT INTO _items (description, is_deleted, name, item_status, price, priority, subcategory) VALUES ('Deskripcija4', false, 'Jelo1', 'active', 100, 1, 'subcategory4');
INSERT INTO _foods (item) VALUES (4);
INSERT INTO _items (description, is_deleted, name, item_status,price, priority, subcategory) VALUES ('Deskripcija5', false, 'Jelo2', 'active',100, 1, 'subcategory5');
INSERT INTO _foods (item) VALUES (5);
INSERT INTO _items (description, is_deleted, name, item_status,price, priority, subcategory) VALUES ('Deskripcija6', false, 'Jelo3', 'active',100, 1, 'subcategory6');
INSERT INTO _foods (item) VALUES (6);

INSERT INTO _tables (table_number, floor, positionX, positionY, state, is_deleted) VALUES (1, 1, 1.0, 2.0, 'free', false);
INSERT INTO _tables (table_number, floor, positionX, positionY, state, is_deleted) VALUES (2, 4, 30.0, 2.0, 'free', false);

INSERT INTO _orders (price, waiter_id, restourant_table_id,date_time) VALUES (100.0, 12, 1, '2012-12-12');
INSERT INTO _orders (price, waiter_id, restourant_table_id, date_time) VALUES (200.0, 13, 2, '2012-11-11');

INSERT INTO _ordered_items (state, number, note,  date_time, item_id, staff_id, price, _id) VALUES ('ordered', 2, 'alergija na kikiriki', '2012-12-12', 1, 5, 50, 1);
INSERT INTO _ordered_items (state, number, note,  date_time, item_id, staff_id, price, _id) VALUES ('ordered', 2, 'alergija na nesto', '2012-11-11', 4, 6, 100, 2);

INSERT INTO _notifications (id,date_time, text, user_type) VALUES (1, '2012-12-12 11:11:11', 'Notifikacija1', 'admin');
INSERT INTO _notifications (id,date_time, text, user_type) VALUES (2, '2012-10-12 05:05:05', 'Notifikacija2', 'admin');
INSERT INTO _notifications (id,date_time, text, user_type) VALUES (3, '2012-11-09 09:09:09', 'Notifikacija3', 'admin');

INSERT INTO _notifications (id,date_time, text, user_type) VALUES (4, '2012-12-12 11:11:11', 'Notifikacija4', 'barman');
INSERT INTO _notifications (id,date_time, text, user_type) VALUES (5, '2012-12-12 11:11:11', 'Notifikacija5', 'barman');

INSERT INTO _notifications (id,date_time, text, user_type) VALUES (6, '2012-12-12 11:11:11', 'Notifikacija6', 'cook');
INSERT INTO _notifications (id,date_time, text, user_type) VALUES (7, '2012-12-12 11:11:11', 'Notifikacija7', 'cook');

INSERT INTO _notifications (id,date_time, text, user_type) VALUES (8, '2012-12-12 11:11:11', 'Notifikacija8', 'maincook');
INSERT INTO _notifications (id,date_time, text, user_type) VALUES (9, '2012-12-12 11:11:11', 'Notifikacija9', 'maincook');

INSERT INTO _notifications (id,date_time, text, user_type) VALUES (10, '2012-12-12 11:11:11', 'Notifikacija10', 'manager');
INSERT INTO _notifications (id,date_time, text, user_type) VALUES (11, '2012-12-12 11:11:11', 'Notifikacija11', 'manager');

INSERT INTO _notifications (id,date_time, text, user_type) VALUES (12, '2012-12-12 11:11:11', 'Notifikacija6', 'waiter');
INSERT INTO _notifications (id,date_time, text, user_type) VALUES (13, '2012-12-12 11:11:11', 'Notifikacija6', 'waiter');
