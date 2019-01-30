package ke.co.technopro_solutions.iamrich;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataModel {
    private String city;
    private double temp;
    private String icon;
    private int condition;

    public static WeatherDataModel fromJSON(JSONObject jsonObject){
        WeatherDataModel weatherDataModel = new WeatherDataModel();

        try {
            weatherDataModel.city       = jsonObject.getString("name");
            weatherDataModel.condition  = jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherDataModel.temp       = jsonObject.getJSONObject("main").getDouble("temp");
            weatherDataModel.icon       = WeatherDataModel.updateWeatherIcon(weatherDataModel.condition);

            return  weatherDataModel;
        }catch (JSONException e){
            Log.d("Clima", e.toString());
            return null;
        }

    }

    private static String updateWeatherIcon(int condition){
        if (condition >= 0 && condition < 300) {
            return "tstorm1";
        } else if (condition >= 300 && condition < 500) {
            return "light_rain";
        } else if (condition >= 500 && condition < 600) {
            return "shower3";
        } else if (condition >= 600 && condition <= 700) {
            return "snow4";
        } else if (condition >= 701 && condition <= 771) {
            return "fog";
        } else if (condition >= 772 && condition < 800) {
            return "tstorm3";
        } else if (condition == 800) {
            return "sunny";
        } else if (condition >= 801 && condition <= 804) {
            return "cloudy2";
        } else if (condition >= 900 && condition <= 902) {
            return "tstorm3";
        } else if (condition == 903) {
            return "snow5";
        } else if (condition == 904) {
            return "sunny";
        } else if (condition >= 905 && condition <= 1000) {
            return "tstorm3";
        }

        return "dunno";
    }

    public String getCity() {
        return city;
    }

    public String getTemp() {
        int local_temp;
        local_temp = (int) Math.rint(temp-273.15);
        return local_temp + "° C";
    }

    public String getIcon() {
        return icon;
    }
}
