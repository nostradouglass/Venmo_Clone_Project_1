package com.kellydouglass.venmocloneproject1.TabFragmentSocial;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kellydouglass.venmocloneproject1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PublicFragment extends Fragment {


    public PublicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_public, container, false);
    }

}
