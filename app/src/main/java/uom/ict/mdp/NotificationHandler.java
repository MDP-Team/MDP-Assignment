package uom.ict.mdp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

/**
 * Handles the push notifications.
 */
public class NotificationHandler extends com.microsoft.windowsazure.notifications.NotificationsHandler {

	public static final int NOTIFICATION_ID = 1;
	private NotificationManager mNotificationManager;
	NotificationCompat.Builder builder;
	Context ctx;

	@Override
	/**
	 * On registration of device with the mobile services notification hub (azure)
	 */
	public void onRegistered(Context context,  final String gcmRegistrationId) {
		super.onRegistered(context, gcmRegistrationId);

		new AsyncTask<Void, Void, Void>() {

			protected Void doInBackground(Void... params) {
				try {
					MainActivity.mClient.getPush().register(gcmRegistrationId, null);
					return null;
				}
				catch(Exception e) {
					// handle error
				}
				return null;
			}
		}.execute();
	}


	@Override
	/**
	 * On recieve on notification
	 */
	public void onReceive(Context context, Bundle bundle) {
		ctx = context;
		String nhMessage = bundle.getString("message");

		sendNotification(nhMessage);
	}

	/**
	 * Issues a notification to the Android system with the given message.
	 *
	 * @param msg The message of the notification
	 */
	private void sendNotification(String msg) {
		mNotificationManager = (NotificationManager)
				ctx.getSystemService(Context.NOTIFICATION_SERVICE);

		PendingIntent contentIntent = PendingIntent.getActivity(ctx, 0,
				new Intent(ctx, MainActivity.class), 0);

		NotificationCompat.Builder mBuilder =
				new NotificationCompat.Builder(ctx)
						.setSmallIcon(R.drawable.ic_launcher)
						.setContentTitle("Notification Hub Demo")
						.setStyle(new NotificationCompat.BigTextStyle()
								.bigText(msg))
						.setContentText(msg);

		mBuilder.setContentIntent(contentIntent);
		mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
	}

}
