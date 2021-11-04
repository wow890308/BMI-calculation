package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.icu.text.NumberFormat;
//import android.support.annotation.RequiresApi;
//import android.support.v7.app.AppCompatActivity;





public class MainActivity extends AppCompatActivity {
    EditText haha;
    EditText wawa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        haha = (EditText) findViewById(R.id.editTextTextPersonName);
        wawa = (EditText) findViewById(R.id.editTextTextPersonName2);
        Button submit = (Button) findViewById(R.id.button);

        submit.setOnClickListener(new Button.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onClick(View arge0) {
                if (!("".equals(haha.getText().toString())
                        || "".equals(wawa.getText().toString()))) {
                    float fh = Float.parseFloat(haha.getEditableText().toString());
                    float fw = Float.parseFloat(wawa.getEditableText().toString());
                    float fresult;
                    TextView result = (TextView) findViewById(R.id.textView3);
                    fh = fh / 100;
                    fh = fh * fh;

                    NumberFormat nf = NumberFormat.getInstance();
                    nf.setMaximumFractionDigits(2);
                    fresult = fw / fh;
                    result.setText(nf.format(fw / fh) + "");
                    TextView dia = (TextView) findViewById(R.id.textView4);

                    if (fresult < 18.5)
                        dia.setText("體重過輕");
                    else if (18.5 <= fresult && fresult < 24)
                        dia.setText("正常範圍");
                    else if (24 <= fresult && fresult < 27)
                        dia.setText("過    重");
                    else if (27 <= fresult && fresult < 30)
                        dia.setText("輕度肥胖");
                    else if (30 <= fresult && fresult < 35)
                        dia.setText("中度肥胖");
                    else if (fresult >= 35)
                        dia.setText("重度肥胖        ");


                }
            }
        });


    }
}
