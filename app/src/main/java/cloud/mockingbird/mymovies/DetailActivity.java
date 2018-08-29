package cloud.mockingbird.mymovies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

  private TextView movieTitle;
  private TextView movieReleaseDate;
  private TextView movieRating;
  private TextView movieDescription;
  private TextView movieImagePath;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);

    titleView = (TextView) findViewById(R.id.tv_movie_title);


  }

}
