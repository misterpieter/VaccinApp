package be.volders.vaccinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import be.volders.vaccinapp.helpers.DateParser;
import be.volders.vaccinapp.helpers.ToastHelper;
import be.volders.vaccinapp.models.DateInputMask;
import be.volders.vaccinapp.models.Patient;

/**
 * The Main Activity of the application. This activity will display a EditText field with a date input mask,
 * as well as a checkbox and a button. When the user presses the button, the {@link PatientGivenVaccins} is launched.
 */
public class MainActivity extends AppCompatActivity {

    // Define UI elements
    EditText txtPatientDob;
    CheckBox checkRiskGroup;
    Button btnProceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle(R.string.main_title);

        // Initialize view objects
        txtPatientDob = findViewById(R.id.txtPatientDob);
        checkRiskGroup = findViewById(R.id.checkRiskGroup);
        btnProceed = findViewById(R.id.btnProceed);

        // Add an input mask to the patient dob field
        new DateInputMask(txtPatientDob);

        // Initialize a OnClickListener for the proceed button.
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onProceed();
            }
        });
    }

    /**
     * Attempt to parse the provided date of birth to a Date object.
     *
     * @return boolean  Whether parsing was successful or not
     */
    private boolean isValidDate() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH);
        try {
            Date date = format.parse(txtPatientDob.getText().toString());
            if (date == null) {
                return false;
            }
        } catch (ParseException e) {
            return false;
        }

        return true;
    }

    /**
     * Called when the user presses the onProceed button
     */
    private void onProceed() {
        // Make sure we have entered a valid date of birth before proceeding.
        if (isValidDate()) {
            // Set our patient object with provided data
            Date dob = DateParser.getDate(txtPatientDob.getText().toString());
            boolean isRiskGroup = checkRiskGroup.isChecked();
            Patient patient = new Patient(dob, isRiskGroup);

            // Start a new intent.
            Intent intent = new Intent(this, PatientGivenVaccins.class);
            intent.putExtra("patient", patient);
            startActivity(intent);
        } else {
            ToastHelper.showLong(this, R.string.dob_invalid);
        }
    }
}
