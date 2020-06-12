package com.example.newcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8,
            btn_9, btn_dot, btn_mult, btn_plus, btn_c, btn_equally, btn_division, btn_minus;

    TextView result, info;
    private final char ADDITION = '+';
    private final char MINUS = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private double val1 = Double.NaN;
    private double val2;
    private final char EQU = '0';
    private char ACTION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_dot = (Button) findViewById(R.id.btn_dot);

        btn_division = (Button) findViewById(R.id.btn_division);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_mult = (Button) findViewById(R.id.btn_mult);
        btn_c = (Button) findViewById(R.id.btn_c);
        btn_equally = (Button) findViewById(R.id.btn_equally);

        result = (TextView) findViewById(R.id.text_view);
        info = (TextView) findViewById(R.id.text_result);

    }

    private void compute() {
        if (!Double.isNaN(val1)) {
            val2 = Double.parseDouble(info.getText().toString());

            switch (ACTION) {
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case MINUS:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case EQU:
                    break;
            }
        } else {
            val1 = Double.parseDouble(info.getText().toString());
        }
    }

    @SuppressLint("SetTextI18n")
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_0:
                info.setText(info.getText().toString() + "0");
                break;
            case R.id.btn_1:
                info.setText(info.getText().toString() + "1");
                break;
            case R.id.btn_2:
                info.setText(info.getText().toString() + "2");
                break;
            case R.id.btn_3:
                info.setText(info.getText().toString() + "3");
                break;
            case R.id.btn_4:
                info.setText(info.getText().toString() + "4");
                break;
            case R.id.btn_5:
                info.setText(info.getText().toString() + "5");
                break;
            case R.id.btn_6:
                info.setText(info.getText().toString() + "6");
                break;
            case R.id.btn_7:
                info.setText(info.getText().toString() + "7");
                break;
            case R.id.btn_8:
                info.setText(info.getText().toString() + "8");
                break;
            case R.id.btn_9:
                info.setText(info.getText().toString() + "9");
                break;
            case R.id.btn_minus:
                compute();
                ACTION = MINUS;
                result.setText(String.valueOf(val1) + "-");
                info.setText(null);
                break;
            case R.id.btn_plus:
                compute();
                ACTION = ADDITION;
                result.setText(String.valueOf(val1) + "+");
                info.setText(null);
                break;
            case R.id.btn_division:
                compute();
                ACTION = DIVISION;
                result.setText(String.valueOf(val1) + "/");
                info.setText(null);
                break;
            case R.id.btn_equally:
                compute();
                ACTION = EQU;
                result.setText(result.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                info.setText(null);
                break;
            case R.id.btn_dot:
                info.setText(info.getText().toString() + ".");
                break;
            case R.id.btn_mult:
                compute();
                ACTION = MULTIPLICATION;
                result.setText(String.valueOf(val1) + "*");
                info.setText(null);
                break;
            case R.id.btn_c:
                if(info.getText().length() > 0){
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0, name.length()-1));
                }
                else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
                break;
        }
    }
}
