insert into roles (id, name) values
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');

insert into users (id, username, password, email, locked) values
(1, 'admin', '$2y$12$Ah2879Rtk3ZTzPIT/8E8wOSgDQweABiADdqUYV4hSWS7MyH0ZNsvu', 'admin@market.com', false);

insert into users_roles (user_id, role_id) values
(1, 1),
(1, 2);
