package com.ali.intent_explicit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    EditText nama;
    EditText alamat;
    EditText umur;
    EditText nohp;
    RadioGroup jeniskelamin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findAllViewsid();
        button.setOnClickListener(this);
    }

    private void findAllViewsid() {
        button = (Button) findViewById(R.id.kirimdata);
        nama = (EditText) findViewById(R.id.edtnama);
        alamat = (EditText) findViewById(R.id.edtalamat);
        umur = (EditText) findViewById(R.id.edtumur);
        nohp = (EditText) findViewById(R.id.edthp);
        jeniskelamin = (RadioGroup) findViewById(R.id.radio);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), TampilDataActivity.class);

        Bundle b = new Bundle();

        b.putString("nama", nama.getText().toString());
        b.putString("alamat", alamat.getText().toString());
        b.putString("umur", umur.getText().toString());
        b.putString("nohp", nohp.getText().toString());
        int idjeniskelamin = jeniskelamin.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(idjeniskelamin);
        b.putString("jeniskelamin", radioButton.getText().toString());

        intent.putExtras(b);
        startActivity(intent);
        onBackPressed();
    }
}
