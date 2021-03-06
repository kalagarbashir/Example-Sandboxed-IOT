/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * Use of this source code is subject to license terms.
 */
package com.microej.example.iot.mqtt;

import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import ej.bon.Timer;
import ej.bon.TimerTask;
import ej.components.dependencyinjection.ServiceLoaderFactory;

/**
 *
 */
public abstract class NetworkCallbackImpl extends NetworkCallback {

	private static final int DELAY = 500;
	private static TimerTask registerTask;

	/**
	 *
	 */
	public NetworkCallbackImpl() {
		super();
		registerConnectivityManager();
	}

	private void registerConnectivityManager() {
		registerTask = null;

		ConnectivityManager connectivityManager = ServiceLoaderFactory.getServiceLoader()
				.getService(ConnectivityManager.class);
		if (connectivityManager != null) {
			NetworkRequest request = new NetworkRequest.Builder().build();
			connectivityManager.registerNetworkCallback(request, this);
			NetworkInfo info = connectivityManager.getActiveNetworkInfo();
			if (info.isConnected()) {
				onAvailable();
			} else {
				onLost();
			}
		} else {
			Timer timer = ServiceLoaderFactory.getServiceLoader().getService(Timer.class);
			registerTask = new TimerTask() {
				@Override
				public void run() {
					registerConnectivityManager();
				}
			};

			timer.schedule(registerTask, DELAY);
		}
	}

	@Override
	public void onAvailable(Network network) {
		super.onAvailable(network);
		onAvailable();
	}

	@Override
	public void onLost(Network network) {
		super.onLost(network);
		onLost();
	}

	public abstract void onAvailable();

	public abstract void onLost();

	protected void unregisterConnectivityManager() {
		if (registerTask != null) {
			registerTask.cancel();
		}

		ConnectivityManager connectivityManager = ServiceLoaderFactory.getServiceLoader()
				.getService(ConnectivityManager.class);
		if (connectivityManager != null) {
			connectivityManager.unregisterNetworkCallback(this);
		}
	}
}
