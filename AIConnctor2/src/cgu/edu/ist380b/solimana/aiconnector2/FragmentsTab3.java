package cgu.edu.ist380b.solimana.aiconnector2;

import cgu.edu.ist380b.solimana.aiconnector2.FragmentsTab3;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import cgu.edu.ist380b.solimana.aiconnector2.FragmentsTab3;


import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

public class FragmentsTab3 extends Fragment implements ActionBar.TabListener {
	
	private Button Write;
	private Button Read;
	private TextView Txt;
	private EditText TxtS;
	String FILENAME = "password.txt";
	public String text;
	private BufferedReader myReader;
	private Fragment mFragment;
	
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.fragment3,container,false);

		Write = (Button) view.findViewById(R.id.btw);
		Write.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				if (!Environment.MEDIA_MOUNTED.equals(Environment
        				.getExternalStorageState())) {
        			Toast.makeText(v.getContext(), "External SD card not mounted",
        					Toast.LENGTH_LONG).show();
        		} else {
    			if (v == Write) {
    				try {
    					PackageManager m = getActivity().getPackageManager();        					
    					String s = getActivity().getPackageName();
    					PackageInfo p = m.getPackageInfo(s, 0);
    					s = p.applicationInfo.dataDir;
    					File myFile = new File(s + "/MyDoople.txt");
    					myFile.createNewFile();
    					FileOutputStream fOut = new FileOutputStream(myFile);
    					OutputStreamWriter myOutWriter = new OutputStreamWriter(
    							fOut);
    					myOutWriter.append(TxtS.getText());
    					myOutWriter.close();
    					fOut.close();
    					Toast.makeText(getActivity(),
    							"Text Updated",
    							Toast.LENGTH_SHORT).show();
    				} catch (Exception e) {
    					Toast.makeText(getActivity(), e.getMessage(),
    							Toast.LENGTH_SHORT).show();
    				}

			}}
			}});
		Read = (Button) view.findViewById(R.id.btr);
		Read.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v) 
            {               
        		if (!Environment.MEDIA_MOUNTED.equals(Environment
        				.getExternalStorageState())) {
        			Toast.makeText(v.getContext(), "External SD card not mounted",
        					Toast.LENGTH_LONG).show();
        		} else {
        			if (v == Read) {
        				try {
        					PackageManager m = getActivity().getPackageManager();
        					String s = getActivity().getPackageName();
        					PackageInfo p = m.getPackageInfo(s, 0);
        					s = p.applicationInfo.dataDir;
        					File myFile = new File(s + "/MyDoople.txt");

        					FileInputStream fIn = new FileInputStream(myFile);
        					myReader = new BufferedReader(
        							new InputStreamReader(fIn));
        					String aDataRow = "";
        					String aBuffer = "";

        					while ((aDataRow = myReader.readLine()) != null) {
        						aBuffer += aDataRow;

        						// byte buffer into a string
        						text = new String(aBuffer);

        						Txt.setText(text);

        					}

        				} catch (Exception e) {
        					Toast.makeText(getActivity(), e.getMessage(),
        							Toast.LENGTH_SHORT).show();
        				}

        			}

        		}
        	}      
        }
        );
	
		TxtS=(EditText) view.findViewById(R.id.txtS);
		
	    return view;
	}
	
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		mFragment = new FragmentsTab3();
		// Attach fragment1.xml layout
		ft.add(android.R.id.content, mFragment);
		ft.attach(mFragment);
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		ft.remove(mFragment);
	}

}
