USE db_example;
--Sifarnik dijagnoa
insert into sifarnik_dijagnoza (naziv) values ('hello3');

--Admin klinickog centra
insert into admin_klinickog_centra (ime, prezime, username, password, email, kontakt_telefon, adresa, izmenjana_sifra_nakon_prvog_logovanja) values ('Ime','Prezime','Username','Pasword','email@email.com','0631738959','Novi Sad',false);

--Klinika
insert into klinika (naziv, adresa, opis) values ('Klinika1','Novi Sad', 'Opis klinike1');

--ZahtevZaRegistraciju
insert into zahtev_za_registraciju (broj_osiguranika, email, password, ime, prezime, adresa, grad, drzava, broj_telefona, status_zahteva, razlog_odbijanja) values (1234, 'pera@gmail.com', 'perapera', 'Pera', 'Peric', 'Fruskogorska 1', 'Novi Sad', 'Srbija', '0601234', 1, '');

--Pacijent
insert into pacijent (email, password, ime, prezime, adresa, grad, drzava, kontakt_telefon) value ("pacijent1@gmail.com","pacijent1sifra","Pacijent1","Prezime1","Safarikova 1","Novi Sad", "Srbija", "0213001486");
insert into pacijent (email, password, ime, prezime, adresa, grad, drzava, kontakt_telefon) value ("pacijent2@gmail.com","pacijent2sifra","Pacijent2","Prezime2","Pasterova 1","Novi Sad", "Srbija", "021445522");