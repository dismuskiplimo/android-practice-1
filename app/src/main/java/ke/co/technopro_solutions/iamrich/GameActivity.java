package ke.co.technopro_solutions.iamrich;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Button rollButton = findViewById(R.id.rollDice);

        final ImageView leftDice = findViewById(R.id.leftDice);

        final ImageView rightDice = findViewById(R.id.rightDice);

        final int[] diceArray = {
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        };

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random randomNumberGenerator = new Random();

                int number = randomNumberGenerator.nextInt(6);

                leftDice.setImageResource(diceArray[number]);

                number = randomNumberGenerator.nextInt(6);

                rightDice.setImageResource(diceArray[number]);



            }
        });




    }
}
