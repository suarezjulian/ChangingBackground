package co.juliansuarez.changingbackground;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by julian on 29/03/14.
 * <p/>
 * Abstract fragment that provides some helper methods to inject views and forces the
 * implementation of the background animation
 */
public abstract class BaseAnimationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.inject(this, v);
        return v;
    }

    public abstract int getLayoutId();

    public abstract void startBackgroundAnimation();
}
