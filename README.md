This app implements the following:

 a. Initializes the SDK with the email address {{candidate’s email}}.Uses the following API key to initialize:
 15161afb186b4b56847c4970fed7e5dc
 b. Implements a button in the app UI that when pressed, leverages the Iterable SDK to
 update the {{candidate’s email} user profile using the criteria below. More info
 around the user profile can be found here.
 i. key: firstName, value: your first name
 ii. key: isRegisteredUser, value: true
 iii. key: TC_User_Test_Key, value: “completed”. (Please note the keys and values in
 THIS ASSIGNMENT are case sensitive

 c. Implements a second button in the app UI that sends a custom event to Iterable using the below criteria.
      Event Name: mobileTCTestEvent
      key: platform, value: “iOS” or “Android” depending on which you’re using
      key: isTestEvent, value: true
      key: url, value: “https://iterable.com/sa-test/YOUR_FIRST_NAME_HERE”
      key: secret_code_key, value: “Code_123”

 d. Renders the in-app message on device or simulator
This app includes the following functionalities:
 1. SDK Initialization: The app initializes the SDK using the candidate’s email and the specified API key: 15161afb186b4b56847c4970fed7e5dc.

 2. Profile Update Button: A button in the app UI allows the user to update the candidate’s profile within Iterable using the following details:

    firstName: Set to your first name.
    isRegisteredUser: Set to true.
    TC_User_Test_Key: Set to "completed".
 3. Custom Event Button: A second button sends a custom event to Iterable, configured with:

    Event Name: mobileTCTestEvent
    Attributes:
      platform: Set to “iOS” or “Android” based on the platform.
      isTestEvent: Set to true.
      url: Set to “https://iterable.com/sa-test/YOUR_FIRST_NAME_HERE”.
      secret_code_key: Set to "Code_123".
4. In-App Message Rendering: Displays the in-app message on the device or simulator.
