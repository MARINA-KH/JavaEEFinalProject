
create table if not exists users
(
    id       int primary key auto_increment,
    login    varchar(30) not null,
    password varchar(40) not null,
    email varchar(40) not null,
    unique uniq_login (login)
);

create table if not exists ITEM
(
    id       int primary key auto_increment,
    itemName    varchar(30) not null,
    quantity varchar(40) not null,
    price varchar(40) not null,
    description varchar(40) not null
);


create table if not exists Category
(
    id       int primary key auto_increment,
    categoryName    varchar(30) not null,
    description varchar(40) not null
);


create table if not exists permissions
(
    id         int primary key auto_increment,
    permission varchar(30) not null,
    unique uniq_permission (permission)
);

create table if not exists user_to_permissions
(
    user_id       int not null,
    permission_id int not null,
    constraint fk_user_to_permission_user foreign key (user_id) references users (id),
    constraint fk_user_to_permission_permission foreign key (permission_id) references permissions (id)
);

create table if not exists item_to_category
(
    item_id       int not null,
    category_id int not null,
    constraint fk_item_to_category_item foreign key (item_id) references items (id),
    constraint fk_item_to_category_category foreign key (category_id) references Categories (id)
);




insert into users (login, password, email) values
('admin', 'password', 'admin@admin.com'),
('user', 'password', 'user@user.com');

insert into items (itemName, quantity, price, description) values
('banana', '12', '13','very delicious and yellow'),
('orange', '14', '15','very delicious and orange');

insert into permissions (permission)
values ('VIEW_ADMIN'),
       ('VIEW_USER');


insert into user_to_permissions (user_id, permission_id)
values ((select id from users where login = 'user'), (select id from permissions where permission = 'VIEW_USER')),
       ((select id from users where login = 'admin'), (select id from permissions where permission = 'VIEW_ADMIN'));
