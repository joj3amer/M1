CREATE OR REPLACE TRIGGER check_dates_trigger
BEFORE INSERT OR UPDATE ON vente
FOR EACH ROW
DECLARE
    dateArrivee DATE;
    dateDepart DATE;
BEGIN
    SELECT r_date INTO dateArrivee FROM r_date WHERE cle_date = :NEW.cle_dateArrivee;
    SELECT r_date INTO dateDepart FROM r_date WHERE cle_date = :NEW.cle_dateDepart;
    
    IF dateDepart >= dateArrivee THEN
        RAISE_APPLICATION_ERROR(-20001,'Erreur : date d''arrivee doit être inférieure à la date de retour...');
    END IF;
END;
/

CREATE OR REPLACE TRIGGER calcule_prixFinal
BEFORE INSERT OR UPDATE OF prix, remise ON vente
FOR EACH ROW
BEGIN
    :NEW.prixFinal := :NEW.prix * (1 - :NEW.remise);
END;
/

CREATE OR REPLACE TRIGGER verifie_aeroport_vol
BEFORE INSERT ON vol
FOR EACH ROW
DECLARE
    v_count_origine NUMBER;
    v_count_destination NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count_origine
    FROM aeroport
    WHERE ville = :NEW.origine;

    SELECT COUNT(*) INTO v_count_destination
    FROM aeroport
    WHERE ville = :NEW.destination;

    IF v_count_origine = 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Erreur : La ville d''origine spécifiée n''existe pas dans la table des aéroports.');
    END IF;

    IF v_count_destination = 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Erreur : La ville de destination spécifiée n''existe pas dans la table des aéroports.');
    END IF;
END;
/