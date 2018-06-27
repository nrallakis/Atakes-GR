package rallakis.nicholas.atakesgr;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class ButtonGridViewAdapter extends ArrayAdapter<Sound> {

    public static final String TAG = ButtonGridViewAdapter.class.getSimpleName();

    private SoundList.PlayLists mPlayList;
    private SoundPlayer mPlayer;
    private PlayButtonListener mListener;

    public ButtonGridViewAdapter(Context context, SoundList.PlayLists playList, PlayButtonListener listener) {
        super(context, R.layout.button);
        mPlayList = playList;
        mPlayer = SoundPlayer.getInstance(context);
        mListener = listener;
    }

    @Override
    public int getCount() {
        return mPlayList.getCount();
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

        final Sound sound = mPlayList.getSound(position);

        Button playButton = child.findViewById(R.id.play_button);

        playButton.setText(sound.getName());
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onPlayClick(sound);
            }
        });
        return child;
    }
}
