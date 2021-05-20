package com.example.jobcupid.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.stfalcon.chatkit.dialogs.DialogsList;
import com.stfalcon.chatkit.dialogs.DialogsListAdapter;
import com.example.jobcupid.R;
import com.stfalcon.chatkit.sample.features.demo.def.model.Dialog;
import com.stfalcon.chatkit.sample.features.demo.def.model.DialogsFixtures;
import com.stfalcon.chatkit.sample.features.demo.def.model.Message;

import com.stfalcon.chatkit.sample.features.demo.DemoDialogsActivity;
import com.stfalcon.chatkit.sample.features.demo.def.model.User;

import java.util.ArrayList;

public class ChatActivity extends DemoDialogsActivity {

    public static void open(Context context) {
        Intent intent = new Intent(context,
                MessageActivity.class);
        context.startActivity(intent);
    }

    private DialogsList dialogsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        dialogsList = findViewById(R.id.dialogsList);
        initAdapter();
    }

    @Override
    public void onDialogClick(Dialog dialog) {
        ChatActivity.open(this);
    }

    private void initAdapter() {
        super.dialogsAdapter = new DialogsListAdapter<>(super.imageLoader);
//        super.dialogsAdapter.setItems(DialogsFixtures.getDialogs());

        super.dialogsAdapter.setOnDialogClickListener(this);
        super.dialogsAdapter.setOnDialogLongClickListener(this);

        dialogsList.setAdapter(super.dialogsAdapter);

        /// add dialog
        User user = new User("bla", "hey", "lala", true);
        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        Message msg = new Message("msg1", user, "Hi! We have a position that looks just for you, do you want to chat and hear more details?");
        Dialog dialog = new Dialog("1", "Mcdonalds", "hh", users, msg, 1);
        onNewDialog(dialog);
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
