package br.com.oslourencos.appexamplelayouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by conceicao on 19/07/17.
 */

public class ControlActivityFrameLayout extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout);

        getSupportActionBar().setTitle("Exemplo Frame Layout");
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
        finish();
    }
}
