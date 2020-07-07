package com.macsags.suctiontop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.ColorInt;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.ContentValues.TAG;
import static android.content.Context.WINDOW_SERVICE;

/**
 * @author : 柳湘翎 （Macsags）
 * @date : 2020/6/28 16:26
 * @mail : 670765255@qq.com
 * @description ：吸顶效果
 */
public abstract class SuctionTop extends RecyclerView.ItemDecoration {
    //默认标签颜色
    private final int DEFAULT_LABEL_COLOR = Color.WHITE;
    //默认标签字体颜色
    private final int DEFAULT_LABEL_TEXT_COLOR = Color.DKGRAY;
    //默认标签字体大小dp
    private final int DEFAULT_LABEL_TEXT_SIZE = 12;
    //默认标签高度dp
    private final int DEFAULT_LABEL_HEIGHT = 40;

    public static int LABEL_GRAVITY_LEFT = 0x00;
    public static int LABEL_GRAVITY_CENTER = 0x01;
    public static int LABEL_GRAVITY_RIGHT = 0x02;

    private Context mContext;
    private Rect mRect = new Rect();
    private Paint mPaint = new Paint();

    private int mLabelHeight;
    private int mLabelColor;
    private int mTextSize;
    private int mTextColor;
    private int mLabelGravity;

    private int mWindowManagerWidth;

    /**
     * 构造方法,用此构造方法创建的话.相关的参数都会会初始化一个默认值,当然你还可以调用以下方
     * 法再进行设置相关参数,设置标签颜色{ #setLabelColor(int)};
     * 设置标签高度{#setLabelHeight(int)};
     * 设置标签字体大小单位是像素{ #setTextSize(int)};
     * 设置标签字体颜色{ #setTextColor(int)};
     *
     * @param context 上下文
     */
    public SuctionTop(Context context) {
        mContext = context;
        setTextSize(dpToPx(DEFAULT_LABEL_TEXT_SIZE));
        setLabelColor(DEFAULT_LABEL_COLOR);
        setTextColor(DEFAULT_LABEL_TEXT_COLOR);
        setLabelHeight(dpToPx(DEFAULT_LABEL_HEIGHT));
        WindowManager wm = (WindowManager) mContext.getSystemService(WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        mWindowManagerWidth = display.getWidth();
        Log.e(TAG, "width" + mWindowManagerWidth);
    }

    /**
     * 用此构造方法创建的对象的话,需要传入相关的参数.
     *
     * @param context     上下文
     * @param labelHeight 标签的高度 dp
     * @param labelColor  标签的颜色 int值
     * @param textSize    标签的字体大小 px
     * @param textColor   标签的字体颜色 int值
     */
    public SuctionTop(Context context, int labelHeight, int labelColor, int textSize, int textColor) {
        mContext = context;
        setLabelHeight(labelHeight);
        setLabelColor(labelColor);
        setTextSize(textSize);
        setTextColor(textColor);
        WindowManager wm = (WindowManager) mContext.getSystemService(WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        mWindowManagerWidth = display.getWidth();
        Log.e(TAG, "width" + mWindowManagerWidth);
    }

    /**
     * 设置标签的颜色
     *
     * @param labelColor 颜色的int值
     */
    public void setLabelColor(@ColorInt int labelColor) {
        this.mLabelColor = labelColor;
        mPaint.setColor(labelColor);
    }

    /**
     * 设置标签字体大小
     *
     * @param textSize 像素 px
     */
    public void setTextSize(int textSize) {
        this.mTextSize = textSize;
        mPaint.setTextSize(mTextSize);
        mPaint.setAntiAlias(true);
        mPaint.setTypeface(Typeface.DEFAULT_BOLD);
    }

    /**
     * 设置标签字体颜色
     *
     * @param textColor 颜色的int值
     */
    public void setTextColor(@ColorInt int textColor) {
        this.mTextColor = textColor;
    }

    /**
     * 设置标签高度
     *
     * @param labelHeight dp
     */
    public void setLabelHeight(int labelHeight) {
        this.mLabelHeight = labelHeight;
    }

    /**
     * 设置标签文字位置
     *
     * @param labelGravity LABEL_GRAVITY_LEFT
     *                     LABEL_GRAVITY_CENTER
     *                     LABEL_GRAVITY_RIGHT
     */
    public void setLabelGravity(int labelGravity) {
        this.mLabelGravity = labelGravity;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        int childCount = parent.getChildCount();
        mRect.left = parent.getPaddingLeft();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(child);

            //画顶部的标签,只有在列表的第一条item的索引为非0,或是第一条item为0但是它的getTop
            //小于0时才需要绘制
            if (i == 0 && (position > 0) || (position == 0 && child.getTop() < 0)) {
                mRect.right = parent.getWidth();
                mRect.top = parent.getTop();
                mRect.bottom = parent.getTop() + mLabelHeight;
                int textWidth = (int) mPaint.measureText(getItemLabelStr(position));

                Rect rect = new Rect(mRect.left, mRect.top, mRect.right, mRect.bottom);
                mPaint.setColor(mLabelColor);
                c.drawRect(rect, mPaint);
                mPaint.setColor(Color.DKGRAY);

                Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), getItemLabelImg(position));
                // 将画布坐标系移动到画布中央
                c.translate(0, 0);
                // 指定图片绘制区域(左上角的四分之一)
                Rect src = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                // 指定图片在屏幕上显示的区域
                Rect dst = new Rect(mRect.left, mRect.top, mLabelHeight, mLabelHeight);
                // 绘制图片
                c.drawBitmap(bitmap, src, dst, null);

                Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
                float bottomLineY = rect.centerY() - (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.top;
                if (mLabelGravity == LABEL_GRAVITY_LEFT) {
                    c.drawText(getItemLabelStr(position), 30 + mLabelHeight, bottomLineY, mPaint);
                } else if (mLabelGravity == LABEL_GRAVITY_CENTER) {
                    c.drawText(getItemLabelStr(position), (mWindowManagerWidth - textWidth) / 2, bottomLineY, mPaint);
                } else if (mLabelGravity == LABEL_GRAVITY_RIGHT) {
                    c.drawText(getItemLabelStr(position), (mWindowManagerWidth - textWidth - 30), bottomLineY, mPaint);
                } else {
                    c.drawText(getItemLabelStr(position), 30, bottomLineY, mPaint);//默认在左
                }
            }

        }

    }


    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();
        mRect.left = parent.getPaddingLeft();

        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(child);

            //组制每组的标签
            if (isShowItemLabel(position)) {
                mRect.top = child.getTop() - mLabelHeight;
                mRect.bottom = child.getTop();
                mRect.right = child.getRight();
                int textWidth = (int) mPaint.measureText(getItemLabelStr(position));
                Rect rect = new Rect(mRect.left, mRect.top, mRect.right, mRect.bottom);
                mPaint.setColor(mLabelColor);
                c.drawRect(rect, mPaint);
                mPaint.setColor(Color.DKGRAY);
                Log.e(TAG, "onDraw:position" + position);
                Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), getItemLabelImg(position));
                // 将画布坐标系移动到画布中央
                c.translate(0, 0);
                // 指定图片绘制区域(左上角的四分之一)
                Rect src = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                // 指定图片在屏幕上显示的区域
                Rect dst = new Rect(mRect.left, mRect.top, mLabelHeight, rect.centerY() + mLabelHeight / 2);
                // 绘制图片
                c.drawBitmap(bitmap, src, dst, null);

                Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
                float bottomLineY = rect.centerY() - (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.top;
                if (mLabelGravity == LABEL_GRAVITY_LEFT) {
                    c.drawText(getItemLabelStr(position), 30 + mLabelHeight, bottomLineY, mPaint);
                } else if (mLabelGravity == LABEL_GRAVITY_CENTER) {
                    c.drawText(getItemLabelStr(position), (mWindowManagerWidth - textWidth) / 2, bottomLineY, mPaint);
                } else if (mLabelGravity == LABEL_GRAVITY_RIGHT) {
                    c.drawText(getItemLabelStr(position), (mWindowManagerWidth - textWidth - 30), bottomLineY, mPaint);
                } else {
                    c.drawText(getItemLabelStr(position), 30, bottomLineY, mPaint);//默认在左
                }
            }

        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        if (isShowItemLabel(position)) {
            outRect.top = mLabelHeight;
        } else {
            outRect.top = 0;
        }
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    private int dpToPx(int dp) {
        return (int) (mContext.getResources().getDisplayMetrics().density * dp);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 是否显示Item的标签
     * 子类必须要复写此方法来说明当前item是否要显示标签
     *
     * @param position 当前item的索引
     */
    protected abstract boolean isShowItemLabel(int position);

    /**
     * 获取标签的字符串
     * 子类必须要复写此方法来返回标签的文本内容
     *
     * @param position 当前item的索引
     */
    protected abstract String getItemLabelStr(int position);

    /**
     * 获取标签的图片
     * 子类必须要复写此方法来返回标签的图片地址
     *
     * @param position 当前item的索引
     */
    protected abstract int getItemLabelImg(int position);


}