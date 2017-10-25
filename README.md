**# react-native-hotline**

**hotline.io integration with React Native App for Android**


Add below lines project level build.gradle.After adding the build.gradle fiel ooks like below

Top-level build file where you can add configuration options common to all sub-projects/modules.




    
    buildscript {
    
     repositories {
         jcenter()
     }

     dependencies {
         classpath 'com.android.tools.build:gradle:2.2.3'
         classpath 'com.github.dcendents:android-maven-gradle-plugin:1.5'
     }
    }

     allprojects {
         repositories {
             jcenter()
             maven { url "https://maven.google.com" }
             maven { url "https://jitpack.io" }
             maven {
                 url "$rootDir/../node_modules/react-native/android"
             }
         }
     }
Now **app** level **build.gradle**


add this dependency under dependencies:

    dependencies{
        ....
        compile 'com.github.freshdesk:hotline-android:1.2.5'
    
    }


Add the  above java files **Constants,HotLineModule,HotLineReactPackage** to your Java source folder.


After addding,include your HotLineReactPackage to MainApplication where all your packages includes

    ,new HotLineReactPackage()



Now Final Step is to add HotLine Configuration in your **MainActivity** under onCreate method

I added these lines of code under **onCreate()**.
 
    HotlineConfig hlConfig = new HotlineConfig(Constants.HOTLINE_APP_ID, Constants.HOTLINE_APP_KEY);
    hlConfig.setVoiceMessagingEnabled(false);//depends on your requirement
    hlConfig.setCameraCaptureEnabled(true);//depends on your requirement
    hlConfig.setPictureMessagingEnabled(true);//depends on your requirement
    Hotline.getInstance(getApplicationContext()).init(hlConfig);


Now call  show method from Your Example.js in your react-native project 
with

Don't forget to import NativeModules before calling
i.e add
the following line 

_import {NativeModules} from 'react-native';_

then place below line under any action (onPress)

**NativeModules.HotLineChat.show(param1,param2,param3)**


You might ask what is  HotLineChat?

That is what we have returned our Module name as in **HotLineModule.java** file  under **getName()** method

