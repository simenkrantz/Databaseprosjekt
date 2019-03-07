-- ID, Navn, Beskrivelse
INSERT INTO Apparat VALUES (1, 'Benk', 'Benk med stang'), (2, 'Mølle', 'Til løping'), (3, 'Romaskin', 'Sånn man ror med'),
(4, 'Bakkeløp', 'Intervalltrening opp bakker'), (5, 'Traktordekk', 'Crossfitraritet'),
(6, 'Sykkel', 'Sånn man sykler med'), (7, 'Multiapparat', 'For diverse øvelser');

-- ID, Navn
INSERT INTO Ovelsesgruppe VALUES (1, 'Brystøvelser'),(2,'Ryggøvelser'),(3,'Beinøvelser'),(4,'Kondisjonsøvelse'),
(5,'Bicepsøvelser'),(6,'Tricepsøvelser'),(7,'Magesøvelse'),(8,'Skulderøvelser');

-- ID, Navn, Gruppe, Form, Prestasjon
INSERT INTO Ovelse VALUES (1,'Benkpress',1,8,6),(2,'Roing',3,4,1),(3,'Dips',6,8,5),
(4,'Bakkeløp',4,10,10),(5,'Jogging',4,5,3),(6,'Utfall',3,5,5),(7,'Knebøy',3,6,10),
(8,'Bicepscurl',5,7,4),(9,'Militærpress',8,1,3),(10,'Hangups',2,4,7),(11,'Triceps pushdown',6,8,8),
(12,'Sykling',4,1,4),(13,'Sittende roing',2,5,4),(14,'Pushups',1,6,7),(15,'Situps',7,8,8);

-- ØvelseID, Beskrivelse
INSERT INTO Frittstaende VALUES (3,'Dipsbeskrivelse'),(4,'Bakkeløp er bare løping'),
(5,'Jogging er kjedelig løping'),(6,'Dont skip leg day'),(7,'SQUAT'),(14,'For them abs');

-- ØvelseID, Antall kg, Antall sett, Apparat
INSERT INTO Fastmontert VALUES (1,120,10,1),(2,10,3,3),
(10,85,3,7),(12,50,3,7);

-- ID, Navn, Tlf.nr, Favorittøvelse
INSERT INTO Person VALUES (1,'Kjell Aukrust','69696969',6),(2,'Harald Heide Steen','41454554',12),
(3,'OJ (not Simpson)','98564211',9),(4,'Halvor','Not for you',1),(5,'Simen','44111425',3);

-- ID, Dato YYYY-MM-DD, Tidspunkt hh:mm:ss, Varighet [min], Treningspartner, Notat
INSERT INTO Treningsokt VALUES (1,'2019-03-02', '13:08:00', 60,NULL,'OK');
UPDATE Treningsokt
SET treningspartner = 1
WHERE oktID = 1;

-- ØktID, ØvelseID
INSERT INTO Ovelseriokt VALUES (1,1),(1,3);

SELECT oktID AS Økt, dato, tidspunkt, varighet AS Øktvarighet, Person.navn AS Treningspartner, Ovelse.navn AS Øvelse 
FROM ((Treningsokt NATURAL JOIN Ovelseriokt) NATURAL JOIN Ovelse) INNER JOIN Person ON Treningsokt.treningspartner = Person.personID;