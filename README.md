# react-native-hotline
hotline.io integration with React Native App for Android

Add below lines project level build.gradle.

 classpath 'com.github.dcendents:android-maven-gradle-plugin:1.5'
 After addding your build.gradle looks like below
 buildscript {
     repositories {
         jcenter()
     }
     dependencies {
         classpath 'com.android.tools.build:gradle:2.2.3'
         classpath 'com.github.dcendents:android-maven-gradle-plugin:1.5'
   }
 }


Add this also under build.gradle(Project level) under allprojects{...}
        maven { url "https://maven.google.com" }
        maven { url "https://jitpack.io" }


Now app level build.gradle

add this dependency under dependencies:

dependencies{
    ....
    compile 'com.github.freshdesk:hotline-android:1.2.5'

}


Add the files Constants,HotLineModule,HotLineReactPackage to your Java source folder.


After addding,
include your HotLineReactPackage to MainApplication where all your packages includes

    ,new HotLineRreactPackage()



Now Final Step is to add HotLine Configuration in your MainActivity under onCreate method

I added these lines of code under onCreate().
        HotlineConfig hlConfig = new HotlineConfig(Constants.HOTLINE_APP_ID, Constants.HOTLINE_APP_KEY);
        hlConfig.setVoiceMessagingEnabled(false);//depends on your requirement
        hlConfig.setCameraCaptureEnabled(true);//depends on your requirement
        hlConfig.setPictureMessagingEnabled(true);//depends on your requirement
        Hotline.getInstance(getApplicationContext()).init(hlConfig);



