INSERT INTO _users (username,password, is_deleted) VALUES ('markoMarkovic@maildrop.cc','MarkoMarkovic12', false);
INSERT INTO _admins (user) VALUES (1);

INSERT INTO _users (username,password, is_deleted) VALUES ('peraperic@maildrop.cc','peraperic', false);
INSERT INTO _admins (user) VALUES (2);

INSERT INTO _users(username,password, is_deleted) VALUES ('milanmilanovic@maildrop.cc','milanmilanovic', false);
INSERT INTO _admins (user) VALUES (3);



INSERT INTO _users (username,password, is_deleted) VALUES ('savosavic@maildrop.cc','MarkoMarkovic12', false);
INSERT INTO _staff (user) VALUES (4);
INSERT INTO _barmen (staff) VALUES (4);


INSERT INTO _users (username,password, is_deleted) VALUES ('pavlepavlovic@maildrop.cc','peraperic', false);
INSERT INTO _staff (user) VALUES (5);
INSERT INTO _barmen (staff) VALUES (5);

INSERT INTO _users(username,password, is_deleted) VALUES ('luka@maildrop.cc','luka', false);
INSERT INTO _staff (user) VALUES (6);
INSERT INTO _cooks (staff) VALUES (6);

INSERT INTO _users (username,password, is_deleted) VALUES ('petarpetrovic@maildrop.cc','petarpetrovic', false);
INSERT INTO _staff (user) VALUES (7);
INSERT INTO _cooks (staff) VALUES (7);



INSERT INTO _users(username,password, is_deleted) VALUES ('jovan@maildrop.cc','jovan', false);
INSERT INTO _staff (user) VALUES (8);
INSERT INTO _cooks (staff) VALUES (8);
INSERT INTO _main_cooks (cook) VALUES (8);

INSERT INTO _users(username,password, is_deleted) VALUES ('miladin@maildrop.cc','miladin', false);
INSERT INTO _staff (user) VALUES (9);
INSERT INTO _cooks (staff) VALUES (9);
INSERT INTO _main_cooks (cook) VALUES (9);



INSERT INTO _users (username,password, is_deleted) VALUES ('nikolanikolic@maildrop.cc','nikolanikolic', false);
INSERT INTO _managers (user) VALUES (10);

INSERT INTO _users (username,password, is_deleted) VALUES ('slavko@maildrop.cc','slavko', false);
INSERT INTO _managers (user) VALUES (11);


INSERT INTO _users (username,password, is_deleted) VALUES ('ognjen@maildrop.cc','ognjen', false);
INSERT INTO _waiters (user) VALUES (12);

INSERT INTO _users (username,password, is_deleted) VALUES ('todor@maildrop.cc','todor', false);
INSERT INTO _waiters (user) VALUES (13);



INSERT INTO _items (description, is_deleted, name,price, priority, subcategory, version) VALUES ('Deskripcija1', false, 'Jelo1',100, 1, 'subcategory1', 1);
INSERT INTO _drinks (item) VALUES (1);
INSERT INTO _items (description, is_deleted, name,price, priority, subcategory, version) VALUES ('Deskripcija2', false, 'Jelo2',100, 1, 'subcategory2', 1);
INSERT INTO _drinks (item) VALUES (2);
INSERT INTO _items (description, is_deleted, name,price, priority, subcategory, version) VALUES ('Deskripcija3', false, 'Jelo3',100, 1, 'subcategory3', 1);
INSERT INTO _drinks (item) VALUES (3);

INSERT INTO _items (description, is_deleted, name,price, priority, subcategory, version) VALUES ('Deskripcija4', false, 'Jelo4',100, 1, 'subcategory4', 1);
INSERT INTO _drinks (item) VALUES (4);
INSERT INTO _items (description, is_deleted, name,price, priority, subcategory, version) VALUES ('Deskripcija5', false, 'Jelo5',100, 1, 'subcategory5', 1);
INSERT INTO _drinks (item) VALUES (5);
INSERT INTO _items (description, is_deleted, name,price, priority, subcategory, version) VALUES ('Deskripcija6', false, 'Jelo6',100, 1, 'subcategory6', 1);
INSERT INTO _drinks (item) VALUES (6);