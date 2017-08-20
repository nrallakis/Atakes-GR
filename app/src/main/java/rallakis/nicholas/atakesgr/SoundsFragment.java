package rallakis.nicholas.atakesgr;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.google.firebase.analytics.FirebaseAnalytics;


public class SoundsFragment extends Fragment {

    public static final String EXTRA_SOUNDS_NAME = "sounds_name";

    private SoundList mSoundList;

    public static SoundsFragment newInstance(int soundsName) {
        Bundle args = new Bundle();
        args.putInt(EXTRA_SOUNDS_NAME, soundsName);

        SoundsFragment fragment = new SoundsFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        int soundsName = args.getInt(EXTRA_SOUNDS_NAME);

        mSoundList = SoundList.get(soundsName);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sounds, container, false);

        if (mSoundList.getBackground() != SoundList.NO_BACKGROUND) {
            LinearLayout root = view.findViewById(R.id.root_layout);
            setBackground(getContext(), root, mSoundList.getBackground());
        }

        final SoundPlayer player = SoundPlayer.getInstance(getContext());

        Button randomPlayButton = view.findViewById(R.id.random_play_button);
        randomPlayButton.setText(getString(R.string.random_choice, mSoundList.getName()));
        randomPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.handleSoundAvailability(getContext());
                int randomIndex = (int) (Math.random() * mSoundList.getCount());
                player.playSound(mSoundList.getSound(randomIndex));
                logRandomPlayButtonClicked();
            }
        });

        GridView gridView = view.findViewById(R.id.button_grid);
        gridView.setAdapter(new ButtonGridViewAdapter(getContext(), mSoundList));

        return view;
    }

    private void logRandomPlayButtonClicked() {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "RandomButton");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, mSoundList.getName());
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "button");
        FirebaseAnalytics.getInstance(getContext()).logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

    private void setBackground(Context context, View view, int drawableId){
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), drawableId);
        int width = Resources.getSystem().getDisplayMetrics().widthPixels;
        int height = Resources.getSystem().getDisplayMetrics().heightPixels;
        bitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        view.setBackground(bitmapDrawable);
    }
}
