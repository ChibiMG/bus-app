package fr.istic.mob.busappmaudsaly;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.room.Room;
import androidx.work.PeriodicWorkRequest;
import fr.istic.mob.busappmaudsaly.database.AppDatabase;
import fr.istic.mob.busappmaudsaly.database.BusRoute;
import fr.istic.mob.busappmaudsaly.services.SiteConsultation;
import fr.istic.mob.busappmaudsaly.task.SiteConsultationTask;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(SiteConsultationTask.class, 10, TimeUnit.MINUTES).build();
    }
}
