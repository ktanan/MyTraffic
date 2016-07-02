package easybuy.tananjaiwin.kachen.mytraffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(),R.raw.sheep);
                mediaPlayer.start();

                //Web View
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://youtu.be/RBumgq5yVrA"));
                startActivity(intent);


            } //Onclick
        });


    }// Main Method
} // Main Class
