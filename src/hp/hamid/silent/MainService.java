package hp.hamid.silent;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;

public class MainService extends IntentService {
	
	Vibrator vib ;
	AudioManager audio;
	
	public MainService() {
		super("hamid");
	}

	@Override
	protected void onHandleIntent(Intent arg0) {
		int now = audio.getRingerMode();
		 if(now == 1){
			 audio.setRingerMode(2);
			 try {
			        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
			        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
			        r.play();
			    } catch (Exception e) {}
		 }
		 else
		 {
			 audio.setRingerMode(1); 
		 	 vib.vibrate(50);
		 }
		 stopSelf();
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
	    return super.onStartCommand(intent,flags,startId);
	}

	@Override
	public void onCreate() {
		vib = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
		audio = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		super.onCreate();
	}

}
