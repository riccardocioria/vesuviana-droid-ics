package it.vesuviana.servizi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

public class SplashScreen extends Activity {
	protected boolean _active = true;
    protected static final int SPLASH_TIME = 4000;
    // thread for displaying the SplashScreen
    protected Thread splashTread = new Thread() {
        @Override
        public void run() {
            try {
                int waited = 0;
                while(_active && (waited < SPLASH_TIME)) {
                    sleep(100);
                    if(_active) {
                        waited += 100;
                    }
                }
            } catch(InterruptedException e) {
                // do nothing
            } finally {
                finish();
                startActivity(new Intent("it.vesuviana.servizi.MainActivity"));
                //stop();
                stopSplashThread();
            }
        }
    };
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        splashTread.start();
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            _active = false;
        }
        return true;
    }
    
    protected void stopSplashThread() {
    	splashTread = null;
    }
}