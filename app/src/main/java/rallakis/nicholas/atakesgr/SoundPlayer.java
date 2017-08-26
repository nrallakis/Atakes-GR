package rallakis.nicholas.atakesgr;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundPlayer {

    private MediaPlayer mPlayer;
    private int mLastSoundResource;
    private Context mAppContext;

    private static SoundPlayer sSoundPlayer;

    private SoundPlayer(Context appContext) {
        mAppContext = appContext;
    }

    public static SoundPlayer getInstance(Context c) {
        if (sSoundPlayer == null) {
            sSoundPlayer = new SoundPlayer(c.getApplicationContext());
        }
        return sSoundPlayer;
    }

    public void playSound(Sound sound) {
        if (mPlayer != null && mPlayer.isPlaying()) {
            mPlayer.stop();
        }

        int soundResource = sound.getResourceId();
        mPlayer = MediaPlayer.create(mAppContext, soundResource);
        mPlayer.start();
        mLastSoundResource = soundResource;
    }

    public void start() {
        if (mPlayer != null) {
            mPlayer.start();
        }
    }

    public boolean isPlaying() {
        if (mPlayer != null) {
            return mPlayer.isPlaying();
        }
        return false;
    }

    public void pause() {
        if (mPlayer == null) return;
        if (mPlayer.isPlaying()) {
            mPlayer.pause();
        } else {
            mPlayer.start();
        }
    }

    public void stop() {
        if (mPlayer == null) return;
        mPlayer.stop();
        mPlayer.release();
        mPlayer = null;
    }
}
