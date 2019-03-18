-- Navn, Beskrivelse
INSERT INTO Apparat VALUES ('Benk', 'Benk med stang'), ('Mølle', 'Til løping'), ('Romaskin', 'Sånn man ror med'),
('Bakkeløp', 'Intervalltrening opp bakker'), ('Traktordekk', 'Crossfitraritet'),
('Sykkel', 'Sånn man sykler med'), ('Multiapparat', 'For diverse øvelser');

-- Navn
INSERT INTO Ovelsesgruppe VALUES ('Brystøvelser'),('Ryggøvelser'),('Beinøvelser'),('Kondisjonsøvelse'),
('Bicepsøvelser'),('Tricepsøvelser'),('Magesøvelse'),('Skulderøvelser');

-- Navn, Gruppe
-- INSERT INTO Ovelse VALUES ('Benkpress',1),('Roing',3),('Dips',6),
-- ('Bakkeløp',4),('Jogging',4),('Utfall',3),('Knebøy',3),
-- ('Bicepscurl',5),('Militærpress',8),('Hangups',2),('Triceps pushdown',6),
-- ('Sykling',4),('Sittende roing',2),('Pushups',1),('Situps',7);

-- ØvelseID, Beskrivelse
-- INSERT INTO Frittstaende VALUES (3,'Dipsbeskrivelse'),(4,'Bakkeløp er bare løping'),
-- (5,'Jogging er kjedelig løping'),(6,'Dont skip leg day'),(7,'SQUAT'),(14,'For them abs');

-- ØvelseID, Antall kg, Antall sett, Apparat
-- INSERT INTO Fastmontert VALUES (1,120,10,1),(2,10,3,3),
-- (10,85,3,7),(12,50,3,7);

-- Navn, Tlf.nr, Favorittøvelse
INSERT INTO Person VALUES ('Kjell Aukrust',69696969,NULL),('Harald Heide Steen',41454554,NULL),
('OJ (not Simpson)',98564211,NULL),('Halvor',97470077,NULL),('Simen',44111425,NULL),('Turid-Laila',73805520,NULL);

-- Dato YYYY-MM-DD, Tidspunkt hh:mm:ss, Varighet [min], Form, Prestasjon, Treningspartner, Notat
INSERT INTO Treningsokt VALUES ('2019-03-02', '13:08:00', 60, 9, 7,NULL,'OK'),
('2018-12-29','10:08:34',35,4,8,3,'God kok, Tutten kjører svett push'),('2010-08-07','22:09:00',120,10,10,NULL,'Kai prepper prottispulver i garderoben, mæget god S'),
('2018-12-28','08:00:10', 55,2,3,4,'Spysjuk etter et heidundrandes kalas med Roger, men gønnsa må pumpes'),('2019-01:30','12:23:56',67,10,10,6,'Turid-Laila på mølla må jo bli bra'),
('2016-10-14','14:45:32',14,1,2,2,'Nøtternte å løpe bakkeløp i hasjrus'),('20119-03-01','23:14:09',44,8,9,NULL,'OK');

-- ØktID, ØvelseID
INSERT INTO Ovelseriokt VALUES (1,1),(1,3),(1,5),(2,3),(),(),(),(),(),(),(),();
