package co.juliansuarez.changingbackground;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;


public class MainActivity extends FragmentActivity implements FragmentManager
        .OnBackStackChangedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().addOnBackStackChangedListener(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    FirstFragment.newInstance()).commit();
        }
    }


    /**
     * This is where we start the second fragment and add it to the backstack
     */
    public void startSecondFragment() {
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim
                .enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left,
                R.anim.exit_to_right).replace(R.id.container,
                SecondFragment.newInstance()).addToBackStack(null).commit();
    }

    /**
     * I need to do this in order to detect when the user hits back, or closes the SecondFragment
     */
    @Override
    public void onBackStackChanged() {

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container);
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();

        if (fragment instanceof FirstFragment && backStackEntryCount == 0) {
            // this means that we were going back from the second fragment to the first
            ((FirstFragment) fragment).startBackgroundAnimation();
        }
    }

}
