package ke.co.technopro_solutions.iamrich;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class WeatherAvtivity extends AppCompatActivity {

    //Minimum duration before change in miliseconds
    protected static int MIN_TIME = 5000;

    //Minimum distance before location update
    protected static int MIN_DISTANCE = 1000;

    protected int REQUEST_CODE = 456;

    protected final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather";

    protected final String APP_ID = "6134317c10db877014543c36d6f4d45d";

    //Location Provider
    protected static String LOCATION_PROVIDER = LocationManager.GPS_PROVIDER;

    protected LocationManager locationManager;

    protected LocationListener locationListener;

    protected String location;

    protected String city;
    protected String temp;
    protected String icon;
    protected String condition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_avtivity);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();

        String intent_city = intent.getStringExtra("City");

        if(intent_city == null){
            getCurrentLocation();
        }else{
            getWeatherForCity(intent_city);

        }


    }

    @Override
    protected void onPause() {
        super.onPause();

        if(locationManager != null){
            locationManager.removeUpdates(locationListener);
        }
    }

    protected void getCurrentLocation() {
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {


                String latitude     = String.valueOf(location.getLatitude());
                String longitude    = String.valueOf(location.getLongitude());

                RequestParams params = new RequestParams();

                params.put("lat", latitude);
                params.put("lon", longitude);
                params.put("appid", APP_ID);

                letsDoSomeNetworking(params);


            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);

            return;
        }

        locationManager.requestLocationUpdates(LOCATION_PROVIDER, MIN_TIME, MIN_DISTANCE, locationListener);
    }

    protected void getWeatherForCity(String city){
        RequestParams params = new RequestParams();
        params.put("q", city);
        params.put("appid", APP_ID);

        letsDoSomeNetworking(params);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            getCurrentLocation();
        }else{
            Toast.makeText(this, "Location is needed in order to use the weather app", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public void loadWeatherController(View v){
        startActivity(new Intent(WeatherAvtivity.this, WeatherController.class));
    }

    public void letsDoSomeNetworking(RequestParams params){
        AsyncHttpClient client = new AsyncHttpClient();

        client.get(WEATHER_URL, params, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response){
                Log.d("Clima", response.toString());

                WeatherDataModel weatherDataModel = WeatherDataModel.fromJSON(response);

                updateUI(weatherDataModel);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable e, JSONObject response){
                Log.e("Clima", e.toString());
                Log.d("Clima", "Status Code: " + statusCode);

                Toast.makeText(getApplicationContext(), "Request Failed", Toast.LENGTH_SHORT).show();
            }

            public void updateUI(WeatherDataModel weatherDataModel){
                if(weatherDataModel != null){
                    TextView city_name      = findViewById(R.id.city_field);
                    TextView temp           = findViewById(R.id.temp);
                    ImageView weather_icon  = findViewById(R.id.weather_icon);
                    int resourceId;

                    resourceId = getResources().getIdentifier(weatherDataModel.getIcon(), "drawable",getPackageName());

                    temp.setText(weatherDataModel.getTemp());
                    weather_icon.setImageResource(resourceId);
                    city_name.setText(weatherDataModel.getCity());


                }
            }
        });
    }


}
