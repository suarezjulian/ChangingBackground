ChangingBackground
==================

Coding challenge for Ora Interactive.

I created a new repo instead of adding a pull request to the original challenge since this is the Android version and apart from the background drawable they have nothing in common.

The basic strategy was using a TransitionDrawable as a background with two states blue and green. Then it was just a matter of detecting when to start the transitions.

I added a sample APK for simple installation.
I used Fragments, Gradle, Android Studio and Google's support library (without ActionBar since it wasn't really needed in this case)
