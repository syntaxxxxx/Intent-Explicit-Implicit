package id.co.imastudio.myintentapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnMoveActivity;
    private Button btnMoveWithData;
    private Button btnMoveWithObject;
    private Button btnDialPhone;
    private Button btnForResult;
    private TextView tvReslut;
    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMoveActivity = (Button)findViewById(R.id.btn_Move_Activity);
        btnMoveActivity.setOnClickListener(this);

        btnMoveWithData = (Button)findViewById(R.id.btn_move_activity_data);
        btnMoveWithData.setOnClickListener(this);

        btnMoveWithObject = (Button)findViewById(R.id.btn_move_activity_object);
        btnMoveWithObject.setOnClickListener(this);

        btnDialPhone = (Button)findViewById(R.id.btn_dial_number);
        btnDialPhone.setOnClickListener(this);

        btnForResult = (Button)findViewById(R.id.btn_move_for_result);
        btnForResult.setOnClickListener(this);
        tvReslut = (TextView)findViewById(R.id.tv_result);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            // Tidak membawa data
            case R.id.btn_Move_Activity:
            Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
            startActivity(moveIntent);
            break;
            // Membawa data
            case R.id.btn_move_activity_data:
                Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "SMK Cirebon");
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5);
                startActivity(moveWithDataIntent);
            break;
            // Pindah dengan object
            case R.id.btn_move_activity_object:
                Person mPerson = new Person();
                mPerson.setName("Fiqri Hafzain Islami");
                mPerson.setAge(19);
                mPerson.setEmail("fiqrihafzainislami@gmail.com");
                mPerson.setCity("Jakarta");
                Intent moveWithObjectIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, mPerson);
                startActivity(moveWithObjectIntent);
            break;
            // Implicit
            case R.id.btn_dial_number:
                String phoneNumber = "089614191467";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneIntent);
                break;
            /**
             * CallBack
             * Find value result callback dari activity yang sudah close
             * Yang dieksekusi pertama */
            case R.id.btn_move_for_result:
                Intent moveForReslut = new Intent(MainActivity.this, MoveForResultActivity.class);
                startActivityForResult(moveForReslut, REQUEST_CODE);
                break;
        }
    }

    /** Method ini yang terakhir dieksekusi untuk get hasilnya */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResultActivity.RESULT_CODE) {
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0);
                tvReslut.setText("Hasil : "+selectedValue);
            }
        }
    }
}
