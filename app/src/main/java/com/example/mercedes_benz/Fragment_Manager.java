package com.example.mercedes_benz;

import android.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KARIZsystem on 20/04/2018.
 */

public class Fragment_Manager extends FragmentPagerAdapter {

    private final List <android.support.v4.app.Fragment> fragmentList=new ArrayList <>(  );
    private final List<String> stringList=new ArrayList <>(  );



    public Fragment_Manager(android.support.v4.app.FragmentManager fm) {
        super( fm );
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return fragmentList.get( position );
    }


    @Override
    public int getCount() {
        return stringList == null ? 0 : stringList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get( position );
    }

    public void AddFragment_Title(android.support.v4.app.Fragment fragment, String title){

        fragmentList.add( fragment );
        stringList.add( title );

    }

}
