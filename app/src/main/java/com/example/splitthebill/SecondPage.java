package com.example.splitthebill;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class SecondPage extends AppCompatActivity {
    double bill;
    int people;
    double split;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        final EditText peopleAmount = (EditText)findViewById(R.id.peopleText);
        final EditText billAmount = (EditText)findViewById(R.id.billText);
        final Spinner group = (Spinner)findViewById(R.id.spinner);
        Button calculate = (Button)findViewById(R.id.button2);
        calculate.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView)findViewById(R.id.result));
            @Override
            public void onClick(View v) {
                bill = Double.parseDouble(billAmount.getText().toString());
                people = Integer.parseInt(peopleAmount.getText().toString());
                split = (bill + (bill * .18)) / people;
                DecimalFormat currency = new DecimalFormat("$###,###.00");
                result.setText("Each person pays " + currency.format(split));
            }
        });
    }
}
