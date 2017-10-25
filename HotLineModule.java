package com.XXXXXX.hotline;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.freshdesk.hotline.Hotline;
import com.freshdesk.hotline.HotlineUser;

import static com.facebook.FacebookSdk.getApplicationContext;


public class HotLineModule extends ReactContextBaseJavaModule {

    public HotLineModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "HotLineChat";
    }



/**
 * I Passed 3 paramaters from my JS Code to store User Details
 */
    @ReactMethod
    public void show(String name, String mobile,String email) {

        //Get the user object for the current installation
        HotlineUser hlUser = Hotline.getInstance(getApplicationContext()).getUser();

        hlUser.setName(name);
        hlUser.setEmail(email);
        hlUser.setPhone("+91", mobile);

        //Call updateUser so that the user information is synced with Hotline's servers
        Hotline.getInstance(getApplicationContext()).updateUser(hlUser);
        Hotline.showConversations(getApplicationContext());


    }

}