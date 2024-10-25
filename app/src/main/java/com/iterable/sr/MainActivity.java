package com.iterable.sr;

import static android.text.Html.*;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;
import com.iterable.iterableapi.IterableApi;
import com.iterable.iterableapi.IterableInAppManager;
import com.iterable.iterableapi.IterableInAppMessage;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView message;

    private static final String API_KEY = "15161afb186b4b56847c4970fed7e5dc";
    private static final String CANDIDATE_EMAIL = "sheebacharles@yahoo.com";
    private static final String FIRST_NAME = "Sheeba";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeIterableSDK();
        setupUI();
        fetchAndShowInAppMessage();
    }

    private void initializeIterableSDK() {
        // Initialize Iterable SDK and set email
        IterableApi.initialize(getApplicationContext(), API_KEY);
        IterableApi.getInstance().setEmail(CANDIDATE_EMAIL);
    }

    private void setupUI() {
        message = findViewById(R.id.textView);


        // Button to update user profile
        Button updateProfileButton = findViewById(R.id.updateProfileButton);
        updateProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUserProfile();
            }
        });

        // Button to send custom event
        Button sendEventButton = findViewById(R.id.sendEventButton);
        sendEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCustomEvent();
            }
        });
    }

    private void updateUserProfile() {
        try {
            // Create JSON object for user profile update
            JSONObject userData = new JSONObject();
            userData.put("firstName", FIRST_NAME);
            userData.put("isRegisteredUser", true);
            userData.put("TC_User_Test_Key", "completed");

            // Update user profile via Iterable API
            IterableApi.getInstance().updateUser(userData);
            message.setText("Your Iterable user profile was updated successfully.");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void sendCustomEvent() {
        try {
            // Create custom event data
            JSONObject eventData = new JSONObject();
            eventData.put("platform", "Android");
            eventData.put("isTestEvent", true);
            eventData.put("url", "https://iterable.com/sa-test/" + FIRST_NAME);
            eventData.put("secret_code_key", "Code_123");

            // Send custom event via Iterable API
            IterableApi.getInstance().track("mobileTCTestEvent", eventData);
            message.setText("Your Iterable custom event was sent.");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void fetchAndShowInAppMessage() {
        // Get in-app messages from Iterable's queue
        IterableInAppManager inAppManager = IterableApi.getInstance().getInAppManager();
        List<IterableInAppMessage> messages = inAppManager.getMessages();

        if (!messages.isEmpty()) {
            // Get the first message in the queue and show it
            IterableInAppMessage firstMessage = messages.get(0);
            //inAppManager.setAutoDisplayPaused(true);
            //inAppManager.showMessage(firstMessage);
            // Extract the HTML content
           String messageFull = Html.fromHtml((firstMessage.getContent().html), FROM_HTML_SEPARATOR_LINE_BREAK_BLOCKQUOTE ).toString();
           if (messageFull.contains("}}"))
                messageFull = messageFull.substring((messageFull.indexOf("}}")+6), messageFull.length());
           message.setText(messageFull);


        } else {
            message.setText("No in-app messages available.");
        }
    }
}
