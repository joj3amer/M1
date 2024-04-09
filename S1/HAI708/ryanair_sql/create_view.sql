CREATE VIEW aeroportdepart AS
SELECT aeroport.cle_aeroport,aeroport.nom,aeroport.ville,aeroport.pays
FROM aeroport,vente WHERE aeroport.cle_aeroport=vente.cle_aeroportDepart;

CREATE VIEW aeroportarrivee AS
SELECT aeroport.cle_aeroport,aeroport.nom,aeroport.ville,aeroport.pays
FROM aeroport,vente WHERE aeroport.cle_aeroport=vente.cle_aeroportArrivee;