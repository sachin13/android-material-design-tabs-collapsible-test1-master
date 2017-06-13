package com.webheavens.androideducator;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.webheavens.androideducator.adapters.MainPagerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)     Toolbar toolbar;

    @Bind(R.id.tabs)        TabLayout tabs;
    @Bind(R.id.pager)       ViewPager pager;

    MainPagerAdapter adapter;
    CharSequence Titles[]={"VIDEOS","IMAGES","MILESTONES"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setUpTabs();

    }



    void setUpTabs(){
        adapter =  new MainPagerAdapter(this.getSupportFragmentManager(),Titles,Titles.length);
        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);
        setupTabIcons();
    }

    private void setupTabIcons() {
        tabs.getTabAt(0).setIcon(R.mipmap.select_video);
        tabs.getTabAt(1).setIcon(R.mipmap.select_image);
        tabs.getTabAt(2).setIcon(R.mipmap.select_milestone);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
