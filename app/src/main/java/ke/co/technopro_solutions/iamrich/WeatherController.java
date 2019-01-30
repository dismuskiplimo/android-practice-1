package ke.co.technopro_solutions.iamrich;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WeatherController extends AppCompatActivity {
    String city;

    EditText city_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_controller);

        city_name = findViewById(R.id.city_name_field);

        city_name.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                getWeather();

                return false;
            }
        });
    }



    public void getWeatherForCity(View v){
        getWeather();

    }

    private void getWeather(){
        city = (city_name.getText().toString().trim());



        Intent intent = new Intent(WeatherController.this, WeatherAvtivity.class);

        if(city.length() > 0){
            intent.putExtra("City", city);
        }

        startActivity(intent);
    }
}
