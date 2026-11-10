
package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    // Déclaration des composants
    private TextView affichageNom;
    private TextView affichageAge;
    private TextView affichageMotif;
    private Button boutonApprouver;
    private Button boutonRefuser;

    private String nomVoyageur;
    private String motifVoyageur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Naffichiw l'interface XML
        setContentView(R.layout.activity_main2);

        // Nربطو les composants Java bel XML
        affichageNom = findViewById(R.id.text_nom_nj);
        affichageAge = findViewById(R.id.text_age_nj);
        affichageMotif = findViewById(R.id.text_motif_nj);
        boutonApprouver = findViewById(R.id.btn_approuver_nj);
        boutonRefuser = findViewById(R.id.btn_refuser_nj);

        // Récupération des données elli b3aththom MainActivity
        Intent intent = getIntent();

        nomVoyageur = intent.getStringExtra(Cles.cleNom(Cles.MATRICULE));
        int anneeNaissance = intent.getIntExtra(Cles.cleAnneeNaissance(Cles.MATRICULE), 0);
        int anneeDestination = intent.getIntExtra(Cles.cleAnneeDestination(Cles.MATRICULE), 0);
        motifVoyageur = intent.getStringExtra(Cles.cleMotif(Cles.MATRICULE));

        // Calcul de l'âge temporel
        int ageTemporel = Math.abs(anneeDestination - anneeNaissance);

        // Affichage des informations fel écran
        affichageNom.setText("Nom : " + nomVoyageur);
        affichageAge.setText("Âge temporel : " + ageTemporel + " ans");
        affichageMotif.setText("Motif : " + motifVoyageur);

        // Ken motif Modification du passé w l'âge nombre premier,
        // nwa9fou bouton Approuver
        if ("Modification du passé".equals(motifVoyageur) && estPremier(ageTemporel)) {
            boutonApprouver.setEnabled(false);
        }

        // Ki l'utilisateur yenzel Approuver, nabaathou true
        boutonApprouver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ouvrirVerdict(true);
            }
        });

        // Ki l'utilisateur yenzel Refuser, nabaathou false
        boutonRefuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ouvrirVerdict(false);
            }
        });
    }

    // Passage lel troisième Activity avec le verdict et les informations
    private void ouvrirVerdict(boolean estApprouve) {

        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);

        intent.putExtra(Cles.cleVerdict(Cles.MATRICULE), estApprouve);
        intent.putExtra(Cles.cleNom(Cles.MATRICULE), nomVoyageur);
        intent.putExtra(Cles.cleMotif(Cles.MATRICULE), motifVoyageur);

        startActivity(intent);
    }

    // Méthode bech nethabtou ken nombre premier wala le
    private boolean estPremier(int nombre) {

        if (nombre < 2) return false;

        for (int diviseur = 2; diviseur * diviseur <= nombre; diviseur++) {

            // Ken nombre yet9assem aal diviseur, mahouche premier
            if (nombre % diviseur == 0) return false;
        }

        // Ken ma l9inech diviseur, nombre premier
        return true;
    }
}
