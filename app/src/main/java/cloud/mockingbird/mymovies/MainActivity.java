package cloud.mockingbird.mymovies;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
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
