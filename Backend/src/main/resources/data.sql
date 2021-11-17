INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('markoMarkovic@maildrop.cc','MarkoMarkovic12', false, "2012-12-12", "Pera", "Peric", 20000);
INSERT INTO _admins (user) VALUES (1);

INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('peraperic@maildrop.cc','peraperic', false, "2012-12-11", "Marko", "Peric", 20000);
INSERT INTO _admins (user) VALUES (2);

INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('milanmilanovic@maildrop.cc','milanmilanovic', false, "2012-12-12", "Pera", "Peric", 20000);
INSERT INTO _admins (user) VALUES (3);



INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('savosavic@maildrop.cc','MarkoMarkovic12', false, "2012-12-12", "Pera", "Peric", 20000);
INSERT INTO _staff (user) VALUES (4);
INSERT INTO _barmen (staff) VALUES (4);


INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('pavlepavlovic@maildrop.cc','peraperic', false, "2012-12-12", "Pera", "Peric", 20000);
INSERT INTO _staff (user) VALUES (5);
INSERT INTO _barmen (staff) VALUES (5);

INSERT INTO _users(username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('luka@maildrop.cc','luka', false, "2012-12-12", "Pera", "Peric", 20000);
INSERT INTO _staff (user) VALUES (6);
INSERT INTO _cooks (staff) VALUES (6);

INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('petarpetrovic@maildrop.cc','petarpetrovic', false, "2012-12-12", "Pera", "Peric", 20000);
INSERT INTO _staff (user) VALUES (7);
INSERT INTO _cooks (staff) VALUES (7);



INSERT INTO _users(username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('jovan@maildrop.cc','jovan', false, "2012-12-12", "Pera", "Peric", 20000);
INSERT INTO _staff (user) VALUES (8);
INSERT INTO _cooks (staff) VALUES (8);
INSERT INTO _main_cooks (cook) VALUES (8);

INSERT INTO _users(username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('miladin@maildrop.cc','miladin', false, "2012-12-12", "Pera", "Peric", 20000);
INSERT INTO _staff (user) VALUES (9);
INSERT INTO _cooks (staff) VALUES (9);
INSERT INTO _main_cooks (cook) VALUES (9);



INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('nikolanikolic@maildrop.cc','nikolanikolic', false, "2012-12-12", "Pera", "Peric", 20000);
INSERT INTO _managers (user) VALUES (10);

INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('slavko@maildrop.cc','slavko', false, "2012-12-12", "Pera", "Peric", 20000);
INSERT INTO _managers (user) VALUES (11);


INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('ognjen@maildrop.cc','ognjen', false, "2012-12-12", "Pera", "Peric", 20000);
INSERT INTO _waiters (user) VALUES (12);

INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('todor@maildrop.cc','todor', false, "2012-12-12", "Pera", "Peric", 20000);
INSERT INTO _waiters (user) VALUES (13);



INSERT INTO _items (description, is_deleted, name,price, priority, subcategory) VALUES ('Deskripcija1', false, 'Jelo1',100, 1, 'subcategory1');
INSERT INTO _drinks (item) VALUES (1);
INSERT INTO _items (description, is_deleted, name,price, priority, subcategory) VALUES ('Deskripcija2', false, 'Jelo2',100, 1, 'subcategory2');
INSERT INTO _drinks (item) VALUES (2);
INSERT INTO _items (description, is_deleted, name,price, priority, subcategory) VALUES ('Deskripcija3', false, 'Jelo3',100, 1, 'subcategory3');
INSERT INTO _drinks (item) VALUES (3);

INSERT INTO _items (description, is_deleted, name,price, priority, subcategory) VALUES ('Deskripcija4', false, 'Jelo4',100, 1, 'subcategory4');
INSERT INTO _foods (item) VALUES (4);
INSERT INTO _items (description, is_deleted, name,price, priority, subcategory) VALUES ('Deskripcija5', false, 'Jelo5',100, 1, 'subcategory5');
INSERT INTO _foods (item) VALUES (5);
INSERT INTO _items (description, is_deleted, name,price, priority, subcategory) VALUES ('Deskripcija6', false, 'Jelo6',100, 1, 'subcategory6');
INSERT INTO _foods (item) VALUES (6);

INSERT INTO _tables (table_number, floor, positionX, positionY, state, is_deleted) VALUES (1, 1, 1.0, 2.0, "free", false);
INSERT INTO _tables (table_number, floor, positionX, positionY, state, is_deleted) VALUES (2, 4, 30.0, 2.0, "free", false);

INSERT INTO _orders (price, note, waiter_id, restourant_table_id) VALUES (100.0, "asd", 12, 1);
INSERT INTO _orders (price, note, waiter_id, restourant_table_id) VALUES (200.0, "asdasd", 13, 2);

INSERT INTO _ordered_items (status, state, number, date_time, item_id, staff_id) VALUES ("free", "active", 2, "2012-12-12 11:11:11", 1, 5);
INSERT INTO _ordered_items (status, state, number, date_time, item_id, staff_id) VALUES ("free", "active", 2, "2012-12-12 11:11:11", 4, 6);