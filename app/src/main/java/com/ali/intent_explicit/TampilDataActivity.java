package com.ali.intent_explicit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class TampilDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_data);

        Bundle b = getIntent().getExtras();

        TextView nama = (TextView) findViewById(R.id.valuenama);
        TextView alamat = (TextView) findViewById(R.id.valuealamat);
        TextView umur = (TextView) findViewById(R.id.valueumur);
        TextView nohp = (TextView) findViewById(R.id.valueno_hp);
        RadioButton jeniskelamin = (RadioButton) findViewById(R.id.valuejeniskelamin);

        nama.setText(b.getCharSequence("nama"));
        alamat.setText(b.getCharSequence("alamat"));
        umur.setText(b.getCharSequence("umur"));
        nohp.setText(b.getCharSequence("nohp"));
        jeniskelamin.setText(b.getCharSequence("jeniskelamin"));
    }
}
