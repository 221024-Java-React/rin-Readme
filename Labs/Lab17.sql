create database labs;

create user postgres with password 'password';

grant all privileges on database labs to postgres;

create table songs (
	id int primary key, 
	name varchar not null,
	artist varchar not null,
	album varchar not null,
	genre varchar not null,
	duration decimal not null,
	fav bool
);

insert into songs 
values (1, 'Heart-Shaped Box', 'Nirvana', 'In Utero', 'Rock', 4.68, False),
	(2, 'Smells Like Teen Spirit', 'Nirvana', 'Nevermind', 'Rock', 3.65, False),
	(3, 'Higher', 'Creed', 'Human Clay', 'Rock', 5.43, False),
	(4, 'Hero', 'Skillet', 'Awake', 'Rock', 3.12, False),
	(5, 'Hotel California', 'Eagles', 'Hotel California', 'Rock', 3.47, False),
	(6, 'Austin', 'Blake Shelton', 'Blake Shelton', 'Country', 3.38, False),
	(7, 'Dirty Road Anthem', 'Jason Aldean', 'My Kinda Party', 'Country', 3.81, False),
	(8, 'Springsteen', 'Eric Church', 'Chief', 'Country', 4.38, False),
	(9, 'Watching Airplanes', 'Gary Allen', 'Living Hard', 'Country', 4.05, False),
	(10, 'Hey Girl', 'Billy Currington', 'We Are Tonight', 'Country', 3.35, False),
	(11, 'A Milli', 'Lil Wayne', 'Tha Carter III', 'Hip Hop', 3.70, False),
	(12, 'Over', 'Drake', 'Thank Me Later', 'Hip Hop', 3.90, False),
	(13, 'No Interuption', 'Hoodie Allen', 'Furture History', 'Hip Hop', 3.58, False),
	(14, 'It Girl', 'Jason Derulo', 'Future History', 'Hip Hop', 3.20, False),
	(15, 'Frick Park Market', 'Mac Miller', 'Blue Slide Park', 'Hip Hop', 3.30, False);

select * from songs;

--Lab17 part1
select * from songs where name = 'Austin';

select artist from songs where genre = 'Country';

select name from songs where genre = 'Hip Hop' and duration > 3.5;

select * from songs where name like 'H%';

select * from songs where genre = 'Country' and artist like '%Allen';

--part 2

update songs set fav = true where genre = 'Hip Hop';

update songs set fav = true where artist = 'Nirvana';

update songs set fav = true where name = 'Austin' or name = 'Springsteen';

--part 3
delete from songs where fav = false;

delete from songs where genre = 'Country';

delete from songs where duration > 3.5;

delete from songs where artist = 'Jason Derulo';

select * from songs;