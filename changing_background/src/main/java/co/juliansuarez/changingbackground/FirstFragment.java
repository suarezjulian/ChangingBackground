package co.juliansuarez.changingbackground;

import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * First fragment that shows the blue background.
 * Use the {@link FirstFragment#newInstance} factory
 * method to
 * create an instance of this fragment.
 */
public class FirstFragment extends BaseAnimationFragment {

    @InjectView(R.id.buttonStartTransition)
    Button mButtonStartTransition;
    @InjectView(R.id.relativeLayoutBackground)
    RelativeLayout mRelativeLayoutBackground;


    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @return A new instance of fragment FirstFragment.
     */
    public static FirstFragment newInstance() {
        FirstFragment fragment = new FirstFragment();
        return fragment;
    }

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_first;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initListeners();
    }

    /**
     * This where I start the transition I use a Transition drawable that goes from green to blue
     */
    @Override
    public void startBackgroundAnimation() {
        mRelativeLayoutBackground.setBackgroundResource(R.drawable.green_2_blue_bg);
        TransitionDrawable background = (TransitionDrawable) mRelativeLayoutBackground
                .getBackground();
        if (background != null) {
            background.startTransition(getResources().getInteger(R.integer
                    .background_animation_duration));
        }
    }

    /**
     * Here I setup the listeners for UI events
     */
    private void initListeners() {
        mButtonStartTransition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStartTransitionButtonPressed();
            }
        });
    }

    public void onStartTransitionButtonPressed() {
        ((MainActivity) getActivity()).startSecondFragment();
    }

}
