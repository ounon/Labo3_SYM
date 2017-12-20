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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        text = (TextView) findViewById(R.id.textView );
    }
}
