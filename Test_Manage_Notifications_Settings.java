/* This test case test functionality of buttons on Manage Notifications dialog as well as verify 
 * text contained in the dialog
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
public class Test_Manage_Notifications_Settings extends ActivityInstrumentationTestCase2 {
	
	private Solo solo;
	
	public Test_Manage_Notifications_Settings(){
		super(MainActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		//super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	public void testSelectingManageNotifications() throws Exception{
		//Wait for application to start in Main
		solo.waitForActivity(MainActivity.class);
		System.out.println("Main Activity started");
				
		//Wait for app to load and line up to be ready
		solo.sleep(5000);
		
		//Navigate to Settings screen
		solo.clickOnText("My Shows");
		solo.clickOnText("Settings");
		System.out.println("We have navigated to settings");
		
		//Click on Manage Notifications
		solo.clickOnText("Manage notifications");
		
		//These will verify the text on the dialog box
		assertTrue(solo.searchText("Notification"));
		assertTrue(solo.searchText("Want notifications when we add new videos to your favorite shows?"));
		assertTrue(solo.searchText("New Shows"));
		assertTrue(solo.searchText("Special Events"));
		assertTrue(solo.searchText("Show this message each time"));
		
	
		
		//These ensure each button can be clicked
		solo.clickOnButton(0);
		solo.clickOnButton(0);
		solo.clickOnButton(1);
		solo.clickOnButton(1);
		solo.clickOnButton(2);
		solo.clickOnButton(2);
		
		//This will dismiss the dialog
		solo.clickOnButton(3);
		
		solo.sleep(5000);
		
	}


	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
