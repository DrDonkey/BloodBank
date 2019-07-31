package np.com.aasutosh.bloodbank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);
    }
    public void logIn(View view) {

        switch(view.getId())
        {
            case R.id.button_register:
//                  handle button A click;
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.button_already_registered:
//                  handle button B click;
                break;
            default:
                throw new RuntimeException("Unknown button ID");
        }

    }
}
