package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText champNom;
    private EditText champNaissance;
    private EditText champDestination;
    private RadioGroup groupeMotif;
    private Button boutonInspecter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        champNom = findViewById(R.id.edit_nom_nj);
        champNaissance = findViewById(R.id.edit_naissance_nj);
        champDestination = findViewById(R.id.edit_destination_nj);
        groupeMotif = findViewById(R.id.radio_group_motif_nj);
        boutonInspecter = findViewById(R.id.btn_inspecter_nj);

        boutonInspecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inspecterProfil();
            }
        });
    }

    private void inspecterProfil() {
        String nom = champNom.getText().toString().trim();
        String texteNaissance = champNaissance.getText().toString().trim();
        String texteDestination = champDestination.getText().toString().trim();
        int motifChoisiId = groupeMotif.getCheckedRadioButtonId();

        if (nom.isEmpty() || texteNaissance.isEmpty()
                || texteDestination.isEmpty() || motifChoisiId == -1) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        String motif;
        if (motifChoisiId == R.id.radio_tourisme_nj) {
            motif = "Tourisme";
        } else if (motifChoisiId == R.id.radio_modification_nj) {
            motif = "Modification du passé";
        } else {
            motif = "Fuite";
        }

        int anneeNaissance = Integer.parseInt(texteNaissance);
        int anneeDestination = Integer.parseInt(texteDestination);

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra(Cles.cleNom(Cles.MATRICULE), nom);
        intent.putExtra(Cles.cleAnneeNaissance(Cles.MATRICULE), anneeNaissance);
        intent.putExtra(Cles.cleAnneeDestination(Cles.MATRICULE), anneeDestination);
        intent.putExtra(Cles.cleMotif(Cles.MATRICULE), motif);
        startActivity(intent);
    }
}