package hp.hamid.silent;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.Toast;

public class silentWidget extends AppWidgetProvider {
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		Toast.makeText(context, "salam", Toast.LENGTH_SHORT).show();
		int N = appWidgetIds.length;
		for (int i=0; i<N; i++) {
            int appWidgetId = appWidgetIds[i];

            // Create an Intent to launch ExampleActivity
            Intent intent = new Intent(context, MainService.class);
            PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent , 0);
            // Get the layout for the App Widget and attach an on-click listener
            // to the button
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.silentwidget);
            views.setOnClickPendingIntent(R.id.imageView1, pendingIntent);

            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
	}
	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		Toast.makeText(context, "bye! :(", Toast.LENGTH_SHORT).show();
		super.onDeleted(context, appWidgetIds);
	}
}
