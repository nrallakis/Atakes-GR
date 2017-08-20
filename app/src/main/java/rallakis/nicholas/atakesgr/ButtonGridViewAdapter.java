package rallakis.nicholas.atakesgr;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.google.firebase.analytics.FirebaseAnalytics;

public class ButtonGridViewAdapter extends ArrayAdapter<Sound> {

    public static final String TAG = ButtonGridViewAdapter.class.getSimpleName();

    private SoundList mSoundList;
    private SoundPlayer mPlayer;

    public ButtonGridViewAdapter(Context context, SoundList soundList) {
        super(context, R.layout.button);
        mSoundList = soundList;
        mPlayer = SoundPlayer.getInstance(context);
    }

    @Override
    public int getCount() {
        return mSoundList.getCount();
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View child = convertView;

        if (child == null) {
            LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();
            child = inflater.inflate(R.layout.button, parent, false);
        }

        final Sound sound = mSoundList.getSound(position);

        Button playButton = (Button) child.findViewById(R.id.play_button);

        playButton.setText(sound.getName());
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.handleSoundAvailability(getContext());
                mPlayer.playSound(sound);
                logPlayButtonClicked(sound.getName());
            }
        });
        return child;
    }

    private void logPlayButtonClicked(String name) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, name);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "button");
        FirebaseAnalytics.getInstance(getContext()).logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }
}
