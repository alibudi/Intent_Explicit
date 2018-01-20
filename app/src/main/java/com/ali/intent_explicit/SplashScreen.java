package com.ali.intent_explicit;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

//    private static int SPLASE_TIME_OUT = 4000;
  private  int progressstatus = 0;
  private int finish = 0;
  private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

  /*      new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent maininten = new Intent(SplashScreen.this, MainActivity.class );
                startActivity(maininten);
                finish();
            }
        }, SPLASE_TIME_OUT);
    */

    final TextView progress_angka = (TextView) findViewById(R.id.progresangka);
    final ProgressBar pb = (ProgressBar) findViewById(R.id.progresbar);

    progressstatus = 0;

    new Thread(new Runnable() {
        @Override
        public void run() {
            while (progressstatus < 100){
                progressstatus +=1;

                try{
                    Thread.sleep(50);
                    if (progressstatus == 100){
                        Intent mainintent = new Intent(SplashScreen.this, MainActivity.class);
                        startActivity(mainintent);
                    }
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        pb.setProgress(progressstatus);
                        progress_angka.setText(progressstatus+"");
                    }
                });

            }
        }
    }).start();
    }
}
