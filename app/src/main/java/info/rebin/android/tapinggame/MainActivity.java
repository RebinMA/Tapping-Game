package info.rebin.android.tapinggame;

import android.content.SharedPreferences;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import info.rebin.android.tapinggame.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(this);
        binding.setScore(preferences.getInt("SCORE",0));


        binding.tapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.setScore(binding.getScore()+1);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences preferences=PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("SCORE", binding.getScore());
        editor.apply();

    }
}
