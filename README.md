AIConnector.Project
===================

1) Overview of the project
The application provide the people with autism a creative and easy to use way to communicate with others. The application is developed in native mode and uses Android SDK. It is important  in this application to have an easy navigation and functions to enable all users specially children.

The application provides different tabs and those tabs the user can access some functions or buttons. When the user access the button, the app will show a large picture of the funciton that he or she wants.

2)Required Android Permissions and why the app needs them

The applicaiton requires Read & Write permission to access the SD card.

3)Required Web Services, e.g., GIS, Google, etc., and why the app needs them

The Applicaiotn does not require web services.

4)Required, built-in, features/devices: GPS, Camera, Gallery, Contacts, SMS, etc. 

The Application does not require such services

5)Testing procedures (emulators, device tests, unit tests, etc.)

The applicaiton was set with a requirment for SDK version 17. although it can be combiled to work on older versions.

6)Screenshots

In the folder with this text file there XX of images. 
  1)The first image (FirstTab) is for the Food Tab with the different predefined images available for the user.
  2)The second image (FoodClicked) shows when the user have selected an item from the list.
  3)The third image (ActivityTab) shows the available activities that the user can select.
  4)The fourth image (ActivityClicked) shows when the user have selected an item from the list.
  5)The fifth image (SettingsTab) shows the available option to enter the password to unlock the app or to change the password.
  
7)Known bugs, limitations, and problems

Currently due to the difficulty to package some images in some folers with the app, I had to use a set of image that can not be changed. Althoug, I was able to upload some image to the emulator and then load the images from there.
Due to this problem, I was not able to use the DB becuase there are no images loaded in the SD card. However, I have included my DB code with this project.

Another problem is, since I am using Tab Fragment, I was not able to mount the SD card. However, I have included the code that worked for me when I have developed it in a seperate activity.



8)Set of features to be implemented or next steps
It is important to find the way to package the images with the app in certain folder. This to allow the app to load them and then show them in the gridviews and the tabs.

In addition, it might be important to fix accessing SD card from the Tab Fragment to allow having password saved to control the applicaiton.
        
        
9) License and contributors
The application can be used for teaching purposes only. Using the application or the code for anyother purpose must be after written consent by the author.
