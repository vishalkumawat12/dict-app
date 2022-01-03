package com.vkkumawat.dictinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {
    TextView res, editText1;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = findViewById(R.id.RES);
        editText = findViewById(R.id.word);
        editText1 = findViewById(R.id.searchWord);
        button = findViewById(R.id.find);
        getSupportActionBar().hide();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word = editText.getText().toString();

                if (!Python.isStarted()) {
                    Python.start(new AndroidPlatform(MainActivity.this));
                    Python py = Python.getInstance();
                    PyObject pyObject = py.getModule("main");
                    PyObject object = pyObject.callAttr("meaning", word);
                    editText1.setText("word you searched "+word);

                    res.setText(object.toString());
                } else {

                    Python py = Python.getInstance();
                    PyObject pyObject = py.getModule("main");
                    PyObject object = pyObject.callAttr("meaning", word);
                    editText1.setText("word you searched "+word);
                    res.setText(object.toString());
                }
            }
        });


    }
}