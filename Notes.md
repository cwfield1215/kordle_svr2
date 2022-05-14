How Did I get the HTTP POST Working in Android Studio

Most important, and this is when it finally worked…

You can’t send the message to localhost or 127.0.0.1.  According to the code that’s running, localhost is the EMULATOR!!!!
You need to point at the actual IP address of the host machine or use 10.0.2.2, which the emulator knows as the host computer.

In addition…

Android studio is constantly looping and waiting for input. Some operations are NOT allowed to be executed in that loop, because they could hold up the app for a long time. Network calls is one of those things. So you need a few lines of code to allow this:

StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
StrictMode.setThreadPolicy(policy);


Also…

You must include these lines in the AndroidManifest.xml

<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

As well as…

android:usesCleartextTraffic="true"


It also helps to either reboot / uninstall from the emulator to get the settings to take effect. I couldn’t really figure out how to uninstall from the emulator, so I just picked another phone from the emulator list.

See:
https://stackoverflow.com/questions/56266801/java-net-socketexception-socket-failed-eperm-operation-not-permitted
https://stackoverflow.com/questions/5495534/java-net-connectexception-localhost-127-0-0-18080-connection-refusedhttps://stackoverflow.com/questions/25093546/android-os-networkonmainthreadexception-at-android-os-strictmodeandroidblockgua
