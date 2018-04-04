package com.yuoyanbo.dialog;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



/**
 *
 * description ：弹出框的view holder
 *
 */
public class DialogViewHolder {
	private final SparseArray<View> mViews;
	private View mDialogView;

	private DialogViewHolder(Context context, int layoutId) {
		this();
		mDialogView = getView(context, layoutId, null);
	}

	public DialogViewHolder() {
		this.mViews = new SparseArray<View>();
	}

	public static DialogViewHolder get(Context context, int layoutId) {
		return new DialogViewHolder(context, layoutId);
	}

	public View getConvertView() {
		return mDialogView;
	}

	public void setConvertView(View dialogView) {
		this.mDialogView = dialogView;
	}

	/**
	 * Set the string for TextView
	 * 
	 * @param viewId
	 * @param text
	 * @return
	 */
	public DialogViewHolder setText(int viewId, CharSequence text) {
		if (text!=null) {
			TextView view = getView(viewId);
			view.setText(text);
		}
		return this;
	}

	/**
	 * set view visible
	 * 
	 * @param viewId
	 * @return
	 */
	public DialogViewHolder setViewInViSible(int viewId) {
		TextView view = getView(viewId);
		view.setVisibility(View.INVISIBLE);
		return this;
	}

	/**
	 * set view visible
	 * 
	 * @param viewId
	 * @return
	 */
	public DialogViewHolder setViewVisible(int viewId) {
		TextView view = getView(viewId);
		view.setVisibility(View.VISIBLE);
		return this;
	}

	/**
	 * set view gone
	 * 
	 * @param viewId
	 * @return
	 */
	public DialogViewHolder setViewGone(int viewId) {
		TextView view = getView(viewId);
		view.setVisibility(View.GONE);
		return this;
	}

	/**
	 * 设置点击
	 */
	public DialogViewHolder setOnClick(int viewId, OnClickListener onClick) {
		View view = getView(viewId);
		view.setOnClickListener(onClick);
		return this;
	}

	/**
	 * 设置图标
	 */
	public DialogViewHolder setIcon(int viewId, int resouceId) {
		if (resouceId != 0) {
			View view = getView(viewId);
			if (view instanceof ImageView) {
				((ImageView) view).setImageResource(resouceId);
			} else {
				view.setBackgroundResource(resouceId);
			}
		}
		return this;
	}

	/**
	 * 设置图标
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public DialogViewHolder setIcon(int viewId, Drawable drawable) {
		if (drawable != null) {
			View view = getView(viewId);
			if (view instanceof ImageView) {
				((ImageView) view).setImageDrawable(drawable);
			} else {
				view.setBackground(drawable);
			}
		}
		return this;
	}

	/**
	 * Through control the Id of the access to control, if not join views
	 * 
	 * @param viewId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends View> T getView(int viewId) {
		View view = mViews.get(viewId);
		if (view == null) {
			view = mDialogView.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return (T) view;
	}

	/**
	 * 根据布局文件id实例化view
	 *
	 * @param layoutId
	 * @return
	 */
	public View getView(Context context, int layoutId, ViewGroup group) {
		return View.inflate(context, layoutId, group);
	}
}
