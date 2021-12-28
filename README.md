# 90 Cards

90 Cards is a project created by Giovanni Agustoni back in 2019 and developped by Alex Guardini since 2019. The idea was to create a card game similar to ring of fire, but with more rules and cards. 

## Requirements

[Android Studio](https://developer.android.com/studio?gclid=CjwKCAiAiKuOBhBQEiwAId_sK4EbmaY8Ak9kTfCm0GxPpo-fShewx7tyhjt4YvOCiUQKjiWSuBVUixoCbbEQAvD_BwE&gclsrc=aw.ds)


## Starting up

Clone this repository in a folder that you like on your pc. Then open the app folder with Android Studio. 
In order to make the code properly work, the JDK (Java Development Kit) has to be configured correctly. Go to File -> Project Structure -> SDK Location and select your JDK in the JDK Location section. For some versions of Android Studio this is already managed by Gradle. In Gradle Settings it is possible to check the version used.
After this, check that the Build Tools Version and the SDK Version are correct as well. Go to File -> Project Structure -> Modules and select the Version accordingly. If an error concerning licenses occurs, then go to File -> Settings -> Appearance & Behavior -> System Settings -> Android SDK -> SDK Tools and tick "Google Play Licensing Library".


## Files

Hereafter are listed the main folders of the project, which are stored in the 90_cards/app/src folder

#### assets

Set of JSON files used for the creation of the cards in different languages

#### java/com/example/a90_cards

Folder containing all the java files, mainly the files representing the cards, the deck, the logic behind the application

#### res

Resources files where the layouts, images, animations are stored


#### AndroidManifest

Backbone of the entire project. Every time a new activity is added to the project, it has to be declared in the AndroidManifest.xml file

