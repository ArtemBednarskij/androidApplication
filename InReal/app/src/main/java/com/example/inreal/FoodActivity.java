//package com.example.inreal;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.appcompat.app.ActionBar;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.ShareActionProvider;
//import androidx.appcompat.widget.Toolbar;
//import androidx.core.view.MenuItemCompat;
//
//public class FoodActivity extends AppCompatActivity {
//
//    public static final String EXTRA_FOODID = "drink_id";
//    private int id = 0;
//    private ShareActionProvider shareActionProvider;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_drink_and_food);
//
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
//
//        Intent intent = getIntent();
//        id = intent.getIntExtra(EXTRA_FOODID, 0);
//
//        Food food = Food.foods[id];
//
//        TextView name = (TextView)findViewById(R.id.name);
//        name.setText(food.getName());
//        //Заполнение описания напитка
//        TextView description = (TextView)findViewById(R.id.description);
//        description.setText(food.getDescription());
//        //Заполнение изображения напитка
//        ImageView photo = (ImageView)findViewById(R.id.photo);
//        photo.setImageResource(food.getImageId());
//        photo.setContentDescription(food.getName());
//    }
//
//    public void onClick(View view) {
//        Intent intent = new Intent(FoodActivity.this, ARfoundtaion.class);
//        String category = "Food";
//        intent.putExtra(ARfoundtaion.EXTRA_ID, (int) id);
//        intent.putExtra(ARfoundtaion.EXTRA_CATEGORY, (String) category);
//        startActivity(intent);
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
//
//
//}