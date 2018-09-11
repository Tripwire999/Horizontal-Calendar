package devs.mulham.horizontalcalendar.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import devs.mulham.horizontalcalendar.R;
import devs.mulham.horizontalcalendar.model.CalendarEvent;

/**
 * @author Mulham-Raee
 * @since v1.3.2
 */
public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventViewHolder> {

    private List<CalendarEvent> eventList;
    private int maxDotsShown = 0;
    private Context context;

    public EventsAdapter(List<CalendarEvent> eventList) {
        this.eventList = eventList;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        return new EventViewHolder(new ImageView(context));
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        CalendarEvent event = getItem(position);

        ImageView imageView = (ImageView) holder.itemView;

        if (eventList.size() > maxDotsShown && position == (maxDotsShown  - 1)) {
            setPlus(imageView);
        } else {
            setNormal(imageView);
        }

        imageView.setContentDescription(event.getDescription());
        DrawableCompat.setTint(imageView.getDrawable(), event.getColor());
    }

    public CalendarEvent getItem(int position) throws IndexOutOfBoundsException {
        return eventList.get(position);
    }

    @Override
    public int getItemCount() {
        if (maxDotsShown == 0) {
            return eventList.size();
        }

        if (eventList.size() <= maxDotsShown) {
            return eventList.size();
        } else {
            return maxDotsShown;
        }
    }

    public void update(List<CalendarEvent> eventList, int maxDotsShown) {
        this.eventList = eventList;
        this.maxDotsShown = maxDotsShown;
        notifyDataSetChanged();
    }

    private void setPlus(ImageView imageView) {
        Drawable plus = ContextCompat.getDrawable(context, R.drawable.ic_add_circle_white_8dp);
        Drawable drawableWrapper = DrawableCompat.wrap(plus);
        imageView.setImageDrawable(drawableWrapper);
    }

    private void setNormal(ImageView imageView) {
        Drawable circle = ContextCompat.getDrawable(context, R.drawable.ic_circle_white_8dp);
        Drawable drawableWrapper = DrawableCompat.wrap(circle);
        imageView.setImageDrawable(drawableWrapper);
    }

    static class EventViewHolder extends RecyclerView.ViewHolder {
        EventViewHolder(View itemView) {
            super(itemView);
        }
    }
}

