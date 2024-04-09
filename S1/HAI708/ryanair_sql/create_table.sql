DROP TABLE RETARD;
DROP TABLE RAISON_RETARD;
DROP TABLE VOL;
DROP TABLE HEURE;
DROP TABLE r_date;
DROP TABLE AEROPORT;
DROP TABLE CLIENT;
DROP TABLE VENTE;


CREATE TABLE client ( 
    cle_client NUMBER PRIMARY KEY, 
    nom VARCHAR2(50), 
    prenom VARCHAR2(50), 
    age NUMBER, 
    sexe VARCHAR2(10), 
    nationalite VARCHAR2(50), 
    numero_passeport VARCHAR2(20), 
    numero_telephone VARCHAR2(20), 
    rue VARCHAR2(100), 
    numero_rue VARCHAR2(10), 
    ville VARCHAR2(50), 
    pays VARCHAR2(50) 
)

CREATE TABLE aeroport ( 
    cle_aeroport NUMBER PRIMARY KEY, 
    nom VARCHAR2(50), 
    ville VARCHAR2(50), 
    region VARCHAR2(50), 
    pays VARCHAR2(50), 
    latitude NUMBER(9, 6), 
    longitude NUMBER(9, 6), 
    capacite NUMBER, 
    volInternational NUMBER(1) CHECK (volInternational IN (0, 1)), 
    distanceAvecVille NUMBER, 
    aeroportStatus NUMBER(1) CHECK (aeroportStatus IN (0, 1)) 
)

CREATE TABLE heure ( 
    cle_heure NUMBER PRIMARY KEY, 
    temps VARCHAR2(20), 
    heure NUMBER, 
    minutes NUMBER, 
    seconde NUMBER, 
    am_pm VARCHAR2(2) CHECK (am_pm IN ('am', 'pm')), 
    heureHiver NUMBER(1) CHECK (heureHiver IN (0, 1)), 
    momentJournee VARCHAR(20) CHECK (momentJournee IN ('matin', 'après-midi', 'soir')), 
    quartHeure NUMBER, 
    heureTravail NUMBER(1) CHECK (heureTravail IN (0, 1)) 
)

CREATE TABLE r_date ( 
    cle_date NUMBER PRIMARY KEY, 
    r_date DATE, 
    nombreJourMoisFiscal NUMBER, 
    DateFinSemaineCivil DATE, 
    numeroSemaine NUMBER, 
    nomMois VARCHAR2(20), 
    trimestre NUMBER, 
    semaine NUMBER, 
    mois NUMBER, 
    annee NUMBER, 
    vacances NUMBER(1) CHECK (vacances IN (0, 1)) 
)

CREATE TABLE vol ( 
    cle_vol NUMBER PRIMARY KEY, 
    id_vol VARCHAR2(50), 
    volPrevu DATE, 
    code_itineraire VARCHAR2(20), 
    origine VARCHAR2(50), 
    destination VARCHAR2(50), 
    capaciteVol NUMBER, 
    AvionFabriquePar VARCHAR2(50), 
    numeroPiste VARCHAR2(10), 
    revisionPar VARCHAR2(50) 
)

CREATE TABLE vente ( 
 
    cle_client NUMBER, 
    cle_aeroport NUMBER, 
    cle_dateDepart NUMBER, 
    cle_dateArrivee NUMBER, 
    cle_heureDepart NUMBER, 
    cle_heureArrivee NUMBER, 
    cle_aeroportDepart NUMBER, 
    cle_aeroportArrivee NUMBER, 
    idVol VARCHAR2(50), 
    classe VARCHAR2(20), 
    prix NUMBER, 
    remise NUMBER(3, 2) CHECK (remise >= 0 AND remise <= 1), 
    prixFinal NUMBER, 
    billet_vendu NUMBER,
    id_vente NUMBER PRIMARY KEY, 
    FOREIGN KEY (cle_client) REFERENCES client (cle_client), 
    FOREIGN KEY (cle_aeroport) REFERENCES aeroport (cle_aeroport), 
    FOREIGN KEY (cle_dateDepart) REFERENCES r_date (cle_date), 
    FOREIGN KEY (cle_dateArrivee) REFERENCES r_date (cle_date), 
    FOREIGN KEY (cle_heureDepart) REFERENCES heure (cle_heure), 
    FOREIGN KEY (cle_heureArrivee) REFERENCES heure (cle_heure), 
    FOREIGN KEY (cle_aeroportDepart) REFERENCES aeroport (cle_aeroport), 
    FOREIGN KEY (cle_aeroportArrivee) REFERENCES aeroport (cle_aeroport) 
 
)



CREATE TABLE client (
    cle_client NUMBER PRIMARY KEY,
    nom VARCHAR2(50),
    prenom VARCHAR2(50),
    age NUMBER,
    sexe VARCHAR2(10),
    nationalite VARCHAR2(50),
    numero_passeport VARCHAR2(20),
    numero_telephone VARCHAR2(20),
    rue VARCHAR2(100),
    numero_rue VARCHAR2(10),
    ville VARCHAR2(50),
    pays VARCHAR2(50)
);

CREATE TABLE aeroport (
    cle_aeroport NUMBER PRIMARY KEY,
    nom VARCHAR2(50),
    ville VARCHAR2(50),
    region VARCHAR2(50),
    pays VARCHAR2(50),
    latitude NUMBER(9, 6),
    longitude NUMBER(9, 6),
    capacite NUMBER,
    volInternational NUMBER(1) CHECK (volInternational IN (0, 1)),
    distanceAvecVille NUMBER,
    aeroportStatus NUMBER(1) CHECK (aeroportStatus IN (0, 1))
);

CREATE TABLE heure (
    cle_heure NUMBER PRIMARY KEY,
    temps VARCHAR2(20),
    heure NUMBER,
    minutes NUMBER,
    seconde NUMBER,
    am_pm VARCHAR2(2) CHECK (am_pm IN ('am', 'pm')),
    heureHiver NUMBER(1) CHECK (heureHiver IN (0, 1)),
    momentJournee VARCHAR(20) CHECK (momentJournee IN ('matin', 'après-midi', 'soir')),
    quartHeure NUMBER,
    heureTravail NUMBER(1) CHECK (heureTravail IN (0, 1))
);

CREATE TABLE r_date (
    cle_date NUMBER PRIMARY KEY,
    r_date DATE,
    nombreJourMoisFiscal NUMBER,
    DateFinSemaineCivil DATE,
    numeroSemaine NUMBER,
    nomMois VARCHAR2(20),
    trimestre NUMBER,
    semaine NUMBER,
    mois NUMBER,
    annee NUMBER,
    vacances NUMBER(1) CHECK (vacances IN (0, 1))
);

CREATE TABLE vol (
    cle_vol NUMBER PRIMARY KEY,
    id_vol VARCHAR2(50),
    volPrevu DATE,
    code_itineraire VARCHAR2(20),
    origine VARCHAR2(50),
    destination VARCHAR2(50),
    capaciteVol NUMBER,
    AvionFabriquePar VARCHAR2(50),
    numeroPiste VARCHAR2(10),
    revisionPar VARCHAR2(50)
);

-- Table de dimension RAISON_RETARD avec attributs booléens
CREATE TABLE RAISON_RETARD (
    CLE_RAISON_RETARD NUMBER PRIMARY KEY,
    RAISON_RETARD VARCHAR2(255),
    METEO NUMBER(1) CHECK (METEO IN (0, 1)),
    PROBLEMES_TECHNIQUES NUMBER(1) CHECK (PROBLEMES_TECHNIQUES IN (0, 1)),
    PROBLEMES_LOGISTIQUES NUMBER(1) CHECK (PROBLEMES_LOGISTIQUES IN (0, 1)),
    PROBLEMES_PERSONNEL NUMBER(1) CHECK (PROBLEMES_PERSONNEL IN (0, 1))
);

-- Table des faits RETARD
CREATE TABLE RETARD (
    CLE_RETARD NUMBER PRIMARY KEY,
    CLE_VOL NUMBER,
    CLE_DATE_ARRIVEE_ACTUELLE NUMBER,
    CLE_DATE_ARRIVEE_PREVUE NUMBER,
    CLE_AEROPORT_DEPAR NUMBER,
    CLE_AEROPORT_ARRIVE NUMBER,
    CLE_HEURE_ARRIVEE_ACTUELLE NUMBER,
    CLE_HEURE_ARRIVEE_PREVUE NUMBER,
    CLE_RAISON_RETARD NUMBER,
    DUREE_RETARD NUMBER,
    PASSAGERS_IMPACTES NUMBER,
    NOMBRE_RECLAMATIONS NUMBER,
    REMBOURSEMENT_COUT NUMBER,
    FOREIGN KEY (CLE_VOL) REFERENCES VOL(CLE_VOL),
    FOREIGN KEY (CLE_DATE_ARRIVEE_ACTUELLE) REFERENCES R_DATE(CLE_DATE),
    FOREIGN KEY (CLE_AEROPORT_DEPAR) REFERENCES AEROPORT(CLE_AEROPORT),
    FOREIGN KEY (CLE_AEROPORT_ARRIVE) REFERENCES AEROPORT(CLE_AEROPORT),
    FOREIGN KEY (CLE_HEURE_ARRIVEE_ACTUELLE) REFERENCES HEURE(CLE_HEURE),
    FOREIGN KEY (CLE_RAISON_RETARD) REFERENCES RAISON_RETARD(CLE_RAISON_RETARD)
);