package fr.cyberix.kolo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class DashboardActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //Drawer animation and toggle
        drawerLayout = findViewById(R.id.drawer_nav);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Navigation item click events handling
        NavigationView nvdrawer = findViewById(R.id.drawer_naview);
        setupDrawerContent(nvdrawer);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.drawermenu_02, menu);
        return true;
    }

    //Drawer Buttom coding
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return (true);
        }

        switch (item.getItemId()){
            case R.id.draw_menu_home: startActivity(new Intent(DashboardActivity.this, DashboardActivity.class));
                break;
            default: break;
        }
        return super.onOptionsItemSelected(item);
    }

    //Fragment implementaion through navigation drawer.
    public void selectitemDrawer(MenuItem menuItem) {
        Fragment myfragment = null;
        Class fragmentClass = null;
        /*switch (menuItem.getItemId()) {
            case R.id.drawer_dash:
                fragmentClass = DashboardActivity.class;
                break;
            case R.id.drawer_search:
                fragmentClass = SearchFragment.class;
                break;
            default:
                break;
        }*/
        try {
            myfragment = (Fragment) fragmentClass.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fra_lay_nav, myfragment).commit();
        setTitle(menuItem.getTitle());
        drawerLayout.closeDrawers();
    }
    private void setupDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectitemDrawer(item);
                return true;
            }
        });
    }
}
