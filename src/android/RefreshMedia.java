package com.metacube.metacampus.mediarefresher;

import java.io.File;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class RefreshMedia extends CordovaPlugin{
	
	/**
	 * Executes the request and returns PluginResult.
	 * 
	 * @param action
	 *            The action to execute.
	 * @param args
	 *            JSONArry of arguments for the plugin.
	 * @param callbackId
	 *            The callback id used when calling back into JavaScript.
	 * @return A PluginResult object with a status and message.
	 */
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {

		//PluginResult.Status status = PluginResult.Status.OK;
		//String result = "";

		try {

			if (action.equals("refresh")) {

				String filePath = checkFilePath(args.getString(0));

				if (filePath.equals("")) {
					callbackContext.error("No file Path given");
					return false;
				}

				File file = new File(filePath);

				Intent scanIntent = new Intent(
						Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
				scanIntent.setData(Uri.fromFile(file));
				
				Context context = cordova.getActivity().getApplicationContext();
				context.sendBroadcast(scanIntent);
				callbackContext.success(new String("Media Scan complete"));
				return true;
			}
			
			return false;
		} catch (JSONException e) {
			callbackContext.error(e.getMessage());
			return false;
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			callbackContext.error(e.getMessage());
			return false;
		}

	}

	private String checkFilePath(String filePath) {
		String return_value = "";
		try {
			return_value = filePath.replaceAll("^file://", "");

		} catch (Exception e) {
			System.out.println("Error with the filePath");
		}

		return return_value;
	}

}
