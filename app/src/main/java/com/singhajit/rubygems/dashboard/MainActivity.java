package com.singhajit.rubygems.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.singhajit.rubygems.R;
import com.singhajit.rubygems.core.NetworkActivity;
import com.singhajit.rubygems.newgems.NewGemsFragment;
import com.singhajit.rubygems.profile.UserProfileFragment;
import com.singhajit.rubygems.recent.view.RecentlyUpdatedGemsFragment;
import com.singhajit.rubygems.search.GemSearchActivity;

public class MainActivity extends NetworkActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
    setupViewPager(viewPager);

    TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
    tabLayout.setupWithViewPager(viewPager);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == R.id.search) {
      startActivity(new Intent(this, GemSearchActivity.class));
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  private void setupViewPager(ViewPager viewPager) {
    ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
    adapter.addFragment(new ViewPagerFragment(new NewGemsFragment(), getString(R.string.new_gems)));
    adapter.addFragment(new ViewPagerFragment(new RecentlyUpdatedGemsFragment(), getString(R.string.updates)));
    adapter.addFragment(new ViewPagerFragment(new UserProfileFragment(), getString(R.string.profile)));
    viewPager.setOffscreenPageLimit(3);
    viewPager.setAdapter(adapter);
  }
}

