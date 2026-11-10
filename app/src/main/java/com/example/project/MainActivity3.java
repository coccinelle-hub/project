
package com.example.project;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    // Déclaration des composants
    private View fondEcran;
    private TextView messageTitre;
    private TextView messageDescription;
    private Button boutonNouveauVoyageur;

    private TextView textRecapNom;
    private TextView textRecapMotif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Naffichiw l'interface XML
        setContentView(R.layout.activity_main3);

        // Nربطو les composants Java bel XML
        fondEcran = findViewById(R.id.layout_verdict_nj);
        messageTitre = findViewById(R.id.text_titre_nj);
        messageDescription = findViewById(R.id.text_message_nj);
        boutonNouveauVoyageur = findViewById(R.id.btn_nouveau_nj);

        // Liaison mta3 les composants de récapitulatif
        textRecapNom = findViewById(R.id.text_recap_nom_nj);
        textRecapMotif = findViewById(R.id.text_recap_motif_nj);

        // Récupération des données elli b3aththom MainActivity2
        Intent intent = getIntent();

        boolean estApprouve = intent.getBooleanExtra(Cles.cleVerdict(Cles.MATRICULE), false);
        String nomVoyageur = intent.getStringExtra(Cles.cleNom(Cles.MATRICULE));
        String motifVoyageur = intent.getStringExtra(Cles.cleMotif(Cles.MATRICULE));

        // Affichage du nom et du motif fel carte
        if (nomVoyageur != null) {
            textRecapNom.setText("Nom : " + nomVoyageur);
        }

        if (motifVoyageur != null) {
            textRecapMotif.setText("Motif : " + motifVoyageur);
        }

        // Naffichiw résultat selon décision Approuver wala Refuser
        if (estApprouve) {

            // Ken accepté, fond vert w message de réussite
            fondEcran.setBackgroundColor(Color.parseColor("#4CAF50"));
            messageTitre.setText("Bon voyage " + nomVoyageur);
            messageDescription.setText("Saut temporel approuvé");

        } else {

            // Ken refusé, fond rouge w message de refus
            fondEcran.setBackgroundColor(Color.parseColor("#F44336"));
            messageTitre.setText(nomVoyageur + " est en état d'arrestation temporelle");
            messageDescription.setText("Saut temporel refusé : risque de paradoxe");
        }

        // Ki l'utilisateur yenzel aal bouton, yarja3 lel formulaire principal
        boutonNouveauVoyageur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent retour = new Intent(MainActivity3.this, MainActivity.class);

                // Nfas5ou les anciennes Activity w narj3ou lel début
                retour.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                startActivity(retour);
            }
        });
    }
}
