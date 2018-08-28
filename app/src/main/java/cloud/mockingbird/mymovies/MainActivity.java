package cloud.mockingbird.mymovies;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = MainActivity.class.getSimpleName();

  private RecyclerView recyclerView;
  private TextView errorMessageDisplay;
  private ProgressBar loadingIndicator;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    recyclerView = (RecyclerView) findViewById(R.id.rv_movie_posters);
    errorMessageDisplay = (TextView) findViewById(R.id.tv_error_message_display);



  }

  @Nullable
  @Override
  public ActionBar getSupportActionBar() {
    return super.getSupportActionBar();
  }

  @Override
  protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
  }

  @Override
  protected void onRestart() {
    super.onRestart();
  }

  @Override
  public boolean onContextItemSelected(MenuItem item) {
    return super.onContextItemSelected(item);
  }
}
