package com.cassiehanyu.fotagmobile;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.cassiehanyu.fotagmobile.Model.Model;
import com.cassiehanyu.fotagmobile.View.MainView;
import com.cassiehanyu.fotagmobile.View.MyToolBar;
import com.cassiehanyu.fotagmobile.View.RVAdapter;

public class MainActivity extends AppCompatActivity {
    private Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Fotag", "onCreate");

        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.myToolbar);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle("Placeholder here");
        model = new Model();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        Log.d("Fotag", "onPostCreate");

        MyToolBar myToolBar = new MyToolBar(this,model);
        //Toolbar myToolBar = (Toolbar) findViewById(R.id.aa);
        //setSupportActionBar(myToolBar);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar_layout);
        appBarLayout.addView(myToolBar);
        //setSupportActionBar(myToolBar);


//        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
//        rv.setHasFixedSize(true);
//        LinearLayoutManager llm = new LinearLayoutManager(this);
//        rv.setLayoutManager(llm);
//
//        RVAdapter rvAdapter = new RVAdapter(model.getImageModelList());
//        rv.setAdapter(rvAdapter);


        MainView mainView = new MainView(this,model);
        ScrollView v2 = (ScrollView) findViewById(R.id.ScrollView01);
        v2.addView(mainView);


        //floating action button fab is the email button at the right button
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            System.out.println("lllllllllll");
            model.setCurLayout("Grid");
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            System.out.println("ppppppppppp");
            model.setCurLayout("List");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
