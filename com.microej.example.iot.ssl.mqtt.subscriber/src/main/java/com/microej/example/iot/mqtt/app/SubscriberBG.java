/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * Use of this source code is subject to license terms.
 */
package com.microej.example.iot.mqtt.app;

import com.microej.example.iot.mqtt.HelloWorldSubscriber;
import ej.wadapps.app.BackgroundService;

/**
 *
 */
public class SubscriberBG implements BackgroundService {

	@Override
	public void onStart() {
		HelloWorldSubscriber.main(new String[0]);

	}

	@Override
	public void onStop() {

	}

}
