package rallakis.nicholas.atakesgr;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

public class Utils {

    public static void handleSoundAvailability(Context context) {
        AudioManager audio = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        Log.d(Utils.class.getSimpleName(), "Current volume: " + audio.getStreamVolume(AudioManager.STREAM_MUSIC));
        int currentVolume = audio.getStreamVolume(AudioManager.STREAM_MUSIC);
        int maxVolume = audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int minPreferredVolume = (int) (maxVolume * 0.35f);
        if (currentVolume < minPreferredVolume) {
            Toast.makeText(context, context.getString(R.string.increase_volume), Toast.LENGTH_LONG).show();
        }
    }

    public static void rateApp(Context context) {
        Intent rateIntent = null;
        try {
            rateIntent = rateIntentForUrl("market://details", context);
        } catch (ActivityNotFoundException e) {
            rateIntent = rateIntentForUrl("https://play.gooogle.com/store/apps/details", context);
        }
        context.startActivity(rateIntent);
    }

    private static Intent rateIntentForUrl(String url, Context c) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("%s?id=%s", url, c.getPackageName())));
        int flags = Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_MULTIPLE_TASK;
        if (Build.VERSION.SDK_INT >= 21) {
            flags |= Intent.FLAG_ACTIVITY_NEW_DOCUMENT;
        } else {
            flags |= Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET;
        }
        intent.addFlags(flags);
        return intent;
    }

}
