package com.yuoyanbo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;



/**
 * =========================
 * <p>
 * Version：1.0<br/>
 * description: <br/>
 *
 *  底部弹窗基类
 *  <br/>示例代码见 README.md文件
 * <br/>
 * =========================
 */

public class BaseBottomDialog implements View.OnClickListener, DialogInterface.OnDismissListener {

    protected Dialog dialog;
    protected Context mContext;

    protected BaseBottomDialog(Context context) {
        this.mContext = context;
        this.dialog = new Dialog(mContext, R.style.frame_bottom_dialog);
    }

    /**
     * 设置dialog从下方弹出
     */
    protected void setDialogLocation() {
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.frame_bottom_dialog_animstyle);
        WindowManager.LayoutParams lp = window.getAttributes();
        WindowManager manager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        lp.x = 0;
        lp.y = manager.getDefaultDisplay().getHeight();
        // 以下这两句是为了保证按钮可以水平满屏
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        // 设置显示位置
        dialog.onWindowAttributesChanged(lp);
        // 设置点击外围解散
        dialog.setCanceledOnTouchOutside(true);
        dialog.setOnDismissListener(this);
    }

    public void show() {
        if (dialog != null) {
            dialog.show();
        }
    }

    public void dismiss() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override
    public void onClick(View v) {
        dismiss();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {

    }
}
