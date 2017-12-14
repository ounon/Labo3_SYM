package ch.heigvd.sym.labo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnNfc = null;
    private Button btnQRCode = null;
    private Button btnIBeacon = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnNfc = (Button) findViewById(R.id.nfc);
        this.btnQRCode = (Button) findViewById(R.id.qrcode);
        this.btnIBeacon = (Button) findViewById(R.id.ibeacon);

        btnNfc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnQRCode.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, QRcodeActivity.class);
                startActivity(intent);
            }
        });

        btnIBeacon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, IBeaconActivity.class);
                startActivity(intent);
            }
        });




    }
}
