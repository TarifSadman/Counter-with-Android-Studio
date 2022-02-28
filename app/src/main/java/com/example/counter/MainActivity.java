package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tcounter;
    private Button bplus, bminus, breset, bmage;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tcounter = findViewById(R.id.texthw);
        bplus = findViewById(R.id.b1);
        bminus = findViewById(R.id.b2);
        breset = findViewById(R.id.b3);
        bmage = findViewById(R.id.b4);
        img = findViewById(R.id.iv);
    }
    public void Lol(View view){
        int id = view.getId();
        int counter = 0;

        switch(id){
            case R.id.b1:
                counter = Integer.parseInt(tcounter.getText().toString());
                counter++;
                tcounter.setText(counter+"");
                break;
            case R.id.b2:
                counter = Integer.parseInt(tcounter.getText().toString());
                if(counter!=0) {
                    counter--;
                    tcounter.setText(counter + "");
                }
                    break;
            case R.id.b3:
                tcounter.setText("0");
                }
                bmage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(img.getVisibility() == View.VISIBLE){
                            img.setVisibility(View.GONE);
                        }
                        else{
                            img.setVisibility(View.VISIBLE);
                        }
                    }
                                         ;}
                );}
}