package com.example.sihtry1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Calendar;

public class CreateReferralActivity extends AppCompatActivity {

    private Button create_referral_btn_submit, create_referral_btn_pick_name;
    private EditText create_referral_et_parent_name, create_referral_et_child_f_name, create_referral_et_l_name, create_referral_rb__child_male, create_referral_rb_child_female,
            create_referral_rb_child_other, create_referral_et_symptoms, create_referral_et_blodgp, create_referral_et_ashamsmt, create_referral_et_height,
            create_referral_et_weight, create_referral_et_phone, create_referral_et_city, create_referral_et_state, create_referral_et_aadhaar_num, create_referral_et_add, create_referral_et_pin;
    private TextView create_referral_tv_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_referral);

        create_referral_btn_submit = (Button) findViewById(R.id.create_referral_btn_submit);
        create_referral_btn_pick_name = (Button) findViewById(R.id.create_referral_btn_pick_date);
        create_referral_et_parent_name = (EditText) findViewById(R.id.create_referral_et_parent_name);
        create_referral_et_child_f_name = (EditText) findViewById(R.id.create_referral_et_child_f_name);
        create_referral_et_l_name = (EditText) findViewById(R.id.create_referral_et_child_l_name);
        create_referral_rb__child_male = (RadioButton) findViewById(R.id.create_referral_rb_child_male);
        create_referral_rb_child_female = (RadioButton) findViewById(R.id.create_referral_rb_child_female);
        create_referral_rb_child_other = (RadioButton) findViewById(R.id.create_referral_btn_submit);
        create_referral_et_symptoms = (EditText) findViewById(R.id.create_referral_btn_submit);
        create_referral_et_blodgp = (EditText) findViewById(R.id.create_referral_btn_submit);
        create_referral_et_ashamsmt = (EditText) findViewById(R.id.create_referral_btn_submit);
        create_referral_et_height = (EditText) findViewById(R.id.create_referral_btn_submit);
        create_referral_et_weight = (EditText) findViewById(R.id.create_referral_btn_submit);
        create_referral_et_phone = (EditText) findViewById(R.id.create_referral_btn_submit);
        create_referral_et_city = (EditText) findViewById(R.id.create_referral_btn_submit);
        create_referral_et_state = (EditText) findViewById(R.id.create_referral_btn_submit);
        create_referral_et_aadhaar_num = (EditText) findViewById(R.id.create_referral_btn_submit);
        create_referral_et_add = (EditText) findViewById(R.id.create_referral_btn_submit);
        create_referral_et_pin = (EditText) findViewById(R.id.create_referral_btn_submit);
        create_referral_tv_date = (TextView) findViewById(R.id.create_referral_btn_submit);

        create_referral_btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IMainActivity iMainActivity = new IMainActivity();
                iMainActivity.createNewReferral(child_first_name, referral_id, child_last_name, guadian_name, nrc_id, rcr_id, guardian_aadhar_num, child_gender, day_of_birth, month_of_birth, year_of_birth, symptoms, blood_group, asha_measure, height, weight, phone, state, city, pincode, address);
            }
        });
    }
}
