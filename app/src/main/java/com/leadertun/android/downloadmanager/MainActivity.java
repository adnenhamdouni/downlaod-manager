package com.leadertun.android.downloadmanager;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.leadertun.android.downloadmanager.core.DownloadManagerPro;
import com.leadertun.android.downloadmanager.report.listener.DownloadManagerListener;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements DownloadManagerListener {

    private DownloadManagerPro mDownloadManagerPro;
    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDownloadManagerPro = new DownloadManagerPro(this.getApplicationContext());
        mDownloadManagerPro.init("downloadManager/", 12, this);
        int taskToekn = mDownloadManagerPro.addTask("save_name", "http://www.site.com/video/ss.mp4", false, false);
        try {
            mDownloadManagerPro.startDownload(taskToekn);

        } catch (IOException e) {
            e.printStackTrace();
        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void OnDownloadStarted(long taskId) {
        Log.e(TAG, "Manager Pro => OnDownloadStarted");

    }

    @Override
    public void OnDownloadPaused(long taskId) {
        Log.e(TAG, "Manager Pro => OnDownloadPaused");

    }

    @Override
    public void onDownloadProcess(long taskId, double percent, long downloadedLength) {
        Log.e(TAG, "Manager Pro => onDownloadProcess");

    }

    @Override
    public void OnDownloadFinished(long taskId) {
        Log.e(TAG, "Manager Pro => OnDownloadFinished");

    }

    @Override
    public void OnDownloadRebuildStart(long taskId) {
        Log.e(TAG, "Manager Pro => OnDownloadRebuildStart");

    }

    @Override
    public void OnDownloadRebuildFinished(long taskId) {
        Log.e(TAG, "Manager Pro => OnDownloadRebuildFinished");

    }

    @Override
    public void OnDownloadCompleted(long taskId) {
        Log.e(TAG, "Manager Pro => OnDownloadCompleted");

    }

    @Override
    public void connectionLost(long taskId) {
        Log.e(TAG, "Manager Pro => connectionLost");

    }
}
