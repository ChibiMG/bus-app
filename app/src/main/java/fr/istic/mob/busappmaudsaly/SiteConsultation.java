package fr.istic.mob.busappmaudsaly;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Maud Garcon & Saly Knab
 *
 * Service qui consulte le site : https://data.explore.star.fr/explore/dataset/tco-busmetro-horaires-gtfs-versions-td/export/
 * On recupere : https://data.explore.star.fr/api/records/1.0/search/?dataset=tco-busmetro-horaires-gtfs-versions-td
 *
 * Qui regarde si on nouveau fichier CSV est disponible
 *
 * TODO : rechercher comment trouver le nouveau fihcier csv dispo sur le site
 * TODO : faire une notification comme quoi nouveau csv
 * TODO : cliqué et ouvre l'activity TelechargementActivity
 * TODO : enregister la verion (pas dans le service)
 * TODO : service qui regarde de temps en temps si nouvelle version (dans ce cas si tel echou ou aura toujours pas la bonne version donc une nouvelle notif plus tard)
 * TODO : test : lors de l'installation on télécharge automatiquement le 1 fichier JSON (mais pas zip qui est dedans)
 * TODO : le service se lance au démarrage du téléphone
 */

public class SiteConsultation extends Service {

    private URL url;
    private String contenu;
    private BufferedReader br;

    public SiteConsultation() {

        try {
            url = new URL("https://data.explore.star.fr/api/records/1.0/search/?dataset=tco-busmetro-horaires-gtfs-versions-td");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        try {
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            contenu = br.readLine();
            System.out.println(contenu);
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
