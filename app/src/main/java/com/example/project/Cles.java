package com.example.project;

public class Cles {

    // 4 derniers chiffres de la carte d'étudiant d'un membre du groupe
    public static final String MATRICULE = "1234";

    // Méthode statique qui construit une clé à partir du matricule
    public static String construireCle(String matricule, String champ) {
        return matricule + "_" + champ;
    }

    public static String cleNom(String matricule) {
        return construireCle(matricule, "NOM_VOYAGEUR");
    }

    public static String cleAnneeNaissance(String matricule) {
        return construireCle(matricule, "ANNEE_NAISSANCE");
    }

    public static String cleAnneeDestination(String matricule) {
        return construireCle(matricule, "ANNEE_DESTINATION");
    }

    public static String cleMotif(String matricule) {
        return construireCle(matricule, "MOTIF");
    }

    public static String cleVerdict(String matricule) {
        return construireCle(matricule, "VERDICT");
    }
}