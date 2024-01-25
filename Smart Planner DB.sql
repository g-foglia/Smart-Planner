DROP DATABASE IF EXISTS smartplannerdb;
CREATE DATABASE smartplannerdb;
USE smartplannerdb;

CREATE TABLE Utente(
	email varchar(30) primary key,
    password_ varchar(30) not null,
	nome varchar(20) not null,
    cognome varchar(20) not null,
    username varchar(20) not null,
    dataDiNascita varchar(12) not null
);

CREATE TABLE Calendario(
	codiceCalendario int primary key auto_increment,
    nomeCalendario varchar(30) not null,
    coloreCalendario varchar(6) not null
);

CREATE TABLE Evento(
	codiceEvento int primary key auto_increment,
	nomeEvento varchar(30),
    descrizione varchar(200),
    coloreEvento varchar(6) not null,
    periodicita int not null,
    notifiche boolean not null,
    dataEvento varchar(12) not null,
    orarioInizio varchar(5) not null,
    orarioFine varchar(5) not null,
    emailE varchar(30) not null,
    FOREIGN KEY (emailE) REFERENCES Utente(email)
    ON DELETE CASCADE
);

CREATE TABLE Lista(
	emailUL varchar(30) primary key,
    coloreLista varchar(6) not null,
    FOREIGN KEY (emailUL) REFERENCES Utente(email)
    ON DELETE CASCADE
);

CREATE TABLE Impegno(
	codiceImpegno int primary key auto_increment,
	nomeImpegno varchar(30),
    durataImpegno int not null,
    prioritaImpegno int not null,
    emailUI varchar(30),
    FOREIGN KEY (emailUI) REFERENCES Lista(emailUL)
    ON DELETE CASCADE
);

CREATE TABLE Inserimento(
	codiceCalendarioI int not null,
    codiceEventoI int not null,
    PRIMARY KEY(codiceCalendarioI, codiceEventoI),
    FOREIGN KEY (codiceCalendarioI) REFERENCES Calendario(codiceCalendario) on delete cascade,
    FOREIGN KEY (codiceEventoI) REFERENCES Evento(codiceEvento)
    ON DELETE CASCADE
);
CREATE TABLE Creazione(
	emailC varchar(30) not null,
    codiceCalendarioC int not null,
    PRIMARY KEY(emailC, codiceCalendarioC),
    FOREIGN KEY (emailC) REFERENCES Utente(email) on delete cascade,
    FOREIGN KEY (codiceCalendarioC) REFERENCES Calendario(codiceCalendario)    
    ON DELETE CASCADE
);

 
