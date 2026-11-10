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
        String nom = getIntent().getStringExtra(KeyExtra.getNomKey(KeyExtra.MATRICULE));
        String naissanceStr = getIntent().getStringExtra(KeyExtra.getNaissanceKey(KeyExtra.MATRICULE));
        String destinationStr = getIntent().getStringExtra(KeyExtra.getDestinationKey(KeyExtra.MATRICULE));
        String motif = getIntent().getStringExtra(KeyExtra.getMotifKey(KeyExtra.MATRICULE));

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
            // au cas ou 3anna erreur de format
        }
        int diffTemps = destination - naissance;

        // affichage mte3 resume
        String resumeTexte = "📋 Résumé du voyageur :" +
                "\n----------------------------------" +
                "\nNom : " + (nom != null ? nom : "Inconnu") +
                "\nAnnée de Naissance : " + naissance +
                "\nAnnée de Destination : " + destination +
                "\nMotif : " + (motif != null ? motif : "-") +
                "\n\n Âge temporel (Différence) : " + diffTemps + " ans";
        tvResume.setText(resumeTexte);

        // houni ken nombre prmier bch na3mlou disable lel boutton Approuver
        if ("Modification du passe".equals(motif) && nbPrmier(Math.abs(diffTemps))) {
            btnApprouver.setEnabled(false);
            btnApprouver.setAlpha(0.5f); // nrodouh semi-transparent
        }
        // Navigation lel ResultActivity
        btnApprouver.setOnClickListener(v -> {
            Intent intent = new Intent(VerificationActivity.this, ResultActivity.class);
            intent.putExtra(KeyExtra.getNomKey(KeyExtra.MATRICULE), nom);
            // naba3thou verdict zeda lel ResultActivity
            intent.putExtra(KeyExtra.getVerdictKey(KeyExtra.MATRICULE), true);
            startActivity(intent);
        });
        // action mta3 el boutton refuser w el passage lel ResultActivity
        btnRefuser.setOnClickListener(v -> {
            Intent intent = new Intent(VerificationActivity.this, ResultActivity.class);
            intent.putExtra(KeyExtra.getNomKey(KeyExtra.MATRICULE), nom);
            intent.putExtra(KeyExtra.getVerdictKey(KeyExtra.MATRICULE), false);
            startActivity(intent);
        });
    }
}