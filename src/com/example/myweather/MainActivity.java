package com.example.myweather;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {
	private String[] weatherListData = {"星期一","星期二","星期三","星期四","星期五",""};
	private String[] weatherTendencyData = {"星期1 ","星期2","星期3","星期4","星期5"};
	private String[] weatherIndexData = {"防晒指数","穿衣指数","运动指数","洗车指数","晾晒指数"};
	
	private List<WeatherIndex> weatherIndexList = new ArrayList<WeatherIndex>();
	 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        
        //下面是录入七天天气数据并显示出来
        ArrayAdapter<String> weatherListAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,weatherListData);
        ListView weatherListlistView = (ListView)findViewById(R.id.weather_list);
        weatherListlistView.setAdapter(weatherListAdapter);
        
        
        //下面录入当天天气指数
        ArrayAdapter<String> weatherIndexAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,weatherIndexData);
        ListView weatherLindexListView = (ListView)findViewById(R.id.weather_index);
        weatherLindexListView.setAdapter(weatherIndexAdapter);
        
        //下面录入天气趋势
        
        ArrayAdapter<String> weatherTendencyAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,weatherTendencyData);
        ListView weatherTendencyListView = (ListView)findViewById(R.id.weather_tendency);
        weatherTendencyListView.setAdapter(weatherTendencyAdapter);    
        
        //定义按钮监听事件
        final ImageButton iBBAdd =(ImageButton)findViewById(R.id.image_menu_bottom_add);
        final ImageButton iBBIndex =(ImageButton)findViewById(R.id.image_menu_bottom_index);
        final ImageButton iBBTendency =(ImageButton)findViewById(R.id.image_menu_bottom_tendency);   
        
        
        //添加城市
        iBBAdd.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				if(iBBAdd.getTag() == "off"){
					
					//同时将其他按钮复位
					iBBTendency.setImageDrawable(getResources().getDrawable(R.drawable.menu_bottom_tendency));
					iBBTendency.setTag("off");
					iBBIndex.setImageDrawable(getResources().getDrawable(R.drawable.menu_bottom_index));
					iBBIndex.setTag("off");
					
					//关闭天气趋势和气象指数
					View weatherTendencyView = (View)findViewById(R.id.view_weather_tendency);
					weatherTendencyView.setVisibility(View.GONE);
					weatherTendencyView.setTag("gone");

					View weatherIndexView = (View)findViewById(R.id.view_weather_index);
					weatherIndexView.setVisibility(View.GONE);
					weatherIndexView.setTag("gone");					
					
					
					//打开城市列表
					Intent addCityIntent = new Intent(MainActivity.this,CityList.class);
					startActivity(addCityIntent);
					
					}else{
						iBBAdd.setImageDrawable(getResources().getDrawable(R.drawable.menu_bottom_add));
						iBBAdd.setTag("off");
					}					
			}
        });
    
        //指数
        iBBIndex.setOnClickListener(new OnClickListener(){
        
			@Override
			public void onClick(View v) {
				if(iBBIndex.getTag() == "off"){
					iBBIndex.setImageDrawable(getResources().getDrawable(R.drawable.menu_bottom_index_on));
					iBBIndex.setTag("on");
					
					//同时将其他按钮复位
					iBBTendency.setImageDrawable(getResources().getDrawable(R.drawable.menu_bottom_tendency));
					iBBTendency.setTag("off");
					iBBAdd.setImageDrawable(getResources().getDrawable(R.drawable.menu_bottom_add));
					iBBAdd.setTag("off");
					
					//关闭天气趋势图
					View weatherTendencyView = (View)findViewById(R.id.view_weather_tendency);
					weatherTendencyView.setVisibility(View.GONE);
					weatherTendencyView.setTag("gone");
					
					View weatherIndexView = (View)findViewById(R.id.view_weather_index);
					weatherIndexView.setVisibility(View.VISIBLE);
					weatherIndexView.setTag("visibe");
					
					//如何设置对子项中按钮的监听事件
					
					}else{
						iBBIndex.setImageDrawable(getResources().getDrawable(R.drawable.menu_bottom_index));
						iBBIndex.setTag("off");
						View weatherIndexView = (View)findViewById(R.id.view_weather_index);
						weatherIndexView.setVisibility(View.GONE);
						weatherIndexView.setTag("gone");
					}
		
			}
        });

        
        //趋势
        iBBTendency.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				if(iBBTendency.getTag() == "off"){
					iBBTendency.setImageDrawable(getResources().getDrawable(R.drawable.menu_bottom_tendency_on));
					iBBTendency.setTag("on");
					
					//同时将其他按钮复位
					iBBAdd.setImageDrawable(getResources().getDrawable(R.drawable.menu_bottom_add));
					iBBAdd.setTag("off");
					iBBIndex.setImageDrawable(getResources().getDrawable(R.drawable.menu_bottom_index));
					iBBIndex.setTag("off");
					
					//关闭气象指数
					View weatherIndexView = (View)findViewById(R.id.view_weather_index);
					weatherIndexView.setVisibility(View.GONE);
					weatherIndexView.setTag("gone");
					
					View weatherTendencyView = (View)findViewById(R.id.view_weather_tendency);
					weatherTendencyView.setVisibility(View.VISIBLE);
					weatherTendencyView.setTag("visibe");
					}else{
						iBBTendency.setImageDrawable(getResources().getDrawable(R.drawable.menu_bottom_tendency));
						iBBTendency.setTag("off");
						View weatherTendencyView = (View)findViewById(R.id.view_weather_tendency);
						weatherTendencyView.setVisibility(View.GONE);
						weatherTendencyView.setTag("gone");
					}	
			}
        });
        
        //设置进入空气指数页面
        final ImageButton imgButtonIntoAirInfo = (ImageButton)findViewById(R.id.into_air_info);
        imgButtonIntoAirInfo.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intoAirInfoIntent = new Intent(MainActivity.this,AirInfo.class);
				startActivity(intoAirInfoIntent);
				
			}
        	
        });
        
        //下面是动态录入气象指数数据并调用自定义ListView
        initWeatherIndex();//初始化数据
        WeatherIndexAdapter weatherIndexAdapterMain = new WeatherIndexAdapter(MainActivity.this,R.layout.weather_index_item,weatherIndexList);
        ListView listView = (ListView)findViewById(R.id.weather_index);
        listView.setAdapter(weatherIndexAdapterMain);
        
    }

    //对气象指数初始化
    private void initWeatherIndex(){
    	WeatherIndex sunblock = new WeatherIndex(R.drawable.index_sunblock,"防晒指数","level",R.id.weather_index_button,"text1");
    	weatherIndexList.add(sunblock);
    	WeatherIndex dress = new WeatherIndex(R.drawable.index_dress,"穿衣指数","level",R.id.weather_index_button,"text2");
    	weatherIndexList.add(dress);
    	WeatherIndex exercise = new WeatherIndex(R.drawable.index_exercise,"运动指数","level",R.id.weather_index_button,"text3");
    	weatherIndexList.add(exercise);
    	WeatherIndex car = new WeatherIndex(R.drawable.index_car,"洗车指数","level",R.id.weather_index_button,"text4");
    	weatherIndexList.add(car);
    	WeatherIndex field = new WeatherIndex(R.drawable.index_field,"晾晒指数","level",R.id.weather_index_button,"text5");
    	weatherIndexList.add(field);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
