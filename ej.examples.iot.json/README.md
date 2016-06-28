<!--
	Markdown
	
	Copyright 2016 IS2T. All rights reserved.
	Modification and distribution is permitted under certain conditions.
	IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
-->
# Overview
A MicroEJ sandboxed application that uses the org.json.me parser provided by json.org to parse and browse a [JSON file](/ej.examples.iot.json/src/main/resources/json/menu.json). 

The contents of the JSON file is taken from an example available from http://www.json.org/example.html

The example then iterates over all the **menuitem** elements available in the **popup** menu and print their contents.

# Usage
## Run on MicroEJ Simulator
1. Right Click on the project
1. Select **Run as -> MicroEJ Application**
1. Select **BackgroundServicesStandalone**
1. Select your platform 
1. Press **Ok**

## Run on device
### Local deploy
1. Right Click on [JsonExampleEntryPoint.java](/ej.examples.iot.json/src/.generated~/.java/__JsonExample__/generated/JsonExampleEntryPoint.java)
1. Select **Run as -> Run Configurations...** 
1. Select **MicroEJ Application** configuration kind
1. Click on **New launch configuration** icon
1. In **Execution** tab
	1. In **Target** frame, in **Platform** field, select a relevant platform
	1. In **Execution** frame
		1. Select **Execute on Device**
		2. In **Settings** field, select **Build & Deploy**
1. In **Configuration** tab
	1. In **Board** frame
		1. Set **Host** field to your board IP address
1. Press **Apply**
1. Press **Run**

# Requirements
* MicroEJ Studio or SDK 4.0 or later
* A platform with at least:
	* EDC-1.2 or higher
	* BON-1.2 or higher
	* KF-1.4 or higher

## Dependencies
_All dependencies are retrieved transitively by Ivy resolver_.