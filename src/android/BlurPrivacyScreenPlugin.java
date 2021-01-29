/**
 * BlurPrivacyScreenPlugin.java
 * Created by s3rious a.k.a Leonid Semenov on 09/09/2019
 * Copyright (c) 2019 s3rious a.k.a Leonid Semenov. All rights reserved.
 * MIT Licensed
 */
package com.llamalox.blurprivacyscreen;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.Bundle;

public class BlurPrivacyScreenPlugin extends CordovaPlugin {

  @Override
  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    // Initialize plugin
    super.initialize(cordova, webView);
    
    Activity activity = this.cordova.getActivity();
	activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);	
  }
  
@Override
public void onPause(boolean multitasking) {
		Activity activity = this.cordova.getActivity();
		activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
	}
	
	@Override
	public void onResume(boolean multitasking) {
		Activity activity = this.cordova.getActivity();
		activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);		
	}
}
