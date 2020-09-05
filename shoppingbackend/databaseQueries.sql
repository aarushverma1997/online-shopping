CREATE table category(


id IDENTITY,
name VARCHAR(50),
description VARCHAR(255),
image_url VARCHAR(50),
is_active BOOLEAN,

CONSTRAINT pk_category_id PRIMARY KEY(id)



);


insert into category(name,description,image_url,is_active) values('Mobile','This is Mobile Category','mobile_url.png',true);
insert into category(name,description,image_url,is_active) values('Laptop','This is Laptop Category','laptop_url.png',true);
insert into category(name,description,image_url,is_active) values('TV','This is Tv Category','tv_url.png',true);


CREATE table user_detail(


id IDENTITY,
first_name VARCHAR(50),
last_name VARCHAR(50),
role VARCHAR(50),
enabled BOOLEAN,
password VARCHAR(100),
email VARCHAR(100),
contact_number VARCHAR(15),

CONSTRAINT pk_user_id PRIMARY KEY(id)




);

insert into user_detail(first_name,last_name,role,enabled,password,email,contact_number) values('Ravindra','Verma','ADMIN',true,'admin','admin@gmail.com','1234567890');

insert into user_detail(first_name,last_name,role,enabled,password,email,contact_number) values('Aarush','Verma','SUPPLIER',true,'aarush@verma','aarush@gmail.com','9999967890');


insert into user_detail(first_name,last_name,role,enabled,password,email,contact_number) values('Dharmendra','Goyal','SUPPLIER',true,'dharmendra@goyal','dharmendra@gmail.com','7894567890');



insert into user_detail(first_name,last_name,role,enabled,password,email,contact_number) values('Ramchand','Hatagle','SUPPLIER',true,'ram@hatagle','ramn@gmail.com','1566222890');




CREATE TABLE product(

id IDENTITY,
code VARCHAR(20),
name VARCHAR(50),
brand VARCHAR(50),
description VARCHAR(255),
unit_price DECIMAL(10,2),
quantity INT,
is_active BOOLEAN,
category_id INT,
supplier_id INT,
purchases INT DEFAULT 0,
views INT DEFAULT 0,


CONSTRAINT pk_product_id PRIMARY KEY(id),
CONSTRAINT fk_product_category_id FOREIGN KEY(category_id) REFERENCES category(id),
CONSTRAINT fk_product_supplier_id FOREIGN KEY(supplier_id) REFERENCES user_detail(id)



);



insert into product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id  ) values('PRDABC123DEX','iphone 5s','apple','apple mobile',50000,2,true,1,2);


insert into product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id ) values('PRDCDE789ABC','Glaxy','samsung','samsung mobile',5200,5,true,1,3);



insert into product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id ) values('PRDLPT133PPT','ideapad 330','lenovo','lenovo laptop',32005,10,true,2,4);
