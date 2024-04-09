SELECT code_itineraire, COUNT(*) AS nombre_ventes
FROM vol
JOIN vente ON vol.id_vol = vente.idVol
GROUP BY code_itineraire
ORDER BY nombre_ventes DESC
FETCH FIRST 5 ROWS ONLY;

SELECT r_date.nomMois, COUNT(*) AS nombre_ventes
FROM vente
JOIN r_date ON vente.cle_dateDepart = r_date.cle_date
GROUP BY r_date.nomMois
ORDER BY nombre_ventes DESC
FETCH FIRST 3 ROWS ONLY;

SELECT r_date.nomMois, AVG(CASE WHEN heure.heureTravail = 1 THEN 1 ELSE 0 END) AS taux_ponctualite
FROM vente
JOIN r_date ON vente.cle_dateDepart = r_date.cle_date
JOIN heure ON vente.cle_heureDepart = heure.cle_heure
GROUP BY r_date.nomMois;

SELECT aeroport.nom, SUM(aeroport.volInternational) AS vols_internationaux
FROM aeroport
JOIN vol ON aeroport.cle_aeroport = vol.cle_aeroport
GROUP BY aeroport.nom;

SELECT heure.momentJournee, COUNT(*) AS nombre_ventes
FROM vente
JOIN heure ON vente.cle_heureDepart = heure.cle_heure
GROUP BY heure.momentJournee;

SELECT r_date.nomMois, COUNT(*) AS nombre_ventes
FROM vente
JOIN r_date ON vente.cle_dateDepart = r_date.cle_date
GROUP BY r_date.nomMois
ORDER BY r_date.mois;