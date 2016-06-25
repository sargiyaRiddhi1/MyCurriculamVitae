package com.example.riddhi.riddhiresumeapp;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by riddhi on 25/5/16.
 */
public class HomeActivity extends AppCompatActivity {
    @Bind(R.id.facebookIcon)
    ImageView facebookIcon;

    @Bind(R.id.linkedinIcon)
    ImageView linkedinIcon;

    @Bind(R.id.twitterIcon)
    ImageView twitterIcon;

    @Bind(R.id.fabNextEmoji)
    FloatingActionButton fabNextEmoji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.facebookIcon)
    public void facebookIconOnClickHandler(){
        Intent facebookIntent = getOpenFacebookIntent(this);
        startActivity(facebookIntent);
    }
    public Intent getOpenFacebookIntent(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.facebook.katana", 0); //Checks if FB is even installed.
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://profile/100005595123968")); //Trys to make intent with FB's URI
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/riddhi.sargiya")); //catches and opens a url to the desired page
        }
    }
    @OnClick(R.id.instagraIcon)
    public void instagraIconOnClickHandler(){
        Uri uri = Uri.parse("https://www.instagram.com/sargiyariddhi/");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.instagram.android");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/sargiyariddhi/")));
        }
    }

    @OnClick(R.id.linkedinIcon)
    public void linkedinIconOnClickHandler(){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://riddhi-sargiya"));
        final PackageManager packageManager = this.getPackageManager();
        final List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (list.isEmpty()) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/riddhi-sargiya-2b2208121?"));
        }
        startActivity(intent);
    }
    @OnClick(R.id.twitterIcon)
    public void twitterIconOnClickHandler(){
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=" +"SargiyaRiddhi")));
        }catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/#!/" +"SargiyaRiddhi")));
        }
    }
    @OnClick(R.id.fabNextEmoji)
    public void fabNextEmojiOnClickHAndler(){
        Intent intent=new Intent(HomeActivity.this,CategoriesActivity.class);
        startActivity(intent);
    }
}
