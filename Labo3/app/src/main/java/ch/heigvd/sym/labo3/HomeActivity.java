package ch.heigvd.sym.labo3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Auteurs: Ibrahim Ounon & Emmanuel Schmid
 */

public class HomeActivity extends AppCompatActivity{

    private TextView text = null;
    private Button btnInfo = null;

    private static final int AUTHENTICATE_MAX = 60000; // en ms, 60000ms = 1 min
    long startTime; // Temps de depart après l'authentification
    long endTime;  // Temps de fin, lorsque l'utilisateur clique si le bouton info pour lire l'info

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        startTime = System.currentTimeMillis();

        text = (TextView) findViewById(R.id.textView );
        btnInfo = (Button) findViewById(R.id.btn_info );

        btnInfo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                endTime = System.currentTimeMillis();

                // Avant une minute on accès l'information sinon il faut se reloguer pour voir
                if (endTime - startTime < AUTHENTICATE_MAX){
                    text.setText("Information");
                }
                else{
                    text.setText("Information not available, please relog you to see information");
                }
            }
        });
    }
}
