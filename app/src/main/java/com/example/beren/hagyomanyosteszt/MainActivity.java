package com.example.beren.hagyomanyosteszt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener{
        TextView t1;
        Button b1,b2,b3,b4,b5,b6,b7,b8,b9;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b7=(Button)findViewById(R.id.szam7);
        b8=(Button)findViewById(R.id.szam8);
        b9=(Button)findViewById(R.id.szam9);
        b4=(Button)findViewById(R.id.szam4);
        b5=(Button)findViewById(R.id.szam5);
        b6=(Button)findViewById(R.id.szam6);
        b1=(Button)findViewById(R.id.szam1);
        b2=(Button)findViewById(R.id.szam2);
        b3=(Button)findViewById(R.id.szam3);


        t1=(TextView)findViewById(R.id.kijelzo1);


        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        t1.setOnClickListener(this);
    }

    public void onClick(View v){

        try{
            int proba = v.getId();

            switch(proba){

                case R.id.szam7: t1.setText(t1.getText()+"7");
                break;

                case R.id.szam8: t1.setText(t1.getText()+"8");
                    break;

                case R.id.szam9: t1.setText(t1.getText()+"9");
                    break;

                case R.id.szam4: t1.setText(t1.getText()+"4");
                    break;

                case R.id.szam5: t1.setText(t1.getText()+"5");
                    break;

                case R.id.szam6: t1.setText(t1.getText()+"6");
                    break;

                case R.id.szam1: t1.setText(t1.getText()+"1");
                    break;

                case R.id.szam2: t1.setText(t1.getText()+"2");
                    break;

                case R.id.szam3: t1.setText(t1.getText()+"3");
                    break;


            }











        }


        catch(Exception e){
            Toast.makeText(getApplicationContext(), "Számot kell  begépelni...", Toast.LENGTH_SHORT).show();











        }








    }




}
