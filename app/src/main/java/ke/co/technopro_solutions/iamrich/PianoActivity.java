package ke.co.technopro_solutions.iamrich;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PianoActivity extends AppCompatActivity {

    private final int NR_OF_SIMULTANEOUS_SOUNDS = 7;
    private final float LEFT_VOLUME             = 1.0f;
    private final float RIGHT_VOLUME            = 1.0f;
    private final int NO_LOOP                   = 0;
    private final int PRIORITY                  = 0;
    private final float NORMAL_PLAY_RATE        = 1.0f;

    private SoundPool soundPool;
    private int cSoundId;
    private int dSoundId;
    private int eSoundId;
    private int fSoundId;
    private int gSoundId;
    private int aSoundId;
    private int bSoundId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano);

        soundPool = new SoundPool(NR_OF_SIMULTANEOUS_SOUNDS, AudioManager.STREAM_MUSIC, 0);

        cSoundId = soundPool.load(getApplicationContext(),R.raw.note1_c, PRIORITY);
        dSoundId = soundPool.load(getApplicationContext(),R.raw.note2_d, PRIORITY);
        eSoundId = soundPool.load(getApplicationContext(),R.raw.note3_e, PRIORITY);
        fSoundId = soundPool.load(getApplicationContext(),R.raw.note4_f, PRIORITY);
        gSoundId = soundPool.load(getApplicationContext(),R.raw.note5_g, PRIORITY);
        aSoundId = soundPool.load(getApplicationContext(),R.raw.note6_a, PRIORITY);
        bSoundId = soundPool.load(getApplicationContext(),R.raw.note7_b, PRIORITY);

    }

    public void playCSound(View v){
        soundPool.play(cSoundId,LEFT_VOLUME,RIGHT_VOLUME, PRIORITY,NO_LOOP, NORMAL_PLAY_RATE);
    }

    public void playDSound(View v){
        soundPool.play(dSoundId,LEFT_VOLUME,RIGHT_VOLUME, PRIORITY,NO_LOOP, NORMAL_PLAY_RATE);
    }

    public void playESound(View v){
        soundPool.play(eSoundId,LEFT_VOLUME,RIGHT_VOLUME, PRIORITY,NO_LOOP, NORMAL_PLAY_RATE);
    }

    public void playFSound(View v){
        soundPool.play(fSoundId,LEFT_VOLUME,RIGHT_VOLUME, PRIORITY,NO_LOOP, NORMAL_PLAY_RATE);
    }

    public void playGSound(View v){
        soundPool.play(gSoundId,LEFT_VOLUME,RIGHT_VOLUME, PRIORITY,NO_LOOP, NORMAL_PLAY_RATE);
    }

    public void playASound(View v){
        soundPool.play(aSoundId,LEFT_VOLUME,RIGHT_VOLUME, PRIORITY,NO_LOOP, NORMAL_PLAY_RATE);
    }

    public void playBSound(View v){
        soundPool.play(bSoundId,LEFT_VOLUME,RIGHT_VOLUME, PRIORITY,NO_LOOP, NORMAL_PLAY_RATE);
    }
}
