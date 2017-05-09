package it.unicampania.slotmachine;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // Widget
    // Todo: dichiare gli oggetti

    // variabili
    private int numeroCorrente = 0;
    private int numeroLanci = 0;
    private int punteggio = 0;
    private double score = 0.0;

    // Costanti
    private final int CIFRA_BAR = 0;
    private final int PUNTI_1_BAR = 5;
    private final int PUNTI_2_BAR = 10;
    private final int PUNTI_3_BAR = 20;
    private final int PUNTI_1_CIFRA = 10;
    private final int PUNTI_2_CIFRE = 20;
    private final int PUNTI_3_CIFRE = 50;

    private final int RITARDO_CIFRA = 10000; // Todo: da verificare

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
     * Todo: metodo in corrispondenza del pulsante di avvio
     *    leggere la forza
     *    creare un oggetto di tipo ParametroAvvio
     *    creare un oggetto di tipo Rotelle
     *    invocare Rotelle.execute() passando parametro di avvio
     */


    /**
     * Classe contenente i parametri da passare al task
     */
    private class ParametroAvvio {
        public int valoreIniziale;
        public int forza;
    }

    /**
     * Task asincrono per la rotazione delle rotelle
     */
    private class Rotelle extends AsyncTask<ParametroAvvio, Integer, Integer> {

        /**
         * Codice eseguito in background. Effettua la rotazione
         * delle rotelle
         * @param parametri valore iniziale e forza di pressione
         * @return
         */
        public Integer doInBackground(ParametroAvvio... parametri) {
            if (parametri.length == 1) {
                int forza = parametri[0].forza;

                // Parto dal valore iniziale
                int valore = parametri[0].valoreIniziale;

                for (int cifre = 3; cifre >= 1; cifre--) {
                    // Devo var ruotare solo il numero di "cifre"
                    // più a sinistra

                    // Eseguo un loop dipendente dalla forza
                    for (int step = 0; step < forza; step++) {
                        // Faccio girare le cifre di uno step
                    }
                    // Ad ogni passaggio pubblico l'avanzamento
                    publishProgress(valore);
                    SystemClock.sleep(RITARDO_CIFRA / forza);
                }
                // Restituisco il valore finale
                return valore;
            }
            return 0;
        }

        /**
         * Codice eseguito sullo UI thread.
         * Eseguito al termine della rotazione
         * @param valoreFinale
         */
        @Override
        protected void onPostExecute(Integer valoreFinale) {
            // Calcolo il punteggio verificando la puntata
            // Segnalo l'eventuale vittoria
            // Aggiorno i punteggi sullo schermo
            super.onPostExecute(valoreFinale);
        }

        /**
         * Codice eseguito sullo UI thread.
         * Eseguito prima di avviare la rotazione
         */
        @Override
        protected void onPreExecute() {
            // Eventuali inizializzazioni
            super.onPreExecute();
        }

        /**
         * Eseguito sullo UI thread.
         * Aggiorna la visualizzazione delle rotelle
         * @param values
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
    }

}
