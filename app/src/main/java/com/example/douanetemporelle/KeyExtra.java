package com.example.douanetemporelle;
/*
  Classe utilitaire : KeyExtra
  Description : El classe hedhi fiha les méthodes statiques bech na3mlou bihom les clés mte3 l'Intent
  - clé fiha les 4 chiffres mte3 el carte etudiant
  - Hedha bech ntjanbou noko3dou nktbou fel clé kol marra manuellement (codées en dur)
 */
public class KeyExtra {
    public static final String MATRICULE = "1784";
    // key mta3 nom
    public static String getNomKey(String matricule) {
        return matricule + "_NOM_VOYAGEUR";
    }

    // key mta3 annee naissance
    public static String getNaissanceKey(String matricule) {
        return matricule + "_ANNEE_NAISSANCE";
    }

    // key mta3 annee destination
    public static String getDestinationKey(String matricule) {
        return matricule + "_ANNEE_DESTINATION";
    }

    // key mta3 matricule
    public static String getMotifKey(String matricule) {

        return matricule + "_MOTIF";
    }
    // key mta3 verdict
    public static String getVerdictKey(String matricule) {

        return   matricule + "_VERDICT";
    }
}

