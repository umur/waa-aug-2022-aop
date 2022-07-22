insert into public.address (id, city, street, zip)
values  (1, 'city 1', 'street 1', 123),
        (8, 'city 2', 'street 2 edit', 200);

insert into public.user (id, email, first_name, last_name, password, address_id)
values  (1, 'email@gmail.com', 'jack', 'hana', '12345', 1),
        (10, 'email1@gmail.com', 'jill edit', 'nathan', '12345', 8);

insert into public.category (id, name)
values  (6, 'cate 6'),
        (7, 'cate 7'),
        (4, 'cate 4'),
        (9, 'cate 9'),
        (3, 'cate 3'),
        (2, 'cate 2');

insert into public.product (id, name, price, rating, category_id)
values  (14, 'product 2', 220, 3, 2),
        (15, 'product 3', 220, 3, 3);

insert into public.review (id, comment, product_id)
values  (1, 'comment 1', 14),
        (17, 'comment 3', 14),
        (16, 'comment 2', 14),
        (18, 'comment 4', 14),
        (19, 'comment 1', 15),
        (20, 'comment 3', 15);