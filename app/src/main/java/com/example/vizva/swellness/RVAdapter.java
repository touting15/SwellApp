package com.example.vizva.swellness;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.SuggestionViewHolder> {

    public static class SuggestionViewHolder extends RecyclerView.ViewHolder {
       // RelativeLayout layout;
        CardView cv;
        ImageView vimage;
        ImageView vstar;
        TextView vTitle;
        TextView vSubtitle;
        TextView vXp;

        public SuggestionViewHolder(View v) {
            super(v);
           // layout = v.findViewById()
            cv = (CardView)v.findViewById(R.id.card_view);
            vimage =  (ImageView) v.findViewById(R.id.imageView);
            vstar = (ImageView)  v.findViewById(R.id.star);
            vTitle = (TextView)  v.findViewById(R.id.textView);
            vSubtitle = (TextView) v.findViewById(R.id.textView2);
            vXp = (TextView) v.findViewById(R.id.xp);
        }
    }

    List<Suggestion> suggestions;
    Context context;

    public RVAdapter(Context context, List<Suggestion> suggestions) {
        this.context = context;
        this.suggestions = suggestions;
    }

    @Override
    public int getItemCount() {
        return suggestions.size();
    }

    @Override
    public void onBindViewHolder(SuggestionViewHolder suggestionViewHolder, final int i) {

        suggestionViewHolder.vimage.setImageResource(suggestions.get(i).photoId);
        suggestionViewHolder.vstar.setImageResource(R.drawable.ic_star);
        suggestionViewHolder.vTitle.setText(suggestions.get(i).title);
        suggestionViewHolder.vSubtitle.setText(suggestions.get(i).subtitle);
        suggestionViewHolder.vXp.setText(suggestions.get(i).xp);

        suggestionViewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(suggestions.get(i).title.equals("Here's a Chill playlist")){
                    Intent intent = new Intent(context, PlaylistActivity.class);

                    context.startActivity(intent);
                }
                else{
                    Intent intent = new Intent(context, SuggestionActivity.class);
                    //The activity_suggestions page has a textview and image view
                    intent.putExtra("image",suggestions.get(i).photoId);
                    intent.putExtra("title", suggestions.get(i).title);

                    context.startActivity(intent);
                }

            }
        });
    }

    @Override
    public SuggestionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.cardview, viewGroup, false);

        return new SuggestionViewHolder(itemView);
    }

  //  @Override
  //  public void onAttachedToRecyclerView(RecyclerView recyclerView) {
  //      super.onAttachedToRecyclerView(recyclerView);
  //  }

}