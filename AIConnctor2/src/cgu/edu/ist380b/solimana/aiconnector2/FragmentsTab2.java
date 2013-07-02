package cgu.edu.ist380b.solimana.aiconnector2;

import cgu.edu.ist380b.solimana.aiconnector2.FragmentsTab2;
import cgu.edu.ist380b.solimana.aiconnector2.FullImageActivity2;
import cgu.edu.ist380b.solimana.aiconnector2.ImageAdapter2;

import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class FragmentsTab2 extends Fragment implements ActionBar.TabListener {

	private Fragment mFragment;
	
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.grid_layout2,container,false);
	    GridView gridView = (GridView) view.findViewById(R.id.grid_view2);
	    gridView.setAdapter(new ImageAdapter2(view.getContext())); 
		//On Click Do Action: Show Image		 
		gridView.setOnItemClickListener(new OnItemClickListener() {			
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				
				Toast.makeText(v.getContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
				// Sending image id to FullImageActivity
				Intent i = new Intent(v.getContext(), FullImageActivity2.class);
				// passing array index
				i.putExtra("id", position);
				startActivity(i);			
			}
		});
	    return view;
	}
	
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		mFragment = new FragmentsTab2();
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
