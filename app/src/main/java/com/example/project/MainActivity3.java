package com.example.project;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    private View fondEcran;
    private TextView messageTitre;
    private TextView messageDescription;
    private Button boutonNouveauVoyageur;

    // LES DEUX TEXTES DE LA CARTE :
    private TextView textRecapNom;
    private TextView textRecapMotif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        fondEcran = findViewById(R.id.layout_verdict_nj);
        messageTitre = findViewById(R.id.text_titre_nj);
        messageDescription = findViewById(R.id.text_message_nj);
        boutonNouveauVoyageur = findViewById(R.id.btn_nouveau_nj);

        // Liaison avec le XML :
        textRecapNom = findViewById(R.id.text_recap_nom_nj);
        textRecapMotif = findViewById(R.id.text_recap_motif_nj);

        Intent intent = getIntent();
        boolean estApprouve = intent.getBooleanExtra(Cles.cleVerdict(Cles.MATRICULE), false);
        String nomVoyageur = intent.getStringExtra(Cles.cleNom(Cles.MATRICULE));
        String motifVoyageur = intent.getStringExtra(Cles.cleMotif(Cles.MATRICULE)); // <-- Récupéré depuis MainActivity2

        // Affichage dans la carte :
        if (nomVoyageur != null) {
            textRecapNom.setText("Nom : " + nomVoyageur);
        }
        if (motifVoyageur != null) {
            textRecapMotif.setText("Motif : " + motifVoyageur);
        }

        if (estApprouve) {
            fondEcran.setBackgroundColor(Color.parseColor("#4CAF50")); // vert
            messageTitre.setText("Bon voyage " + nomVoyageur);
            messageDescription.setText("Saut temporel approuvé");
        } else {
            fondEcran.setBackgroundColor(Color.parseColor("#F44336")); // rouge
            messageTitre.setText(nomVoyageur + " est en état d'arrestation temporelle");
            messageDescription.setText("Saut temporel refusé : risque de paradoxe");
        }

        boutonNouveauVoyageur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retour = new Intent(MainActivity3.this, MainActivity.class);
                retour.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(retour);
            }
        });
    }
}