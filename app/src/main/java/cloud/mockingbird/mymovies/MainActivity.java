package cloud.mockingbird.mymovies;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;
import cloud.mockingbird.mymovies.MoviePosterAdapter.MoviePosterAdapterOnClickHandler;

public class MainActivity extends AppCompatActivity implements MoviePosterAdapterOnClickHandler,
    LoaderCallbacks<String[]>, SharedPreferences.OnSharedPreferenceChangeListener {

  private static final String TAG = MainActivity.class.getSimpleName();

  private MoviePosterAdapter moviePosterAdapter;

  private RecyclerView recyclerView;
  private TextView errorMessageDisplay;
  private ProgressBar loadingIndicator;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //Tie recyclerView, errorText, and progressBar to the xml entity.
    recyclerView = (RecyclerView) findViewById(R.id.rv_movie_posters);
    errorMessageDisplay = (TextView) findViewById(R.id.tv_error_message_display);
    loadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);

    //Setting for layoutManager params.
    int recyclerViewOrientation = GridLayoutManager.VERTICAL;
    boolean shouldReversLayout = false;

    //Declare and initialize layoutManager.
    GridLayoutManager layoutManager = new GridLayoutManager(this, 2, recyclerViewOrientation,
        shouldReversLayout);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setHasFixedSize(true);

    //Tie the adapter to the views
    moviePosterAdapter = new MoviePosterAdapter(this);
    recyclerView.setAdapter(moviePosterAdapter);


  }

  @NonNull
  @Override
  public Loader<String[]> onCreateLoader(int id, @Nullable Bundle args) {

    return new AsyncTaskLoader<String[]>(this) {

      String[] moviePosterData = null;

      @Override
      protected void onStartLoading() {
        super.onStartLoading();
      }

      @Nullable
      @Override
      public String[] loadInBackground() {
        return new String[0];
      }

      @Override
      public void deliverResult(@Nullable String[] data) {
        super.deliverResult(data);
      }
    };
  }

  @Override
  public void onLoadFinished(@NonNull Loader<String[]> loader, String[] data) {

  }

  @Override
  public void onLoaderReset(@NonNull Loader<String[]> loader) {

  }

  @Override
  protected void onStart() {
    super.onStart();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    int id = item.getItemId();

    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

  }

  @Override
  public void onClick(String moviePosterSelected) {
    Context context = this;
    Class destinationClass = DetailActivity.class;
    Intent intentToStartDetailActivity = new Intent(context, destinationClass);
    intentToStartDetailActivity.putExtra(Intent.EXTRA_TEXT, moviePosterSelected);
    startActivity(intentToStartDetailActivity);
  }

}
