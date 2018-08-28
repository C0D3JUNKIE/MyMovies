package cloud.mockingbird.mymovies.utilities;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtility {
  private static final String LOG_TAG = NetworkUtility.class.getSimpleName();
  private static final String BASE_URL = "http://api.themoviedb.org/3/movie";
  private static final String DEFULT_URL = BASE_URL;
  private static final String KEY_PARAM = api_key;

  public static URL buildUrl(Context context, String criteria){

    Uri builtUri = Uri.parse(DEFULT_URL).buildUpon().appendPath(criteria).appendQueryParameter(KEY_PARAM, context.getString(R.string.tmdb_key)).build();
    URL url = null;

    try{
      url = new URL(builtUri.toString());
    }catch(MalformedURLException e){
      e.printStackTrace();
    }

    Log.v(LOG_TAG, "Built URI " + url);

    return url;

  }

  public static String getResponseFromHttpURL(URL url) throws IOException {

    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

    try{
      InputStream in = urlConnection.getInputStream();
      Scanner scanner = new Scanner(in);
      scanner.useDelimiter("\\A");

      if(scanner.hasNext()){
        return scanner.next();
      }else{
        return null;
      }

    }finally{
      urlConnection.disconnect();
    }

  }

}