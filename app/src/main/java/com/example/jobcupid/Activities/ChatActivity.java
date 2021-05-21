package com.example.jobcupid.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.jobcupid.AppData;
import com.example.jobcupid.FireBaseHandlers.FireStoreHandler;
import com.stfalcon.chatkit.dialogs.DialogsList;
import com.stfalcon.chatkit.dialogs.DialogsListAdapter;
import com.example.jobcupid.R;
import com.stfalcon.chatkit.sample.features.demo.def.model.Dialog;
import com.stfalcon.chatkit.sample.features.demo.def.model.DialogsFixtures;
import com.stfalcon.chatkit.sample.features.demo.def.model.Message;

import com.stfalcon.chatkit.sample.features.demo.DemoDialogsActivity;
import com.stfalcon.chatkit.sample.features.demo.def.model.User;

import java.util.ArrayList;

import static com.example.jobcupid.Activities.LoginActivity.BUSINESS_OWNER;

public class ChatActivity extends DemoDialogsActivity {

    public static void open(Context context, String msg) {
        Intent intent = new Intent(context,
                MessageActivity.class);
        intent.putExtra("msg", msg);
        context.startActivity(intent);
    }

    private DialogsList dialogsList;
    private AppData appData;

    public static final String CANDIDATE = "candidate";
    public static final String BUSINESS_OWNER = "business owner";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        dialogsList = findViewById(R.id.dialogsList);
        appData = (AppData) getApplicationContext();
        initAdapter();
    }

    @Override
    public void onDialogClick(Dialog dialog) {
        ChatActivity.open(this, dialog.getLastMessage().getText());
    }

    private void initAdapter() {
        super.dialogsAdapter = new DialogsListAdapter<>(super.imageLoader);
//        super.dialogsAdapter.setItems(DialogsFixtures.getDialogs());

        super.dialogsAdapter.setOnDialogClickListener(this);
        super.dialogsAdapter.setOnDialogLongClickListener(this);

        dialogsList.setAdapter(super.dialogsAdapter);

        appData.fireStoreHandler.getUserCategory(new FireStoreHandler.FireStoreUserCategoryCallback() {
            @Override
            public void onCallBack(String userCategory, Boolean success) {
                if (userCategory.equals(BUSINESS_OWNER)) {
                    addDialogsForBusiness();
                } else {
                    addDialogsForCandidate();
                }
            }
        });

    }

    private void addDialogsForCandidate() {
        User user1 = new User("1", "hey", "https://media-cdn.tripadvisor.com/media/photo-s/16/c3/0c/36/getlstd-property-photo.jpg", true);
        ArrayList<User> users1 = new ArrayList<>();
        users1.add(user1);
        Message msg1 = new Message("msg1", user1, "It's a match!");
        Dialog dialog1 = new Dialog("1", "Bar 55", "https://media-cdn.tripadvisor.com/media/photo-s/16/c3/0c/36/getlstd-property-photo.jpg", users1, msg1, 1);
        onNewDialog(dialog1);

        User user2 = new User("2", "hey", "https://i.pinimg.com/280x280_RS/2b/27/55/2b2755c18564277c248ab8815646ef62.jpg", true);
        ArrayList<User> users2 = new ArrayList<>();
        users2.add(user2);
        Message msg2 = new Message("msg2", user2, "Hi! We have a position that looks just for you, do you want to chat and hear more details?");
        Dialog dialog2 = new Dialog("2", "McDonald's", "https://i.pinimg.com/280x280_RS/2b/27/55/2b2755c18564277c248ab8815646ef62.jpg", users2, msg2, 0);
        onNewDialog(dialog2);

        User user3 = new User("3", "hey", "https://media-cdn.tripadvisor.com/media/photo-s/16/de/7e/04/logo-domino-s-pizza.jpg", true);
        ArrayList<User> users3 = new ArrayList<>();
        users3.add(user3);
        Message msg3 = new Message("msg3", user3, "Hey there! Come and join the best pizza stuff.");
        Dialog dialog3 = new Dialog("3", "Domino's", "https://media-cdn.tripadvisor.com/media/photo-s/16/de/7e/04/logo-domino-s-pizza.jpg", users3, msg3, 0);
        onNewDialog(dialog3);
    }

    private void addDialogsForBusiness() {

        User user2 = new User("2", "hey", "https://media-exp1.licdn.com/dms/image/C4E03AQEG6dlDaZRfkQ/profile-displayphoto-shrink_400_400/0/1554212015600?e=1626912000&v=beta&t=IWbru0G6vJ5Qz5wnQGB2oyiW8tnths1Q5maP_AO8Rus", true);
        ArrayList<User> users2 = new ArrayList<>();
        users2.add(user2);
        Message msg2 = new Message("msg2", user2, "It's a match!");
        Dialog dialog2 = new Dialog("2", "Lior Forer", "https://media-exp1.licdn.com/dms/image/C4E03AQEG6dlDaZRfkQ/profile-displayphoto-shrink_400_400/0/1554212015600?e=1626912000&v=beta&t=IWbru0G6vJ5Qz5wnQGB2oyiW8tnths1Q5maP_AO8Rus", users2, msg2, 1);
        onNewDialog(dialog2);

        User user1 = new User("1", "hey", "https://images.generated.photos/vck4kSWJHS3tDJ1gU31vOxl4HksUTqmmRmkePSz9JO0/rs:fit:256:256/Z3M6Ly9nZW5lcmF0/ZWQtcGhvdG9zL3Yz/XzAwOTkyMDMuanBn.jpg", true);
        ArrayList<User> users1 = new ArrayList<>();
        users1.add(user1);
        Message msg1 = new Message("msg1", user1, "Hi, do you have some open positions?");
        Dialog dialog1 = new Dialog("1", "Nir Vaknin", "https://images.generated.photos/vck4kSWJHS3tDJ1gU31vOxl4HksUTqmmRmkePSz9JO0/rs:fit:256:256/Z3M6Ly9nZW5lcmF0/ZWQtcGhvdG9zL3Yz/XzAwOTkyMDMuanBn.jpg", users1, msg1, 0);
        onNewDialog(dialog1);

        User user3 = new User("3", "hey", "https://images.generated.photos/GwR2LK1fKp6FlVZUtu63s7NGgXcnfLg9BYwrTumCBa0/rs:fit:256:256/Z3M6Ly9nZW5lcmF0/ZWQtcGhvdG9zL3Yz/XzA3ODAwMjcuanBn.jpg", true);
        ArrayList<User> users3 = new ArrayList<>();
        users3.add(user3);
        Message msg3 = new Message("msg3", user3, "Hi, I'm Eva. I'm from Jerusalem and I saw that you have some open positions there. Is that relevant?");
        Dialog dialog3 = new Dialog("3", "Eva King", "https://images.generated.photos/GwR2LK1fKp6FlVZUtu63s7NGgXcnfLg9BYwrTumCBa0/rs:fit:256:256/Z3M6Ly9nZW5lcmF0/ZWQtcGhvdG9zL3Yz/XzA3ODAwMjcuanBn.jpg", users3, msg3, 0);
        onNewDialog(dialog3);
    }

    //for example
    private void onNewMessage(String dialogId, Message message) {
        boolean isUpdated = dialogsAdapter.updateDialogWithMessage(dialogId, message);
        if (!isUpdated) {
            //Dialog with this ID doesn't exist, so you can create new Dialog or update all dialogs list
        }
    }

    //for example
    private void onNewDialog(Dialog dialog) {
        dialogsAdapter.addItem(dialog);
    }
}
