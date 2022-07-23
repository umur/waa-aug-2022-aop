INSERT INTO public.category (id, name) VALUES (1, 'Fruits');
INSERT INTO public.category (id, name) VALUES (2, 'Vegetables');
INSERT INTO public.category (id, name) VALUES (3, 'Baked');

INSERT INTO public.product (id, name, price, category_id) VALUES (1, 'Bread', 1.99, 3);
INSERT INTO public.product (id, name, price, category_id) VALUES (2, 'Cookies', 2.99, 3);
INSERT INTO public.product (id, name, price, category_id) VALUES (3, 'Watermelon', 0.99, 1);
INSERT INTO public.product (id, name, price, category_id) VALUES (4, 'Banana', 0.99, 1);
INSERT INTO public.product (id, name, price, category_id) VALUES (5, 'Strawberry', 4.99, 1);
INSERT INTO public.product (id, name, price, category_id) VALUES (6, 'Potato', 3.99, 2);
INSERT INTO public.product (id, name, price, category_id) VALUES (7, 'Onion', 1.49, 2);

INSERT INTO public.address (id, city, street, zip) VALUES (1, 'Fairfield', '1000 N 4th St', '52557');
INSERT INTO public.address (id, city, street, zip) VALUES (2, 'Fairfield', '2701 W Burlington Ave', '52556');
INSERT INTO public.address (id, city, street, zip) VALUES (3, 'Boston', '140 Bay State Road', '02215');

INSERT INTO public.users (id, email, first_name, last_name, password, address_id) VALUES (1, 'alikhan.amandyk@miu.edu', 'Alikhan', 'Amandyl', '1', 1);
INSERT INTO public.users (id, email, first_name, last_name, password, address_id) VALUES (2, 'jamkhurbek.islomov@miu.edu', 'Jamkhurbek', 'Islomov', '2', 2);

INSERT INTO public.review (id, comment, product_id, user_id) VALUES (1, 'Great product', 1, 1);
INSERT INTO public.review (id, comment, product_id, user_id) VALUES (2, 'Not so great', 6, 2);
