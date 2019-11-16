package com.arbelkilani.clock;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import com.arbelkilani.clock.enumeration.ClockDegreeStep;
import com.arbelkilani.clock.enumeration.ClockDegreeType;
import com.arbelkilani.clock.enumeration.ClockType;
import com.arbelkilani.clock.enumeration.ClockValueDisposition;
import com.arbelkilani.clock.enumeration.ClockValueStep;
import com.arbelkilani.clock.enumeration.ClockValueType;
import com.arbelkilani.clock.enumeration.StopwatchState;
import com.arbelkilani.clock.global.Utils;
import com.arbelkilani.clock.listener.ClockListener;
import com.arbelkilani.clock.model.ClockTheme;
import com.arbelkilani.clock.runnable.ClockRunnable;
import com.arbelkilani.clock.runnable.StopWatchRunnable;
import com.arbelkilani.clock.runnable.TimeCounterRunnable;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class Clock extends View {

    private final static String TAG = Clock.class.getSimpleName();

    private static final int ANALOGICAL_CLOCK = 0;
    private static final int NUMERIC_CLOCK = 1;
    private static final int STOP_WATCH = 2;
    private static final int TIME_COUNTER = 3;

    private static final int FULL_ANGLE = 360;
    private static final int REGULAR_ANGLE = 90;

    private static final int CUSTOM_ALPHA = 140;
    private static final int FULL_ALPHA = 255;

    private static final int DEFAULT_PRIMARY_COLOR = Color.BLACK;
    private static final int DEFAULT_SECONDARY_COLOR = Color.LTGRAY;

    private static final float DEFAULT_MINUTES_BORDER_FACTOR = 0.4f;
    private static final float DEFAULT_SECONDS_BORDER_FACTOR = 0.9f;

    private static final float DEFAULT_DEGREE_STROKE_WIDTH = 0.010f;
    private static final float DEFAULT_BORDER_THICKNESS = 0.018f;
    private static final float DEFAULT_NEEDLE_STROKE_WIDTH = 0.015f;
    private static final float NEEDLE_LENGTH_FACTOR = 0.9f;
    private static final float DEFAULT_NEEDLE_START_SPACE = 0.05f;

    private static final float DEFAULT_HOURS_VALUES_TEXT_SIZE = 0.09f;

    private static final int QUARTER_DEGREE_STEPS = 90;

    public final static int AM = 0;

    private static final float MINUTES_TEXT_SIZE = 0.050f;
    private static final int RIGHT_ANGLE = 90;

    private int mWidth, mCenterX, mCenterY, mRadius;

    private ClockRunnable mClockRunnable;
    private StopWatchRunnable mStopWatchRunnable;
    private TimeCounterRunnable mTimeCounterRunnable;

    private int clockType = ANALOGICAL_CLOCK;
    private ClockListener mClockListener;

    private long mStartTime, mMillisecondsTime, mUpdateTime, mTimeBuffer = 0L;
    private int mMilliseconds, mSeconds, mMinutes;

    private StopwatchState mStopwatchState = StopwatchState.stopped;

    private long mTimeCounterValue = 1000;
    private long mInitialTimeCounter;

    /**
     * properties
     */
    private boolean showCenter;
    private int centerInnerColor;
    private int centerOuterColor;

    private boolean showBorder;
    private int borderColor;
    private boolean showHoursProgress;
    private int hoursProgressColor;
    private boolean showMinutesProgress;
    private int minutesProgressColor;
    private float minutesProgressFactor;
    private boolean showSecondsProgress;
    private float secondsProgressFactor;
    private int secondsProgressColor;

    private boolean showSecondsNeedle;
    private int secondsNeedleColor;
    private int hoursNeedleColor;
    private int minutesNeedleColor;

    private boolean showDegrees;
    private ClockDegreeType clockDegreesType;
    private ClockDegreeStep clockDegreeStep;
    private int degreesColor;

    private boolean showHoursValues;
    private int hoursValuesColor;
    private Typeface hoursValuesTypeFace;
    private int clockValueType;
    private int clockValueDisposition;
    private int clockValueStep;

    private boolean showMinutesValues;
    private float minutesValuesFactor;

    private Drawable clockBackground;


    private int mNumbersColor;

    private Calendar mCalendar;

    public Clock(Context context) {
        super(context);
        init(context, null);
    }

    public Clock(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public Clock(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int size;
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        int widthWithoutPadding = width - getPaddingLeft() - getPaddingRight();
        int heightWithoutPadding = height - getPaddingTop() - getPaddingBottom();

        if (widthWithoutPadding > heightWithoutPadding) {
            size = heightWithoutPadding;
        } else {
            size = widthWithoutPadding;
        }

        setMeasuredDimension(size + getPaddingLeft() + getPaddingRight(), size + getPaddingTop() + getPaddingBottom());
    }

    private void init(Context context, AttributeSet attrs) {
        mClockRunnable = new ClockRunnable(this);
        mStartTime = SystemClock.uptimeMillis();

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.Clock, 0, 0);

        try {

            this.clockType = typedArray.getInt(R.styleable.Clock_clock_type, ANALOGICAL_CLOCK);

            this.showCenter = typedArray.getBoolean(R.styleable.Clock_show_center, false);
            this.centerInnerColor = typedArray.getColor(R.styleable.Clock_center_inner_color, Color.LTGRAY);
            this.centerOuterColor = typedArray.getColor(R.styleable.Clock_center_outer_color, DEFAULT_PRIMARY_COLOR);

            this.showBorder = typedArray.getBoolean(R.styleable.Clock_show_border, false);
            this.borderColor = typedArray.getColor(R.styleable.Clock_border_color, DEFAULT_PRIMARY_COLOR);
            this.showHoursProgress = typedArray.getBoolean(R.styleable.Clock_show_hours_progress, false);
            this.hoursProgressColor = typedArray.getColor(R.styleable.Clock_hours_progress_color, DEFAULT_SECONDARY_COLOR);
            this.showMinutesProgress = typedArray.getBoolean(R.styleable.Clock_show_minutes_progress, false);
            this.minutesProgressColor = typedArray.getColor(R.styleable.Clock_minutes_progress_color, DEFAULT_PRIMARY_COLOR);
            this.minutesProgressFactor = typedArray.getFloat(R.styleable.Clock_minutes_progress_factor, DEFAULT_MINUTES_BORDER_FACTOR);
            this.showSecondsProgress = typedArray.getBoolean(R.styleable.Clock_show_seconds_progress, false);
            this.secondsProgressFactor = typedArray.getFloat(R.styleable.Clock_seconds_progress_factor, DEFAULT_SECONDS_BORDER_FACTOR);
            this.secondsProgressColor = typedArray.getColor(R.styleable.Clock_seconds_progress_color, DEFAULT_PRIMARY_COLOR);

            this.showSecondsNeedle = typedArray.getBoolean(R.styleable.Clock_show_seconds_needle, false);
            this.secondsNeedleColor = typedArray.getColor(R.styleable.Clock_seconds_needle_color, DEFAULT_SECONDARY_COLOR);
            this.hoursNeedleColor = typedArray.getColor(R.styleable.Clock_hours_needle_color, DEFAULT_PRIMARY_COLOR);
            this.minutesNeedleColor = typedArray.getColor(R.styleable.Clock_minutes_needle_color, DEFAULT_PRIMARY_COLOR);

            this.showDegrees = typedArray.getBoolean(R.styleable.Clock_show_degree, false);
            this.degreesColor = typedArray.getColor(R.styleable.Clock_degree_color, DEFAULT_PRIMARY_COLOR);
            this.clockDegreesType = ClockDegreeType.line;
            this.clockDegreeStep = ClockDegreeStep.full;

            this.showHoursValues = typedArray.getBoolean(R.styleable.Clock_show_hours_values, false);
            this.hoursValuesColor = typedArray.getColor(R.styleable.Clock_hours_values_color, DEFAULT_PRIMARY_COLOR);
            int hoursTypeFace = typedArray.getResourceId(R.styleable.Clock_hours_values_font, R.font.proxima_nova_thin);
            this.hoursValuesTypeFace = ResourcesCompat.getFont(getContext(), hoursTypeFace);
            this.clockValueType = typedArray.getInt(R.styleable.Clock_clock_value_type, ClockValueType.none.getId());
            this.clockValueDisposition = typedArray.getInt(R.styleable.Clock_clock_value_disposition, ClockValueDisposition.regular.getId());
            this.clockValueStep = typedArray.getInt(R.styleable.Clock_clock_value_step, ClockValueStep.full.getId());

            this.showMinutesValues = typedArray.getBoolean(R.styleable.Clock_show_minutes_value, false);
            this.minutesValuesFactor = typedArray.getFloat(R.styleable.Clock_minutes_values_factor, DEFAULT_MINUTES_BORDER_FACTOR);

            this.clockBackground = typedArray.getDrawable(R.styleable.Clock_clock_background);

            mNumbersColor = typedArray.getColor(R.styleable.Clock_numbers_color, Color.BLACK);

            typedArray.recycle();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);

        mWidth = getHeight() > getWidth() ? getWidth() : getHeight();

        mCenterX = mWidth / 2;
        mCenterY = mWidth / 2;
        mRadius = (mWidth / 2) - ((int) (mWidth * DEFAULT_BORDER_THICKNESS) / 2);

        mCalendar = Calendar.getInstance();

        if (mClockListener != null) {
            mClockListener.getCalendar(mCalendar);
        }
        
        switch (clockType) {

            case ANALOGICAL_CLOCK:
                drawBackground(canvas);
                drawBorder(canvas);
                drawHoursValues(canvas);
                drawMinutesValues(canvas);
                drawDegrees(canvas);
                drawNeedles(canvas);
                drawCenter(canvas);
                break;

            case NUMERIC_CLOCK:
                drawNumbers(canvas);
                break;

            case STOP_WATCH:
                //drawStopWatch(canvas);
                break;

            case TIME_COUNTER:
                //drawTimeCounter(canvas);
                break;
        }


        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(mWidth * 0.005f);
        //canvas.drawRect(0, 0, mWidth, mWidth, paint);
        //canvas.drawCircle(mCenterX, mCenterY, mRadius, paint);
    }

    private void drawMinutesValues(Canvas canvas) {

        if (!showMinutesValues)
            return;

        Rect rect = new Rect();

        Typeface typeface = ResourcesCompat.getFont(getContext(), R.font.proxima_nova_thin);
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(minutesProgressColor);
        textPaint.setTypeface(typeface);
        textPaint.setTextSize(mWidth * MINUTES_TEXT_SIZE);

        int rText = (int) (mCenterX - ((1 - minutesValuesFactor - (2 * DEFAULT_BORDER_THICKNESS) - MINUTES_TEXT_SIZE) * mRadius));

        for (int i = 0; i < 360; i = i + QUARTER_DEGREE_STEPS) {

            int value = i / 6;
            String formatted;
            switch (clockValueType) {
                case -1:
                    formatted = String.format(Locale.getDefault(), "%02d", value);
                    break;

                case 1:
                    formatted = Utils.toArabic(value);
                    break;

                case 0:
                    formatted = Utils.toRoman(value);
                    break;

                default:
                    formatted = String.format(Locale.getDefault(), "%02d", value);
                    break;
            }

            int textX = (int) (mCenterX + rText * Math.cos(Math.toRadians(90 - i)));
            int textY = (int) (mCenterX - rText * Math.sin(Math.toRadians(90 - i)));
            textPaint.getTextBounds(formatted, 0, formatted.length(), rect);
            canvas.drawText(formatted, textX - rect.width() / formatted.length(), textY + rect.height() / formatted.length(), textPaint);
        }
    }

    private void drawDegrees(Canvas canvas) {

        if (!showDegrees)
            return;

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(mWidth * DEFAULT_DEGREE_STROKE_WIDTH);
        paint.setColor(degreesColor);

        int rPadded = mCenterX - (int) (mWidth * (DEFAULT_BORDER_THICKNESS + 0.01f));
        int rEnd = mCenterX - (int) (mWidth * (DEFAULT_BORDER_THICKNESS + 0.05f));

        for (int i = 0; i < FULL_ANGLE; i = i + clockDegreeStep.getId()) {

            if ((i % RIGHT_ANGLE) != 0 && (i % 15) != 0)
                paint.setAlpha(CUSTOM_ALPHA);
            else {
                paint.setAlpha(FULL_ALPHA);
            }

            int startX = (int) (mCenterX + rPadded * Math.cos(Math.toRadians(i)));
            int startY = (int) (mCenterX - rPadded * Math.sin(Math.toRadians(i)));

            int stopX = (int) (mCenterX + rEnd * Math.cos(Math.toRadians(i)));
            int stopY = (int) (mCenterX - rEnd * Math.sin(Math.toRadians(i)));

            switch (clockDegreesType) {
                case line:
                    canvas.drawLine(startX, startY, stopX, stopY, paint);
                    break;

                case circle:
                    canvas.drawCircle(stopX, stopY, mWidth * DEFAULT_DEGREE_STROKE_WIDTH, paint);
                    break;

                case square:
                    canvas.drawRect(startX, startY, startX + (mWidth * DEFAULT_DEGREE_STROKE_WIDTH), startY + (mWidth * DEFAULT_DEGREE_STROKE_WIDTH), paint);
                    break;

                default:
                    canvas.drawLine(startX, startY, stopX, stopY, paint);
                    break;
            }

        }
    }

    private void drawTimeCounter(Canvas canvas) {
        Log.i(TAG, "draw time counter");

        Paint paint = new Paint();

        paint.setColor(DEFAULT_PRIMARY_COLOR);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(mWidth * 0.008f);
        paint.setAlpha(CUSTOM_ALPHA);

        canvas.drawCircle(mCenterX, mCenterY, mRadius, paint);

        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(mWidth * 0.25f);
        textPaint.setColor(Color.WHITE);

        Typeface typeface = ResourcesCompat.getFont(getContext(), R.font.proxima_nova_thin);
        textPaint.setTypeface(typeface);


        mTimeCounterValue = mTimeCounterValue - 1000;

        if (mTimeCounterValue == 0) {
            removeCallback();
        }

        Paint progressArcPaint = new Paint();

        progressArcPaint.setColor(DEFAULT_PRIMARY_COLOR);
        progressArcPaint.setStyle(Paint.Style.STROKE);
        progressArcPaint.setStrokeWidth(mWidth * 0.008f);
        progressArcPaint.setStrokeCap(Paint.Cap.ROUND);

        RectF rectF = new RectF(mCenterX - mRadius, mCenterY - mRadius, mCenterX + mRadius, mCenterY + mRadius);

        long sweepAngle;
        String value;
        if (mInitialTimeCounter != 0) {
            sweepAngle = (long) ((float) mTimeCounterValue / mInitialTimeCounter * FULL_ANGLE);
            canvas.drawArc(rectF, -REGULAR_ANGLE, FULL_ANGLE - (FULL_ANGLE - sweepAngle), false, progressArcPaint);

            value = String.format(Locale.getDefault(), "%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(mTimeCounterValue),
                    TimeUnit.MILLISECONDS.toSeconds(mTimeCounterValue) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(mTimeCounterValue)));


        } else {
            canvas.drawArc(rectF, -REGULAR_ANGLE, FULL_ANGLE, false, progressArcPaint);
            value = "00:00";
        }

        SpannableStringBuilder spannableString = new SpannableStringBuilder(value);
        StaticLayout layout = new StaticLayout(spannableString, textPaint, canvas.getWidth(), Layout.Alignment.ALIGN_CENTER, 1, 1, true);
        canvas.translate(mCenterX - layout.getWidth() / 2, mCenterY - layout.getHeight() / 2);

        layout.draw(canvas);
    }

    private void drawStopWatch(Canvas canvas) {

        Log.i(TAG, "draw stop watch");

        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(mWidth * 0.35f);
        textPaint.setColor(Color.WHITE);

        Typeface typeface = ResourcesCompat.getFont(getContext(), R.font.proxima_nova_thin);
        textPaint.setTypeface(typeface);

        mMillisecondsTime = SystemClock.uptimeMillis() - mStartTime;

        mUpdateTime = mTimeBuffer + mMillisecondsTime;

        mSeconds = (int) (mUpdateTime / 1000);
        mMinutes = mSeconds / 60;
        mSeconds = mSeconds % 60;

        mMilliseconds = (int) (mUpdateTime % 1000);

        String value = String.format(Locale.getDefault(), "%02d", mMinutes) + ":" + String.format(Locale.getDefault(), "%02d", mSeconds);
        SpannableStringBuilder spannableString = new SpannableStringBuilder(value);
        StaticLayout layout = new StaticLayout(spannableString, textPaint, canvas.getWidth(), Layout.Alignment.ALIGN_CENTER, 1, 1, true);
        canvas.translate(mCenterX - layout.getWidth() / 2, mCenterY - layout.getHeight() / 2);

        layout.draw(canvas);


        if (mStopwatchState == StopwatchState.paused)
            mTimeBuffer += mMillisecondsTime;
    }

    private void drawNumbers(Canvas canvas) {

        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(mWidth * 0.3f);
        textPaint.setColor(mNumbersColor);
        textPaint.setColor(mNumbersColor);

        Typeface typeface = ResourcesCompat.getFont(getContext(), R.font.proxima_nova_thin);
        textPaint.setTypeface(typeface);

        Calendar calendar = mCalendar;

        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int amPm = calendar.get(Calendar.AM_PM);

        String time = String.format("%s:%s%s",
                String.format(Locale.getDefault(), "%02d", hour),
                String.format(Locale.getDefault(), "%02d", minute),
                amPm == AM ? "AM" : "PM");

        SpannableStringBuilder spannableString = new SpannableStringBuilder(time);
        spannableString.setSpan(new RelativeSizeSpan(0.3f), spannableString.toString().length() - 2, spannableString.toString().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // se superscript percent

        StaticLayout layout = new StaticLayout(spannableString, textPaint, canvas.getWidth(), Layout.Alignment.ALIGN_CENTER, 1, 1, true);
        canvas.translate(mCenterX - layout.getWidth() / 2, mCenterY - layout.getHeight() / 2);
        layout.draw(canvas);
    }

    private void drawHoursValues(Canvas canvas) {

        if (!showHoursValues)
            return;

        Rect rect = new Rect();

        TextPaint textPaint = new TextPaint();
        textPaint.setColor(hoursValuesColor);
        textPaint.setTypeface(hoursValuesTypeFace);
        textPaint.setTextSize(mWidth * DEFAULT_HOURS_VALUES_TEXT_SIZE);

        float degreeSpace = 0f;
        if (showDegrees)
            degreeSpace = DEFAULT_DEGREE_STROKE_WIDTH + 0.06f;

        int rText = (int) (mCenterX - (mWidth * DEFAULT_HOURS_VALUES_TEXT_SIZE) - (mWidth * degreeSpace));

        for (int i = FULL_ANGLE; i > 0; i = i - clockValueStep) {

            int value = i / 30;
            String formatted;
            switch (clockValueType) {

                case -1:
                    formatted = String.format(Locale.getDefault(), "%02d", value);
                    break;

                case 0:
                    formatted = Utils.toRoman(value);
                    break;

                case 1:
                    formatted = Utils.toArabic(value);
                    break;

                default:
                    formatted = String.format(Locale.getDefault(), "%02d", value);
                    break;
            }

            switch (clockValueDisposition) {
                case -1:
                    textPaint.setTextSize(mWidth * DEFAULT_HOURS_VALUES_TEXT_SIZE);
                    textPaint.setAlpha(FULL_ALPHA);
                    break;

                case 0:
                    if ((i % RIGHT_ANGLE) == 0) {
                        textPaint.setTextSize(mWidth * DEFAULT_HOURS_VALUES_TEXT_SIZE);
                        textPaint.setAlpha(FULL_ALPHA);
                    } else {
                        textPaint.setTextSize(mWidth * (DEFAULT_HOURS_VALUES_TEXT_SIZE - 0.03f));
                        textPaint.setAlpha(CUSTOM_ALPHA);
                    }
                    break;

                default:
                    textPaint.setTextSize(mWidth * DEFAULT_HOURS_VALUES_TEXT_SIZE);
                    textPaint.setAlpha(FULL_ALPHA);
                    break;
            }


            int textX = (int) (mCenterX + rText * Math.cos(Math.toRadians(REGULAR_ANGLE - i)));
            int textY = (int) (mCenterX - rText * Math.sin(Math.toRadians(REGULAR_ANGLE - i)));
            textPaint.getTextBounds(formatted, 0, formatted.length(), rect);
            canvas.drawText(formatted, textX - rect.width() / formatted.length(), textY + rect.height() / formatted.length(), textPaint);
        }

    }

    private void drawNeedles(final Canvas canvas) {

        final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(mWidth * DEFAULT_NEEDLE_STROKE_WIDTH);

        float needleStartSpace = DEFAULT_NEEDLE_START_SPACE;

        float borderThickness = 0f;
        float hoursTextSize = 0f;
        float degreesSpace = 0f;

        if (showBorder)
            borderThickness = mWidth * DEFAULT_BORDER_THICKNESS;

        if (showHoursValues)
            hoursTextSize = mWidth * DEFAULT_HOURS_VALUES_TEXT_SIZE;

        if (showDegrees)
            degreesSpace = mWidth * (DEFAULT_BORDER_THICKNESS + 0.06f); // // TODO: 11/7/18  

        //float needleMaxLength = (mRadius * NEEDLE_LENGTH_FACTOR) - 2 * (borderThickness + hoursTextSize);
        float needleMaxLength = (mRadius * NEEDLE_LENGTH_FACTOR) - (degreesSpace + borderThickness + hoursTextSize);

        // draw seconds needle
        float secondsDegree = mCalendar.get(Calendar.SECOND) * 6;

        float startSecondsX = (float) (mCenterX + (mRadius * needleStartSpace) * Math.cos(Math.toRadians(-REGULAR_ANGLE + secondsDegree)));
        float stopSecondsX = (float) (mCenterX + needleMaxLength * Math.cos(Math.toRadians(-REGULAR_ANGLE + secondsDegree)));
        float startSecondsY = ((float) (mCenterY + (mRadius * needleStartSpace) * Math.sin(Math.toRadians(-REGULAR_ANGLE + secondsDegree))));
        float stopSecondsY = ((float) (mCenterY + needleMaxLength * Math.sin(Math.toRadians(-REGULAR_ANGLE + secondsDegree))));

        // draw hours needle
        float hoursDegree = (mCalendar.get(Calendar.HOUR) + (mCalendar.get(Calendar.MINUTE) / 60f)) * 30; // 30 = 360 / 12

        float startHoursX = (float) (mCenterX + (mRadius * needleStartSpace) * Math.cos(Math.toRadians(-REGULAR_ANGLE + hoursDegree)));
        float stopHoursX = (float) (mCenterX + (needleMaxLength * 0.6f) * Math.cos(Math.toRadians(-REGULAR_ANGLE + hoursDegree)));
        float startHoursY = ((float) (mCenterY + (mRadius * needleStartSpace) * Math.sin(Math.toRadians(-REGULAR_ANGLE + hoursDegree))));
        float stopHoursY = ((float) (mCenterY + (needleMaxLength * 0.6f) * Math.sin(Math.toRadians(-REGULAR_ANGLE + hoursDegree))));

        // draw minutes needle
        float minutesDegree = (mCalendar.get(Calendar.MINUTE) + (mCalendar.get(Calendar.SECOND) / 60f)) * 6;

        float startMinutesX = (float) (mCenterX + (mRadius * needleStartSpace) * Math.cos(Math.toRadians(-REGULAR_ANGLE + minutesDegree)));
        float stopMinutesX = (float) (mCenterX + (needleMaxLength * 0.8f) * Math.cos(Math.toRadians(-REGULAR_ANGLE + minutesDegree)));
        float startMinutesY = ((float) (mCenterY + ((mRadius - (mWidth * DEFAULT_BORDER_THICKNESS)) * needleStartSpace) * Math.sin(Math.toRadians(-REGULAR_ANGLE + minutesDegree))));
        float stopMinutesY = ((float) (mCenterY + (needleMaxLength * 0.8f) * Math.sin(Math.toRadians(-REGULAR_ANGLE + minutesDegree))));

        drawProgressBorder(canvas, hoursDegree, minutesDegree, secondsDegree);

        // hours needle
        paint.setColor(hoursNeedleColor);
        canvas.drawLine(startHoursX, startHoursY, stopHoursX, stopHoursY, paint);

        // minutes needle
        paint.setColor(minutesNeedleColor);
        canvas.drawLine(startMinutesX, startMinutesY, stopMinutesX, stopMinutesY, paint);

        // seconds needle
        paint.setStrokeWidth(mWidth * 0.008f);
        paint.setColor(secondsNeedleColor);
        if (showSecondsNeedle) {
            canvas.drawLine(startSecondsX, startSecondsY, stopSecondsX, stopSecondsY, paint);
        }

    }

    private void drawProgressBorder(Canvas canvas, float hoursDegree, float minutesDegree, float secondsDegree) {

        float minuteProgressSpace = (mRadius - DEFAULT_BORDER_THICKNESS) * minutesProgressFactor;
        RectF minutesRectF = new RectF(mCenterX - minuteProgressSpace, mCenterY - minuteProgressSpace, mCenterX + minuteProgressSpace, mCenterY + minuteProgressSpace);

        RectF hoursRectF = new RectF(mCenterX - mRadius, mCenterY - mRadius, mCenterX + mRadius, mCenterY + mRadius);

        float secondsProgressSpace = (mRadius - DEFAULT_BORDER_THICKNESS) * secondsProgressFactor;
        RectF secondsRectF = new RectF(mCenterX - secondsProgressSpace, mCenterY - secondsProgressSpace, mCenterX + secondsProgressSpace, mCenterX + secondsProgressSpace);

        Paint progressArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        progressArcPaint.setColor(borderColor);
        progressArcPaint.setStyle(Paint.Style.STROKE);
        progressArcPaint.setStrokeWidth(mWidth * DEFAULT_BORDER_THICKNESS);
        progressArcPaint.setStrokeCap(Paint.Cap.ROUND);

        if (showSecondsProgress) {
            progressArcPaint.setColor(secondsProgressColor);
            canvas.drawArc(secondsRectF, -REGULAR_ANGLE, secondsDegree, false, progressArcPaint);
        }

        if (showMinutesProgress) {
            progressArcPaint.setColor(borderColor);
            canvas.drawCircle(mCenterX, mCenterY, minutesRectF.width() / 2, progressArcPaint);

            progressArcPaint.setColor(minutesProgressColor);
            canvas.drawArc(minutesRectF, -REGULAR_ANGLE, minutesDegree, false, progressArcPaint);
        }

        if (showHoursProgress) {
            progressArcPaint.setColor(hoursProgressColor);
            canvas.drawArc(hoursRectF, -REGULAR_ANGLE, hoursDegree, false, progressArcPaint);
        }

    }

    private void drawBorder(Canvas canvas) {

        if (!showBorder)
            return;

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setAntiAlias(true);
        paint.setColor(borderColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(mWidth * DEFAULT_BORDER_THICKNESS);
        canvas.drawCircle(mCenterX, mCenterY, mRadius, paint);
    }

    private void drawBackground(Canvas canvas) {

        if (clockBackground == null)
            return;

        Bitmap bitmap = ((BitmapDrawable) clockBackground).getBitmap();
        RectF rectF = new RectF(mCenterX - mRadius, mCenterY - mRadius, mCenterX + mRadius, mCenterY + mRadius);

        Bitmap output = Bitmap.createBitmap(mWidth, mWidth, Bitmap.Config.ARGB_8888);
        Canvas tCanvas = new Canvas(output);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        tCanvas.drawCircle(mCenterX, mCenterY, mRadius, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        tCanvas.drawBitmap(bitmap, null, rectF, paint);

        canvas.drawBitmap(output, null, rectF, new Paint());

    }

    private void drawCenter(Canvas canvas) {

        if (!showCenter)
            return;

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(centerInnerColor);
        canvas.drawCircle(mCenterX, mCenterY, mWidth * 0.015f, paint); // center

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(centerOuterColor);
        paint.setStrokeWidth(mWidth * 0.008f);
        canvas.drawCircle(mCenterX, mCenterY, mWidth * 0.02f, paint); // border

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mClockRunnable.run();
    }

    public void setClockListener(ClockListener clockListener) {
        mClockListener = clockListener;
    }

    public void setStyle(ClockType clockType) {
        switch (clockType) {
            case numeric:
                this.clockType = NUMERIC_CLOCK;
                mClockRunnable.run();
                break;

            case analogical:
                this.clockType = ANALOGICAL_CLOCK;
                mClockRunnable.run();
                break;

            case stopwatch:
                this.clockType = STOP_WATCH;
                break;

            case time_counter:
                stopTimeCounter();
                this.clockType = TIME_COUNTER;
                break;
        }

        resetStopwatchValues();
        resetTimeCounterValues();
        invalidate();

    }

    private void resetTimeCounterValues() {
    }

    private void resetStopwatchValues() {
        mMillisecondsTime = 0L;
        mStartTime = SystemClock.uptimeMillis();
        mTimeBuffer = 0L;
        mUpdateTime = 0L;
    }

    public ClockType getType() {

        switch (clockType) {

            case ANALOGICAL_CLOCK:
                return ClockType.analogical;

            case NUMERIC_CLOCK:
                return ClockType.numeric;

            case STOP_WATCH:
                return ClockType.stopwatch;

            case TIME_COUNTER:
                return ClockType.time_counter;

            default:
                return null;
        }
    }

    public void runStopwatch() {

        Log.i(TAG, "run stopwatch");

        mStopWatchRunnable = new StopWatchRunnable(this);
        mStartTime = SystemClock.uptimeMillis();
        mStopWatchRunnable.run();
        mStopwatchState = StopwatchState.running;
    }

    public void pauseStopwatch() {

        Log.i(TAG, "pause stopwatch");

        removeCallbacks(mStopWatchRunnable);
        removeCallbacks(mClockRunnable);
        mStopwatchState = StopwatchState.paused;
    }

    public void resumeStopWatch() {

        Log.i(TAG, "resume stopwatch");

        mStartTime = SystemClock.uptimeMillis();
        mStopWatchRunnable.run();
        mStopwatchState = StopwatchState.running;
    }

    public StopwatchState getStopwatchState() {
        return mStopwatchState;
    }

    public void stopStopwatch() {

        Log.i(TAG, "stop stopwatch");

        resetStopwatchValues();

        if (mStopWatchRunnable != null) mStopWatchRunnable.run(); // re-run runnable to enable draw
        removeCallbacks(mStopWatchRunnable);
        removeCallbacks(mClockRunnable);
        mStopwatchState = StopwatchState.stopped;
    }

    public long getCurrentValue() {
        return mUpdateTime;
    }

    public void setTimeCounterValue(long timeCounterValue) {

        removeCallback();

        mTimeCounterValue = timeCounterValue;
        mTimeCounterRunnable = new TimeCounterRunnable(this);
        mTimeCounterRunnable.run();

        mInitialTimeCounter = timeCounterValue;

    }

    private void removeCallback() {
        removeCallbacks(mTimeCounterRunnable);
        removeCallbacks(mClockRunnable);
        removeCallbacks(mStopWatchRunnable);
    }

    public void stopTimeCounter() {
        removeCallback();
        mInitialTimeCounter = 0L;
        if (mTimeCounterRunnable != null) mTimeCounterRunnable.run();
        removeCallbacks(mStopWatchRunnable);
        removeCallbacks(mTimeCounterRunnable);
        //// TODO: 8/10/18 time counter state
    }

    // setters
    public void setShowCenter(boolean showCenter) {
        this.showCenter = showCenter;
    }

    public void setCenterInnerColor(int centerInnerColor) {
        try {
            this.centerInnerColor = ContextCompat.getColor(getContext(), centerInnerColor);
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    public void setCenterOuterColor(int centerOuterColor) {
        try {
            this.centerOuterColor = ContextCompat.getColor(getContext(), centerOuterColor);
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    public void setShowHoursValues(boolean showHoursValues) {
        this.showHoursValues = showHoursValues;
    }

    public void setClockValueStep(ClockValueStep clockValueStep) {
        this.clockValueStep = clockValueStep.getId();
    }

    public void setShowBorder(boolean showBorder) {
        this.showBorder = showBorder;
    }

    public void setBorderColor(int borderColor) {
        try {
            this.borderColor = ContextCompat.getColor(getContext(), borderColor);
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    public void setShowHoursProgress(boolean showHoursProgress) {
        this.showHoursProgress = showHoursProgress;
    }

    public void setHoursProgressColor(int hoursProgressColor) {
        try {
            this.hoursProgressColor = ContextCompat.getColor(getContext(), hoursProgressColor);
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    public void setShowMinutesProgress(boolean showMinutesProgress) {
        this.showMinutesProgress = showMinutesProgress;
    }

    public void setMinutesProgressColor(int minutesProgressColor) {
        try {
            this.minutesProgressColor = ContextCompat.getColor(getContext(), minutesProgressColor);
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    public void setMinutesProgressFactor(float minutesProgressFactor) {
        this.minutesProgressFactor = minutesProgressFactor;
    }

    public void setShowSecondsProgress(boolean showSecondsProgress) {
        this.showSecondsProgress = showSecondsProgress;
    }

    public void setSecondsProgressFactor(float secondsProgressFactor) {
        this.secondsProgressFactor = secondsProgressFactor;
    }

    public void setSecondsProgressColor(int secondsProgressColor) {
        try {
            this.secondsProgressColor = ContextCompat.getColor(getContext(), secondsProgressColor);
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    public void setShowSecondsNeedle(boolean showSecondsNeedle) {
        this.showSecondsNeedle = showSecondsNeedle;
    }

    public void setSecondsNeedleColor(int secondsNeedleColor) {
        try {
            this.secondsNeedleColor = ContextCompat.getColor(getContext(), secondsNeedleColor);
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    public void setHoursNeedleColor(int hoursNeedleColor) {
        this.hoursNeedleColor = hoursNeedleColor;
    }

    public void setMinutesNeedleColor(int minutesNeedleColor) {
        this.minutesNeedleColor = minutesNeedleColor;
    }

    public void setHoursValuesColor(int hoursValuesColor) {
        this.hoursValuesColor = hoursValuesColor;
    }

    public void setHoursValuesTypeFace(Typeface hoursValuesTypeFace) {
        this.hoursValuesTypeFace = hoursValuesTypeFace;
    }

    public void setClockType(int clockType) {
        this.clockType = clockType;
    }

    public void setShowDegrees(boolean showDegrees) {
        this.showDegrees = showDegrees;
    }

    public void setClockDegreesType(ClockDegreeType clockDegreesType) {
        this.clockDegreesType = clockDegreesType;
    }

    public void setClockDegreeStep(ClockDegreeStep clockDegreeStep) {
        this.clockDegreeStep = clockDegreeStep;
    }

    public void setDegreesColor(int degreesColor) {
        this.degreesColor = degreesColor;
    }

    public void setClockValueType(ClockValueType clockValueType) {
        this.clockValueType = clockValueType.getId();
    }

    public void setClockValueDisposition(ClockValueDisposition clockValueDisposition) {
        this.clockValueDisposition = clockValueDisposition.getId();
    }

    public void setClockValueStep(int clockValueStep) {
        this.clockValueStep = clockValueStep;
    }

    public void setShowMinutesValues(boolean showMinutesValues) {
        this.showMinutesValues = showMinutesValues;
    }

    public void setMinutesValuesFactor(float minutesValuesFactor) {
        this.minutesValuesFactor = minutesValuesFactor;
    }

    public void setClockBackground(int clockBackground) {
        try {
            this.clockBackground = ContextCompat.getDrawable(getContext(), clockBackground);
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    public void setTheme(ClockTheme clockTheme) {

        this.showCenter = clockTheme.isShowCenter();

        this.showBorder = clockTheme.isShowBorder();
        this.showHoursProgress = clockTheme.isShowHoursProgress();
        this.showMinutesProgress = clockTheme.isShowMinutesProgress();
        this.minutesProgressFactor = clockTheme.getMinutesProgressFactor();
        this.showSecondsProgress = clockTheme.isShowSecondsProgress();
        this.secondsProgressFactor = clockTheme.getSecondsProgressFactor();

        this.showSecondsNeedle = clockTheme.isShowSecondsNeedle();

        this.showDegrees = clockTheme.isShowDegrees();
        this.clockDegreesType = clockTheme.getClockDegreeType();

        this.showHoursValues = clockTheme.isShowHoursValues();
        if (clockTheme.getClockValueType() != null) {
            this.clockValueType = clockTheme.getClockValueType().getId();
        }
        if (clockTheme.getClockValueDisposition() != null) {
            this.clockValueDisposition = clockTheme.getClockValueDisposition().getId();
        }
        if (clockTheme.getClockValueStep() != null) {
            this.clockValueStep = clockTheme.getClockValueStep().getId();
        }
        this.showMinutesValues = clockTheme.isShowMinutesValues();
        this.minutesValuesFactor = clockTheme.getMinutesValuesFactor();

        this.centerInnerColor = clockTheme.getCenterInnerColor();
        this.centerOuterColor = clockTheme.getCenterOuterColor();

        try {
            this.clockBackground = ContextCompat.getDrawable(getContext(), clockTheme.getClockBackground());
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
            e.printStackTrace();
        }

        try {
            this.borderColor = ContextCompat.getColor(getContext(), clockTheme.getBorderColor());
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
            e.printStackTrace();
        }

        try {
            this.hoursProgressColor = ContextCompat.getColor(getContext(), clockTheme.getHoursProgressColor());
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
            e.printStackTrace();
        }

        try {
            this.minutesProgressColor = ContextCompat.getColor(getContext(), clockTheme.getMinutesProgressColor());
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
            e.printStackTrace();
        }

        try {
            this.secondsProgressColor = ContextCompat.getColor(getContext(), clockTheme.getSecondsProgressColor());
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
            e.printStackTrace();
        }

        try {
            this.secondsNeedleColor = ContextCompat.getColor(getContext(), clockTheme.getSecondsNeedleColor());
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
            e.printStackTrace();
        }

        try {
            this.hoursNeedleColor = ContextCompat.getColor(getContext(), clockTheme.getHoursNeedleColor());
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
            e.printStackTrace();
        }

        try {
            this.minutesNeedleColor = ContextCompat.getColor(getContext(), clockTheme.getMinutesNeedleColor());
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
            e.printStackTrace();
        }

        try {
            this.degreesColor = ContextCompat.getColor(getContext(), clockTheme.getDegreesColor());
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
            e.printStackTrace();
        }

        try {
            this.hoursValuesColor = ContextCompat.getColor(getContext(), clockTheme.getHoursValuesColor());
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
            e.printStackTrace();
        }

        try {
            hoursValuesTypeFace = ResourcesCompat.getFont(getContext(), clockTheme.getHoursValuesFont());
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
            e.printStackTrace();
        }

        invalidate();
    }

    /**
     * Ref : https://garygregory.wordpress.com/2013/06/18/what-are-the-java-timezone-ids/
     *
     * @param timezoneCountry
     */
    public void setTimezone(String timezoneCountry) {
        mCalendar = Calendar.getInstance(TimeZone.getTimeZone(timezoneCountry));
    }
}
