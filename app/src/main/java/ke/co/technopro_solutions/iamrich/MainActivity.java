package ke.co.technopro_solutions.iamrich;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startGame = findViewById(R.id.play_dice);

        Button startBallGame = findViewById(R.id.ball_button);

        Button playPiano = findViewById(R.id.play_piano);

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameIntent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(gameIntent);
            }
        });

        startBallGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newBallGame = new Intent(MainActivity.this, BallActivity.class);
                startActivity(newBallGame);
            }
        });

        playPiano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pianoGame = new Intent(MainActivity.this, PianoActivity.class);
                startActivity(pianoGame);
            }
        });

    }

    public void loadWeatherActivity(View v){
        startActivity(new Intent(MainActivity.this, WeatherAvtivity.class));
    }
}
