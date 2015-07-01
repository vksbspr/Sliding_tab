package com.example.vks.sliding_tab;
import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by hp1 on 21-01-2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private final FragmentManager mFragmentManager;
    private Fragment mFragmentAtPos0;
    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created

    boolean flag=false;

    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerAdapter(FragmentManager fm,CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);
        mFragmentManager=fm;
        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;
    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {
        Log.v(MainActivity.package_name,"item got");
        if (position == 0)
        {   if(flag==true){
                mFragmentAtPos0=new Tab3();
             }
            else{
                mFragmentAtPos0=new Tab1();
            }
            Log.v(MainActivity.package_name,mFragmentAtPos0.getClass().toString());
            return mFragmentAtPos0;
        }
        else             // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            Tab2 tab2 = new Tab2();
            return tab2;
        }


    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        Log.v(MainActivity.package_name,"cout requested");
        return NumbOfTabs;

    }

    @Override
    public int getItemPosition(Object object)
    {
        Log.v(MainActivity.package_name,"position got"+object.getClass());
        if (object instanceof Tab1||object instanceof Tab3)
            return POSITION_NONE;
        return POSITION_UNCHANGED;
    }
}