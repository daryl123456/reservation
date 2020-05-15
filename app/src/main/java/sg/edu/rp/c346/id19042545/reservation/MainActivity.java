package sg.edu.rp.c346.id19042545.reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName,etmobile,etsize;
    DatePicker dp;
    TimePicker tp;
    CheckBox cbSmoke;
    Button btnConfirm,btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.editTextName);
        etmobile = findViewById(R.id.editTextMobile);
        etsize = findViewById(R.id.editTextSize);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        cbSmoke = findViewById(R.id.checkBoxSmoke);
        btnClear = findViewById(R.id.buttonClear);
        btnConfirm = findViewById(R.id.buttonConfirm);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etName.getText().toString().trim().length() == 0 || etmobile.getText().toString().trim().length() == 0 || etsize.getText().toString().trim().length() == 0) {
                    Toast.makeText(MainActivity.this, "Please filled all Text Field", Toast.LENGTH_LONG).show();
                } else {


                    String message = "Name: " + etName.getText().toString() + " Mobile: " + etmobile.getText().toString() + " Size: " + etsize.getText();
                    int day = dp.getDayOfMonth();
                    int month = dp.getMonth();
                    int year = dp.getYear();
                    String date = day + "/" + month + 1 + "/" + year;
                    int hour = tp.getCurrentHour();
                    int min = tp.getCurrentMinute();
                    String time = hour + ":" + min;
                    message += " Date: " + date + " Time: " + time;
                    if (cbSmoke.isChecked()) {
                        message += " Smoking Table ";
                    } else {
                        message += " Non-Smoking Table ";
                    }
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etmobile.setText("");
                etName.setText("");
                etsize.setText("");
                dp.updateDate(2020, 5, 1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                cbSmoke.setChecked(false);
            }
        });
    }
}
