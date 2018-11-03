package com.example.beren.hagyomanyosteszt;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    Button buttons [] = new Button[19];

    double memory, prevInput, prevResult;
    boolean justOutputted = true;
    boolean firstInput = true;
    Operations prevOp = null;

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.style_white:
                getWindow().getDecorView().setBackgroundColor(Color.WHITE);
                for(int i = 0; i < buttons.length; i++)
                {
                    buttons[i].setTextColor(Color.BLACK);
                }
                return true;
            case R.id.style_black:
                getWindow().getDecorView().setBackgroundColor(Color.BLACK);
                for(int i = 0; i < buttons.length; i++)
                {
                    buttons[i].setTextColor(Color.WHITE);
                }
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons[0] = findViewById(R.id.szam0);
        buttons[1] = findViewById(R.id.szam1);
        buttons[2] = findViewById(R.id.szam2);
        buttons[3] = findViewById(R.id.szam3);
        buttons[4] = findViewById(R.id.szam4);
        buttons[5] = findViewById(R.id.szam5);
        buttons[6] = findViewById(R.id.szam6);
        buttons[7] = findViewById(R.id.szam7);
        buttons[8] = findViewById(R.id.szam8);
        buttons[9] = findViewById(R.id.szam9);
        buttons[10] = findViewById(R.id.comma);
        buttons[11] = findViewById(R.id.plussz);
        buttons[12] = findViewById(R.id.minusz);
        buttons[13] = findViewById(R.id.szorzas);
        buttons[14] = findViewById(R.id.osztas);
        buttons[15] = findViewById(R.id.egyenlo);
        buttons[16] = findViewById(R.id.memoryplussz);
        buttons[17] = findViewById(R.id.memoryminusz);
        buttons[18] = findViewById(R.id.AC);

/*
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
        */
/*
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
*/
        buttons[0].setOnClickListener(this);
        buttons[1].setOnClickListener(this);
        buttons[2].setOnClickListener(this);
        buttons[3].setOnClickListener(this);
        buttons[4].setOnClickListener(this);
        buttons[5].setOnClickListener(this);
        buttons[6].setOnClickListener(this);
        buttons[7].setOnClickListener(this);
        buttons[8].setOnClickListener(this);
        buttons[9].setOnClickListener(this);
        buttons[10].setOnClickListener(this);
        buttons[11].setOnClickListener(this);
        buttons[12].setOnClickListener(this);
        buttons[13].setOnClickListener(this);
        buttons[14].setOnClickListener(this);
        buttons[15].setOnClickListener(this);
        buttons[16].setOnClickListener(this);
        buttons[17].setOnClickListener(this);
        buttons[18].setOnClickListener(this);
    }

    public void onClick(View v)
    {
        Button button = (Button) v;

        int buttonId = button.getId();
        //TODO megoldani hogy a buttonID mukodjon a buttonarrayjel
        // lehet jo a switch de lehet jobb a for loop
        // ha kitalaltatok valamit szoljatok
        // egyenlore csak kikommenteltem amit valtoztattam mert meg nem mukodik amit akarok

        String input = t1.getText().toString();

        switch(button.getId()){
            case R.id.szam0:
                if (input.equals("0"))
                    break;

            case R.id.comma:

                if (input.contains("."))
                {
                    StringBuilder sb = new StringBuilder(input);
                    sb.deleteCharAt(input.indexOf("."));
                    t1.setText(sb.toString());
                }

            case R.id.szam1:
            case R.id.szam2:
            case R.id.szam3:
            case R.id.szam4:
            case R.id.szam5:
            case R.id.szam6:
            case R.id.szam7:
            case R.id.szam8:
            case R.id.szam9:

                if (justOutputted && buttonId != R.id.comma)
                {
                    t1.setText(button.getText().toString());
                    justOutputted = false;
                }
                else
                {
                    t1.setText(t1.getText() + button.getText().toString());
                    justOutputted = false;
                }

                break;

            case R.id.plussz:
                DoMath(Operations.Addition);
                break;
            case R.id.minusz:
                DoMath(Operations.Subtraction);
                break;
            case R.id.szorzas:
                DoMath(Operations.Multiplication);
                break;
            case R.id.osztas:
                DoMath(Operations.Division);
                break;

            case R.id.egyenlo:
                if (prevOp != null)
                {

                    DoMath(Operations.Equal);
                }
                else
                    Display(Input());
                break;

            case R.id.AC:
                ResetCalculator();
                break;
            case R.id.memoryplussz:
                memory += Input();
                break;
            case R.id.memoryminusz:
                memory -= Input();
                break;
        }
    }

    private void ResetCalculator()
    {
        Display(0);
        firstInput = true;
        prevInput = 0;
        prevOp = null;
        prevResult = 0;
    }

    private void Display(double x)
    {
        justOutputted = true;
        DecimalFormat df = new DecimalFormat("###,###,###,###.###############");
        t1.setText(df.format(x));
        prevResult = x;
    }

    private double Input() {
        String input = t1.getText().toString();
        input = input.replaceAll("[^0-9.]", "");
        if (input.startsWith("."))
        {
            input = input.replace(".", "0.");
        }

        else if (input.endsWith("."))
        {
            input = input.replace(".", "");
        }

        if (!justOutputted)
        {
            prevInput = Double.parseDouble(input);
        }
        return prevInput;
    }

    private void DoMath(Operations op)
    {

        double input = Input();
        if (prevOp == null)
        {
            prevOp = op;
            if (!justOutputted)
                Display(input);
            else
                Display(prevResult);
            return;
        }

        switch (prevOp)
        {
            case Addition:
                Display(prevResult + input);
                break;

            case Subtraction:
                Display(prevResult - input);
                break;

            case Multiplication:
                Display(prevResult * input);
                break;

            case Division:
                if (input == 0)
                {
                    Toast.makeText(getApplicationContext(), "Nullával nem lehet osztani.", Toast.LENGTH_SHORT).show();
                    ResetCalculator();
                    return;
                }
                Display(prevResult / input);
                break;
        }
        prevOp = op;
    }
}

enum Operations
{
    Addition, Subtraction, Multiplication, Division, Equal
}
