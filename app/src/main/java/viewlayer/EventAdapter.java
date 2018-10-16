package viewlayer;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.eventbritelist.R;

import java.util.ArrayList;
import java.util.List;

import data.entities.Event;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    private Context context;
    private List<Event> events;

    public EventAdapter(Context context) {
        this.context = context;
    }

    public void setEvents(List<Event> events) {
        this.events = new ArrayList<>();
        this.events = events;
    }

    @NonNull
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.event_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.setData(position);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        Event event;
        private TextView name_textview;
        private TextView description_textview;
        private ImageView logo_image_view;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            initViews(itemView);
        }

        private void initViews(View view) {
            name_textview = view.findViewById(R.id.name_textview);
            description_textview = view.findViewById(R.id.description_textview);
            logo_image_view = view.findViewById(R.id.logo_image_view);
        }

        public void setData(int position) {
            event = events.get(position);
            name_textview.setText(event.getName().getText());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                description_textview.setText(Html.fromHtml(event.getDescription().getHtml(), Html.FROM_HTML_MODE_COMPACT));
            } else {
                description_textview.setText(Html.fromHtml(event.getDescription().getHtml()));
            }

            if (event.getLogo() != null) {
                Glide.with(context)
                        .load(event.getLogo().getOriginal().getUrl())
                        .into(logo_image_view);
            }
        }
    }
}
