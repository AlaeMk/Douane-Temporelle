package com.example.douanetemporelle;
/*
  Activité 3 : ResultActivity
  Description : el Activity hedhi ta3ti el verdict final (succès wala refus) elli jey mel VerificationActivity
  - Tbadal el couleur mte3 el fond (Vert ken valide, Rouge ken le).
  - Taffichi message fih esm el voyageur.
  - Fiha bouton "Nouveau voyageur" bech tarja3 lel MainActivity w tfar8 el mémoire mta3 les activités elli 9bal
 */
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Njibou el nom wel verdict men intent
        String nom = getIntent().getStringExtra(KeyExtra.getNomKey(KeyExtra.MATRICULE));
        boolean verdict = getIntent().getBooleanExtra(KeyExtra.getVerdictKey(KeyExtra.MATRICULE), false);

        // narbtou les elements b les ID
        LinearLayout rootLayout = findViewById(R.id.root_result_ab);
        ImageView imgStatus = findViewById(R.id.img_status_ab);
        TextView tvTitre = findViewById(R.id.tv_titre_ab);
        TextView tvMessage = findViewById(R.id.tv_message_ab);
        Button btnNouveauVoyageur = findViewById(R.id.btn_nouveau_voyageur_ab);

        // n7otou l interface ttbadal + message selon l verdict
        if (verdict) {
            // ken succees nhotouha verte
            rootLayout.setBackgroundColor(Color.parseColor("#209247"));
            imgStatus.setImageResource(R.drawable.bonvoyage);

            tvTitre.setText("SUCCESS!");
            tvMessage.setText("Bon voyage " + nom);

            btnNouveauVoyageur.setTextColor(Color.parseColor("#209247"));

        } else {
            // sinn nhotouha rouge
            rootLayout.setBackgroundColor(Color.parseColor("#D32F2F"));

            // ne5dhou icone mt3 warning men Android
            imgStatus.setImageResource(android.R.drawable.ic_dialog_alert);
            imgStatus.setColorFilter(Color.WHITE);

            tvTitre.setText("REFUSÉ");
            // w nafichiw message mt3 refus
            tvMessage.setText(nom + " est en état d'arrestation temporelle");

            btnNouveauVoyageur.setTextColor(Color.parseColor("#D32F2F"));
        }

        // nzidou boutton yraja3na lel interface loula bch na3mlou voyageur jdid
        btnNouveauVoyageur.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            // nfar8ou l memoire mt3 les activites bch l utilisateur mayarj3lhomch
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}