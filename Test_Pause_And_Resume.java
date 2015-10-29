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
public class Test_Pause_And_Resume extends ActivityInstrumentationTestCase2 {
	
	private Solo solo;
	
	public Test_Pause_And_Resume(){
		super(MainActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		//super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	

	
	public void testPauseAndResume() throws Exception{
		
		
		
		
		solo.waitForActivity(MainActivity.class);
		solo.sleep(10000);
		solo.clickOnText("TV Shows");
		solo.waitForView(com.mobitv.client.sprinttvng.R.id.main_movie_list);
		solo.sleep(5000);
		solo.clickOnView(MainActivity.getInstance().findViewById(com.mobitv.client.sprinttvng.R.id.title));
		solo.sleep(5000);
		solo.scrollDown();
		solo.clickOnView(MainActivity.getInstance().findViewById(com.mobitv.client.sprinttvng.R.id.guide_strip_content_layout));
		solo.sleep(5000);
		if (MainActivity.getInstance().getVideoPlayer().isPlaying() == true){
			solo.setActivityOrientation(solo.LANDSCAPE);
			assertTrue(MainActivity.getInstance().getVideoPlayer().isPlaying() == true);
			assertTrue(MainActivity.getInstance().getRequestedOrientation() == solo.LANDSCAPE);
			solo.clickOnView(MainActivity.getInstance().getMovieBox().findViewById(com.mobitv.client.sprinttvng.R.id.button_video_overlay_play_landscape));
			solo.sleep(5000);
			assertTrue(MainActivity.getInstance().getVideoPlayer().isPlaying() == false);
			solo.clickOnView(MainActivity.getInstance().getMovieBox().findViewById(com.mobitv.client.sprinttvng.R.id.button_video_overlay_play_landscape));
			solo.sleep(5000);
			assertTrue(MainActivity.getInstance().getVideoPlayer().isPlaying() == true);			
		}
		else{
			solo.waitForText("We're sorry");
			solo.clickOnText("OK");
			solo.scrollUp();
			solo.clickOnText("TV Shows");
			solo.waitForView(com.mobitv.client.sprinttvng.R.id.main_movie_list);
			solo.sleep(5000);
			solo.scrollDown();
			solo.clickOnView(MainActivity.getInstance().findViewById(com.mobitv.client.sprinttvng.R.id.title));
			solo.sleep(5000);
			solo.scrollDown();
			solo.clickOnView(MainActivity.getInstance().findViewById(com.mobitv.client.sprinttvng.R.id.guide_strip_content_layout));
			solo.sleep(5000);
			solo.setActivityOrientation(solo.LANDSCAPE);
			assertTrue(MainActivity.getInstance().getVideoPlayer().isPlaying() == true);
			assertTrue(MainActivity.getInstance().getRequestedOrientation() == solo.LANDSCAPE);
			solo.clickOnView(MainActivity.getInstance().getMovieBox().findViewById(com.mobitv.client.sprinttvng.R.id.button_video_overlay_play_landscape));
			solo.sleep(5000);
			assertTrue(MainActivity.getInstance().getVideoPlayer().isPlaying() == false);
			solo.clickOnView(MainActivity.getInstance().getMovieBox().findViewById(com.mobitv.client.sprinttvng.R.id.button_video_overlay_play_landscape));
			solo.sleep(5000);
			assertTrue(MainActivity.getInstance().getVideoPlayer().isPlaying() == true);	
			
		}
		solo.sleep(5000);
		
		
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
