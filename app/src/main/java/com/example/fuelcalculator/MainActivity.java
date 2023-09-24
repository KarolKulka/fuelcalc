package com.example.fuelcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fuelcalculator.R;
import com.example.fuelcalculator.ResultActivity;

import org.decimal4j.util.DoubleRounder;

public class MainActivity extends Activity {

    private EditText editDistance, editFuelConsumption, editFuelPrice, editPassengers;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editDistance = findViewById(R.id.editDistance);
        editFuelConsumption = findViewById(R.id.editFuelConsumption);
        editFuelPrice = findViewById(R.id.editFuelPrice);
        editPassengers = findViewById(R.id.editPassengers);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateCost();
            }
        });
    }

    private void calculateCost() {
        double distance = Double.parseDouble(editDistance.getText().toString());
        double fuelConsumption = Double.parseDouble(editFuelConsumption.getText().toString());
        double fuelPrice = Double.parseDouble(editFuelPrice.getText().toString());
        int passengers = Integer.parseInt(editPassengers.getText().toString());

        double totalCost = (distance / 100) * fuelConsumption * fuelPrice;
        double costPerPerson = totalCost / passengers;
        double costPer100Km = (totalCost / distance) * 100;

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("totalCost", DoubleRounder.round(totalCost, 2));
        intent.putExtra("costPerPerson", DoubleRounder.round(costPerPerson, 2));
        intent.putExtra("costPer100Km", DoubleRounder.round(costPer100Km, 2));
        startActivity(intent);
    }
}
