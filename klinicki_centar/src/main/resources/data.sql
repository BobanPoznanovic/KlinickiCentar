USE db_example;
--Sifarnik dijagnoa
insert into sifarnik_dijagnoza (naziv) values ('hello3');

--Admin klinickog centra
insert into admin_klinickog_centra (ime, prezime, username, password, email, kontakt_telefon, adresa, izmenjana_sifra_nakon_prvog_logovanja) values ('Ime','Prezime','Username','Pasword','email@email.com','0631738959','Novi Sad',false);

--Klinika
insert into klinika (naziv, adresa, opis) values ('Klinika1','Novi Sad', 'Opis klinike1');