package ro.pub.cs.systems.pdsd.phonedialer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class PhoneDialerActivity extends Activity {

	public static int[] BtnNumberIds = {
		R.id.Button0,
		R.id.Button01,
		R.id.Button02,
		R.id.Button03,
		R.id.Button04,
		R.id.Button05,
		R.id.Button06,
		R.id.Button07,
		R.id.Button08,
		R.id.Button09, 
		R.id.Buttonsharp,
		R.id.Buttonstar
		
	};
	
		
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);
        
        final EditText txt = (EditText)findViewById(R.id.editText1);
        
        for(int i = 0; i < BtnNumberIds.length; i++ ){
        	final Button btn = (Button)findViewById(BtnNumberIds[i]);	
        	btn.setOnClickListener(new OnClickListener() {
        		@Override
        		public void onClick(View vw) {            	
        			txt.setText(txt.getText().toString() + btn.getText().toString());
        		}
        	});
        }
        
        final ImageButton btnBack = (ImageButton)findViewById(R.id.ButtonBackspace);	
        btnBack.setOnClickListener(new OnClickListener() {
        		@Override
        		public void onClick(View vw) {        
        			String s = txt.getText().toString();
        			if(s.length() > 0)	
        			txt.setText(s.substring(0, s.length() - 1));
        		}
        	});

    	final ImageButton btncall = (ImageButton)findViewById(R.id.ButtonCall);	
    	btncall.setOnClickListener(new OnClickListener() {
    		@Override
    		public void onClick(View vw) {
    			Intent intent = new Intent(Intent.ACTION_CALL);
    	        intent.setData(Uri.parse("tel:" + txt.getText().toString()));
    	        startActivity(intent);    		}
    	});

        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.phone_dialer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
        
}
