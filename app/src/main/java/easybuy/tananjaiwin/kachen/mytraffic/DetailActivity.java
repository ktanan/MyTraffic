package easybuy.tananjaiwin.kachen.mytraffic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    //Explicit
    TextView nameTextView,detailTextView;//ประกาศ private อย่างย่อ
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Bind widget
        nameTextView = (TextView) findViewById(R.id.textView4);
        detailTextView = (TextView) findViewById(R.id.textView5);
        imageView = (ImageView) findViewById(R.id.imageView2);

        //Get value from Intent
        String strName = getIntent().getStringExtra("Name");
        int intIcon = getIntent().getIntExtra("Icon", R.drawable.traffic_01); // ถ้า Get แล้ว Error ให้ Get >> R.drawable.traffic_01
        int intIndex = getIntent().getIntExtra("Index", 0); // ถ้า Get แล้ว Error ให้ Get >> 0

        //Chk Log
        Log.d("Traffic", "strName ==> " + strName);
        Log.d("Traffic", "intIcon ==> " + intIcon);
        Log.d("Traffic", "intIndex ==> " + intIndex);

        //Show View
        nameTextView.setText(strName);
        imageView.setImageResource(intIcon);
        String[] detailStrings = getResources().getStringArray(R.array.long_data);
        detailTextView.setText(detailStrings[intIndex]);

    }//Main Method

    public void clickBack(View view) {
        finish();
    }



}//Main Class
