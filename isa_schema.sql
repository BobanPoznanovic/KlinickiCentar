DROP TABLE IF EXISTS ADMIN_KLINICKOG_CENTRA;
DROP TABLE IF EXISTS ADMIN_KLINIKE;
DROP TABLE IF EXISTS CENOVNIK_KLINIKE;
DROP TABLE IF EXISTS ZAHTEV_ZA_ODSUSTVO;
DROP TABLE IF EXISTS MEDICINSKA_SESTRA;
DROP TABLE IF EXISTS SPISAK_LEKARA_NA_OPERACIJI;
DROP TABLE IF EXISTS OPERACIJA;
DROP TABLE IF EXISTS LEKAR;
DROP TABLE IF EXISTS SALA;
DROP TABLE IF EXISTS KLINKA;
DROP TABLE IF EXISTS SIFARNIK_DIJAGNOZA;
DROP TABLE IF EXISTS LEK;
DROP TABLE IF EXISTS ZAHTEV_ZA_REGISTRACIJU;
DROP TABLE IF EXISTS SPECIJALIZACIJA_LEKARA;


CREATE TABLE ADMIN_KLINICKOG_CENTRA (
	adminID int IDENTITY(1,1) PRIMARY KEY,
	ime varchar(255),
	prezime varchar(255),
	username varchar(255),
	password varchar(255),
	email varchar(255),
	kontakt_telefon varchar(255),
	adresa varchar(255),
	izmenjana_sifra_nakon_prvog_logovanja bit
);

CREATE TABLE KLINKA (
	klinikaID int IDENTITY(1,1) PRIMARY KEY,
	naziv varchar(255),
	adresa varchar(255),
	opis varchar(1000)
);

CREATE TABLE CENOVNIK_KLINIKE (
	cenovnik_klinikeID int IDENTITY(1,1) PRIMARY KEY,
	klinikaID int,
	--tip pregleda - posebna tabela
	cena_pregleda money
);

CREATE TABLE ADMIN_KLINIKE (
	adminID int IDENTITY(1,1) PRIMARY KEY,
	klinikaID int,
	ime varchar(255),
	prezime varchar(255),
	username varchar(255),
	password varchar(255),
	email varchar(255),
	kontakt_telefon varchar(255),
	adresa varchar(255),
	izmenjana_sifra_nakon_prvog_logovanja bit,
	CONSTRAINT fk_admin_klinikaID FOREIGN KEY (klinikaID) REFERENCES KLINKA(klinikaID)
);

CREATE TABLE SIFARNIK_DIJAGNOZA (
	dijagnozaID int IDENTITY(1,1) PRIMARY KEY,
	naziv varchar(255)
);

CREATE TABLE LEK (
	lekID int IDENTITY(1,1) PRIMARY KEY,
	naziv varchar(255),
	proizvodjac varchar(255),
	doza varchar(255)
);

CREATE TABLE ZAHTEV_ZA_REGISTRACIJU (
	zahtevID int IDENTITY(1,1) PRIMARY KEY,
	broj_osiguranika int UNIQUE,
	email varchar(255),
	password varchar(255),
	ime varchar(255),
	prezime varchar(255),
	adresa varchar(255),
	grad varchar(255),
	drzava varchar(255),
	broj_telefona varchar(255),
	status_zahteva varchar(255) CHECK (status_zahteva IN ('Na_cekanju','Odobren','Odbijen')),
	razlog_odbijanja varchar(1000)
);

CREATE TABLE SPECIJALIZACIJA_LEKARA (
	specijalizacijaID int IDENTITY(1,1) PRIMARY KEY,
	naziv_specijalizacije varchar(255)
);

CREATE TABLE LEKAR (
	lekarID int IDENTITY(1,1) PRIMARY KEY,
	specijalizacijaID int,
	klinikaID int,
	ime varchar(255),
	prezime varchar(255),
	username varchar(255),
	password varchar(255),
	email varchar(255),
	kontakt_telefon varchar(255),
	adresa varchar(255),
	izmenjana_sifra_nakon_prvog_logovanja bit,
	CONSTRAINT fk_specijalizacijeID FOREIGN KEY (specijalizacijaID) REFERENCES SPECIJALIZACIJA_LEKARA(specijalizacijaID),
	CONSTRAINT fk_lekar_klinikaID FOREIGN KEY (klinikaID) REFERENCES KLINKA(klinikaID)
);

CREATE TABLE MEDICINSKA_SESTRA (
	medicinska_sestraID int IDENTITY(1,1) PRIMARY KEY,
	klinikaID int,
	ime varchar(255),
	prezime varchar(255),
	username varchar(255),
	password varchar(255),
	email varchar(255),
	kontakt_telefon varchar(255),
	adresa varchar(255),
	izmenjana_sifra_nakon_prvog_logovanja bit,
	CONSTRAINT fk_medicinska_sestra_klinikaID FOREIGN KEY (klinikaID) REFERENCES KLINKA(klinikaID)
);

CREATE TABLE SALA (
	salaID int IDENTITY(1,1) PRIMARY KEY,
	klinikaID int,
	naziv_sale varchar(255),
	broj_sale int,
	CONSTRAINT fk_sala_klinikaID FOREIGN KEY (klinikaID) REFERENCES KLINKA(klinikaID)
);

CREATE TABLE OPERACIJA (
	operacijaID int IDENTITY(1,1) PRIMARY KEY,
	lekarID int, --lekar koji je zakazao operaciju
	datum_operacije date,
	satnica_pocetka_operacije time,
	satnica_kraja_operacije time,
	salaID int,
	CONSTRAINT fk_operacija_lekarID FOREIGN KEY (lekarID) REFERENCES LEKAR(lekarID),
	CONSTRAINT fk_operacija_salaID FOREIGN KEY (salaID) REFERENCES SALA(salaID)
);

CREATE TABLE SPISAK_LEKARA_NA_OPERACIJI (
	spisakID int IDENTITY(1,1) PRIMARY KEY,
	operacijaID int,
	lekarID int,
	CONSTRAINT fk_spisak_operacijaID FOREIGN KEY (operacijaID) REFERENCES OPERACIJA(operacijaID),
	CONSTRAINT fk_spisak_lekarID FOREIGN KEY (lekarID) REFERENCES LEKAR(lekarID)
);

CREATE TABLE ZAHTEV_ZA_ODSUSTVO (
	zahtevID int IDENTITY(1,1) PRIMARY KEY,
	podnosilac_zahtevaID int,
	tip_odsustva varchar(255) CHECK (tip_odsustva IN ('Godisnji_odmor','Odsustvo')),
	datum_pocetka date,
	datum_kraja date,
	status_odobrenja varchar(255) CHECK (status_odobrenja IN ('Na_cekanju','Odobren','Odbijen')),
	razlog_odbijanja varchar(255),
	CONSTRAINT fk_odsustvo_lekarID FOREIGN KEY (podnosilac_zahtevaID) REFERENCES LEKAR(lekarID),
	CONSTRAINT fk_odsustvo_medicinska_sestraID FOREIGN KEY (podnosilac_zahtevaID) REFERENCES MEDICINSKA_SESTRA(medicinska_sestraID)
);