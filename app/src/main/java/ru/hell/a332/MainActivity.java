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

    private ImageView image;
    private Spinner select, chTheme, chMarg;
    private Button ok;
    private TextView text;
    private String param = "ru";
    private static int currentThemeRes = -1, set, mrg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (currentThemeRes != -1){
            setTheme(currentThemeRes);
        }

        setContentView(R.layout.activity_main);

        init();

        ArrayAdapter<?> arrCh = ArrayAdapter.createFromResource( this, R.array.language, android.R.layout.simple_spinner_item);
        arrCh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        select.setAdapter(arrCh);



        ArrayAdapter<?> arrMg = ArrayAdapter.createFromResource( this, R.array.margin, android.R.layout.simple_spinner_item);
        arrMg.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        chMarg.setAdapter(arrMg);


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mrg = chMarg.getSelectedItemPosition();
                switch (mrg) {
                    case 0:
                        currentThemeRes = R.style.AppTheme_Small;
                        break;
                    case 1:
                        currentThemeRes =  R.style.AppTheme_Medium;
                        break;
                    case 2:
                        currentThemeRes = R.style.AppTheme_Big;
                        break;
                    default:
                        break;
                }

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
        chMarg = findViewById(R.id.spinMarg);
       /* chTheme = findViewById(R.id.spinTheme);*/
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
