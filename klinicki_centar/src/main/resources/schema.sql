USE db_example;

DROP TABLE IF EXISTS IZVESTAJ_PREGLEDA;
DROP TABLE IF EXISTS PREGLED;
DROP TABLE IF EXISTS PREDEF_PREGLED;
DROP TABLE IF EXISTS TIPOVI_PREGLEDA_LEKARA;
DROP TABLE IF EXISTS ZAHTEV_ZA_DODELU_SALE;
DROP TABLE IF EXISTS ZAHTEV_ZA_PREGLED;
DROP TABLE IF EXISTS ALERGIJE_PACIJENTA;
DROP TABLE IF EXISTS ZDRAVSTVENI_KARTON;
DROP TABLE IF EXISTS PACIJENT;
DROP TABLE IF EXISTS ADMIN_KLINICKOG_CENTRA;
DROP TABLE IF EXISTS ADMIN_KLINIKE;
DROP TABLE IF EXISTS CENOVNIK_KLINIKE;
DROP TABLE IF EXISTS TIP_PREGLEDA;
DROP TABLE IF EXISTS ZAHTEV_ZA_ODSUSTVO;
DROP TABLE IF EXISTS MEDICINSKA_SESTRA;
DROP TABLE IF EXISTS SPISAK_LEKARA_NA_OPERACIJI;
DROP TABLE IF EXISTS OPERACIJA;
DROP TABLE IF EXISTS LEKAR;
DROP TABLE IF EXISTS SALA;
DROP TABLE IF EXISTS KLINIKA;
DROP TABLE IF EXISTS SIFARNIK_DIJAGNOZA;
DROP TABLE IF EXISTS LEK;
DROP TABLE IF EXISTS ZAHTEV_ZA_REGISTRACIJU;
DROP TABLE IF EXISTS SPECIJALIZACIJA_LEKARA;

CREATE TABLE PACIJENT (
	pacijentID int AUTO_INCREMENT PRIMARY KEY,
	broj_osiguranika int UNIQUE,
    email varchar(255),
    password varchar(255),
    ime varchar(255),
    prezime varchar(255),
    adresa varchar(255),
    grad varchar(255),
    drzava varchar(255),
    kontakt_telefon varchar(255),
    zdravstveni_kartonID int,
    aktivan bit,
    version int
);

CREATE TABLE ZDRAVSTVENI_KARTON (
	kartonID int AUTO_INCREMENT PRIMARY KEY,
    pacijentID int,
    datum_rodjenja date,
    visina_pacijenta float,
    tezina_pacijenta float,
    krvna_grupa varchar(5),
    dioptrija varchar(50),
    CONSTRAINT fk_karton_pacijentID FOREIGN KEY (pacijentID) REFERENCES PACIJENT(pacijentID)
);

CREATE TABLE ADMIN_KLINICKOG_CENTRA (
	adminID int AUTO_INCREMENT PRIMARY KEY,
	ime varchar(255),
	prezime varchar(255),
	username varchar(255),
	password varchar(255),
	email varchar(255),
	kontakt_telefon varchar(255),
	adresa varchar(255),
	izmenjana_sifra_nakon_prvog_logovanja bit
);

CREATE TABLE KLINIKA (
	klinikaID int AUTO_INCREMENT PRIMARY KEY,
	naziv varchar(255),
	adresa varchar(255),
    grad varchar(255),
	opis varchar(1000),
    prosecna_ocena float,
    broj_ocena int
);

CREATE TABLE TIP_PREGLEDA (
	tip_pregledaID int AUTO_INCREMENT PRIMARY KEY,
    naziv varchar(255),
    cena float
);

CREATE TABLE CENOVNIK_KLINIKE (
	cenovnik_klinikeID int AUTO_INCREMENT PRIMARY KEY,
	klinikaID int,
	tip_pregledaID int,
    CONSTRAINT fk_cenovnik_tip_pregledaID FOREIGN KEY (tip_pregledaID) REFERENCES TIP_PREGLEDA(tip_pregledaID)
);

CREATE TABLE ADMIN_KLINIKE (
	adminID int AUTO_INCREMENT PRIMARY KEY,
	klinikaID int,
	ime varchar(255),
	prezime varchar(255),
	username varchar(255),
	password varchar(255),
	email varchar(255),
	kontakt_telefon varchar(255),
	adresa varchar(255),
	izmenjana_sifra_nakon_prvog_logovanja bit,
	CONSTRAINT fk_admin_klinikaID FOREIGN KEY (klinikaID) REFERENCES KLINIKA(klinikaID)
);

CREATE TABLE SIFARNIK_DIJAGNOZA (
	dijagnozaID int AUTO_INCREMENT PRIMARY KEY,
	naziv varchar(255)
);

CREATE TABLE LEK (
	lekID int AUTO_INCREMENT PRIMARY KEY,
	naziv varchar(255),
	proizvodjac varchar(255),
	doza varchar(255)
);

CREATE TABLE ALERGIJE_PACIJENTA (
	alergija_pacijentID int AUTO_INCREMENT PRIMARY KEY,
    pacijentID int,
    lekID int,
    CONSTRAINT fk_alergije_pacijentID FOREIGN KEY (pacijentID) REFERENCES PACIJENT(pacijentID),
    CONSTRAINT fk_alergije_lekID FOREIGN KEY (lekID) REFERENCES LEK(lekID)
);

CREATE TABLE ZAHTEV_ZA_REGISTRACIJU (
	zahtevID int AUTO_INCREMENT PRIMARY KEY,
	broj_osiguranika int UNIQUE,
	email varchar(255),
	password varchar(255),
	ime varchar(255),
	prezime varchar(255),
	adresa varchar(255),
	grad varchar(255),
	drzava varchar(255),
	broj_telefona varchar(255),
	-- status_zahteva varchar(255) CHECK (status_zahteva IN ('Na_cekanju','Odobren','Odbijen')),
	status_zahteva ENUM('Na_cekanju','Odobren','Odbijen' ),
	razlog_odbijanja varchar(1000)
);

CREATE TABLE SPECIJALIZACIJA_LEKARA (
	specijalizacijaID int AUTO_INCREMENT PRIMARY KEY,
	naziv_specijalizacije varchar(255)
);

CREATE TABLE LEKAR (
	lekarID int AUTO_INCREMENT PRIMARY KEY,
	--specijalizacijaID int,
	klinikaID int,
	ime varchar(255),
	prezime varchar(255),
	username varchar(255),
	password varchar(255),
	email varchar(255),
	kontakt_telefon varchar(255),
	adresa varchar(255),
	pocetak_radnog_vremena time,
	kraj_radnog_vremena time,
	prosecna_ocena float,
    broj_ocena int,
	izmenjena_sifra_nakon_prvog_logovanja bit,
	--CONSTRAINT fk_specijalizacijeID FOREIGN KEY (specijalizacijaID) REFERENCES SPECIJALIZACIJA_LEKARA(specijalizacijaID),
	CONSTRAINT fk_lekar_klinikaID FOREIGN KEY (klinikaID) REFERENCES KLINIKA(klinikaID)
);

CREATE TABLE TIPOVI_PREGLEDA_LEKARA (
	lekar_id int,
    tip_pregleda_id int,
    CONSTRAINT fk_tip_pregleda_tip_pregledaID FOREIGN KEY (tip_pregleda_id) REFERENCES TIP_PREGLEDA(tip_pregledaID),
    CONSTRAINT fk_tip_pregleda_lekarID FOREIGN KEY (lekar_id) REFERENCES LEKAR(lekarID)
);

CREATE TABLE MEDICINSKA_SESTRA (
	medicinska_sestraID int AUTO_INCREMENT PRIMARY KEY,
	klinikaID int,
	ime varchar(255),
	prezime varchar(255),
	username varchar(255),
	password varchar(255),
	email varchar(255),
	kontakt_telefon varchar(255),
	adresa varchar(255),
	izmenjena_sifra_nakon_prvog_logovanja bit,
	CONSTRAINT fk_medicinska_sestra_klinikaID FOREIGN KEY (klinikaID) REFERENCES KLINIKA(klinikaID)
);

CREATE TABLE SALA (
	salaID int AUTO_INCREMENT PRIMARY KEY,
	klinikaID int,
	naziv_sale varchar(255),
	broj_sale int,
	CONSTRAINT fk_sala_klinikaID FOREIGN KEY (klinikaID) REFERENCES KLINIKA(klinikaID)
);

CREATE TABLE OPERACIJA (
	operacijaID int AUTO_INCREMENT PRIMARY KEY,
	lekarID int, -- lekar koji je zakazao operaciju --
	datum_operacije date,
	satnica_pocetka_operacije time,
	satnica_kraja_operacije time,
	salaID int,
	CONSTRAINT fk_operacija_lekarID FOREIGN KEY (lekarID) REFERENCES LEKAR(lekarID),
	CONSTRAINT fk_operacija_salaID FOREIGN KEY (salaID) REFERENCES SALA(salaID)
);

CREATE TABLE SPISAK_LEKARA_NA_OPERACIJI (
	spisakID int AUTO_INCREMENT PRIMARY KEY,
	operacijaID int,
	lekarID int,
	CONSTRAINT fk_spisak_operacijaID FOREIGN KEY (operacijaID) REFERENCES OPERACIJA(operacijaID),
	CONSTRAINT fk_spisak_lekarID FOREIGN KEY (lekarID) REFERENCES LEKAR(lekarID)
);

CREATE TABLE ZAHTEV_ZA_ODSUSTVO (
	zahtevID int AUTO_INCREMENT PRIMARY KEY,
	podnosilac_zahtevaID int,
	tip_odsustva varchar(255) CHECK (tip_odsustva IN ('Godisnji_odmor','Odsustvo')),
	datum_pocetka date,
	datum_kraja date,
	status_odobrenja varchar(255) CHECK (status_odobrenja IN ('Na_cekanju','Odobren','Odbijen')),
	razlog_odbijanja varchar(255),
	CONSTRAINT fk_odsustvo_medicinska_sestraID FOREIGN KEY (podnosilac_zahtevaID) REFERENCES MEDICINSKA_SESTRA(medicinska_sestraID)
);

CREATE TABLE ZAHTEV_ZA_PREGLED (
	zahtevID int AUTO_INCREMENT PRIMARY KEY,
    klinikaID int,
    pacijentID int,
    datum date,
    satnica_pocetak time,
    satnica_kraj time,
    lekarID int,
    tip_pregledaID int,
    CONSTRAINT fk_zahtev_za_pregled_klinikaID FOREIGN KEY (klinikaID) REFERENCES KLINIKA(klinikaID),
    CONSTRAINT fk_zahtev_za_pregled_pacijentID FOREIGN KEY (pacijentID) REFERENCES PACIJENT(pacijentID),
    CONSTRAINT fk_zahtev_za_pregled_lekarID FOREIGN KEY (lekarID) REFERENCES LEKAR(lekarID),
    CONSTRAINT fk_zahtev_za_pregled_tip_pregledaID FOREIGN KEY (tip_pregledaID) REFERENCES TIP_PREGLEDA(tip_pregledaID)
);

CREATE TABLE ZAHTEV_ZA_DODELU_SALE (
	zahtevID int AUTO_INCREMENT PRIMARY KEY,
    operacijaID int,
    salaID int,
    datum_kreiranja_zahteva date,
    vreme_kreiranja_zahteva time,
    status_zahteva varchar(255) CHECK (status_zahteva IN ('Nije_procesuiran','Admin_odobrio','Admin_pomerio','Algoritam_odobrio','Algoritam_pomerio')),
    CONSTRAINT fk_zahtev_za_dodelu_sale_zahtev_za_pregledID FOREIGN KEY (operacijaID) REFERENCES OPERACIJA(operacijaID),
    CONSTRAINT fk_zahtev_za_dodelu_sale_salaID FOREIGN KEY (salaID) REFERENCES SALA(salaID)
);

CREATE TABLE PREDEF_PREGLED (
	predef_pregledID int AUTO_INCREMENT PRIMARY KEY,
    klinikaID int,
    datum_pregleda date,
    satnica_pocetak time,
    satnica_kraj time,
    salaID int,
    lekarID int,
    tip_pregledaID int,
    popust float,
    CONSTRAINT fk_predef_pregled_klinikaID FOREIGN KEY (klinikaID) REFERENCES KLINIKA(klinikaID),
    CONSTRAINT fk_predef_pregled_salaID FOREIGN KEY (salaID) REFERENCES SALA(salaID),
    CONSTRAINT fk_predef_pregled_lekarID FOREIGN KEY (lekarID) REFERENCES LEKAR(lekarID),
    CONSTRAINT fk_predef_pregled_tip_pregledaID FOREIGN KEY (tip_pregledaID) REFERENCES TIP_PREGLEDA(tip_pregledaID)
);

CREATE TABLE PREGLED (
	pregledID int AUTO_INCREMENT PRIMARY KEY,
    kategorija_pregleda varchar(255) CHECK (kategorija_pregleda in ('Predefinisan','Normalan')),
    lekarID int,
    pacijentID int,
    salaID int,
    datum_pregleda date,
    satnica_pocetak time,
    satnica_kraj time,
    tip_pregledaID int,
    popust float,
    zakazan_dodatan_pregled bool,
    zakazana_operacija bool,
    CONSTRAINT fk_pregled_lekarID FOREIGN KEY (lekarID) REFERENCES LEKAR(lekarID),
    CONSTRAINT fk_pregled_pacijentID FOREIGN KEY (pacijentID) REFERENCES PACIJENT(pacijentID),
    CONSTRAINT fk_pregled_salaID FOREIGN KEY (salaID) REFERENCES SALA(salaID),
    CONSTRAINT fk_pregled_tip_pregledaID FOREIGN KEY (tip_pregledaID) REFERENCES TIP_PREGLEDA(tip_pregledaID)
);

CREATE TABLE IZVESTAJ_PREGLEDA (
	izvestaj_pregledaID int AUTO_INCREMENT PRIMARY KEY,
    pregledID int,
    dijagnozaID int,
    opis_pregleda varchar(1000),
    CONSTRAINT fk_izvestaj_pregleda_pregledID FOREIGN KEY (pregledID) REFERENCES PREGLED(pregledID),
    CONSTRAINT fk_izvestaj_pregleda_dijagnozaID FOREIGN KEY (dijagnozaID) REFERENCES SIFARNIK_DIJAGNOZA(dijagnozaID)
);