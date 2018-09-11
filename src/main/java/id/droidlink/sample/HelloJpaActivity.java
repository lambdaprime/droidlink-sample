package id.droidlink.sample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import id.droidlink.sample.entities.Author;
import id.droidlink.sample.entities.Card;
import id.droidlink.DroidLinkPersistenceProvider;
import id.droidlink.sample.R;

public class HelloJpaActivity extends Activity {

    private static final String TAG = HelloJpaActivity.class.getSimpleName();
    private EntityManager entityManager;
    private TextView area;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);

        initEntityManager();

        area = (TextView) findViewById(R.id.textArea);
        area.setMovementMethod(new ScrollingMovementMethod());
        
        final Button persist = (Button)findViewById(R.id.persist);
        persist.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Card c = new Card();
                c.setQuestion("Does JPA work?");
                c.setAnswer("YES");
                Author a = new Author();
                a.setCity("City");
                a.setStreet1("strasse 2");
                a.setCards(Arrays.asList(c));
                c.setAuthor(a);

                entityManager.getTransaction().begin();
                entityManager.persist(c);
                entityManager.getTransaction().commit();

                displayDb();
            }
        });
        
        displayDb();
    }

    private void initEntityManager() {
        String jdbcUrl = "jdbc:sqlite:" + "/data/data/" + getPackageName() + "/my-database.db";
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.jdbc.url", jdbcUrl);
        EntityManagerFactory emf = new DroidLinkPersistenceProvider().createEntityManagerFactory(this, "cards", properties);
        entityManager = emf.createEntityManager();        
    }

    private void displayDb() {
        area.setText(entityManager.createNamedQuery(Card.FIND_ALL).getResultList().toString());        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}

