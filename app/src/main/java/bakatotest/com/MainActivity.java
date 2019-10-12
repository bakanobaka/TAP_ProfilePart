package bakatotest.com;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.listView1);
        customadapter ca = new customadapter();
        list.setAdapter(ca);

        RatingBar ratingBar = (RatingBar)findViewById(R.id.myratingbar);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                Toast.makeText(MainActivity.this,
                        "Rating changed, current rating "+ ratingBar.getRating(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    class customadapter extends BaseAdapter {

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return images.length;
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub

            return null;
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(final int position, View convertview, ViewGroup arg2) {
            // TODO Auto-generated method stub
            LayoutInflater inflater = getLayoutInflater();
            convertview = inflater.inflate(R.layout.custom, null);
            TextView tv = (TextView) convertview.findViewById(R.id.textView1);
            TextView tv1 = (TextView) convertview.findViewById(R.id.textView2);
            ImageView image = (ImageView) convertview
                    .findViewById(R.id.imageView1);
            tv.setText(names[position]);
            tv1.setText(positions[position]);
            image.setImageResource(images[position]);

            return convertview;
        }

    }

    String[] names = { "Niño Muring", "Rexsa Salvador", "Sarfel Mulawan", "Christian Donzal"};
    String[] positions = { "Leader", "Member", "Member", "Member"};
    int[] images = { R.drawable.muring_pf, R.drawable.salvador_pf, R.drawable.mulawan_pf,
            R.drawable.donzal_pf };
}

