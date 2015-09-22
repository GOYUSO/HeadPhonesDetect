package es.elelog;

import android.content.Context;
import android.media.AudioManager;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

public class CDVHPhone extends CordovaPlugin {

  private static final String ACTION_DETECT = "detect";

  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    try {
      if (ACTION_DETECT.equals(action)) {
        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, isHeadsetEnabled()));
        return true;
      } else {
        callbackContext.error("La acción: " + action + " no está permitida.");
        return false;
      }
    } catch (Exception e) {
      callbackContext.error(e.getMessage());
      return false;
    }
  }

  private boolean isHeadsetEnabled() {
    final AudioManager audioManager = (AudioManager) cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
    return audioManager.isWiredHeadsetOn() ||
        audioManager.isBluetoothA2dpOn() ||
        audioManager.isBluetoothScoOn();
  }
}