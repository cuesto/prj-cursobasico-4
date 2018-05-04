package widget.infosocial.com.agecalculator;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        int DURATION_SPLASH = 1500;
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this, AgeCalculatorActivity.class);
            startActivity(intent);
            finish();
        }, DURATION_SPLASH);

    }
}
