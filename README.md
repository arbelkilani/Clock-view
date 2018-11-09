# Clock View
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/vlad1m1r990/Lemniscate/blob/master/LICENSE)
[![minSdkVersion](https://img.shields.io/badge/minSdkVersion-21-orange.svg)]()
[![targetSdkVersion](https://img.shields.io/badge/targetSdkVersion-28-yellowgreen.svg)]()
[![](https://jitpack.io/v/arbelkilani/Clock-view.svg)](https://jitpack.io/#arbelkilani/Clock-view)

![https://github.com/arbelkilani/Clock-view/wiki/clock_cover.png]

Full options Clock view.<br/>You are now able to create and design your own clock view with changing just attributes. <br/> Over 20 attributes are available. 

## Credits
Developed by : [<b>Belkilani Ahmed Radhouane</b>](http://arbelkilani.tn/)
<br/>
Inspired and based on [<b>Souissi Dorsaf</b>](https://www.behance.net/souissidor8b6c) design.

## Setup

### Gradle 
Add it in your root build.gradle at the end of repositories:

```xml
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
Add the dependency

```xml
dependencies {
    implementation 'com.github.arbelkilani:Clock-view:1.0'
}
```
### Maven 

```xml
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>
```

Add the dependency

```xml
<dependency>
    <groupId>com.github.arbelkilani</groupId>
    <artifactId>Clock-view</artifactId>
    <version>1.0</version>
</dependency>
```

## How does this work ?
3 ways enable you to customise your own clock view design. 

* Example 1 : Using only XML, attributes : 

```xml
<com.arbelkilani.clock.Clock
    android:id="@+id/clock_2"
    android:layout_width="0dp"
    android:layout_height="match_parent"
    android:layout_margin="5dp"
    android:layout_weight="1"
    app:clock_value_step="full"
    app:show_center="true"
    app:center_inner_color="@color/white"
    app:clock_value_disposition="alternate"
    app:show_hours_values="true"
    app:show_seconds_needle="true" />
```

* Example 2 : Using simple setters : 

```java
Clock clock = findViewById(R.id.clock);

clock.setShowBorder(true);
clock.setBorderColor(R.color.gray);
clock.setShowHoursProgress(true);
clock.setHoursProgressColor(R.color.black);
clock.setShowHoursValues(true);
clock.setClockValueStep(ClockValueStep.quarter);
clock.setShowCenter(true);
clock.setCenterOuterColor(R.color.black);
clock.setCenterInnerColor(R.color.gray);
...

```

* Example 3 : Using <b>ClockTheme</b> builder : 

```java
Clock clock = findViewById(R.id.clock);

ClockTheme clockTheme = new ClockTheme.ClockThemeBuilder()
        .showBorder(true, R.color.gray)
        .showHoursProgress(true, R.color.black)
        .showMinutesProgress(true, R.color.black, 0.35f)
        .showMinutesValues(true, 0.37f)
        ...
        .showHoursValues(true, ClockValueStep.quarter)
        .build();
        
clock.setTheme(clockTheme);
```

![https://github.com/arbelkilani/Clock-view/wiki/examples.png]

## Enumeration

* <b> ClockDegreeStep </b> : quarter, full, twelve
* <b> ClockDegreeType </b> : line, circle, square
* <b> ClockValueDisposition </b> : regular, alternate
* <b> ClockValueStep </b> : quarter, full
* <b> ClockValueType </b> : none, roman, arabic


## Available attributes

Attribute 	   | Type          | Description    | Default value
------------ | ------------- | ------------- | ------------- | 
clockBackground | Reference | set a custom drawable background for the clock.<br/>Example : clock.setClockBackground(R.drawable.background_7); | null
showCenter  | boolean | show clock center or not<br/> | false 
centerInnerColor | Color | clock center innner color <br/> example = setCenterInnerColor(R.color.black); | Color.LTGRAY
centerOuterColor | Color | clock center border color <br/> example = setCenterOuterColor(R.color.black); | Color.BLACK
showBorder | boolean | enable or disable showing border for analogical type. | false
borderColor | Color | set color for the clock border once showBorder set to true. | Color.BLACK
showHoursProgress | boolean | enable showing hours circular progress | false
hoursProgressColor | Color | set color for the circular progress that show hours value. | Color.BLACK
showMinutesProgress | boolean | enable showing minutes circular progress. | false
minutesProgressColor | Color | set color for the circular progress that show minutes value. | Color.BLACK
minutesProgressFactor | float | set factor for the miutes progress position, should be between <b>0.2f</b> and <b>0.5f</b> | 0.4f
showSecondsProgress | boolean | enable showing seconds circular progress. | false
secondsProgressColor | Color | set color for the circular progress that show seconds value. | Color.BLACK
secondsProgressFactor | float | set factor for the seconds progress position, should be between <b>0.2f</b> and <b>0.9f</b> | 0.7f
showSecondsNeedle | boolean | enable showing needle for the seconds value.<br/> | false
secondsNeedleColor | Color | set color for the seconds needle once showSecondsNeedle is set to true. | Color.BLACK
hoursNeedleColor | Color | set color for the hours needle. | Color.BLACK
minutesNeedleColor | Color | set color for the minutes needle. | Color.BLACK
showDegrees | boolean | enable showing or hiding degrees. | false
degreesColor | Color | set degrees color. | Color.BLACK
clockDegreeType | ClockDegreeType | degrees could be on line, circle or square shapes. | ClockDegreeType.line
clockDegreeStep | ClockDegreeStep | degrees could be set in 3 types : <b>quarter</b>, <b>full</b> or <b>twelve</b>. | ClockDegreeStep.full
showHoursValues | boolean | show clock hours values | false
hoursValuesColor | Color | set color for hours values. | Color.BLACK
hoursValuesFont | Reference | set font for hours values.<br/> Example : clock.setHoursValuesTypeFace(R.font.hunters); | R.font.proxima_nova_thin
clockValueType | ClockValueType | set values type, it could be <b>none</b>, <b>roman</b>, or <b>arabic</b> | ClockValueType.none
clockValueDisposition | ClockValueDisposition | change methods of hours values disposition, it could be either <b>regular</b> or <b>alternate</b>. | ClockValueDisposition.regular
clockValueStep | ClockValueStep | user could enable showing all hours values or just four of them. Values could be <b>quarter</b> or <b>full</b>. | ClockValueStep.full
showMinutesValues | boolean | enable or not showning minutes values. | false
minutesValuesFactor | float | set factor for minutes values disposition. Should be between <b>0.2f</b> and <b>0.9f</b> | 0.4f

## License

    Copyright 2018 Belkilani Ahmed Radhouane

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
