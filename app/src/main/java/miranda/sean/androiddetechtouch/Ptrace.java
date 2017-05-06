package miranda.sean.androiddetechtouch;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Ptrace extends ActionBarActivity {
    MediaPlayer p_sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptrace);
        stopService(new Intent(getBaseContext(), MyService.class));
        p_sound=MediaPlayer.create(Ptrace.this,R.raw.p);
        p_sound.start();


        Button b = (Button)findViewById(R.id.button2);
        Button psound = (Button)findViewById(R.id.sound_icon);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Ptrace.this,P.class);
                startActivity(i);
                finish();

            }
        });

        psound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p_sound= MediaPlayer.create(Ptrace.this,R.raw.p);
                p_sound.start();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_btrace, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(Ptrace.this, Alphabets_numbers.class));
        finish();

    }
}
