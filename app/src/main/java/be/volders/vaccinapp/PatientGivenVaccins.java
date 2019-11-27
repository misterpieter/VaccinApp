package be.volders.vaccinapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import be.volders.vaccinapp.helpers.ToastHelper;
import be.volders.vaccinapp.models.Patient;

/**
 * This activity will be launched from {@link MainActivity}. It will provide the user a ListView with all available vaccins.
 * The user will be required to select all vaccins which the patient has received.
 */
public class PatientGivenVaccins extends AppCompatActivity {

    ListView listVaccins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_given_vaccins);
        getSupportActionBar().setTitle(R.string.given_vaccins_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Get the patient object from the intent
        Intent intent = getIntent();
        Patient patient = (Patient) intent.getSerializableExtra("patient");

        listVaccins = findViewById(R.id.listVaccins);


        // Make sure patient is not null before proceeding
        if(patient != null) {
            populateListView(listVaccins);
        }

        /*
            TODO:
                Loopen door alle objecten in Firebase database. Hieruit per item Vaccin object aanmaken en toevoegen aan List.
                Vervolgens de list uitprinten en weergeven in de activity.
         */
    }

    private void populateListView(ListView view) {
        ArrayList<Patient> patients = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();

        Patient patient1 = new Patient(new GregorianCalendar(1995, Calendar.MAY, 29).getTime(), false);
        Patient patient2 = new Patient(new GregorianCalendar(2000, Calendar.JANUARY, 1).getTime(), true);

        patients.add(patient1);
        patients.add(patient2);

        for(Patient p : patients) {
            String mainStr = "Patient dob: " + p.getFormattedDob();
            String str;

            if(p.isRiskGroup()) {
                str = mainStr + " and patient is a riskgroup";
            }else{
                str = mainStr + " and patient is not a riskgroup";
            }

            list.add(str);
            ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, list);
            listVaccins.setAdapter(listAdapter);

            // TODO: add clickListener for item and apply checked() method
        }
    }

}
