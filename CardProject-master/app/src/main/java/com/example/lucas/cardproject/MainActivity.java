package com.example.lucas.cardproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.widget.TabHost;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class MainActivity extends FragmentActivity implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener{

    private TabHost mTabHost;
    private ViewPager mViewPager;
    private HashMap<String, TabInfo> mapTabInfo = new HashMap<String, MainActivity.TabInfo>();
    private PagerAdapter mPagerAdapter;

    //Informação da Tab
    private class TabInfo{
        private String tag;
        private Class<?> clss;
        private Bundle args;
        private Fragment fragment;

        TabInfo(String tag, Class<?> clazz, Bundle args){
            this.tag = tag;
            this.clss = clazz;
            this.args = args;
        }
    }

    //  Factory que retorna View para o TabHost
    class TabFactory implements TabHost.TabContentFactory{
        private final Context mContext;

        public TabFactory(Context context){
            mContext = context;
        }

        public View createTabContent(String tag){
            View v = new View(mContext);
            v.setMinimumWidth(0);
            v.setMinimumHeight(0);
            return v;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //infla o main
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        this.initialiseTabHost(savedInstanceState); //inicializa o TabHost
        if(savedInstanceState != null)
            mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab")); //define o tab de acordo com o estado salvo

        this.initialiseViewPager(); //inicializa o ViewPager
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    protected void onSaveInstanceState(Bundle outState){
        //salva a Tab selecionada
        outState.putString("tab", mTabHost.getCurrentTabTag());
        super.onSaveInstanceState(outState);
    }

    private void initialiseViewPager(){
        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(this, TabFragmentA.class.getName()));
        fragments.add(Fragment.instantiate(this, TabFragmentB.class.getName()));
        fragments.add(Fragment.instantiate(this, TabFragmentC.class.getName()));

        this.mPagerAdapter = new ViewPagerAdapter(super.getSupportFragmentManager(), fragments);
        this.mViewPager = (ViewPager)super.findViewById(R.id.viewpager);
        this.mViewPager.setAdapter(this.mPagerAdapter);
        this.mViewPager.setOnPageChangeListener(this);

    }

    private void initialiseTabHost(Bundle args){
        mTabHost = (TabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup();
        TabInfo tabInfo = null;
        MainActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab1").setIndicator("Status"), (tabInfo = new TabInfo("Tab1", TabFragmentA.class, args)));
        MainActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab2").setIndicator("Faturas"), (tabInfo = new TabInfo("Tab2", TabFragmentB.class, args)));
        MainActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab3").setIndicator("Outros"), (tabInfo = new TabInfo("Tab3", TabFragmentC.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        mTabHost.setOnTabChangedListener(this);
    }

    private static void AddTab(MainActivity activity, TabHost tabHost, TabHost.TabSpec tabSpec, TabInfo tabInfo){
        //Attach uma Tab view factory para o spec
        tabSpec.setContent(activity.new TabFactory(activity));
        tabHost.addTab(tabSpec);
    }


    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.actPerdiMeuCartao:
                Intent intent = new Intent(this, LostCardActivity.class);
                startActivity(intent);
                return false;
            default:
                return super.onOptionsItemSelected(item);
        }

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
       //     return true;
        //}

    }*/


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabChanged(String s) {
        //Avisa para o mViewPager qual Tab está ativa
        int pos = this.mTabHost.getCurrentTab();
        this.mViewPager.setCurrentItem(pos);
    }
}
