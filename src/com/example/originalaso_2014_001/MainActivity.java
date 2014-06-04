package com.example.originalaso_2014_001;

import java.util.Random;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }
    
    @Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		// ボタンをIDで探してボタンを作る
		Button btnOK = (Button)findViewById(R.id.btnOK);
		// ボタン変数をリスナーを登録する。
		btnOK.setOnClickListener(this);
	}

	public void onClick(View v) {
    	// TODO 児童生成されたメソッド・スタブ
    	switch(v.getId()) {
    	case R.id.btnOK: //OKボタンが押された
    		//エディットテキスト内容から入力内容を取り出す。
    		EditText etv = (EditText)findViewById(R.id.edtName);
    		String inputMsg = etv.getText().toString();
    		
    		//Randomクラスのインスタンスを作る
    		Random rnd = new Random();
    		// 0～3の4パターンの数字をranに取得
    		int ran = rnd.nextInt(4);
    		
    		// 生成して代入用のInttentインスタンス変数を用意
    		Intent Intent = null;
    		// ranの値によって処理を分ける
    		switch(ran){
    			case 0:
    				// 0なら大吉ページへと飛ばす
    				// インテントのインスタンスを生成
    				Intent = new Intent(MainActivity.this, DaikitiActivity.class);
    				break;
    			case 1:
    				// 1なら吉ページへと飛ばす
    				// インテントのインスタンスを生成
    				Intent = new Intent(MainActivity.this, TyukitiActivity.class);
    				break;
    			case 2:
    				// 2なら凶ページへと飛ばす
    				// インテントのインスタンスを生成
    				Intent = new Intent(MainActivity.this, DaikyoActivity.class);
    				break;
    			case 3:
    				// 3なら大凶ページへと飛ばす
    				// インテントのインスタンスを生成
    				Intent = new Intent(MainActivity.this, KyoActivity.class);
    				break;
    		}
    		Intent.putExtra("name",inputMsg);
    		// 次画面のアクティビティ起動
    		startActivity(Intent);
    	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

    }

}
