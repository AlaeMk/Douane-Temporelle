package com.example.douanetemporelle;

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
        Button btnInspecter = findViewById(R.id.btn_Inspecter_ab);

        btnInspecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            // on recupere les informations elli hathom l'utilisateur fel formulaire
                String nom = ((EditText) findViewById(R.id.et_Nom_ab)).getText().toString();
                String naissance = ((EditText) findViewById(R.id.et_annee_naissance_ab)).getText().toString();
                String destination = ((EditText) findViewById(R.id.et_annee_destination_ab)).getText().toString();
                String motif = ((Spinner) findViewById(R.id.sp_motif_ab)).getSelectedItem().toString();

            // nasn3ou new Intent (hya elli t5alli activity tnjm elle communique m3a une autre activity) w naba3thou les donnees lel VerificationActivity
                // houni sta3malna Intent explicite (5ater na3rfou l Activity destinataire)
                Intent intent = new Intent(MainActivity.this, VerificationActivity.class);
                intent.putExtra("NOM_EXTRA", nom);
                intent.putExtra("NAISSANCE_EXTRA", naissance);
                intent.putExtra("DESTINATION_EXTRA", destination);
                intent.putExtra("MOTIF_EXTRA", motif);
            //nlanciw l Activity 2
                startActivity(intent);
            }
        });


    }
}