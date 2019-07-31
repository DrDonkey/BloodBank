package np.com.aasutosh.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Spinner spinner;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        editText = findViewById(R.id.etPhoneNumber);

        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, CountryData.countryNames));

    }

    public void checkDetails(View view) {
        String phone = editText.getText().toString().trim();
        if (phone.isEmpty() || phone.length() < 10) {
            editText.setError("Valid number is required");
            editText.requestFocus();
            return;
        }
        Toast.makeText(this, phone, Toast.LENGTH_SHORT).show();
        String code = CountryData.countryAreaCodes[spinner.getSelectedItemPosition()];
        Log.i("Phone", phone);
        Log.i("COde", code);

        String phoneNo = "+" + code + phone;
        Log.i("phone+code", phoneNo);
        Intent intent = new Intent(this, VerifyPhone.class);
        intent.putExtra("phoneNo", phoneNo);
        startActivity(intent);

    }

}
