package co.juliansuarez.changingbackground;

import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.InjectView;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory
 * method to
 * create an instance of this fragment.
 */
public class SecondFragment extends BaseAnimationFragment {

    @InjectView(R.id.imageViewCloseAction)
    ImageView mImageViewCloseAction;
    @InjectView(R.id.relativeLayoutBackground)
    RelativeLayout mRelativeLayoutBackground;

    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @return A new instance of fragment FirstFragment.
     */
    public static SecondFragment newInstance() {
        SecondFragment fragment = new SecondFragment();
        return fragment;
    }

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_second;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initListeners();
        if (savedInstanceState == null) {
            startBackgroundAnimation();
        } else {
            mRelativeLayoutBackground.setBackgroundResource(R.drawable.green);
        }
    }

    /**
     * This where I start the transition I use a Transition drawable that goes from blue to green
     */
    @Override
    public void startBackgroundAnimation() {
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
        mImageViewCloseAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
    }

}
