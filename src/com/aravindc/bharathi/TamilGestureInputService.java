package com.aravindc.bharathi;


import com.aravindc.lipitk.LipiTKJNIInterface;


import android.annotation.SuppressLint;
import android.inputmethodservice.InputMethodService;
import android.util.Log;
import android.view.View;

@SuppressLint("NewApi")
public class TamilGestureInputService extends InputMethodService {
	
	private static final String TAG = "TamilGestureInutService";
	View mTamKeyboard;
	private LipiTKJNIInterface _lipitkInterface;

	@Override
	public void onCreate() {
		Log.d(TAG, TAG + ".onCreate()");
		String path = "/mnt/sdcard/Android/data/com.canvas/files";
		Log.d("JNI", "Path: " + path);
		_lipitkInterface = new LipiTKJNIInterface(path, "SHAPEREC_ALPHANUM");
		_lipitkInterface.initialize();
		super.onCreate();
	}
	
	@Override
	public View onCreateInputView() {
		Log.d(TAG, TAG + ".onCreateInputView()");
		mTamKeyboard = getLayoutInflater().inflate(R.layout.bharathi_ime_gui, null);
		return mTamKeyboard;
	}
	
	@Override
	public void onInitializeInterface() {
		Log.d(TAG, TAG + ".onInitializeInterface()");
	}

}
