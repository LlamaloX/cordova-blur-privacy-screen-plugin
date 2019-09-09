/**
 * BlurPrivacyScreenPlugin.java
 * Created by s3rious a.k.a Leonid Semenov on 09/09/2019
 * Copyright (c) 2019 s3rious a.k.a Leonid Semenov. All rights reserved.
 * MIT Licensed
 */
package com.s3rious.blurprivacyscreen;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

public class BlurPrivacyScreenPlugin extends CordovaPlugin {

  @Override
  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    // Initialize plugin
    super.initialize(cordova, webView);
    
    // Get main activity window
    Activity activity = this.cordova.getActivity();
    Window window = activity.getWindow();
    
    // Set FLAG_SECURE
    window.addFlags(WindowManager.LayoutParams.FLAG_SECURE);
  }
}
