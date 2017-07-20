package br.com.oslourencos.appexamplelayouts;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by conceicao on 19/07/17.
 */

public class UserFragment extends Fragment {

    View view;

     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_user, container, false);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
