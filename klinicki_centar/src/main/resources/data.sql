USE db_example;
--Sifarnik dijagnoa
insert into sifarnik_dijagnoza (naziv) values ('Prehlada');
insert into sifarnik_dijagnoza (naziv) values ('Upala grla');
insert into sifarnik_dijagnoza (naziv) values ('Boginje');

--Admin klinickog centra
insert into admin_klinickog_centra (ime, prezime, username, password, email, kontakt_telefon, adresa, izmenjana_sifra_nakon_prvog_logovanja) values ('Ime','Prezime','Username','Pasword','email@email.com','0631738959','Novi Sad',false);

--Klinika
insert into klinika (naziv, adresa, grad, opis, prosecna_ocena, broj_ocena) values ('Klinika1', 'Futoski put 14', 'Novi Sad', 'Opis klinike1', 0.0, 0);
insert into klinika (naziv, adresa, grad, opis, prosecna_ocena, broj_ocena) values ('Klinika2', 'Balkanska 188', 'Beograd', 'Opis klinike2', 0.0, 0);
insert into klinika (naziv, adresa, grad, opis, prosecna_ocena, broj_ocena) values ('Klinika3', 'Pasterova 16', 'Novi Sad', 'Opis klinike3', 0.0, 0);
insert into klinika (naziv, adresa, grad, opis, prosecna_ocena, broj_ocena) values ('Klinika4', 'Jovana Popovica 6', 'Novi Sad', 'Opis klinike4', 0.0, 0);
insert into klinika (naziv, adresa, grad, opis, prosecna_ocena, broj_ocena) values ('Klinika5', 'Savska 155', 'Beograd', 'Opis klinike5', 0.0, 0);

--ZahtevZaRegistraciju
insert into zahtev_za_registraciju (broj_osiguranika, email, password, ime, prezime, adresa, grad, drzava, broj_telefona, status_zahteva, razlog_odbijanja) values (1234, 'pera@gmail.com', 'perapera', 'Pera', 'Peric', 'Fruskogorska 1', 'Novi Sad', 'Srbija', '0601234', 1, '');
insert into zahtev_za_registraciju (broj_osiguranika, email, password, ime, prezime, adresa, grad, drzava, broj_telefona, status_zahteva, razlog_odbijanja) values (3214, 'joka@gmail.com', 'jokajoka', 'Joka', 'Jokic', 'Temerinska 1', 'Novi Sad', 'Srbija', '060445566', 1, '');

--Pacijent
insert into pacijent (broj_osiguranika, email, password, ime, prezime, adresa, grad, drzava, kontakt_telefon, zdravstveni_kartonID, aktivan, version) values (1234, 'pacijent1@gmail.com', 'pacijent1sifra', 'Pera', 'Peric', 'Safarikova 1', 'Novi Sad', 'Srbija', '0213001486', 1, 0, 0);
insert into pacijent (broj_osiguranika, email, password, ime, prezime, adresa, grad, drzava, kontakt_telefon, zdravstveni_kartonID, aktivan, version) values (2345, 'pacijent2@gmail.com' ,'pacijent2sifra', 'Mika', 'Mikic', 'Pasterova 1', 'Novi Sad', 'Srbija', '021445522', 2, 0, 0);

--ZdravstveniKarton
INSERT INTO zdravstveni_karton (pacijentID, datum_rodjenja , visina_pacijenta , tezina_pacijenta , krvna_grupa , dioptrija) VALUES (1, '1990-02-20', '190', '80.5', 'AB+', '+1');
INSERT INTO zdravstveni_karton (pacijentID, datum_rodjenja , visina_pacijenta , tezina_pacijenta , krvna_grupa , dioptrija) VALUES (2, '1980-05-16', '180', '72.0', 'B+', '+2');

--Specijalizacije
--insert into specijalizacija_lekara (naziv_specijalizacije) values ("Opsta praksa");
--insert into specijalizacija_lekara (naziv_specijalizacije) values ("Hirurg");
--insert into specijalizacija_lekara (naziv_specijalizacije) values ("Kardiolog");
--insert into specijalizacija_lekara (naziv_specijalizacije) values ("Oftamolog");
--insert into specijalizacija_lekara (naziv_specijalizacije) values ("Pulmolog");
--insert into specijalizacija_lekara (naziv_specijalizacije) values ("Radiolog");
--insert into specijalizacija_lekara (naziv_specijalizacije) values ("Patolog");
--insert into specijalizacija_lekara (naziv_specijalizacije) values ("Otorinolaringolog");





--Lekar

--izbaciti sepcijalizacijaID
--mozda da doktor ima referencu na tip/tipove pregleda koje moze da obavlja
--kako vise vrednosti sacuvati za jedno polje? -> nova tabela pa JOIN ?

--insert into lekar (specijalizacijaID, klinikaID, ime, prezime, username, password, email, kontakt_telefon, adresa, pocetak_radnog_vremena, kraj_radnog_vremena, izmenjena_sifra_nakon_prvog_logovanja) values (1, 1, "Zika", "Zikic", "zikson", "zikinasifra", "zika@gmail.com", "0645896214", "Novi Sad", '08:30', '16:30', true);
--insert into lekar (specijalizacijaID, klinikaID, ime, prezime, username, password, email, kontakt_telefon, adresa, pocetak_radnog_vremena, kraj_radnog_vremena, izmenjena_sifra_nakon_prvog_logovanja) values (2, 1, "Mile", "Kovacevic", "mikan", "mika123", "mile@gmail.com", "064122333", "Novi Sad", '07:00', '15:00',true);
--insert into lekar (specijalizacijaID, klinikaID, ime, prezime, username, password, email, kontakt_telefon, adresa, pocetak_radnog_vremena, kraj_radnog_vremena, izmenjena_sifra_nakon_prvog_logovanja) values (3, 3, "Lena", "Markovic", "marlena", "lena234", "lena@gmail.com", "0640096214", "Novi Sad", '09:30', '17:30', true);
--insert into lekar (specijalizacijaID, klinikaID, ime, prezime, username, password, email, kontakt_telefon, adresa, pocetak_radnog_vremena, kraj_radnog_vremena, izmenjena_sifra_nakon_prvog_logovanja) values (4, 3, "Dejana", "Stokic", "dejana", "deja222", "dejana@gmail.com", "060999080", "Novi Sad", '08:00', '16:00', true);
--insert into lekar (specijalizacijaID, klinikaID, ime, prezime, username, password, email, kontakt_telefon, adresa, pocetak_radnog_vremena, kraj_radnog_vremena, izmenjena_sifra_nakon_prvog_logovanja) values (6, 4, "Marko", "Lekovic", "male", "kkmm147", "marko@gmail.com", "0614452366", "Novi Sad", '09:00', '17:00', true);
--insert into lekar (specijalizacijaID, klinikaID, ime, prezime, username, password, email, kontakt_telefon, adresa, pocetak_radnog_vremena, kraj_radnog_vremena, izmenjena_sifra_nakon_prvog_logovanja) values (8, 4, "Fedor", "Milic", "fele", "zzwert45", "fedor@gmail.com", "0635899665", "Novi Sad", '07:00', '15:00', true);
--insert into lekar (specijalizacijaID, klinikaID, ime, prezime, username, password, email, kontakt_telefon, adresa, pocetak_radnog_vremena, kraj_radnog_vremena, izmenjena_sifra_nakon_prvog_logovanja) values (1, 4, "Julija", "Stankovic", "jules", "12vbbv", "julija@gmail.com", "0625894412", "Novi Sad", '07:00', '15:00', true);

--schema.sql - LEKAR - izbacena polja
--specijalizacijaID int,
--CONSTRAINT fk_specijalizacijeID FOREIGN KEY (specijalizacijaID) REFERENCES SPECIJALIZACIJA_LEKARA(specijalizacijaID),


insert into lekar (klinikaID, ime, prezime, username, password, email, kontakt_telefon, adresa, pocetak_radnog_vremena, kraj_radnog_vremena, prosecna_ocena, broj_ocena, izmenjena_sifra_nakon_prvog_logovanja, version) values (1, "Zika", "Zikic", "zikson", "zikinasifra", "zika@gmail.com", "0645896214", "Novi Sad", '08:30', '16:30', 0.0, 0, true, 0);
insert into lekar (klinikaID, ime, prezime, username, password, email, kontakt_telefon, adresa, pocetak_radnog_vremena, kraj_radnog_vremena, prosecna_ocena, broj_ocena, izmenjena_sifra_nakon_prvog_logovanja, version) values (1, "Mile", "Kovacevic", "mikan", "mika123", "mile@gmail.com", "064122333", "Novi Sad", '07:00', '15:00', 0.0, 0, true, 0);
insert into lekar (klinikaID, ime, prezime, username, password, email, kontakt_telefon, adresa, pocetak_radnog_vremena, kraj_radnog_vremena, prosecna_ocena, broj_ocena, izmenjena_sifra_nakon_prvog_logovanja, version) values (3, "Lena", "Markovic", "marlena", "lena234", "lena@gmail.com", "0640096214", "Novi Sad", '09:30', '17:30', 0.0, 0, true, 0);
insert into lekar (klinikaID, ime, prezime, username, password, email, kontakt_telefon, adresa, pocetak_radnog_vremena, kraj_radnog_vremena, prosecna_ocena, broj_ocena, izmenjena_sifra_nakon_prvog_logovanja, version) values (3, "Dejana", "Stokic", "dejana", "deja222", "dejana@gmail.com", "060999080", "Novi Sad", '08:00', '16:00', 0.0, 0, true, 0);
insert into lekar (klinikaID, ime, prezime, username, password, email, kontakt_telefon, adresa, pocetak_radnog_vremena, kraj_radnog_vremena, prosecna_ocena, broj_ocena, izmenjena_sifra_nakon_prvog_logovanja, version) values (4, "Marko", "Lekovic", "male", "kkmm147", "marko@gmail.com", "0614452366", "Novi Sad", '09:00', '17:00', 0.0, 0, true, 0);
insert into lekar (klinikaID, ime, prezime, username, password, email, kontakt_telefon, adresa, pocetak_radnog_vremena, kraj_radnog_vremena, prosecna_ocena, broj_ocena, izmenjena_sifra_nakon_prvog_logovanja, version) values (4, "Fedor", "Milic", "fele", "zzwert45", "fedor@gmail.com", "0635899665", "Novi Sad", '07:00', '15:00', 0.0, 0, true, 0);
insert into lekar (klinikaID, ime, prezime, username, password, email, kontakt_telefon, adresa, pocetak_radnog_vremena, kraj_radnog_vremena, prosecna_ocena, broj_ocena, izmenjena_sifra_nakon_prvog_logovanja, version) values (4, "Julija", "Stankovic", "jules", "12vbbv", "julija@gmail.com", "0625894412", "Novi Sad", '07:00', '15:00', 0.0, 0, true, 0);

--TipPregleda
insert into tip_pregleda (naziv, cena) values ("Opsti pregled", 1500.0);
insert into tip_pregleda (naziv, cena) values ("Pregled ociju", 1200.0);
insert into tip_pregleda (naziv, cena) values ("Pregled srca", 2500.0);
insert into tip_pregleda (naziv, cena) values ("Pregled pluca", 1400.0);
insert into tip_pregleda (naziv, cena) values ("Pregled glave", 2000.0);
insert into tip_pregleda (naziv, cena) values ("Pregled kicme", 1800.0);
insert into tip_pregleda (naziv, cena) values ("Pregled abdomena", 1300.0);
insert into tip_pregleda (naziv, cena) values ("Pregled prostate", 1200.0);
insert into tip_pregleda (naziv, cena) values ("Ginekoloski pregled", 1200.0);
insert into tip_pregleda (naziv, cena) values ("Stomatoloski pregled", 1400.0);
insert into tip_pregleda (naziv, cena) values ("Pregled stitaste zlezde", 2000.0);

--Tipovi_Pregleda_Lekara

INSERT INTO tipovi_pregleda_lekara (lekar_id, tip_pregleda_id) VALUES (1, 1);
INSERT INTO tipovi_pregleda_lekara (lekar_id, tip_pregleda_id) VALUES (1, 2);
INSERT INTO tipovi_pregleda_lekara (lekar_id, tip_pregleda_id) VALUES (1, 5);
INSERT INTO tipovi_pregleda_lekara (lekar_id, tip_pregleda_id) VALUES (2, 1);
INSERT INTO tipovi_pregleda_lekara (lekar_id, tip_pregleda_id) VALUES (2, 3);
INSERT INTO tipovi_pregleda_lekara (lekar_id, tip_pregleda_id) VALUES (2, 4);
INSERT INTO tipovi_pregleda_lekara (lekar_id, tip_pregleda_id) VALUES (3, 1);
INSERT INTO tipovi_pregleda_lekara (lekar_id, tip_pregleda_id) VALUES (3, 6);
INSERT INTO tipovi_pregleda_lekara (lekar_id, tip_pregleda_id) VALUES (3, 7);
INSERT INTO tipovi_pregleda_lekara (lekar_id, tip_pregleda_id) VALUES (4, 1);
INSERT INTO tipovi_pregleda_lekara (lekar_id, tip_pregleda_id) VALUES (4, 8);
INSERT INTO tipovi_pregleda_lekara (lekar_id, tip_pregleda_id) VALUES (4, 9);
INSERT INTO tipovi_pregleda_lekara (lekar_id, tip_pregleda_id) VALUES (5, 1);
INSERT INTO tipovi_pregleda_lekara (lekar_id, tip_pregleda_id) VALUES (5, 10);
INSERT INTO tipovi_pregleda_lekara (lekar_id, tip_pregleda_id) VALUES (6, 1);
INSERT INTO tipovi_pregleda_lekara (lekar_id, tip_pregleda_id) VALUES (6, 11);
INSERT INTO tipovi_pregleda_lekara (lekar_id, tip_pregleda_id) VALUES (7, 1);
INSERT INTO tipovi_pregleda_lekara (lekar_id, tip_pregleda_id) VALUES (7, 3);

--MedicinskaSestra
insert into medicinska_sestra (klinikaID, ime, prezime, username, password, email, kontakt_telefon, adresa, izmenjena_sifra_nakon_prvog_logovanja) values (1, "Mira", "Miric", "miraa", "mirinasifra", "mira@gmail.com", "0645555214", "Novi Saddyyy", true);

--Sala
insert into sala (klinikaID, naziv_sale, broj_sale) values (1, "Klinika 1 - Sala za pregled", 101);
insert into sala (klinikaID, naziv_sale, broj_sale) values (1, "Klinika 1 - Sala za operaciju", 201);
insert into sala (klinikaID, naziv_sale, broj_sale) values (1, "Klinika 1 - Sala za pregled 2", 202);
insert into sala (klinikaID, naziv_sale, broj_sale) values (1, "Klinika 1 - Sala za operaciju 2", 202);
insert into sala (klinikaID, naziv_sale, broj_sale) values (3, "Klinika 3 - Sala za pregled", 10);
insert into sala (klinikaID, naziv_sale, broj_sale) values (3, "Klinika 3 - Sala za operaciju", 20);
insert into sala (klinikaID, naziv_sale, broj_sale) values (3, "Klinika 3 - Sala za pregled 2", 11);
insert into sala (klinikaID, naziv_sale, broj_sale) values (3, "Klinika 3 - Sala za operaciju 2", 21);
insert into sala (klinikaID, naziv_sale, broj_sale) values (4, "Klinika 4 - Sala za pregled", 501);
insert into sala (klinikaID, naziv_sale, broj_sale) values (4, "Klinika 4 - Sala za operaciju", 701);
insert into sala (klinikaID, naziv_sale, broj_sale) values (4, "Klinika 4 - Sala za pregled 2", 502);
insert into sala (klinikaID, naziv_sale, broj_sale) values (4, "Klinika 4 - Sala za operaciju 2", 702);
insert into sala (klinikaID, naziv_sale, broj_sale) values (4, "Klinika 4 - Sala za pregled 3", 503);
insert into sala (klinikaID, naziv_sale, broj_sale) values (4, "Klinika 4 - Sala za operaciju 3", 703);
insert into sala (klinikaID, naziv_sale, broj_sale) values (4, "Klinika 4 - Sala za pregled 4", 504);
insert into sala (klinikaID, naziv_sale, broj_sale) values (4, "Klinika 4 - Sala za operaciju 4", 704);


--Pregled
insert into pregled (kategorija_pregleda, lekarID, pacijentID, salaID, datum_pregleda, satnica_pocetak, satnica_kraj, tip_pregledaID, popust, potvrdjen, zavrsen) values ("Normalan", 1, 1, 1, '2020-06-19', '10:00', '10:29', 1, 0, false, false);
insert into pregled (kategorija_pregleda, lekarID, pacijentID, salaID, datum_pregleda, satnica_pocetak, satnica_kraj, tip_pregledaID, popust, potvrdjen, zavrsen) values ("Normalan", 2, 1, 3, '2020-06-29', '11:00', '11:29', 1, 0, false, false);
insert into pregled (kategorija_pregleda, lekarID, pacijentID, salaID, datum_pregleda, satnica_pocetak, satnica_kraj, tip_pregledaID, popust, potvrdjen, zavrsen) values ("Normalan", 3, 2, 5, '2020-06-19', '12:00', '12:29', 1, 0, false, false);
insert into pregled (kategorija_pregleda, lekarID, pacijentID, salaID, datum_pregleda, satnica_pocetak, satnica_kraj, tip_pregledaID, popust, potvrdjen, zavrsen) values ("Normalan", 4, 2, 7, '2020-06-27', '10:30', '10:59', 1, 0, false, false);
insert into pregled (kategorija_pregleda, lekarID, pacijentID, salaID, datum_pregleda, satnica_pocetak, satnica_kraj, tip_pregledaID, popust, potvrdjen, zavrsen) values ("Normalan", 6, 2, 11, '2020-07-03', '08:30', '09:29', 1, 0, false, false);

insert into pregled (kategorija_pregleda, lekarID, pacijentID, salaID, datum_pregleda, satnica_pocetak, satnica_kraj, tip_pregledaID, popust, potvrdjen, zavrsen) 
			values ("Predefinisan", 1, null, 1, '2020-06-26', '12:00', '12:59', 1, 200, false, false);
insert into pregled (kategorija_pregleda, lekarID, pacijentID, salaID, datum_pregleda, satnica_pocetak, satnica_kraj, tip_pregledaID, popust, potvrdjen, zavrsen) 
			values ("Predefinisan", 2, null, 3, '2020-06-29', '12:00', '12:29', 2, 200, false, false);
insert into pregled (kategorija_pregleda, lekarID, pacijentID, salaID, datum_pregleda, satnica_pocetak, satnica_kraj, tip_pregledaID, popust, potvrdjen, zavrsen) 
			values ("Predefinisan", 3, null, 5, '2020-07-01', '10:00', '10:59', 6, 300, false, false);
insert into pregled (kategorija_pregleda, lekarID, pacijentID, salaID, datum_pregleda, satnica_pocetak, satnica_kraj, tip_pregledaID, popust, potvrdjen, zavrsen) 
			values ("Predefinisan", 4, null, 7, '2020-07-14', '13:00', '13:59', 7, 150, false, false);
insert into pregled (kategorija_pregleda, lekarID, pacijentID, salaID, datum_pregleda, satnica_pocetak, satnica_kraj, tip_pregledaID, popust, potvrdjen, zavrsen) 
			values ("Predefinisan", 6, null, 11, '2020-06-22', '10:00', '10:29', 1, 200, false, false);
insert into pregled (kategorija_pregleda, lekarID, pacijentID, salaID, datum_pregleda, satnica_pocetak, satnica_kraj, tip_pregledaID, popust, potvrdjen, zavrsen) 
			values ("Predefinisan", 7, null, 13, '2020-07-16', '14:00', '14:29', 1, 200, false, false);

-- Predefinisan pregled
INSERT INTO predef_pregled (klinikaID, datum_pregleda, satnica_pocetak, satnica_kraj, salaID, lekarID, tip_pregledaID, popust)
					VALUES (1, '2020-06-26', '12:00', '12:59', 1, 1, 1, 200);
INSERT INTO predef_pregled (klinikaID, datum_pregleda, satnica_pocetak, satnica_kraj, salaID, lekarID, tip_pregledaID, popust)
					VALUES (1, '2020-06-29', '11:00', '11:39', 3, 2, 2, 200);
INSERT INTO predef_pregled (klinikaID, datum_pregleda, satnica_pocetak, satnica_kraj, salaID, lekarID, tip_pregledaID, popust)
					VALUES (3, '2020-07-01', '10:00', '10:59', 5, 3, 6, 300);
INSERT INTO predef_pregled (klinikaID, datum_pregleda, satnica_pocetak, satnica_kraj, salaID, lekarID, tip_pregledaID, popust)
					VALUES (3, '2020-07-14', '13:00', '13:59', 7, 4, 8, 150);
INSERT INTO predef_pregled (klinikaID, datum_pregleda, satnica_pocetak, satnica_kraj, salaID, lekarID, tip_pregledaID, popust)
					VALUES (4, '2020-06-22', '10:00', '10:29', 11, 6, 1, 200);
INSERT INTO predef_pregled (klinikaID, datum_pregleda, satnica_pocetak, satnica_kraj, salaID, lekarID, tip_pregledaID, popust)
					VALUES (4, '2020-07-16', '14:00', '14:29', 13, 7, 1, 200);					

--Operacije
insert into operacija (lekarID, datum_operacije, satnica_pocetka_operacije, satnica_kraja_operacije) values (1, '2020-03-03', '15:30', '16:00');
insert into operacija (lekarID, datum_operacije, satnica_pocetka_operacije, satnica_kraja_operacije) values (1, '2020-03-03', '11:00', '12:00');
insert into operacija (lekarID, datum_operacije, satnica_pocetka_operacije, satnica_kraja_operacije) values (1, '2020-03-03', '14:00', '15:00');

--ZahtevZaDodeluSale
insert into zahtev_za_dodelu_sale (operacijaID, salaID, datum_kreiranja_zahteva, vreme_kreiranja_zahteva, status_zahteva) values (1, 2, '2020-02-09', '10:00', "Nije_procesuiran");
insert into zahtev_za_dodelu_sale (operacijaID, salaID, datum_kreiranja_zahteva, vreme_kreiranja_zahteva, status_zahteva) values (2, 2, '2020-02-09', '10:00', "Nije_procesuiran");
insert into zahtev_za_dodelu_sale (operacijaID, salaID, datum_kreiranja_zahteva, vreme_kreiranja_zahteva, status_zahteva) values (3, 2, '2020-02-09', '10:00', "Nije_procesuiran");
