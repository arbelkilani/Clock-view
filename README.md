# Clock View
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/vlad1m1r990/Lemniscate/blob/master/LICENSE)
[![minSdkVersion](https://img.shields.io/badge/minSdkVersion-21-orange.svg)]()
[![targetSdkVersion](https://img.shields.io/badge/targetSdkVersion-28-yellowgreen.svg)]()

Full options Clock view

## Setup

Add to your module's build.gradle:

```xml
allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
```
and to your app build.gradle:

```xml
dependencies {
  implementation 'com.github.arbelkilani:Clock-view:1.0'
}
```

## Usage
3 ways enable you to customise your own clock view design. 

* Using only XML, attributes : 

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
	    ...
	    app:clock_value_disposition="alternate"
	    app:show_hours_values="true"
	    app:show_seconds_needle="true" />
```

* Using simple setters : 

```java
Clock clock4 = findViewById(R.id.clock_4);

clock4.setShowBorder(true);
clock4.setBorderColor(R.color.gray);
clock4.setShowHoursProgress(true);
clock4.setHoursProgressColor(R.color.black);
clock4.setShowHoursValues(true);
clock4.setClockValueStep(ClockValueStep.quarter);
clock4.setShowCenter(true);
clock4.setCenterOuterColor(R.color.black);
clock4.setCenterInnerColor(R.color.gray);
...

```

* Using ClockTheme builder : 

```java
ClockTheme clockTheme = new ClockTheme.ClockThemeBuilder()
        .showBorder(true, R.color.gray)
        .showHoursProgress(true, R.color.black)
        .showMinutesProgress(true, R.color.black, 0.35f)
        .showMinutesValues(true, 0.37f)
        ...
        .showHoursValues(true, ClockValueStep.quarter)
        .build();
        
clock5.setTheme(clockTheme);
```

## Properties

Property 	   | type          | definition    | 
------------ | ------------- | ------------- | 
clockBackground | Reference | set a custom drawable background for the clock.<br/>Example : clock.setClockBackground(R.drawable.background_7);
showCenter  | boolean | show clock center or not<br/> - default value : false |
centerInnerColor | Color | clock center innner color <br/> example = setCenterInnerColor(R.color.black);
centerOuterColor | Color | clock center border color <br/> example = setCenterOuterColor(R.color.black);
showBorder | boolean | enable or disable showing border for analogical type.
borderColor | Color | set color for the clock border once showBorder set to true.
showHoursProgress | boolean | enable showing hours circular progress.
hoursProgressColor | Color | set color for the circular progress that show hours value.
showMinutesProgress | boolean | enable showing minutes circular progress.
minutesProgressColor | Color | set color for the circular progress that show minutes value.
minutesProgressFactor | float | set factor for the miutes progress position, should be between <b>0.2f</b> and <b>0.5f</b>
showSecondsProgress | boolean | enable showing seconds circular progress.
secondsProgressColor | Color | set color for the circular progress that show seconds value.
secondsProgressFactor | float | set factor for the seconds progress position, should be between <b>0.2f</b> and <b>0.9f</b> <br/> - defaul value : 0.7f
showSecondsNeedle | boolean | enable showing needle for the seconds value.<br/> - default value : false
secondsNeedleColor | Color | set color for the seconds needle once showSecondsNeedle is set to true.
hoursNeedleColor | Color | set color for the hours needle.
minutesNeedleColor | Color | set color for the minutes needle.
showDegrees | boolean | enable showing or hiding degrees.
degreesColor | Color | set degrees color.
clockDegreeType | ClockDegreeType | degrees could be on line, circle or square shapes.
clockDegreeStep | ClockDegreeStep | degrees could be set in 3 types : <b>quarter</b>, <b>full</b> or <b>twelve</b>.
showHoursValues | boolean | show clock hours values
hoursValuesColor | Color | set color for hours values. 
hoursValuesFont | Reference | set font for hours values.<br/> Example : clock.setHoursValuesTypeFace(R.font.hunters); 
clockValueType | ClockValueType | set values type, it could be <b>none</b>, <b>roman</b>, or <b>arabic</b>
clockValueDisposition | ClockValueDisposition | change methods of hours values disposition, it could be either <b>regular</b> or <b>alternate</b>
clockValueDisposition | ClockValueDisposition | change methods of hours values disposition, it could be either <b>regular</b> or <b>alternate</b>
clockValueStep | ClockValueStep | user could enable showing all hours values or just four of them. Values could be <b>quarter</b> or <b>full</b>
showMinutesValues | boolean | enable or not showning minutes values. 
minutesValuesFactor | float | set factor for minutes values disposition. Should be between <b>0.2f</b> and <b>0.9f</b> 

## Credit

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
