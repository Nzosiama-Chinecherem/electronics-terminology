package com.example.electronicsterminology;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView vertical_recycler_view;
    VerticalAdapter verticalAdapter;
    private List<Data> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vertical_recycler_view= (RecyclerView) findViewById(R.id.horizontal_recycler_view);

        data = fill_with_data();


        verticalAdapter=new VerticalAdapter(data, getApplication());

        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        vertical_recycler_view.setLayoutManager(horizontalLayoutManager);
        vertical_recycler_view.setAdapter(verticalAdapter);
    }

    public List<Data> fill_with_data() {

        List<Data> data = new ArrayList<>();

        data.add(new Data( R.drawable.capacitor, "CAPACITOR"));
        data.add(new Data( R.drawable.current, "CURRENT"));
        data.add(new Data( R.drawable.diode, "DIODE"));
        data.add(new Data( R.drawable.led, "LED"));
        data.add(new Data( R.drawable.voltage, "VOLTAGE"));
        data.add(new Data( R.drawable.multimeter, "MULTIMETER"));
        data.add(new Data( R.drawable.logicgates, "LOGIC GATES"));
        data.add(new Data( R.drawable.resistors, "RESISTOR"));
        data.add(new Data( R.drawable.transistor, "TRANSISTOR"));


        return data;
    }

    public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.MyViewHolder> {





        List<Data> horizontalList = Collections.emptyList();
        Context context;


        public VerticalAdapter(List<Data> horizontalList, Context context) {
            this.horizontalList = horizontalList;
            this.context = context;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            ImageView imageView;
            TextView txtview;
            public MyViewHolder(View view) {
                super(view);
                imageView=(ImageView) view.findViewById(R.id.imageview);
                txtview=(TextView) view.findViewById(R.id.txtview);
                context = view.getContext();
                view.setClickable(true);

            }


        }



        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_menu, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {

            holder.imageView.setImageResource(horizontalList.get(position).imageId);
            holder.txtview.setText(horizontalList.get(position).txt);

            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    final Intent intent;
                    switch (horizontalList.get(position).imageId){
                        case 0:
                            intent = new Intent(MainActivity.this, AboutUs.class);
                            break;
                        case 1:
                            intent = new Intent(MainActivity.this, About_Electronics_ToolKit.class);
                            break;
                        default:
                            intent = new Intent(MainActivity.this, AboutUs.class);
                            break;

                    }
                    startActivity(intent);

                }


            });

        }


        @Override
        public int getItemCount()
        {
            return horizontalList.size();
        }
    }
}


 