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
("0000A", "Visita cardiologo", "Visita dal cardiologo ad Alife", "53A9E6", 0 , false, "08/01/2024", "11:00", "13:00", "silvanacafaro256@gmail.com"),
("1000A", "Bar", "Al blau con tresy isa e simona", "21AA90", 0 , true, "25/02/2024", "17:00", "18:30", "silvanacafaro256@gmail.com"),
("2000A", "parrucchiera", null, "AA231B", 2 , true, "10/01/2024", "10:00", "12:00", "Maria34454@gmail.com"), 
("3000A", "Lavare piatti", "non te li dimenticareeee", "2180AA", 0 , false, "08/01/2024", "14:00", "15:00", "emanuele453eduare@libero.it"),
("4000A", "Serata cinema", null, "D5A6BD", 3 , false, "01/02/2024", "21:00", "23:00", "silvanacafaro256@gmail.com"),
("5000A", "Esame", "esame di FIA", "BDD5A6", 0 , false, "14/02/2024", "15:00", "17:00", "potty@hotmail.com"), 
("6000A", "Evento Gala", "Evento Gala a Milano Via Roma", "ADF5FF", 0 , false, "10/04/2024", "21:00", "23:00", "silvanasessa@gmail.com"),
("7000A", "Esame Chimica", "Esame scritto di Fisica 1", "CDFFAD", 0, true, "31/01/2024", "09:00", "13:00", "alessandrofisio@libero.it"), 
("8000A", "Allenamento", "Allenamento in Palestra", "CDFFAD", 1, true, "15/08/2024", "13:00", "15:00", "isabellasessa2901@gmail.com"),
("9000A", "Sistemare armadio", "Mettere in ordine l'armadio", "E0ADFF", 2, true, "10/01/2024", "09:00", "10:00", "formula1fan@gmail.com"),
("9100A", "Portare dolci a Silvana", "Portare la torta di mele a silvana per la scommessa", "45db00", 3, false, "20/03/2024", "15:00", "16:00", "potty@hotmail.com");

INSERT INTO Calendario VALUES
/*codice calendario, nome , colore*/
("A0001", "Lavoro","e69138"),
("A0002", "Lavoro Bar","45e638"),
("A0003", "Casa","45e638"),
("A0004", "Studio","d5a6bd"),
("A0005", "Tempo Libero","ffe599"),
("A0006", "Lavoro", "f44336"),
("A0007", "Studio", "3636f4"),
("A0008", "Ufficio", "36f484"),
("A0009", "Personale", "fc006f"),
("A0010", "Casa", "f1c232");

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
/*nome, durata, priorita */
("AA000", "Studiare", 180, 1, "isabella.43@libero.it"),
("AA001", "Vedermi con gli amici", 60, 3, "Maria34454@gmail.com"),
("AA002", "Andare a fare spesa", 90, 2, "potty@hotmail.com"),
("AA003", "Correre", 120, 4, "lolliop@gmail.com"),
("AA004", "Studiare", 180, 2, "francesomanlija@hotmail.com"),
("AA005", "Studiare", 120, 1, "fernandanumber@gmail.com"),
("AA006", "Sistemare", 60, 4, "alessandrofisio@libero.it"),
("AA007", "Finire progetto", 100, 2, "emanuele453eduare@libero.it"),
("AA008", "Leggere", 180, 5, "isabellasessa2901@gmail.com"),
("AA009", "Esercizi" , 180, 4, "silvanacafaro256@gmail.com");

INSERT INTO Inserimento VALUES
/*codice calendario, codice evento */
("A0001", "0000A"),
("A0001", "1000A"),
("A0001", "2000A"),
("A0002", "3000A"),
("A0002", "4000A"),
("A0002", "5000A"),
("A0003", "6000A"),
("A0004", "7000A"),
("A0004", "8000A"),
("A0005", "9000A");

INSERT INTO Creazione VALUES
/*email, codice*/
("alessandrofisio@libero.it","A0001"),
("formula1fan@gmail.com","A0002"),
("formula1fan@gmail.com","A0003"),
("silvanasessa@gmail.com","A0004"),
("gennyfoglia71@gmail.com","A0005"),
("silvanacafaro256@gmail.com","A0006"),
("silvanacafaro256@gmail.com","A0007"),
("gennyfoglia71@gmail.com","A0008"),
("isabellasessa2901@gmail.com","A0009"),
("isabellasessa2901@gmail.com","A0010");

