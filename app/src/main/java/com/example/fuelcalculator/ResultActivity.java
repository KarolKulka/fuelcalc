package com.example.fuelcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity {

    private TextView totalCostText, costPerPersonText, costPer100KmText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        totalCostText = findViewById(R.id.totalCostText);
        costPerPersonText = findViewById(R.id.costPerPersonText);
        costPer100KmText = findViewById(R.id.costPer100KmText);

        Intent intent = getIntent();
        double totalCost = intent.getDoubleExtra("totalCost", 0);
        double costPerPerson = intent.getDoubleExtra("costPerPerson", 0);
        double costPer100Km = intent.getDoubleExtra("costPer100Km", 0);

        totalCostText.setText("Całkowity koszt paliwa: " + totalCost + " PLN");
        costPerPersonText.setText("Koszt paliwa na osobę: " + costPerPerson + " PLN/os.");
        costPer100KmText.setText("Koszt przejechania 100 km: " + costPer100Km + " PLN");
    }
}
