package com.example.sihtry1;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sihtry1.models.Referral;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CreateReferralActivity extends AppCompatActivity {

    private int mYear, mMonth, mDay;
    private Button create_referral_btn_submit;
    private EditText create_referral_et_parent_name, create_referral_et_child_f_name, create_referral_et_child_l_name, create_referral_et_bloodgp,
            create_referral_et_city, create_referral_et_state, create_referral_et_ashamsmt, create_referral_et_pincode, create_referral_et_height, create_referral_et_symptoms,
            create_referral_et_weight, create_referral_et_aadhaar_parent, create_referral_et_aadhaar_child, create_referral_et_add, create_referral_et_phone;
    private RadioButton create_referral_rb_child_male, create_referral_rb_child_female, create_referral_rb_child_other;
    private int day_of_birth, month_of_birth, year_of_birth;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_referral);

        create_referral_btn_submit = (Button) findViewById(R.id.create_referral_btn_submit);
        create_referral_et_parent_name = (EditText) findViewById(R.id.create_referral_et_parent_name);
        create_referral_et_child_f_name = (EditText) findViewById(R.id.create_referral_et_child_f_name);
        create_referral_et_child_l_name = (EditText) findViewById(R.id.create_referral_et_child_l_name);
        create_referral_et_bloodgp = (EditText) findViewById(R.id.create_referral_et_bloodgp);
        create_referral_et_city = (EditText) findViewById(R.id.create_referral_et_city);
        create_referral_et_state = (EditText) findViewById(R.id.create_referral_et_state);
        create_referral_et_ashamsmt = (EditText) findViewById(R.id.create_referral_et_ashamsmt);
        create_referral_et_pincode = (EditText) findViewById(R.id.create_referral_et_pin);
        create_referral_et_symptoms = (EditText) findViewById(R.id.create_referral_et_symptoms);
        create_referral_et_height = (EditText) findViewById(R.id.create_referral_et_height);
        create_referral_et_weight = (EditText) findViewById(R.id.create_referral_et_weight);
        create_referral_et_aadhaar_parent = (EditText) findViewById(R.id.create_referral_et_aadhaar_parent);
        create_referral_et_aadhaar_child = (EditText) findViewById(R.id.create_referral_et_aadhaar_child);
        create_referral_et_add = (EditText) findViewById(R.id.create_referral_et_add);
        create_referral_et_phone = (EditText) findViewById(R.id.create_referral_et_phone);
        create_referral_rb_child_male = (RadioButton) findViewById(R.id.create_referral_rb_child_male);
        create_referral_rb_child_female = (RadioButton) findViewById(R.id.create_referral_rb_child_female);
        create_referral_rb_child_other = (RadioButton) findViewById(R.id.create_referral_rb_child_other);


        create_referral_btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gender = null;
                if (create_referral_rb_child_male.isChecked()) {
                    gender = "m";
                } else if (create_referral_rb_child_female.isChecked()) {
                    gender = "f";
                } else {
                    gender = "o";
                }


//                IMainActivity iMainActivity = new IMainActivity();
                createNewReferral(getApplicationContext(), "fdvdfzv", create_referral_et_child_f_name.getText().toString(),
                        create_referral_et_child_l_name.getText().toString(), create_referral_et_parent_name.getText().toString(), FirebaseAuth.getInstance().getCurrentUser().getUid(), null,
                        create_referral_et_aadhaar_parent.getText().toString(), gender, day_of_birth, month_of_birth, year_of_birth, create_referral_et_symptoms.getText().toString(),
                        create_referral_et_bloodgp.getText().toString(), Integer.parseInt(create_referral_et_ashamsmt.getText().toString()),
                        Integer.parseInt(create_referral_et_height.getText().toString()), Integer.parseInt(create_referral_et_weight.getText().toString()),
                        create_referral_et_phone.getText().toString(), create_referral_et_add.getText().toString(), create_referral_et_state.getText().toString()
                        , create_referral_et_city.getText().toString(), Integer.parseInt(create_referral_et_pincode.getText().toString()));
            }
        });

        final Button pickDate = (Button) findViewById(R.id.pick_date);
        final TextView textView = (TextView) findViewById(R.id.date);

        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                // myCalendar.add(Calendar.DATE, 0);
                String myFormat = "yyyy-MM-dd"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                textView.setText(sdf.format(myCalendar.getTime()));
                day_of_birth = myCalendar.getTime().getDay();
                month_of_birth = myCalendar.getTime().getMonth();
                year_of_birth = myCalendar.getTime().getYear();
            }
        };

        pickDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                // Launch Date Picker Dialog
                DatePickerDialog dpd = new DatePickerDialog(CreateReferralActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // Display Selected date in textbox

                                if (year < mYear)
                                    view.updateDate(mYear, mMonth, mDay);

                                if (monthOfYear < mMonth && year == mYear)
                                    view.updateDate(mYear, mMonth, mDay);

                                if (dayOfMonth < mDay && year == mYear && monthOfYear == mMonth)
                                    view.updateDate(mYear, mMonth, mDay);

                                textView.setText(dayOfMonth + "-"
                                        + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                dpd.getDatePicker().setMinDate(1990);
                dpd.show();

            }
        });
    }

    public void createNewReferral(final Context context, String referral_id, String child_first_name, String child_last_name, String guadian_name, String rcr_id, String ncr_id,
                                  String guardian_aadhar_num, String child_gender, int day_of_birth, int month_of_birth, int year_of_birth, String symptoms, String blood_group, int asha_measure, int height, int weight,
                                  String phone, String address, String state, String city, int pincode) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        DocumentReference newReferralRef = db.collection("referral").document();

        Referral referral = new Referral(referral_id, child_first_name, child_last_name, guadian_name, rcr_id, ncr_id,
                guardian_aadhar_num, child_gender, day_of_birth, month_of_birth, year_of_birth, symptoms, blood_group,
                asha_measure, height, weight, phone, state, city, pincode, address);

        newReferralRef.set(referral).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Referral created", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context.getApplicationContext(), "Registeration Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
