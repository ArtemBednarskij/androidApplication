//package com.example.inreal;
//
//import androidx.appcompat.app.ActionBar;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.ShareActionProvider;
//import androidx.appcompat.widget.Toolbar;
//import androidx.core.view.MenuItemCompat;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//import com.example.inreal.R;
//
//public class DrinkCategoryActivity extends AppCompatActivity {
//
//    private ShareActionProvider shareActionProvider;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_drink_category);
//
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
//
//        ArrayAdapter<Drink> arrayAdapter = new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_list_item_1,
//                Drink.drinks);
//
//        ListView listOfDrinks = (ListView) findViewById(R.id.list_of_drinks);
//        listOfDrinks.setAdapter(arrayAdapter);
//
//        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(DrinkCategoryActivity.this, DrinkActivity.class);
//                intent.putExtra(DrinkActivity.EXTRA_DRINKID, (int) id);
//                startActivity(intent);
//            }
//        };
//
//        listOfDrinks.setOnItemClickListener(itemClickListener);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Заполнение меню; элементы действий добавляются на панель приложения
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        MenuItem menuItem = menu.findItem(R.id.action_share);
//        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
//        setShareActionIntent("Want to join me for lunch?");
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    private void setShareActionIntent(String text) {
//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.setType("text/plain");
//        intent.putExtra(Intent.EXTRA_TEXT, text);
//        shareActionProvider.setShareIntent(intent);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_create_order:
//                Intent intent = new Intent(this, OrderActivity.class);
//                startActivity(intent);
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//}