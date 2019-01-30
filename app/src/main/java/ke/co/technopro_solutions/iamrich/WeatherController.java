package ke.co.technopro_solutions.iamrich;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class WeatherController extends AppCompatActivity {
    String city;
    EditText city_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_controller);
    }

    public void getWeatherForCity(View v){
        city_name = findViewById(R.id.city_name_field);
        city = city_name.getText().toString();

        Toast.makeText(this, city, Toast.LENGTH_SHORT).show();

    }
}
