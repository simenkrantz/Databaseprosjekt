
CREATE TABLE Ovelsesgruppe (
	gruppeID 	INTEGER 	NOT NULL,
    navn 		VARCHAR(30) NOT NULL,
    CONSTRAINT gruppe_PK PRIMARY KEY (gruppeID)
);

CREATE TABLE Ovelse (
	ovelseID 	INTEGER 	NOT NULL,
    navn 		VARCHAR(30) NOT NULL,
    gruppeID 	INTEGER,
    CONSTRAINT ovelse_PK PRIMARY KEY (ovelseID),
    CONSTRAINT ovelsesgruppe_FK FOREIGN KEY (gruppeID) REFERENCES Ovelsesgruppe(gruppeID)
													   ON UPDATE CASCADE
													   ON DELETE SET NULL
);

CREATE TABLE Person (
	personID 		INTEGER 	NOT NULL,
    navn 			VARCHAR(30) NOT NULL,
    tlfnr 			INTEGER,
    favorittovelse 	INTEGER,
    CONSTRAINT person_PK PRIMARY KEY (personID),
    CONSTRAINT ovelse_FK FOREIGN KEY (favorittovelse) REFERENCES Ovelse(ovelseID)
													  ON UPDATE CASCADE
                                                      ON DELETE SET NULL
);

CREATE TABLE Treningsokt (
	oktID 			INTEGER NOT NULL,
    dato 			DATE	NOT NULL,
    tidspunkt 		TIME	NOT NULL,
    varighet 		INTEGER NOT NULL,
    form 			INTEGER,
    prestasjon 		INTEGER,
    treningspartner INTEGER,
    notat 			VARCHAR(250),
    CONSTRAINT treningsokt_PK PRIMARY KEY (oktID),
    CONSTRAINT person_FK FOREIGN KEY (treningspartner) REFERENCES Person(personID)
													   ON UPDATE CASCADE
                                                       ON DELETE SET NULL
);

CREATE TABLE Apparat (
	apparatID 	INTEGER 	NOT NULL,
    navn 		VARCHAR(30) NOT NULL,
    beskrivelse VARCHAR(200),
    CONSTRAINT apparat_PK PRIMARY KEY (apparatID)
);

CREATE TABLE Frittstaende (
	ovelseID 	INTEGER NOT NULL,
    beskrivelse VARCHAR(200),
	CONSTRAINT frittstaende_FK FOREIGN KEY (ovelseID) REFERENCES Ovelse(ovelseID)
												      ON UPDATE CASCADE
                                                      ON DELETE CASCADE
);

CREATE TABLE Fastmontert (
	ovelseID 	INTEGER NOT NULL,
    antall_kg 	INTEGER,
    antall_sett INTEGER,
    apparat 	INTEGER NOT NULL,
    CONSTRAINT fastmontert_FK FOREIGN KEY (ovelseID) REFERENCES Ovelse(ovelseID)
												     ON UPDATE CASCADE
                                                     ON DELETE CASCADE,
    CONSTRAINT apparat_FK FOREIGN KEY (apparat) REFERENCES apparat(apparatID)
											    ON UPDATE CASCADE
                                                ON DELETE CASCADE
);

CREATE TABLE Ovelseriokt (
	oktID 		INTEGER NOT NULL,
    ovelseID 	INTEGER NOT NULL,
    CONSTRAINT ovelseriokt_PK PRIMARY KEY (oktID, ovelseID),
    CONSTRAINT ovelseriokt_FK FOREIGN KEY (ovelseID) REFERENCES Ovelse(ovelseID) 
													 ON UPDATE CASCADE
													 ON DELETE CASCADE,
	CONSTRAINT oktID_FK FOREIGN KEY (oktID) REFERENCES Treningsokt(oktID) 
													 ON UPDATE CASCADE
													 ON DELETE CASCADE
);