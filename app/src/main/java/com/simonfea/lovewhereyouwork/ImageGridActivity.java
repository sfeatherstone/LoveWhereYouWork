package com.simonfea.lovewhereyouwork;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.simonfea.lovewhereyouwork.https.BearerSecret;

public class ImageGridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);
        new FetchChatTask().execute();
    }

    private class FetchChatTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            BearerSecret.getBearerAuth();
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
        }
    }
}
