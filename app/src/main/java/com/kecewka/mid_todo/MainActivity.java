package com.kecewka.mid_todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageView delete_btn;
    private RelativeLayout mainLayout;
    private RecyclerView rv;
    private ArrayList<TaskModel> someArray;
    private FloatingActionButton addbtn;
    private TextInputLayout textInputLayout;
    private TextInputEditText textInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.recycler_view);

        someArray = new ArrayList<>();
        someArray.add(new TaskModel("Go do groceries"));
        someArray.add(new TaskModel("Go do groceries"));
        someArray.add(new TaskModel("Go do groceries"));
        someArray.add(new TaskModel("Go do groceries"));
        someArray.add(new TaskModel("Go do groceries"));




        TaskAdapter taskAdapter = new TaskAdapter(this, someArray);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(taskAdapter);

        textInputEditText = findViewById(R.id.input_et);
        textInputLayout = findViewById(R.id.input_layout);

        addbtn = findViewById(R.id.add_btn);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = String.valueOf(textInputLayout.getEditText().getText());
                if(!text.isEmpty()){
                    someArray.add(new TaskModel(text));
                }
                Toast toast = Toast.makeText(getApplicationContext(), "Cant put empty string", Toast.LENGTH_SHORT);
                toast.show();
                textInputLayout.getEditText().setText("");
                textInputLayout.clearFocus();
                mainLayout = (RelativeLayout)findViewById(R.id.rel_layout);
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
            }
        });

        /*delete_btn = findViewById(R.id.delete_btn);
        /*delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
    }
}