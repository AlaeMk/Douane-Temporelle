package com.example.douanetemporelle;
/*
  Activité 1 : MainActivity
  Description : Activity hedhi hya el formulaire elli bch y3abih el voyageur
  - Fiha les champs mte3 l esm, l annee de naissance, l annee de destination wel motif (liste deroulante )
  - Ki nenzlou ala bouton "Inspecter", njibou les données mel formulaire
  - Nasn3ou Intent explicite w naba3thou les données l VerificationActivity b les clés mte3 KeyExtra
 */
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // ndeclari les variables
    private EditText etNomAb;
    private EditText etNaissanceAb;
    private EditText etDestinationAb;
    private Spinner spMotifAb;
    private Button btnInspecter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // njibou boutton Inspecter mel layout xml bel id mte3ou
        btnInspecter = findViewById(R.id.btn_Inspecter_ab);
        // Narbtou les variables b les ID mte3hom m3a les éléments elli fel XML
        etNomAb = findViewById(R.id.et_Nom_ab);
        etNaissanceAb = findViewById(R.id.et_annee_naissance_ab);
        etDestinationAb = findViewById(R.id.et_annee_destination_ab);
        spMotifAb = findViewById(R.id.sp_motif_ab);

        btnInspecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            // njibou les informations elli hathom l'utilisateur fel formulaire
                String nom = etNomAb.getText().toString();
                String naissance = etNaissanceAb.getText().toString();
                String destination = etDestinationAb.getText().toString();
                String motif = spMotifAb.getSelectedItem().toString();


            // nasn3ou new Intent (hya elli t5alli activity tnjm elle communique m3a une autre activity) w naba3thou les donnees lel VerificationActivity
                // houni sta3malna Intent explicite (5ater na3rfou l Activity destinataire)
                // ne5dhou el méthode statique mel classe KeyExtra bech na3mlou les clés
                Intent intent = new Intent(MainActivity.this, VerificationActivity.class);
                intent.putExtra(KeyExtra.getNomKey(KeyExtra.MATRICULE), nom);
                intent.putExtra(KeyExtra.getNaissanceKey(KeyExtra.MATRICULE), naissance);
                intent.putExtra(KeyExtra.getDestinationKey(KeyExtra.MATRICULE), destination);
                intent.putExtra(KeyExtra.getMotifKey(KeyExtra.MATRICULE), motif);
            //nlanciw l Activity 2
                startActivity(intent);
            }
        });


    }
}