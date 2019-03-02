package com.example.sihtry1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RCRActivity extends AppCompatActivity {

    private Button btn_create_new_referral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcr);

        btn_create_new_referral = (Button) findViewById(R.id.rcr_btn_create_new_ref);

        btn_create_new_referral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerChild();
            }
        });
    }

    private void registerChild() {
        IMainActivity iMainActivity = new IMainActivity();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/M/yyyy");
        String date = dateFormat.format(Calendar.getInstance().getTime());
        iMainActivity.createNewReferral(getApplicationContext(), "dfbdfvb", "zdfvbzfb", "zdbvdzb", "zvzsfvb", FirebaseAuth.getInstance().getCurrentUser().getUid(), "dvbdbb",
                "564132156", "m", "fvgdfvbdfbv", Calendar.getInstance().getTime(), "zdsfvdfv", (float) 12.2, (float) 12.2, (float) 12.2,
                "s4vt56w56", "s4vt56w56", "s4vt56w56", "s4vt56w56", 231456);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.main_menu_signout:
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
