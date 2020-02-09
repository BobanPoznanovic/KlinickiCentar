USE db_example;
--Sifarnik dijagnoa
insert into sifarnik_dijagnoza (naziv) values ('Prehlada');
insert into sifarnik_dijagnoza (naziv) values ('Upala grla');
insert into sifarnik_dijagnoza (naziv) values ('Boginje');

--Admin klinickog centra
insert into admin_klinickog_centra (ime, prezime, username, password, email, kontakt_telefon, adresa, izmenjana_sifra_nakon_prvog_logovanja) values ('Ime','Prezime','Username','Pasword','email@email.com','0631738959','Novi Sad',false);

--Klinika
insert into klinika (naziv, adresa, opis) values ('Klinika1','Novi Sad', 'Opis klinike1');

--ZahtevZaRegistraciju
insert into zahtev_za_registraciju (broj_osiguranika, email, password, ime, prezime, adresa, grad, drzava, broj_telefona, status_zahteva, razlog_odbijanja) values (1234, 'pera@gmail.com', 'perapera', 'Pera', 'Peric', 'Fruskogorska 1', 'Novi Sad', 'Srbija', '0601234', 1, '');
insert into zahtev_za_registraciju (broj_osiguranika, email, password, ime, prezime, adresa, grad, drzava, broj_telefona, status_zahteva, razlog_odbijanja) values (3214, 'joka@gmail.com', 'jokajoka', 'Joka', 'Jokic', 'Temerinska 1', 'Novi Sad', 'Srbija', '060445566', 1, '');

--Pacijent
insert into pacijent (broj_osiguranika, email, password, ime, prezime, adresa, grad, drzava, kontakt_telefon) values (1234, "pacijent1@gmail.com","pacijent1sifra","Pera","Peric","Safarikova 1","Novi Sad", "Srbija", "0213001486");
insert into pacijent (broj_osiguranika, email, password, ime, prezime, adresa, grad, drzava, kontakt_telefon) values (2345, "pacijent2@gmail.com","pacijent2sifra","Mika","Mikic","Pasterova 1","Novi Sad", "Srbija", "021445522");

--ZdravstveniKarton
insert into zdravstveni_karton (pacijentID, datum_rodjenja, visina_pacijenta, tezina_pacijenta, krvna_grupa, dioptrija) values (1, '1995-10-10', 182.3, 80.6, "0-", "");
insert into zdravstveni_karton (pacijentID, datum_rodjenja, visina_pacijenta, tezina_pacijenta, krvna_grupa, dioptrija) values (2, '1985-10-10', 172.3, 60.6, "A+", "+1.0");

--Specijalizacije
insert into specijalizacija_lekara (naziv_specijalizacije) values ("Opsta praksa");
insert into specijalizacija_lekara (naziv_specijalizacije) values ("Hirurg");
insert into specijalizacija_lekara (naziv_specijalizacije) values ("Kardiolog");

--Lekar
insert into lekar (specijalizacijaID, klinikaID, ime, prezime, username, password, email, kontakt_telefon, adresa, izmenjana_sifra_nakon_prvog_logovanja) values (1, 1, "Zika", "Zikic", "zikson", "zikinasifra", "zika@gmail.com", "0645896214", "Novi Saddyyy", true);

--MedicinskaSestra
insert into medicinska_sestra (klinikaID, ime, prezime, username, password, email, kontakt_telefon, adresa, izmenjana_sifra_nakon_prvog_logovanja) values (1, "Mira", "Miric", "miraa", "mirinasifra", "mira@gmail.com", "0645555214", "Novi Saddyyy", true);

--Sala
insert into sala (klinikaID, naziv_sale, broj_sale) values (1, "Sala za pregled", 101);
insert into sala (klinikaID, naziv_sale, broj_sale) values (1, "Sala za operaciju", 109);

--TipPregleda
insert into tip_pregleda (naziv, cena) values ("Obican pregled", 50.5);

--Pregled
insert into pregled (kategorija_pregleda, lekarID, pacijentID, salaID, datum_pregleda, satnica_pocetak, satnica_kraj, tip_pregledaID, popust) values ("Normalan", 1, 1, 1, '2020-02-19', '10:00', '10:30', 1, 0);
insert into pregled (kategorija_pregleda, lekarID, pacijentID, salaID, datum_pregleda, satnica_pocetak, satnica_kraj, tip_pregledaID, popust) values ("Normalan", 1, 1, 1, '2020-02-29', '11:00', '11:30', 1, 0);
insert into pregled (kategorija_pregleda, lekarID, pacijentID, salaID, datum_pregleda, satnica_pocetak, satnica_kraj, tip_pregledaID, popust) values ("Normalan", 1, 2, 1, '2020-02-19', '12:00', '12:30', 1, 0);
insert into pregled (kategorija_pregleda, lekarID, pacijentID, salaID, datum_pregleda, satnica_pocetak, satnica_kraj, tip_pregledaID, popust) values ("Normalan", 1, 2, 1, '2020-02-27', '10:00', '10:30', 1, 0);
insert into pregled (kategorija_pregleda, lekarID, pacijentID, salaID, datum_pregleda, satnica_pocetak, satnica_kraj, tip_pregledaID, popust) values ("Normalan", 1, 2, 2, '2020-03-03', '08:00', '08:30', 1, 0);

--Operacije
insert into operacija (lekarID, datum_operacije, satnica_pocetka_operacije, satnica_kraja_operacije) values (1, '2020-03-03', '15:30', '16:00');
insert into operacija (lekarID, datum_operacije, satnica_pocetka_operacije, satnica_kraja_operacije) values (1, '2020-03-03', '11:00', '12:00');
insert into operacija (lekarID, datum_operacije, satnica_pocetka_operacije, satnica_kraja_operacije) values (1, '2020-03-03', '14:00', '15:00');

--ZahtevZaDodeluSale
insert into zahtev_za_dodelu_sale (operacijaID, salaID, datum_kreiranja_zahteva, vreme_kreiranja_zahteva, status_zahteva) values (1, 2, '2020-02-09', '10:00', "Nije_procesuiran");
insert into zahtev_za_dodelu_sale (operacijaID, salaID, datum_kreiranja_zahteva, vreme_kreiranja_zahteva, status_zahteva) values (2, 2, '2020-02-09', '10:00', "Nije_procesuiran");
insert into zahtev_za_dodelu_sale (operacijaID, salaID, datum_kreiranja_zahteva, vreme_kreiranja_zahteva, status_zahteva) values (3, 2, '2020-02-09', '10:00', "Nije_procesuiran");
