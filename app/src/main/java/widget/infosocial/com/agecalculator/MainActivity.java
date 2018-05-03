package widget.infosocial.com.agecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnStart).setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, AgeCalculatorActivity.class  );
            startActivity(i);
        });

    }
}
