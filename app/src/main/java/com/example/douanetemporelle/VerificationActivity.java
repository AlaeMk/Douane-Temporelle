package com.example.douanetemporelle;
/*
  Activité 2 : VerificationActivity
  Description : el Activity hedhi Tlawej w tverifi les données mta3 el voyageur elli tba3thou mel MainActivity.
  - Te7seb lfar9  bin l'annee de destination wel naissance
  - Tverifi el condition mta3 el paradoxe temporel b nbPrmier w ta3mel disable lel boutton Approuver ken nombre prmier + ken motif = Modification du passé

 */
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class VerificationActivity extends AppCompatActivity {

    // boucle bech na3rfou est ce que nombre premier ou nn
    private boolean nbPrmier(int n) {
        if (n <= 1) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_verification);

        // njibou les donnees men MainActivity b KeyExtra
        Intent intent = getIntent();
        String nom = intent.getStringExtra(KeyExtra.getNomKey(KeyExtra.MATRICULE));
        String naissanceStr = intent.getStringExtra(KeyExtra.getNaissanceKey(KeyExtra.MATRICULE));
        String destinationStr = intent.getStringExtra(KeyExtra.getDestinationKey(KeyExtra.MATRICULE));
        String motif = intent.getStringExtra(KeyExtra.getMotifKey(KeyExtra.MATRICULE));

        // Exception : T'akked elli les données mawjoudin (mch null) bch hatta ken had yhb yhel activite 2 men android studio ma ttcrushech
        if (nom == null || naissanceStr == null || destinationStr == null || motif == null) {
            Toast.makeText(this, "Erreur : Données manquantes !", Toast.LENGTH_LONG).show();
            finish(); // Nsakrou l'Activité 2 w narja3ou l'Activité 1
            return;
        }
        // narbtou les elements  b les ID mte3hom elli fel xml
        TextView tvResume = findViewById(R.id.tv_resume_ab);
        Button btnApprouver = findViewById(R.id.btn_approuver_ab);
        Button btnRefuser = findViewById(R.id.btn_refuser_ab);

        // ne7sbou différence bin l'année de destination wel année de naissance
        int naissance = 0;
        int destination = 0;
        try {
            naissance = Integer.parseInt(naissanceStr);
            destination = Integer.parseInt(destinationStr);
        } catch (Exception e) {
            //nzidou un Toast w finish() bch ma n5alliwch l'app taffichi 0
            Toast.makeText(this, "Erreur : Les années envoyées sont invalides !", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        int diffTemps = destination - naissance;

        // affichage mte3 resume
        String resumeTexte = " Résumé du voyageur :" +
                "\n________________________________" +
                "\nNom : " + (nom != null ? nom : "Inconnu") +
                "\n________________________________" +
                "\nAnnée de Naissance : " + naissance +
                "\n________________________________" +
                "\nAnnée de Destination : " + destination +
                "\n________________________________" +
                "\nMotif : " + (motif != null ? motif : "-") +
                "\n________________________________" +
                "\n\n Âge temporel (Différence) : " + diffTemps + " ans";
        tvResume.setText(resumeTexte);

        // houni ken nombre prmier bch na3mlou disable lel boutton Approuver
        if ("Modification du passe".equals(motif) && nbPrmier(Math.abs(diffTemps))) {
            btnApprouver.setEnabled(false);
            btnApprouver.setAlpha(0.5f); // nrodouh semi-transparent
        }
        // Navigation lel ResultActivity
        btnApprouver.setOnClickListener(v -> {
            Intent i = new Intent(VerificationActivity.this, ResultActivity.class);
            intent.putExtra(KeyExtra.getNomKey(KeyExtra.MATRICULE), nom);
            // naba3thou verdict zeda lel ResultActivity
            intent.putExtra(KeyExtra.getVerdictKey(KeyExtra.MATRICULE), true);
            startActivity(intent);
        });
        // action mta3 el boutton refuser w el passage lel ResultActivity
        btnRefuser.setOnClickListener(v -> {
            Intent i = new Intent(VerificationActivity.this, ResultActivity.class);
            intent.putExtra(KeyExtra.getNomKey(KeyExtra.MATRICULE), nom);
            intent.putExtra(KeyExtra.getVerdictKey(KeyExtra.MATRICULE), false);
            startActivity(intent);
        });
    }
}