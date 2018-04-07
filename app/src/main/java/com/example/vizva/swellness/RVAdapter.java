package com.example.vizva.swellness;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.SuggestionViewHolder> {

    public static class SuggestionViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        ImageView vimage;
        ImageView vstar;
        TextView vTitle;
        TextView vSubtitle;

        public SuggestionViewHolder(View v) {
            super(v);
            cv = (CardView)v.findViewById(R.id.card_view);
            vimage =  (ImageView) v.findViewById(R.id.imageView);
            vstar = (ImageView)  v.findViewById(R.id.star);
            vTitle = (TextView)  v.findViewById(R.id.textView);
            vSubtitle = (TextView) v.findViewById(R.id.textView2);
        }
    }

    List<Suggestion> suggestions;

    public RVAdapter(List<Suggestion> suggestions) {
        this.suggestions = suggestions;
    }

    @Override
    public int getItemCount() {
        return suggestions.size();
    }

    @Override
    public void onBindViewHolder(SuggestionViewHolder suggestionViewHolder, int i) {

        suggestionViewHolder.vimage.setImageResource(suggestions.get(i).photoId);
        suggestionViewHolder.vstar.setImageResource(R.drawable.ic_lock);
        suggestionViewHolder.vTitle.setText(suggestions.get(i).title);
        suggestionViewHolder.vSubtitle.setText(suggestions.get(i).subtitle);
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