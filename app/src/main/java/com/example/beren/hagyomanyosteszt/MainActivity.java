package com.example.beren.hagyomanyosteszt;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
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
    Button buttons [] = new Button[19];
    ConstraintLayout constraintLayout;
    AnimationDrawable animationDrawable;

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

            case R.id.intacool:
                constraintLayout.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.animation_list));
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
/*
        constraintLayout = (ConstraintLayout) findViewById(R.id.contraintlayout);
        animationDrawable =(AnimationDrawable)constraintLayout.getBackground();

        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(1000);
*/
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

        t1 = findViewById(R.id.kijelzo1);
    }
/*
    @Override
    protected void onResume() {
        super.onResume();

        animationDrawable.start();
    }
*/
    public void onClick(View v)
    {
        Button button = (Button) v;

        int buttonId = button.getId();

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
                //TODO irni fuggvenyt a click_gradient change re (most csak gyoran inmplementaltam)
                buttons[11].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.clicked_gradient));
                DoMath(Operations.Addition);
                break;
            case R.id.minusz:
                buttons[12].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.clicked_gradient));
                DoMath(Operations.Subtraction);
                break;
            case R.id.szorzas:
                buttons[13].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.clicked_gradient));
                DoMath(Operations.Multiplication);
                break;
            case R.id.osztas:
                buttons[14].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.clicked_gradient));
                DoMath(Operations.Division);
                break;

            case R.id.egyenlo:
                if (prevOp != null)
                {
                    DoMath(Operations.Equal);
                    buttons[11].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.operation_gradient));
                    buttons[12].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.operation_gradient));
                    buttons[13].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.operation_gradient));
                    buttons[14].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.operation_gradient));
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
