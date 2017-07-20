package br.com.oslourencos.appexamplelayouts;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {

    private Button btn_linear, btn_relative, btn_fragment;
    FragmentTransaction fragmentTransaction;
    private boolean showFragment = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btn_linear = (Button) findViewById(R.id.btn_linear);
        btn_relative = (Button) findViewById(R.id.btn_relative);
        btn_fragment = (Button) findViewById(R.id.btn_fragment);

        btn_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadLinear();
            }
        });

        btn_relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadRelative();
            }
        });

        btn_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (showFragment) {
                    loadFragment(new UserFragment());
                }else {
                    hideFragment(new UserFragment());
                }
            }
        });
    }


    private void loadLinear() {
        startActivity(new Intent(this, ControlActivityLinear.class));
        finish();
    }

    private void loadRelative() {
        startActivity(new Intent(this, ControlActivityRelative.class));
        finish();
    }

    public void setTextButton(boolean ativar){
        if(!ativar){
            btn_fragment.setText("SHOW FRAGMENT");
            showFragment = true;
        } else {
            btn_fragment.setText("HIDE FRAGMENT");
            showFragment = false;

        }
    }

    private void loadFragment(Fragment fragment) {
        // create a FragmentManager
        FragmentManager fm = getFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        fragmentTransaction = fm.beginTransaction();
        // add the FrameLayout with new Fragment - save once Tag userFrag
        fragmentTransaction.add(R.id.frameLayout, fragment, "userFrag");
        fragmentTransaction.commit(); // save the changes
        setTextButton(true);
    }

    private void hideFragment(Fragment fragment) {
        // find the Fragment
        Fragment f = getFragmentManager().findFragmentByTag("userFrag");
        // create a FragmentManager
        FragmentManager fm = getFragmentManager();
        fragmentTransaction = fm.beginTransaction();
        // if exist Fragment in FrameLayout
        if(f!=null) fragmentTransaction.remove(f);
        fragmentTransaction.commit();

        setTextButton(false);
    }


    @Override
    public void onBackPressed() {
        finish();
    }

}
