create table Employee (
  id         serial primary key,
  first_name varchar(100) default null,
  last_name  varchar(100) default null
);

insert into Employee (first_name, last_name)
values ('Rico', 'Apon');
