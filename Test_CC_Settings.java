/* This test case test functionality of closed captions option in settings.  Verifies user 
 * can turn on closed captions and verifies the text change in option of settings screen
 * 
 * Author: Enrique T. Mosqueda
 * Date: 02/04/2014
 * Target Application: Sprint 6.0                                                             */


package com.mobitv.client.sprinttvng.test;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import com.mobitv.client.sprinttvng.MainActivity;
import com.mobitv.client.sprinttvng.ui.views.ElementTopNavigation;
import com.mobitv.client.sprinttvng.ui.views.GuideBarNavigationNew;
import com.mobitv.client.sprinttvng.utils.HandleNavigationBar;
import com.mobitv.common.constants.MenuElements;
import com.mobitv.common.locals.bo.BoTopMenuElementExt;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.view.View;

import com.robotium.solo.Solo;


@SuppressWarnings("unused")
public class Test_CC_Settings extends ActivityInstrumentationTestCase2 {
	
	private Solo solo;
	
	
	
	public Test_CC_Settings(){
		super(MainActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		//super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
		}
	
	public void testClosedCaptioning() throws Exception{
		
		//Wait for application to start in Main
		solo.waitForActivity(MainActivity.class);
		System.out.println("Main Activity started");
		
		//Wait for app to load and line up to be ready
		solo.sleep(5000);
		
		//Navigate to Settings screen
		solo.clickOnText("My Shows");
		solo.clickOnText("Settings");
		
					
		//Scroll down the screen
		solo.scrollDown();
				
		//Start an IF statement to check state of Closed Captioning
		if(solo.searchText("Turn on closed captioning")){
			//Selects the closed captioning option
			solo.clickOnText("Turn on closed captioning");
			//Verifies the pop up text
			solo.searchText("Closed Cap (subtitles) are turned on.");
			//clicks on OK button of pop up
			solo.clickOnButton(0);
						
		}else{
				
		//Gets closed captioning ready for test
		solo.clickOnText("Turn off closed captioning");
		//Selects the closed captioning option
		solo.clickOnText("Turn on closed captioning");
		//Verifies the pop up text
		solo.searchText("Closed Cap (subtitles) are turned on.");
		//clicks on OK button of pop up
		solo.clickOnButton(0);
		}
		
		//Verifies correct option is available in settings after CC has been turned on
		assertTrue(solo.searchText("Turn off closed captioning"));
		solo.sleep(5000);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
