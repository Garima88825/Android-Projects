package com.example.fragmnt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TestFragment extends Fragment {

    private void printLog(String s) {
        Log.d("LifeCycle:", s);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        printLog("onActivityCreated Called");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_test_fragment, container, false);
        printLog("onCreateView Called");

        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        printLog("onViewCreated Called");

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        printLog("onAttach Called");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        printLog("onCreate Called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        printLog("onDestroy Called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        printLog("onDestroyView Called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        printLog("onDetach Called");
    }

    @Override
    public void onPause() {
        super.onPause();
        printLog("onPause Called");
    }

    @Override
    public void onResume() {
        super.onResume();
        printLog("onResume Called");
    }

    @Override
    public void onStart() {
        super.onStart();
        printLog("onStart Called");
    }

    @Override
    public void onStop() {
        super.onStop();
        printLog("onStop Called");
    }

}
