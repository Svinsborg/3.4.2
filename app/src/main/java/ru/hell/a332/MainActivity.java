package ru.hell.a332;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    ImageView image;
    Spinner select;
    Button ok;
    TextView text;
    String param = "ru";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        ArrayAdapter<?> arrCh =ArrayAdapter.createFromResource( this, R.array.language, android.R.layout.simple_spinner_item);
        arrCh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        select.setAdapter(arrCh);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                param = select.getSelectedItem().toString();
                if(param.equals("Russisch") || param.equals("Russian") || param.equals("Русский")){
                    param = "ru";
                    changeLang(param);
                }
                if (param.equals("English") || param.equals("Английский") || param.equals("Englisch")){
                    param = "en";
                    changeLang(param);
                }
                if (param.equals("German") || param.equals("Немецкий") || param.equals("Deutsche")){
                    param = "de";
                    changeLang(param);
                }
            }
        });

    }

    private void init() {
        image = findViewById(R.id.imageFlag);
        select = findViewById(R.id.spinner);
        ok = findViewById(R.id.button);
        text = findViewById(R.id.text);
    }

    private void changeLang(String reg) {
        Locale locale = new Locale(reg);

        Configuration config = new Configuration();
        config.setLocale(locale);

        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

        recreate();
    }

}
