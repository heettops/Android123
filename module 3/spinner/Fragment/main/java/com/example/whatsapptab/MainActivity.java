package com.example.whatsapptab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.tool);
        setSupportActionBar(toolbar);


        viewPager = findViewById(R.id.viewpager);
        setupviewpager();

        tabLayout = findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);

        floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "done", Snackbar.LENGTH_LONG).show();


            }
        });

    }

    private void setupviewpager()

    {

        Myadapter myadapter=new Myadapter(getSupportFragmentManager());
        myadapter.addfragment(new ChatFragment(),"chat");
        myadapter.addfragment(new StatusFragment(),"Status");
        myadapter.addfragment(new CallFragment(),"call");
        viewPager.setAdapter(myadapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)

    {
        switch(item.getItemId())
        {
            case R.id.n1:
                break;

            case R.id.n2:
                break;

            case R.id.l1:
                break;

                case R.id.s1:
                    break;

                    case R.id.p1:
                        break;

                        case R.id.s2:
                            break;
        }
        return super.onOptionsItemSelected(item);
    }
}
