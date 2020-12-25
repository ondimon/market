insert into products
(id, title, price) values
(1, 'Cheese', 320),
(2, 'Milk', 80),
(3, 'Apples', 80),
(4, 'Bread', 30);

insert into categories (id, title) values
(1, 'food'),
(2, 'fruit');

insert into products_categories (product_id, category_id) values
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(3, 2);