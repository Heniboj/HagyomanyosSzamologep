package com.example.beren.hagyomanyosteszt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements OnClickListener
{

        TextView t1;
        Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bplussz,bminusz,bszorzas,bosztas,begyenlo,bmemoryplussz,bmemoryminusz,bAC,comma;

        double memory, prevResult;
        boolean justOutputted = true;
        Operations prevOp = null;
        boolean alreadyformatted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.szam1);
        b2 = findViewById(R.id.szam2);
        b3 = findViewById(R.id.szam3);
        b4 = findViewById(R.id.szam4);
        b5 = findViewById(R.id.szam5);
        b6 = findViewById(R.id.szam6);
        b7 = findViewById(R.id.szam7);
        b8 = findViewById(R.id.szam8);
        b9 = findViewById(R.id.szam9);
        b0 = findViewById(R.id.szam0);

        comma = findViewById(R.id.comma);

        t1 = findViewById(R.id.kijelzo1);

        bplussz = findViewById(R.id.plussz);
        bminusz = findViewById(R.id.minusz);
        bszorzas = findViewById(R.id.szorzas);
        bosztas = findViewById(R.id.osztas);

        begyenlo = findViewById(R.id.egyenlo);

        bmemoryplussz = findViewById(R.id.memoryplussz);
        bmemoryminusz = findViewById(R.id.memoryminusz);

        bAC = findViewById(R.id.AC);

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

    public void onClick(View v)
    {

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
            case R.id.comma:
                if (justOutputted)
                {
                    t1.setText(button.getText().toString());
                    justOutputted = false;
                }
                else
                    t1.setText(t1.getText() + button.getText().toString());
            break;

            case R.id.plussz:
                prevOp = Operations.Addition;
                Display(prevResult + Double.parseDouble(t1.getText().toString()), false);
                break;
            case R.id.minusz:
                prevOp = Operations.Subtraction;
                Display(prevResult - Double.parseDouble(t1.getText().toString()), false);
                break;
            case R.id.szorzas:
                prevOp = Operations.Multiplication;
                Display(prevResult * Double.parseDouble(t1.getText().toString()), false);
                break;
            case R.id.osztas:
                prevOp = Operations.Division;
                Display(prevResult / Double.parseDouble(t1.getText().toString()), false);
                break;

            case R.id.egyenlo:

                switch(prevOp)
                {
                    case Addition:
                        Display(prevResult + Double.parseDouble(t1.getText().toString()), true);
                        break;

                    case Subtraction:
                        Display(prevResult - Double.parseDouble(t1.getText().toString()), true);
                        break;

                    case Multiplication:
                        Display(prevResult * Double.parseDouble(t1.getText().toString()), true);
                        break;

                    case Division:
                        Display(prevResult / Double.parseDouble(t1.getText().toString()), true);
                        break;
                }
                break;

            case R.id.AC:
                Display(0, false);
                break;
            case R.id.memoryplussz:
                memory += Double.parseDouble(t1.getText().toString());
                break;
            case R.id.memoryminusz:
                memory -= Double.parseDouble(t1.getText().toString());
                break;
        }
    }

    public void Display(double x, boolean egyenlo)
    {
        justOutputted = true;
        if(alreadyformatted==false){
        DecimalFormat df = new DecimalFormat("###,###,###,###.##########");
        t1.setText(df.format(x));}
        else{t1.setText(Double.toString(x));}
        if (!egyenlo) {
            prevResult = x;

        }


        alreadyformatted=true;
    }



}

enum Operations
{
    Addition, Subtraction, Multiplication, Division
}
