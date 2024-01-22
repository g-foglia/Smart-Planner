use smartplannerdb;

INSERT INTO Utente VALUES
/* email, password, nome, cognome, username, data di nascita*/
("silvanacafaro256@gmail.com", "Zzilv1234!", "Silvana", "Cafaro", "zzzzilv", "11/10/2002"),
("isabellasessa2901@gmail.com", "Gattini01@", "Isabella Maria", "Sessa", "whereisab", "26/09/2001"),
("gennyfoglia71@gmail.com", "martinaTiAmo03!", "Gennaro", "Foglia", "gennyfoglia", "01/09/2002"),
("formula1fan@gmail.com", "Formula1Lover#", "Michele", "Fragola", "Ricciardo02", "10/09/2002"),
("silvanasessa@gmail.com", "12345678?", "Silvana", "Sessa", "sssss", "25/04/2003"),
("isabella.43@libero.it", "abab1919!!", "Isabella", "Raucci", "Lovely:3", "17/07/1999"),
("Maria34454@gmail.com", "Passowrd1234@!", "Maria", "De Masi", "mary", "06/06/2000"),
("potty@hotmail.com", "@lupo@8", "Enrico", "Cafaro", "Potter", "22/02/1997"),
("lolliop@gmail.com", "NonLoSo03?", "Aurora", "Merola", "caramellina", "05/04/2001"),
("francesomanlija@hotmail.com", "patatine098#", "Francesco", "Ferrante", "ferry99", "29/03/1999"),
("fernandanumber@gmail.com", "numero0099", "Fernando", "Vigorito", "vigorsol", "26/10/1998"),
("alessandrofisio@libero.it", "Pioggia34tiamoA", "Alessandro", "Fisio", "AlexFix", "30/01/2000"),
("emanuele453eduare@libero.it", "IoEluixSempre453", "Emanuele", "Friello", "friariello", "16/08/1994");


INSERT INTO Evento VALUES
/*codice, nome, descrizione, colore, periodicita, notifiche, data, or inizio, or fine, email*/
(null, "Visita cardiologo", "Visita dal cardiologo ad Alife", "53A9E6", 0 , false, "08/01/2024", "11:00", "13:00", "silvanacafaro256@gmail.com"),
(null, "Bar", "Al blau con tresy isa e simona", "21AA90", 0 , true, "25/02/2024", "17:00", "18:30", "silvanacafaro256@gmail.com"),
(null, "parrucchiera", null, "AA231B", 2 , true, "10/01/2024", "10:00", "12:00", "Maria34454@gmail.com"), 
(null, "Lavare piatti", "non te li dimenticareeee", "2180AA", 0 , false, "08/01/2024", "14:00", "15:00", "emanuele453eduare@libero.it"),
(null, "Serata cinema", null, "D5A6BD", 3 , false, "01/02/2024", "21:00", "23:00", "silvanacafaro256@gmail.com"),
(null, "Esame", "esame di FIA", "BDD5A6", 0 , false, "14/02/2024", "15:00", "17:00", "potty@hotmail.com"), 
(null, "Evento Gala", "Evento Gala a Milano Via Roma", "ADF5FF", 0 , false, "10/04/2024", "21:00", "23:00", "silvanasessa@gmail.com"),
(null, "Esame Chimica", "Esame scritto di Fisica 1", "CDFFAD", 0, true, "31/01/2024", "09:00", "13:00", "alessandrofisio@libero.it"), 
(null, "Allenamento", "Allenamento in Palestra", "CDFFAD", 1, true, "15/08/2024", "13:00", "15:00", "isabellasessa2901@gmail.com"),
(null, "Sistemare armadio", "Mettere in ordine l'armadio", "E0ADFF", 2, true, "10/01/2024", "09:00", "10:00", "formula1fan@gmail.com"),
(null, "Portare dolci a Silvana", "Portare la torta di mele a silvana per la scommessa", "45db00", 3, false, "20/03/2024", "15:00", "16:00", "potty@hotmail.com");

INSERT INTO Calendario VALUES
/*codice calendario, nome , colore*/
(null, "Lavoro","e69138"),
(null, "Lavoro Bar","45e638"),
(null, "Casa","45e638"),
(null, "Studio","d5a6bd"),
(null, "Tempo Libero","ffe599"),
(null, "Lavoro", "f44336"),
(null, "Studio", "3636f4"),
(null, "Ufficio", "36f484"),
(null, "Personale", "fc006f"),
(null, "Casa", "f1c232");

INSERT INTO Lista VALUES
/* email, colore */
("isabella.43@libero.it","d5a6bd"), 
("Maria34454@gmail.com","f1c232"),
("potty@hotmail.com","fc006f"),
("lolliop@gmail.com","45e638"),
("francesomanlija@hotmail.com","3636f4"),
("fernandanumber@gmail.com","e69138"),
("alessandrofisio@libero.it","d5a6bd"),
("emanuele453eduare@libero.it","fc006f"),
("isabellasessa2901@gmail.com","2986cc"),
("silvanacafaro256@gmail.com","cce7ff"),
("gennyfoglia71@gmail.com","e06666"),
("formula1fan@gmail.com","e69138"),
("silvanasessa@gmail.com","8e7cc3");

 INSERT INTO Impegno VALUES
/*codice, nome, durata, priorita */
(null, "Studiare", 180, 1, "isabella.43@libero.it"),
(null, "Vedermi con gli amici", 60, 3, "Maria34454@gmail.com"),
(null, "Andare a fare spesa", 90, 2, "potty@hotmail.com"),
(null, "Correre", 120, 4, "lolliop@gmail.com"),
(null, "Studiare", 180, 2, "francesomanlija@hotmail.com"),
(null, "Studiare", 120, 1, "fernandanumber@gmail.com"),
(null, "Sistemare", 60, 4, "alessandrofisio@libero.it"),
(null, "Finire progetto", 100, 2, "emanuele453eduare@libero.it"),
(null, "Leggere", 180, 5, "isabellasessa2901@gmail.com"),
(null, "Esercizi" , 180, 4, "silvanacafaro256@gmail.com");

INSERT INTO Inserimento VALUES
/*codice calendario, codice evento */
("1", "1"),
("1", "2"),
("2", "3"),
("2", "4"),
("2", "5"),
("3", "6"),
("4", "7"),
("4", "8"),
("5", "9");

INSERT INTO Creazione VALUES
/*email, codice*/
("alessandrofisio@libero.it","1"),
("formula1fan@gmail.com","2"),
("formula1fan@gmail.com","3"),
("silvanasessa@gmail.com","4"),
("gennyfoglia71@gmail.com","5"),
("silvanacafaro256@gmail.com","6"),
("silvanacafaro256@gmail.com","7"),
("gennyfoglia71@gmail.com","8"),
("isabellasessa2901@gmail.com","9"),
("isabellasessa2901@gmail.com","10");

