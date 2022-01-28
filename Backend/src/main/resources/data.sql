--password = 'admin'
INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('admin@gmail.com','$2a$12$56lD4PGALif458mS44zuQuuRx28HkmKyJWk85ZtVTKFoDXsaROGNy', false, '2012-12-12', 'Pera', 'Peric', 20000);
INSERT INTO _admins (user) VALUES (1);

--password = 'admin1'
INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('admin1@gmail.com','$2a$12$NJo7BbzawM4gLzfMq.F5Ae29Bwu0uZJWwtDm.Ve4TwLplJGNso/gG', false, '2012-12-11', 'Marko', 'Peric', 20000);
INSERT INTO _admins (user) VALUES (2);

INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('milanmilanovic@maildrop.cc','milanmilanovic', false, '2012-12-12', 'Pera', 'Peric', 20000);
INSERT INTO _admins (user) VALUES (3);

--password = 'barman'
INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('barman@gmail.com','$2a$12$JL62vFqwVuMXsMgFog0hZOeM1IbbUJFhaCcvPhXEDVCRz38wVn.9e', false, '2012-12-12', 'Pera' ,'Peric', 20000);
INSERT INTO _staff (user) VALUES (4);
INSERT INTO _barmen (staff) VALUES (4);


INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('pavlepavlovic@maildrop.cc','peraperic', false, '2012-12-12', 'Pera', 'Peric', 20000);
INSERT INTO _staff (user) VALUES (5);
INSERT INTO _barmen (staff) VALUES (5);

INSERT INTO _users(username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('cook@gmail.com','$2a$12$Nfqk50L3tIg5QZwnOPiQauOYHbbLqwcjbeNLoZauSmaYwiehSrl9K', false, '2012-12-12', 'Pera', 'Peric', 20000);
INSERT INTO _staff (user) VALUES (6);
INSERT INTO _cooks (staff) VALUES (6);

INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('petarpetrovic@maildrop.cc','petarpetrovic', false, '2012-12-12', 'Pera', 'Peric', 20000);
INSERT INTO _staff (user) VALUES (7);
INSERT INTO _cooks (staff) VALUES (7);


--password = 'maincook'
INSERT INTO _users(username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('maincook@gmail.com','$2a$12$z.NQsL83grGYoAxEMQjqSOvwb/2rBclZgEuzSS/F2AFTfh010zzri', false, '2012-12-12', 'Pera', 'Peric', 20000);
INSERT INTO _staff (user) VALUES (8);
INSERT INTO _cooks (staff) VALUES (8);
INSERT INTO _main_cooks (cook) VALUES (8);

INSERT INTO _users(username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('miladin@maildrop.cc','miladin', false, '2012-12-12', 'Pera', 'Peric', 20000);
INSERT INTO _staff (user) VALUES (9);
INSERT INTO _cooks (staff) VALUES (9);
INSERT INTO _main_cooks (cook) VALUES (9);



--password = 'manager'
INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('manager@gmail.com','$2a$12$R8Z3/K8a8QDFSQNl6kpp1ObioZO51I7/pGuzZfe/Icey/kT0t8mUW', false, '2012-12-12', 'Pera', 'Peric', 20000);
INSERT INTO _managers (user) VALUES (10);

INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('slavko@maildrop.cc','slavko', false, '2012-12-12', 'Pera', 'Peric', 20000);
INSERT INTO _managers (user) VALUES (11);

--password = 'admin'

INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('ognjen@maildrop.cc','$2a$12$56lD4PGALif458mS44zuQuuRx28HkmKyJWk85ZtVTKFoDXsaROGNy', false, '2012-12-12', 'Pera', 'Peric', 20000);
INSERT INTO _waiters (user) VALUES (12);
--password = 'admin'

INSERT INTO _users (username,password, is_deleted, date_of_birth, first_name, last_name, salary) VALUES ('todor@maildrop.cc','$2a$12$56lD4PGALif458mS44zuQuuRx28HkmKyJWk85ZtVTKFoDXsaROGNy', false, '2012-12-12', 'Pera', 'eric', 20000);
INSERT INTO _waiters (user) VALUES (13);


INSERT INTO authority (name) VALUES ('ROLE_USER');
INSERT INTO authority (name) VALUES ('ROLE_STAFF');


INSERT INTO authority (name) VALUES ('ROLE_ADMIN');
INSERT INTO authority (name) VALUES ('ROLE_MANAGER');
INSERT INTO authority (name) VALUES ('ROLE_BARMAN');
INSERT INTO authority (name) VALUES ('ROLE_COOK');
INSERT INTO authority (name) VALUES ('ROLE_MAINCOOK');
INSERT INTO authority (name) VALUES ('ROLE_WAITER');


insert into user_authority (user_id, authority_id) values (1, 1); -- admin has ROLE_USER
insert into user_authority (user_id, authority_id) values (2, 1); -- admin has ROLE_USER
insert into user_authority (user_id, authority_id) values (3, 1); -- admin has ROLE_USER
insert into user_authority (user_id, authority_id) values (4, 1); -- admin has ROLE_USER
insert into user_authority (user_id, authority_id) values (5, 1); -- admin has ROLE_USER
insert into user_authority (user_id, authority_id) values (6, 1); -- admin has ROLE_USER
insert into user_authority (user_id, authority_id) values (7, 1); -- admin has ROLE_USER
insert into user_authority (user_id, authority_id) values (8, 1); -- admin has ROLE_USER
insert into user_authority (user_id, authority_id) values (9, 1); -- admin has ROLE_USER
insert into user_authority (user_id, authority_id) values (10, 1); -- admin has ROLE_USER
insert into user_authority (user_id, authority_id) values (11, 1); -- admin has ROLE_USER
insert into user_authority (user_id, authority_id) values (12, 1); -- admin has ROLE_USER
insert into user_authority (user_id, authority_id) values (13, 1); -- admin has ROLE_USER


insert into user_authority (user_id, authority_id) values (4, 2); -- user has ROLE_STAFF
insert into user_authority (user_id, authority_id) values (5, 2); -- user has ROLE_STAFF
insert into user_authority (user_id, authority_id) values (6, 2); -- user has ROLE_STAFF
insert into user_authority (user_id, authority_id) values (7, 2); -- user has ROLE_STAFF
insert into user_authority (user_id, authority_id) values (8, 2); -- user has ROLE_STAFF
insert into user_authority (user_id, authority_id) values (9, 2); -- user has ROLE_STAFF

insert into user_authority (user_id, authority_id) values (1, 3); -- user has ROLE_ADMIN
insert into user_authority (user_id, authority_id) values (2, 3); -- user has ROLE_ADMIN
insert into user_authority (user_id, authority_id) values (3, 3); -- user has ROLE_ADMIN

insert into user_authority (user_id, authority_id) values (10, 4); -- user has ROLE_MANAGER
insert into user_authority (user_id, authority_id) values (11, 4); -- user has ROLE_MANAGER

insert into user_authority (user_id, authority_id) values (4, 5); -- user has ROLE_BARMAN
insert into user_authority (user_id, authority_id) values (5, 5); -- user has ROLE_BARMAN

insert into user_authority (user_id, authority_id) values (6, 6); -- user has ROLE_COOKS
insert into user_authority (user_id, authority_id) values (7, 6); -- user has ROLE_COOKS
insert into user_authority (user_id, authority_id) values (8, 6); -- user has ROLE_COOKS
insert into user_authority (user_id, authority_id) values (9, 6); -- user has ROLE_COOKS

insert into user_authority (user_id, authority_id) values (8, 7); -- user has ROLE_MAINCOOK
insert into user_authority (user_id, authority_id) values (9, 7); -- user has ROLE_MAINCOOK

insert into user_authority (user_id, authority_id) values (12, 8); -- user has ROLE_WAITER
insert into user_authority (user_id, authority_id) values (13, 8); -- user has ROLE_WAITER



INSERT INTO _items (description, is_deleted, name, item_status,price, priority, subcategory, picture) VALUES ('Deskripcija1', false, 'Pice1', 'active',100, 1, 'subcategory1', 'assets/food.jpg');
INSERT INTO _drinks (item) VALUES (1);
INSERT INTO _items (description, is_deleted, name, item_status,price, priority, subcategory, picture) VALUES ('Deskripcija2', false, 'Pice2', 'active',100, 1, 'subcategory2', 'assets/food.jpg');
INSERT INTO _drinks (item) VALUES (2);
INSERT INTO _items (description, is_deleted, name, item_status,price, priority, subcategory, picture) VALUES ('Deskripcija3', false, 'Pice3', 'active',100, 1, 'subcategory3', 'assets/food.jpg');
INSERT INTO _drinks (item) VALUES (3);

INSERT INTO _items (description, is_deleted, name, item_status, price, priority, subcategory, picture) VALUES ('Deskripcija4', false, 'Jelo1', 'active', 100, 1, 'subcategory4', 'assets/food.jpg');
INSERT INTO _foods (item) VALUES (4);
INSERT INTO _items (description, is_deleted, name, item_status,price, priority, subcategory, picture) VALUES ('Deskripcija5', false, 'Jelo2', 'active',100, 1, 'subcategory5', 'assets/food.jpg');
INSERT INTO _foods (item) VALUES (5);
INSERT INTO _items (description, is_deleted, name, item_status,price, priority, subcategory, picture) VALUES ('Deskripcija6', false, 'Jelo3', 'active',100, 1, 'subcategory6', 'assets/food.jpg');
INSERT INTO _foods (item) VALUES (6);


INSERT INTO _items (description, is_deleted, name, item_status,price, priority, subcategory, picture) VALUES ('Deskripcija7', false, 'Pice7', 'newItem',100, 1, 'subcategory7', 'assets/food.jpg');
INSERT INTO _drinks (item) VALUES (7);
INSERT INTO _items (description, is_deleted, name, item_status,price, priority, subcategory, picture) VALUES ('Deskripcija8', false, 'Pice8', 'newItem',100, 1, 'subcategory8', 'assets/food.jpg');
INSERT INTO _drinks (item) VALUES (8);
INSERT INTO _items (description, is_deleted, name, item_status,price, priority, subcategory, picture) VALUES ('Deskripcija9', false, 'Jelo9', 'newItem',100, 1, 'subcategory9', 'assets/food.jpg');
INSERT INTO _foods (item) VALUES (9);

INSERT INTO _tables (table_number, floor, positionX, positionY, state, is_deleted) VALUES (1, 1, 1.0, 2.0, 'free', false);
INSERT INTO _tables (table_number, floor, positionX, positionY, state, is_deleted) VALUES (2, 4, 30.0, 2.0, 'free', false);

INSERT INTO _orders (price, waiter_id, restourant_table_id,date_time) VALUES (100.0, 12, 1, '2012-12-12');
INSERT INTO _orders (price, waiter_id, restourant_table_id, date_time) VALUES (200.0, 13, 2, '2012-11-11');

INSERT INTO _ordered_items (state, number, note,  date_time, item_id, staff_id, price, _id) VALUES ('ordered', 2, 'alergija na kikiriki', '2012-12-12', 1, 5, 200, 1);
INSERT INTO _ordered_items (state, number, note,  date_time, item_id, staff_id, price, _id) VALUES ('ordered', 2, 'alergija na nesto', '2012-11-11', 4, 6, 200, 2);
INSERT INTO _ordered_items (state, number, note,  date_time, item_id, staff_id, price, _id) VALUES ('ordered', 1, 'alergija na kikiriki', '2012-12-12', 1, 5, 50, 1);
INSERT INTO _ordered_items (state, number, note,  date_time, item_id, staff_id, price, _id) VALUES ('ordered', 1, 'alergija na nesto', '2012-11-11', 4, 6, 100, 2);

INSERT INTO _ordered_items (state, number, note,  date_time, item_id, staff_id, price, _id) VALUES ('ordered', 1, 'alergija na kikiriki', '2012-12-12', 2, null, 50, 1);
INSERT INTO _ordered_items (state, number, note,  date_time, item_id, staff_id, price, _id) VALUES ('ordered', 1, 'alergija na nesto', '2012-11-11', 5, null, 100, 2);


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
