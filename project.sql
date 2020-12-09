create table Hotel(
Hotel_name varchar(100) primary key,
Revenue_planned numeric(10,2),
State varchar(100),
Start_date varchar(100));


Create table Cuisine(
	Cuisine_id varchar(100) primary key,
	Cuisine varchar(100)
);

create table chefs(
	SSN varchar(50) primary key,
	Cuisine_id varchar(100) references Cuisine(Cuisine_id),
	Chef_name varchar(100),
	DOJ varchar(100)
);

create table Branch(
	Hotel_name varchar(100) references Hotel(Hotel_name),
	Branch_name varchar(100),
	Expenditure numeric(10,2),
	City varchar(100),
	SSN varchar(50)references chefs(SSN)
);
create table Menu(
	Food_Item  varchar(100) primary key,
	Cuisine_id varchar(100) references Cuisine(Cuisine_id));

create table Employee(
	SSID varchar(100) PRIMARY KEY,
	ename varchar(100),
	DOJ varchar(100),
	designation varchar(100)
);

insert into Hotel values
('RonHotel',500000.00,'Kerala','23-12-2000'),
('AnandHotel',400000.00,'Karnataka','12-02-2001'),
('AnanthanHotel',999999.99,'Goa','20-11-2000'),
('AshishHotel',000001.11,'Rajasthan','01-04-2000');

insert into Cuisine values
('F100','French Cuisine'),
('F101','Italian Cuisine'),
('F102','Indian Cuisine'),
('F103','Japanese Cuisine'),
('F104','Korean Cuisine');

insert into chefs values
('C101','F101','Ron','20-11-2020'),
('C102','F102','Anand','15-11-2018'),
('C103','F104','Ananthan','11-11-1998'),
('C100','F103','Ashish','12-10-2017'),
('C105','F104','Ashwin','12-7-2004');


insert into Branch values
('RonHotel','Branch-A',10000.00,'Kollam','C101'),
('AnandHotel','Branch-A',20000.00,'city1','C102'),
('AnandHotel','Branch-B',30000.00,'city2','C105'),
('AnanthanHotel','Branch-A',40000.00,'cityA','C103'),
('AnanthanHotel','Branch-B',50000.00,'cityB','C103'),
('AshishHotel','Branch-A',60000.00,'cityC','C100');

insert into Menu values
('FoodA','F102'),
('FoodB','F100'),
('FoodC','F103'),
('FoodD','F102'),
('FoodE','F101'),
('FoodA','F104');

insert into Employee values
('S101','Ron','20-11-2020','Janitor'),
('S102','Anand','15-11-2018', 'GM'),
('S103','Ananthan','11-11-1998', 'MD'),
('S100','Ashish','12-10-2017', 'Disposal-Man'),
('S105','Ashwin','12-7-2004', 'Waiter');

select Hotel.Hotel_name,sum(Expenditure) 
from Hotel inner join branch 
on Hotel.Hotel_name=branch.Hotel_name
group by Hotel.Hotel_name 
having Revenue_planned>40000.00;

select * from Hotel natural join Branch order by Hotel_name;

select Hotel_name,Expenditure 
from Branch 
where Branch_name='Branch-A' and Expenditure>20000;

update Hotel
set Revenue_planned=Revenue_planned+Revenue_planned*0.15;

select * from chefs where Chef_name like '_sh%';

select * from Hotel;

select  * from chefs where extract(year from DOJ)='2018';

select Hotel_name,to_char(Start_date,'month') from Hotel;

select * from chefs where DOJ between '1-1-2010' and '31-12-2020';

select SSN from chefs 
intersect
select SSN from branch;

Drop table Menu;
Drop TABLE	Branch;
Drop table chefs;
Drop Table Cuisine;
Drop table Hotel;
