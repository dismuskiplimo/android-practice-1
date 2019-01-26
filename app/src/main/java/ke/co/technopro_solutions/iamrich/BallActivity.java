package ke.co.technopro_solutions.iamrich;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BallActivity extends AppCompatActivity {

    Button rollBall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ball);

        rollBall = findViewById(R.id.roll_ball);

        rollBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Rolling Ball", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
