package com.example.iagron;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TextContentActivity extends AppCompatActivity {
    private int[] array_kylt = {R.string.kylt_1, R.string.kylt_2, R.string.kylt_3, R.string.kylt_4, R.string.kylt_5, R.string.kylt_6, R.string.kylt_7, R.string.kylt_8, R.string.Kylt_9, R.string.kylt_10, R.string.kylt_11, R.string.kylt_12, R.string.kylt_13};
    private int[] array_pochv = {R.string.pochva_1, R.string.pochva_2, R.string.pochva_3, R.string.pochva_4, R.string.pochva_5, R.string.pochva_6, R.string.pochva_7, R.string.pochva_8};
    private int[] array_ydobr = {R.string.ydobrenie_1, R.string.ydobrenie_2, R.string.ydobrenie_3, R.string.ydobrenie_4, R.string.ydobrenie_5, R.string.ydobrenie_6, R.string.ydobrenie_7, R.string.ydobrenie_8};
    private int category = 0;
    private Typeface face1;
    private int position = 0;
    private TextView text_content;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.text_contemt);
        init();
        reciveIntent();
    }

    private void reciveIntent() {
        Intent i = getIntent();
        if (i != null) {
            category = i.getIntExtra("category", 0);
            position = i.getIntExtra("position", 0);
        }
        int i2 = this.category;
        if (i2 == 0) {
            text_content.setText(this.array_kylt[this.position]);
        } else if (i2 == 1) {
            text_content.setText(this.array_ydobr[this.position]);
        } else if (i2 == 2) {
            text_content.setText(this.array_pochv[this.position]);
        }
    }

    private void init() {
        this.text_content = (TextView) findViewById(R.id.text_main_content);
        //Typeface createFromAsset = Typeface.createFromAsset(getAssets(), "fonts/Oswald-VariableFont_wght.ttf");
      //  this.text_content.setTypeface(createFromAsset);
    }
}
