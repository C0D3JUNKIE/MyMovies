package cloud.mockingbird.mymovies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

  private ImageView movieImage;

  private TextView movieTitle;
  private TextView movieReleaseDate;
  private TextView movieRating;
  private TextView movieDescription;


  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);

    movieImage = (ImageView) findViewById(R.id.iv_movie_poster_image);

    movieTitle = (TextView) findViewById(R.id.tv_movie_title);
    movieReleaseDate = (TextView) findViewById(R.id.tv_movie_release_date);
    movieRating = (TextView) findViewById(R.id.tv_movie_vote_average);
    movieDescription = (TextView) findViewById(R.id.tv_movie_plot);


  }

}
