package euphoria.psycho.porn;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

import androidx.annotation.Nullable;

public class SettingsFragment extends PreferenceFragment implements OnSharedPreferenceChangeListener {


    public static final String KEY_VIDEO_FOLDER = "key_video_folder";
    public static final String KEY_CK_COOKIE = "key_ck_cookie";

    public static void updateCkCookie(Context context, String value) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putString(KEY_CK_COOKIE, value)
                .apply();
    }

    public static String getCkCookie(Context context, String defValue) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(KEY_CK_COOKIE, defValue);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }

    @Override
    public void onPause() {
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
    }

}
