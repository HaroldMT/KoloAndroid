package fr.cyberix.kolo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.cyberix.kolo.R;
import fr.cyberix.kolo.fragments.*;
import fr.cyberix.kolo.helpers.KoloHelper;
import fr.cyberix.kolo.helpers.ConfigHelper;
import fr.cyberix.kolo.helpers.KoloHelper;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.card_view_kolo_retrait)
    CardView cardKoloRetrieve;
    @BindView(R.id.card_view_kolo_tranfer)
    CardView cardKoloTransfer;
    @BindView(R.id.card_view_kolo_payement)
    CardView cardKoloPayement;
    @BindView(R.id.drawer_naview)
    NavigationView nvdrawer;
    @BindView(R.id.drawer_nav)
    DrawerLayout drawerLayout;

    //BindView initialisation
    @BindView(R.id.txtDashFirstname)
    TextView _firstnameTextview;
    @BindView(R.id.txtDashMainBalance)
    TextView _mainbalanceTextview;

    private CardView cardDashDrawer;
    private ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.setDebug(true);
        ButterKnife.bind(this);
        KoloHelper.setActivity(this);

        View headerView = nvdrawer.getHeaderView(0);
        cardDashDrawer = headerView.findViewById(R.id.card_dash_drawheader);
        cardDashDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KoloHelper.ShowToast("test");
                showProfile();

        //Click listeners to cards
        cardKoloRetrieve.setOnClickListener(this);
        cardKoloPayement.setOnClickListener(this);
        cardKoloTransfer.setOnClickListener(this);
        //cardDashDrawer.setOnClickListener(this);

        //Retieve User name and account balance
        String accbalstring = String.valueOf(ConfigHelper.getAccountInfo().getCustomer().getBalance());
        String firstnamestring = ConfigHelper.getAccountInfo().getPerson().getFirstname();

        //Set data in textview
        _firstnameTextview.setText(firstnamestring);
        _mainbalanceTextview.setText(accbalstring);

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

    public void showProfile() {
        Intent intent = new Intent(this, KoloUserProfilActivity.class);
//        startActivity(new Intent(getBaseContext(), KoloUserProfilActivity.class));
        startActivity(intent);
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

        switch (item.getItemId()) {
            case R.id.draw_menu_home:
                if (!KoloHelper.getMyActivity().getClass().equals(DashboardActivity.class)) {
                    startActivity(new Intent(DashboardActivity.this, DashboardActivity.class));
                }
                break;
            case R.id.drawMenuProfilloutline:
                showProfile();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //Fragment implementaion through navigation drawer.
    public void selectitemDrawer(MenuItem menuItem) {
        Fragment myfragment = null;
        Class fragmentClass = null;
        switch (menuItem.getItemId()) {
            case R.id.drawer_notifications:
                fragmentClass = KoloNotificationFragment.class;
                break;
            case R.id.drawer_historic:
                fragmentClass = Customer_BalhistoryFragment.class;
                break;
            case R.id.drawer_dash:
                //fragmentClass = TestFragment.class;
                break;
            default:
                break;
        }
        try {
            myfragment = (Fragment) fragmentClass.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fra_lay_nav, myfragment).commit();
        menuItem.setChecked(true);
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

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.card_view_kolo_tranfer:
                intent = new Intent(this, KoloTransferActivity.class);
                startActivity(intent);
                break;
            case R.id.card_dash_drawheader:
                showProfile();
                break;
            default:
                break;
        }
    }
}
