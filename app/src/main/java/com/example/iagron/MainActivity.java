package com.example.iagron;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ArrayAdapter<String> adapter;
    private String[] array;
    public int category_index;
    private DrawerLayout drawer;
    private ListView list;
    private Toolbar toolbar;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        this.list = (ListView) findViewById(R.id.listView);
        this.array = getResources().getStringArray(R.array.kyltyr_array);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList(Arrays.asList(this.array)));
        this.adapter = arrayAdapter;
        this.list.setAdapter(arrayAdapter);
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar2;
        setSupportActionBar(toolbar2);
        this.drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ((NavigationView) findViewById(R.id.nav_view)).setNavigationItemSelectedListener(this);
        this.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, TextContentActivity.class);
                intent.putExtra("category", MainActivity.this.category_index);
                intent.putExtra("position", position);
                MainActivity.this.startActivity(intent);
            }
        });
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, this.drawer, this.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        this.drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        this.toolbar.setTitle((int) R.string.kyltyri);
        return true;
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.id_kylt) {
            this.toolbar.setTitle((int) R.string.kyltyri);
            this.array = getResources().getStringArray(R.array.kyltyr_array);
            this.adapter.clear();
            this.adapter.addAll(this.array);
            this.adapter.notifyDataSetChanged();
            this.category_index = 0;
        } else if (id == R.id.id_ydobr) {
            this.toolbar.setTitle((int) R.string.ydobrenie);
            this.array = getResources().getStringArray(R.array.ydobr_array);
            this.adapter.clear();
            this.adapter.addAll(this.array);
            this.adapter.notifyDataSetChanged();
            this.category_index = 1;
        } else if (id == R.id.id_pochva) {
            this.toolbar.setTitle((int) R.string.pochva);
            this.array = getResources().getStringArray(R.array.pochva_array);
            this.adapter.clear();
            this.adapter.addAll(this.array);
            this.adapter.notifyDataSetChanged();
            this.category_index = 2;
        } else if (id == R.id.id_razvit) {
            startActivity(new Intent(this, RasvitActivity.class));
        } else if (id == R.id.id_analiz) {
            Toast.makeText(this, "Nav analiz pressed", Toast.LENGTH_LONG).show();
        }
        this.drawer.closeDrawer((int) GravityCompat.START);
        return true;
    }
}
