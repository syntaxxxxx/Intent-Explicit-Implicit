package id.co.imastudio.myintentapp;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MoveForResultActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnChoose;
    private RadioGroup rgGroup;
    public static String EXTRA_SELECTED_VALUE = "extra_selected_value";
    public static int RESULT_CODE = 110;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_for_result);
        btnChoose = (Button)findViewById(R.id.btn_choose);
        btnChoose.setOnClickListener(this);
        rgGroup = (RadioGroup)findViewById(R.id.rg_group);
    }

    /** Yang dieksekusi kedua */
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_choose) {
            if (rgGroup.getCheckedRadioButtonId() != 0) {
                int value = 0;
                switch (rgGroup.getCheckedRadioButtonId()) {
                    case R.id.rb_java:
                        value = 10;
                        break;
                    case R.id.rb_kotlin:
                        value = 20;
                        break;
                    case R.id.rb_Php:
                        value = 30;
                        break;
                    case R.id.rb_javascript:
                        value = 40;
                        break;
                }

                /** Setelah itu ini yang dieksekusi */
                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value);
                setResult(RESULT_CODE, resultIntent);
                finish();
            }
        }
    }
}
