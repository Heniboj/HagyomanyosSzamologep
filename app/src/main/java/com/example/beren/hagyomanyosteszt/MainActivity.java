package com.example.beren.hagyomanyosteszt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener{

        TextView t1;
        Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bplussz,bminusz,bszorzas,bosztas,begyenlo,bmemoryplussz,bmemoryminusz,bAC,comma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.szam1);
        b2 = (Button) findViewById(R.id.szam2);
        b3 = (Button) findViewById(R.id.szam3);
        b4 = (Button) findViewById(R.id.szam4);
        b5 = (Button) findViewById(R.id.szam5);
        b6 = (Button) findViewById(R.id.szam6);
        b7 = (Button) findViewById(R.id.szam7);
        b8 = (Button) findViewById(R.id.szam8);
        b9 = (Button) findViewById(R.id.szam9);
        b0 = (Button) findViewById(R.id.szam0);

        comma = (Button) findViewById(R.id.comma);

        t1 = findViewById(R.id.kijelzo1);

        bplussz = (Button) findViewById(R.id.plussz);
        bminusz = (Button) findViewById(R.id.minusz);
        bszorzas = (Button) findViewById(R.id.szorzas);
        bosztas = (Button) findViewById(R.id.osztas);

        begyenlo = (Button) findViewById(R.id.egyenlo);

        bmemoryplussz = (Button) findViewById(R.id.memoryplussz);
        bmemoryminusz = (Button) findViewById(R.id.memoryminusz);

        bAC = (Button) findViewById(R.id.AC);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        bplussz.setOnClickListener(this);
        bminusz.setOnClickListener(this);
        bszorzas.setOnClickListener(this);
        bosztas.setOnClickListener(this);
        begyenlo.setOnClickListener(this);
        bmemoryplussz.setOnClickListener(this);
        bmemoryminusz.setOnClickListener(this);
        bAC.setOnClickListener(this);
        comma.setOnClickListener(this);
    }

    public void onClick(View v){

        Button button = (Button) v;

        int proba = v.getId();

        switch(proba){

            case R.id.szam1:
            case R.id.szam2:
            case R.id.szam3:
            case R.id.szam4:
            case R.id.szam5:
            case R.id.szam6:
            case R.id.szam7:
            case R.id.szam8:
            case R.id.szam9:
            case R.id.szam0:
            case R.id.plussz:
            case R.id.minusz:
            case R.id.szorzas:
            case R.id.osztas:
            case R.id.egyenlo:
            case R.id.memoryplussz:
            case R.id.memoryminusz:
            case R.id.AC:
            case R.id.comma:

                t1.setText(t1.getText() + button.getText().toString());
                break;
        }
    }
}
