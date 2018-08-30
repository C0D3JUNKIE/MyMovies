package cloud.mockingbird.mymovies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MoviePosterAdapter extends RecyclerView.Adapter<MoviePosterAdapter.MoviePosterAdapterViewHolder>{

  private String[] moviePosterData;

  final private MoviePosterAdapterOnClickHandler clickHandler;

  public interface MoviePosterAdapterOnClickHandler{
    void onClick(String moviePosterSelected);
  }

  public MoviePosterAdapter(MoviePosterAdapterOnClickHandler handler){
    clickHandler = handler;
  }

  public class MoviePosterAdapterViewHolder extends RecyclerView.ViewHolder implements
      OnClickListener{

    public MoviePosterAdapterViewHolder(@NonNull View itemView) {
      super(itemView);
      movieImage = (ImageView) itemView.findViewById(R.id.iv_movie_poster);
      itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
      int adapterPosition = getAdapterPosition();
      String moviePosterSelected = moviePosterData[adapterPosition];
      clickHandler.onClick(moviePosterSelected);
    }

  }

  @NonNull
  @Override
  public MoviePosterAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    Context context = parent.getContext();
    int layoutIdForListItem = R.layout.gv_movie_poster_list;
    LayoutInflater inflater = LayoutInflater.from(context);
    boolean attachToParentImmediately = false;

    View view = inflater.inflate(layoutIdForListItem, parent, attachToParentImmediately);
    return new MoviePosterAdapterViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull MoviePosterAdapterViewHolder holder, int position) {
    String selectedMovie = moviePosterData[position];
    holder.moviePosterImageView.setImage(selectedMovie);
  }

  @Override
  public int getItemCount() {
    if (null == moviePosterData) {
      return 0;
    }
    return moviePosterData.length;
  }

  public void setMoviePosterData(String[] movieData){
    moviePosterData = movieData;
    notifyDataSetChanged();
  }

}
