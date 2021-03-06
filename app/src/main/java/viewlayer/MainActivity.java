package viewlayer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.asus.eventbritelist.R;

import java.util.List;

import data.entities.Event;
import presenterlayer.EventsPresenter;
import presenterlayer.IPresenterLayer;

public class MainActivity extends AppCompatActivity implements IViewLayer<List<Event>> {
    private IPresenterLayer eventsPresenter;
    private RecyclerView eventsRecyclerView;
    private EventAdapter eventsAdapter;
    private ProgressBar progressBar;

    @Override
    public void updateView(List<Event> events) {
        eventsAdapter.setEvents(events);
        eventsAdapter.notifyDataSetChanged();
        eventsRecyclerView.setAdapter(eventsAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        eventsPresenter = new EventsPresenter(this);
        eventsPresenter.loadEvents();
    }

    @Override
    protected void onPause() {
        super.onPause();
        eventsPresenter = null;
    }

    private void init(Context context) {
        Drawable divider = getResources().getDrawable(R.drawable.item_divider);
        progressBar = findViewById(R.id.list_progressbar);
        eventsAdapter = new EventAdapter(context);
        eventsRecyclerView = findViewById(R.id.recycler_view);
        eventsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        eventsRecyclerView.addItemDecoration(new HorizontalDividerItemDecoration(divider));
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }
}