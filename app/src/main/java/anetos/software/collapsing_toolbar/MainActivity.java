package anetos.software.collapsing_toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout rl1, rl2;
    private LinearLayout content1, content2;
    private CardView cardView1, cardView2, cardView3;
    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupBottomNavigation();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ScrollingActivity.class));
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });

        rl1 = findViewById(R.id.rl1);
        rl2 = findViewById(R.id.rl2);
        content1 = findViewById(R.id.content1);
        content2 = findViewById(R.id.content2);
        cardView1 = findViewById(R.id.cardView1);
        cardView2 = findViewById(R.id.cardView2);
        cardView3 = findViewById(R.id.cardView3);

        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cardView1:
                Toast.makeText(this, "Bas karne bhai...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardView2:
                rl1.setVisibility(View.GONE);
                content1.setVisibility(View.GONE);
                rl2.setVisibility(View.VISIBLE);
                content2.setVisibility(View.VISIBLE);
                break;
            case R.id.cardView3:
                rl1.setVisibility(View.GONE);
                content1.setVisibility(View.GONE);
                rl2.setVisibility(View.VISIBLE);
                content2.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    private void setupBottomNavigation() {

        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.action_home:
                        rl1.setVisibility(View.VISIBLE);
                        content1.setVisibility(View.VISIBLE);
                        rl2.setVisibility(View.GONE);
                        content2.setVisibility(View.GONE);
                        return true;
                    case R.id.action_navigation:
                        return true;
                }
                return false;
            }
        });
    }
}
