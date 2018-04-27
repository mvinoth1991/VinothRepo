1. Install NPM in windows to get the Appium packages
2. Run the appium server in the default ip and port.
3. Mention the mobile capability class file with all information like device name, platformname et
4. In order to find the app package and app activity name pls do the following steps www.automationtestinghub.com/apppackage-and-appactivity-name/
	4.1- adb shell and open the app on which you want to find the app activity and package name
	4.2- type $ dumpsys window windows | grep -E 'mCurrentFocus' to get the activity and package name
package name- com.android.calculator2/com.android.calculator2.Calculator
