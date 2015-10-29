package com.mobitv.client.sprinttvng.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import com.mobitv.client.sprinttvng.MainActivity;
import com.mobitv.client.sprinttvng.backend.GuideListFiller;
import com.mobitv.client.sprinttvng.ui.views.ElementTopNavigation;
import com.mobitv.client.sprinttvng.ui.views.GuideBarNavigationNew;
import com.mobitv.client.sprinttvng.ui.views.adapters.GuideStripAdapter;
import com.mobitv.client.sprinttvng.utils.HandleNavigationBar;
import com.mobitv.client.sprinttvng.utils.LocalPopulator;
import com.mobitv.common.backend.DataServerCommunication;
import com.mobitv.common.constants.MenuElements;
import com.mobitv.common.locals.bo.BoTopMenuElementExt;
import com.mobitv.common.utils.FileUtils;
import com.mobitv.common.ui.components.BaseVideoPlayer;

import android.app.Instrumentation;
import android.os.Environment;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import com.robotium.solo.Solo;

import junit.framework.TestCase;


@SuppressWarnings("unused")
public class Test_Select_Channel_From_Guide extends ActivityInstrumentationTestCase2 {
	
	private Solo solo;
	
	public Test_Select_Channel_From_Guide(){
		super(MainActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		//super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	
	
	
	
	public void testSelectChannelFromGuide() throws Exception{
		
		String[] titles =  {"ATAKU", "Azteca America" ,"BabyFirstTV","Canto Yo", "Cartoon Network",
				"Countdown" ,"Country", "Dance/Electronic" ,"FOX Business Live" , "FOX News" , "Hip Hop", 
				"Latin Angels Music", "Latin Hits", "MavTV", "MAXX Sports", "My Kazoo TV", 
				"NBC Sports Mobile Live", "R&B Jamz", "Rock" , "Saturday Morning TV", "Teen Pop",
				"Top Hits", "Totally 80's-90's", "Univision Movil", "Video Rola"
		};
		
		int count = 0;
		solo.waitForActivity(MainActivity.class);
		solo.sleep(10000);
		
		while(MainActivity.getInstance().getVideoPlayer().isPlaying() != true){
			solo.clickOnText(titles[count]);
			solo.sleep(5000);
			if(MainActivity.getInstance().getVideoPlayer().isPlaying() == true){
				break;
			}else{
				count++;
				solo.sleep(10000);
				if(solo.searchText("Video Issue")){
					solo.clickOnText("OK");
					solo.clickOnView(MainActivity.getInstance().findViewById(com.mobitv.client.sprinttvng.R.id.main_button_sprint_tv));
					solo.scrollToTop();
					solo.clickOnText("Live TV");
				}else{
					solo.clickOnView(MainActivity.getInstance().findViewById(com.mobitv.client.sprinttvng.R.id.main_button_sprint_tv));
					solo.sleep(5000);
					solo.scrollToTop();
					solo.clickOnText("Live TV");
				}
			}
		}
		
		solo.sleep(5000);
		solo.setActivityOrientation(solo.LANDSCAPE);
		solo.sleep(5000);
		System.out.println("This is the player state: " + MainActivity.getInstance().getVideoPlayer().isPlaying());
		System.out.println("This is the full screen state: " + MainActivity.getInstance().isMovieBoxExpanded());
		assertTrue(MainActivity.getInstance().getVideoPlayer().isPlaying() == true);
		assertTrue(MainActivity.getInstance().getRequestedOrientation() == solo.LANDSCAPE);
		
		
	}
	
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	

		

}
