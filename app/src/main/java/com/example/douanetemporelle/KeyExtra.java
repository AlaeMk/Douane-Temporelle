package com.example.douanetemporelle;

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
        return "VERDICT_" + matricule;
    }
}

