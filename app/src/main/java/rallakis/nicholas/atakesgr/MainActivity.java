package rallakis.nicholas.atakesgr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private FirebaseAnalytics mFirebaseAnalytics;
    private AdView mAdView;

    private ViewPager mViewPager;

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean shouldPlayOnBackground = prefs.getBoolean(getString(R.string.play_background_key),
                getResources().getBoolean(R.bool.pref_play_background_default));
        if (!shouldPlayOnBackground) SoundPlayer.getInstance(getApplicationContext()).stop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.title));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        Log.d("Firebase", "token "+ FirebaseInstanceId.getInstance().getToken());

        setupAds();
        setupViewPager();
        setupTabs();
    }

    private void setupAds() {
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    private void setupViewPager() {
        CustomViewPagerAdapter adapter = new CustomViewPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(adapter);
    }

    private void setupTabs() {
        TabLayout.OnTabSelectedListener tabListener = new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        };

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setOnTabSelectedListener(tabListener);
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.chios)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tsoukalas)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.other)));
    }

    private class CustomViewPagerAdapter extends FragmentStatePagerAdapter {

        public CustomViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            //SoundList names are identical with the positions of the viewpager
            int soundsName = position;
            return SoundsFragment.newInstance(soundsName);
        }

        @Override
        public int getCount() {
            return SoundList.getSoundListsCount();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String soundsName = null;
            switch (position) {
                case SoundList.CHIOS:
                    soundsName = getString(R.string.chios);
                    break;
                case SoundList.TSOUKALAS:
                    soundsName = getString(R.string.tsoukalas);
                    break;
                case SoundList.OTHER:
                    soundsName = getString(R.string.other);
                    break;
            }
            return soundsName;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_rate) {
            Utils.rateApp(this);
            logRateItemClicked();
        }
        else if (id == R.id.action_settings) {
            Intent startSettingsActivity = new Intent(this, SettingsActivity.class);
            startActivity(startSettingsActivity);
            logSettingsItemClicked();
        }
        else if (id == R.id.action_random_selection) {
            SoundPlayer player = SoundPlayer.getInstance(getApplicationContext());
            player.playSound(SoundList.getRandomSound());
            Toast.makeText(this, "Παίζοντας μία τυχαία ατάκα", Toast.LENGTH_SHORT).show();
            logRandomItemClicked();
        }
        else if (id == R.id.action_about) {
            showAboutDialog();
            logAboutItemClicked();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAboutDialog() {
        View messageView = getLayoutInflater().inflate(R.layout.dialog_about, null, false);

        TextView infoLabel = (TextView) messageView.findViewById(R.id.about_info);
        infoLabel.setText(Html.fromHtml(getString(R.string.about_info)));

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle(R.string.app_name);
        builder.setView(messageView);
        builder.create();
        builder.show();
    }

    private void logRateItemClicked() {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "RateItem");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Rate");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "button");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

    private void logSettingsItemClicked() {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "SettingsItem");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Settings");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "button");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

    private void logRandomItemClicked() {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "RandomItem");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Random");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "button");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

    private void logAboutItemClicked() {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "AboutItem");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "About");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "button");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }
}
