DROP TABLE IF EXISTS  `users_roles`;
DROP TABLE IF EXISTS  `roles`;
ALTER TABLE `users` ADD COLUMN `role` varchar(255);
UPDATE `users` set `role` = 'ADMIN' WHERE `id` = 1;

