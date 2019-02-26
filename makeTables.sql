CREATE TABLE Person (
	personID INTEGER NOT NULL,
    navn VARCHAR(30),
    tlfnr INTEGER,
    favorittovelse INTEGER,
    CONSTRAINT person_PK PRIMARY KEY personID
    CONSTRAINT 
);


CREATE TABLE Treningsokt (
	oktID INTEGER NOT NULL,
    dato DATE,
    tidspunkt TIME,
    varighet INTEGER,
    form INTEGER,
    prestasjon INTEGER,
    treningspartner INTEGER,
    notat VARCHAR(250),
    CONSTRAINT treningsokt_PK PRIMARY KEY (oktID),
    CONSTRAINT person_FK FOREIGN KEY (treningspartner) REFERENCES Person(personID)
);

CREATE TABLE Gruppe (
	gruppeID INTEGER NOT NULL,
    navn VARCHAR(30),
    CONSTRAINT gruppe_PK PRIMARY KEY (gruppeID)
);

CREATE TABLE Ovelse (
	ovelseID INTEGER NOT NULL,
    navn VARCHAR(30),
    gruppeID INTEGER,
    CONSTRAINT ovelse_PK PRIMARY KEY (ovelseID),
    CONSTRAINT gruppe_FK FOREIGN KEY (gruppeID) REFERENCES Gruppe(gruppeID)
);

CREATE TABLE Ovelseriokt (
	oktID INTEGER NOT NULL,
    ovelseID INTEGER NOT NULL,
    CONSTRAINT ovelseriokt_PK PRIMARY KEY (oktID, ovelseID),
    CONSTRAINT ovelse_FK FOREIGN KEY (ovelseID) REFERENCES Ovelse(ovelseID) 
);