package com.example.mp08_uf1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

public class SettingsFragment extends Fragment {

    private Switch switchDarkMode;
    private Switch switchShowLearned;
    private Spinner spinnerDifficulty;
    private Button buttonResetProgress;
    private SharedPreferences sharedPreferences;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext());

        switchDarkMode = view.findViewById(R.id.switch_dark_mode);
        switchShowLearned = view.findViewById(R.id.switch_show_learned);
        spinnerDifficulty = view.findViewById(R.id.spinner_difficulty);
        buttonResetProgress = view.findViewById(R.id.button_reset_progress);

        // Set up difficulty spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.difficulty_levels, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDifficulty.setAdapter(adapter);

        // Load saved settings
        switchDarkMode.setChecked(sharedPreferences.getBoolean("dark_mode", false));
        switchShowLearned.setChecked(sharedPreferences.getBoolean("show_learned", false));
        spinnerDifficulty.setSelection(sharedPreferences.getInt("difficulty_filter", 0));

        // Save changes when toggled
        switchDarkMode.setOnCheckedChangeListener((buttonView, isChecked) ->
                sharedPreferences.edit().putBoolean("dark_mode", isChecked).apply());

        switchShowLearned.setOnCheckedChangeListener((buttonView, isChecked) ->
                sharedPreferences.edit().putBoolean("show_learned", isChecked).apply());

        spinnerDifficulty.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {
                sharedPreferences.edit().putInt("difficulty_filter", position).apply();
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> parent) {}
        });

        // Reset progress button
        buttonResetProgress.setOnClickListener(v -> {
            Toast.makeText(requireContext(), "Progress Reset!", Toast.LENGTH_SHORT).show();
            sharedPreferences.edit().clear().apply();
        });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }
}
