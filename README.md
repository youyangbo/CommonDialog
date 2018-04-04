# CommonDialog
万能Dialog
配置：
	
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}


	dependencies {
	        compile 'com.github.youyangbo:CommonDialog:v1.0.0'
	}

使用：

	 CommonDialog commonDialog = new CommonDialog.Builder(MainActivity.this)
                        .setView(R.layout.xxxxxxx)
                        .setHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                        .setWidth(getResources().getDisplayMetrics().widthPixels)
                        .fromBottom()
                        .create();
                commonDialog.show();
