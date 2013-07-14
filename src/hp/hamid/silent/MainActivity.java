package hp.hamid.silent;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Vibrator vib ;
	AudioManager audio;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		vib = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
		audio = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
	}
	
	public void silent(View v){
		 int now = audio.getRingerMode();
		 if(now == 1)
			 Toast.makeText(this, "already silent!", Toast.LENGTH_SHORT).show();
		 else
			 audio.setRingerMode(1); 
		 vib.vibrate(50);
	}
	
	public void onsilent(View v){
		 audio.setRingerMode(2);
		 try {
		        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
		        r.play();
		    } catch (Exception e) {}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
