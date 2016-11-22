package com.xqq.testsqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.xqq.testsqlite.control.PersonCotrol;

public class MainActivity extends AppCompatActivity {

    private EditText mEtName;
    private EditText mEtNumber;
    private CheckBox mCbIsGoogle;
    private boolean isGoogle;
    private PersonCotrol personCotrol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
        isGoogle = false;
        personCotrol = new PersonCotrol(this);
        mCbIsGoogle.setChecked(false);
        mCbIsGoogle.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                isGoogle = isChecked;
            }
        });
    }

    private void findViewById() {
        mEtName = (EditText) findViewById(R.id.et_name);
        mEtNumber = (EditText) findViewById(R.id.et_number);
        mCbIsGoogle = (CheckBox) findViewById(R.id.cb_google);
    }

    public void click(View view) {
        String name = mEtName.getText().toString();
        String number = mEtNumber.getText().toString();
        switch (view.getId()) {
            case R.id.bt_add:
                Toast.makeText(this,
                        personCotrol.add(name, number, isGoogle) + "",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_delete:
                Toast.makeText(this,
                        personCotrol.delete(name, isGoogle) + "",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_search:
                Toast.makeText(this,
                        personCotrol.search(name, isGoogle) + "",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_update:
                Toast.makeText(this,
                        personCotrol.update(name, number, isGoogle) + "",
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
