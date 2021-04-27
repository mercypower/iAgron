package com.example.iagron;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.Toolbar;

public class RasvitActivity extends AppCompatActivity {
    /* access modifiers changed from: private */
    public int money = 10000;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.razvit_content);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle((CharSequence) "Развитие СХ");
        initSpinner((AppCompatSpinner) findViewById(R.id.spinner));
    }

    private void initSpinner(AppCompatSpinner spinner) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View itemSelected, int selectedItemPosition, long selectedId) {
                String[] choose = RasvitActivity.this.getResources().getStringArray(R.array.poliv_array);
                if (selectedItemPosition == 0) {
                    RasvitActivity rasvitActivity = RasvitActivity.this;
                    int unused = rasvitActivity.money = rasvitActivity.money - 400;
                } else if (selectedItemPosition == 1) {
                    RasvitActivity rasvitActivity2 = RasvitActivity.this;
                    int unused2 = rasvitActivity2.money = rasvitActivity2.money - 600;
                } else if (selectedItemPosition == 2) {
                    RasvitActivity rasvitActivity3 = RasvitActivity.this;
                    int unused3 = rasvitActivity3.money = rasvitActivity3.money - 800;
                } else if (selectedItemPosition == 3) {
                    RasvitActivity rasvitActivity4 = RasvitActivity.this;
                    int unused4 = rasvitActivity4.money = rasvitActivity4.money - 1200;
                }
                Context applicationContext = RasvitActivity.this.getApplicationContext();
                Toast.makeText(applicationContext, "Ваш выбор: " + choose[selectedItemPosition] + " У вас осталось " + RasvitActivity.this.money, 0).show();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}
