package easybuy.tananjaiwin.kachen.mytraffic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by User on 03/07/2559.
 */

//extends >> การสืบทอด
public class MyAdapter extends BaseAdapter{

    //Explicit
    //Context การต่อท่อต้นทางกับปลายทางเพื่อส่ง data
    private Context context;
    private int[] iconInts;
    private String[] nameString, detailString;


    //สร้าง Constructor กด Alt+ Ins >> เลือกตัวแปรที่ต้องการกำหนด {สร้าง Method Auto}
    public MyAdapter(Context context, int[] iconInts, String[] nameString, String[] detailString) {
        this.context = context;
        this.iconInts = iconInts;
        this.nameString = nameString;
        this.detailString = detailString;
    }


    @Override
    public int getCount() {
        return iconInts.length; //จำนวน Length ของ Array
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //Open Service
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);//คำสังเปิด Service

        //View คือพาหะหิ้วของ
        View view1 = layoutInflater.inflate(R.layout.my_listview, viewGroup, false);

        //Bind Widget
        ImageView iconImageView = (ImageView) view1.findViewById(R.id.imageView);
        TextView nameTextView = (TextView) view1.findViewById(R.id.textView2);
        TextView detailTextView = (TextView) view1.findViewById(R.id.textView3);

        //Show View
        iconImageView.setImageResource(iconInts[i]);
        nameTextView.setText(nameString[i]);
        detailTextView.setText(detailString[i]);



        return view1;
    }
}//Main Class
