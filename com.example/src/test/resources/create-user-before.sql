
delete from user_role;
delete from usr;

insert into usr (id, active, password, username) values
(1, true, '202cb962ac59075b964b07152d234b70', 'admin'),
(2, true, '202cb962ac59075b964b07152d234b70', 'serg');

insert into user_role(user_id, roles) values
(1, 'ADMIN'), (1, 'USER'),
(2, 'USER');