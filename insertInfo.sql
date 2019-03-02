INSERT INTO Apparat VALUES (1, 'Benk', 'Benk med stang'), (2, 'Romaskin', 'sånn man ror med');

INSERT INTO Ovelsesgruppe VALUES (1, 'Brystøvelser'),(2,'Ryggøvelser'),(3,'Beinøvelser'),(4, 'Kondisjonsøvelse');

INSERT INTO Ovelse VALUES (1,'Benkpress',1),(2,'Roing',4);
INSERT INTO Fastmontert VALUES (1,120,10,1),(2,10,3,2);

INSERT INTO Person VALUES (1,'Kjell','69696969',1);

INSERT INTO Treningsokt VALUES (1,'2019-03-02', '13:08:00', 60,10,10,NULL,'OK');
UPDATE Treningsokt
SET treningspartner = 1
WHERE oktID = 1;

INSERT INTO Ovelseriokt VALUES (1,1),(1,2);

SELECT oktID AS Økt, dato, tidspunkt, varighet AS Øktvarighet, Person.navn AS Treningspartner, Ovelse.navn AS Øvelse 
FROM ((Treningsokt NATURAL JOIN Ovelseriokt) NATURAL JOIN Ovelse) INNER JOIN Person ON Treningsokt.treningspartner = Person.personID;