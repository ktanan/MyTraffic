package easybuy.tananjaiwin.kachen.mytraffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // Explicit การประกาศตัวแปร
    // เพื่อตรวจสอบ & จอง  Memory ที่ App ต้องใช้ Run
    private ListView trafficListView;
    private Button aboutMeButton;

    //Alt + Enter >> Cast On
    //Ctrl + Shit + Enter >>> Completement

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        trafficListView = (ListView) findViewById(R.id.listView);
        aboutMeButton = (Button) findViewById(R.id.button);

        //Controller for Button
        aboutMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Interface ควรใส่เสียงด้วย เพื่อยืนยันการกดปุ่ม
                //sound Effect
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.sheep);
                mediaPlayer.start();

                //Web View
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://youtu.be/RBumgq5yVrA"));
                startActivity(intent);
            } //Onclick
        });


        //Create listView
        //1.Setter Array Simple
        final int[] iconInts = new int[20];
        iconInts[0] = R.drawable.traffic_01;
        iconInts[1] = R.drawable.traffic_02;
        iconInts[2] = R.drawable.traffic_03;
        iconInts[3] = R.drawable.traffic_04;
        iconInts[4] = R.drawable.traffic_05;
        iconInts[5] = R.drawable.traffic_06;
        iconInts[6] = R.drawable.traffic_07;
        iconInts[7] = R.drawable.traffic_08;
        iconInts[8] = R.drawable.traffic_09;
        iconInts[9] = R.drawable.traffic_10;
        iconInts[10] = R.drawable.traffic_11;
        iconInts[11] = R.drawable.traffic_12;
        iconInts[12] = R.drawable.traffic_13;
        iconInts[13] = R.drawable.traffic_14;
        iconInts[14] = R.drawable.traffic_15;
        iconInts[15] = R.drawable.traffic_16;
        iconInts[16] = R.drawable.traffic_17;
        iconInts[17] = R.drawable.traffic_18;
        iconInts[18] = R.drawable.traffic_19;
        iconInts[19] = R.drawable.traffic_20;


        //2. Call from xml
        final String[] namStrings = getResources().getStringArray(R.array.name); //my_data.xml string-array name="name"

        //3. Call from Java MyData.java
        MyData myData = new MyData(); //Create Object or instance
        final String[] detailStrings = myData.getDetailStrings();

        //Inheriate to MyAdapter
        MyAdapter myAdapter = new MyAdapter(this,iconInts,namStrings,detailStrings);
        trafficListView.setAdapter(myAdapter);

        //Intent to Detail when Click
        trafficListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this,DetailActivity.class); //ย้ายข้อมูลจาก this >> class
                intent.putExtra("Name", namStrings[position]);
                intent.putExtra("Icon", iconInts[position]);
                intent.putExtra("Index", position);
                startActivity(intent);



            } //OnItemClick
        });

    }// Main Method

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
} // Main Class
