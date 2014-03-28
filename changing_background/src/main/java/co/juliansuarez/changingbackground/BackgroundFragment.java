package co.juliansuarez.changingbackground;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Use the {@link co.juliansuarez.changingbackground.BackgroundFragment#newInstance} factory
 * method to
 * create an instance of this fragment.
 */
public class BackgroundFragment extends Fragment {

    private static final String ID_PARAM = "id";
    private static final int FIRST_FRAGMENT = 0;
    private static final int GREEN_FRAGMENT = 1;


    @InjectView(R.id.buttonStartTransition)
    Button mButtonStartTransition;

    private int mId;


    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @return A new instance of fragment BackgroundFragment.
     */
    public static BackgroundFragment newInstance(int id) {
        BackgroundFragment fragment = new BackgroundFragment();
        Bundle args = new Bundle();
        args.putInt(ID_PARAM, id);
        return fragment;
    }

    public BackgroundFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mId = getArguments().getInt(ID_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_background, container, false);
        switch (mId) {
            case FIRST_FRAGMENT:
                v.setBackgroundResource(R.drawable.blue);
                break;
            case GREEN_FRAGMENT:
                v.setBackgroundResource(R.drawable.green);
                break;
        }

        ButterKnife.inject(this, v);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initListeners();
    }

    private void initListeners() {
        mButtonStartTransition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStartTransitionButtonPressed();
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onStartTransitionButtonPressed() {

    }





}
