package devs.mulham.horizontalcalendar.model;

import android.graphics.drawable.Drawable;

/**
 * @author Mulham-Raee
 * @since v1.2.5
 */
public class CalendarItemStyle {

    private int colorTopText;
    private int colorMiddleText;
    private int colorBottomText;
    private int colorWeekendText;
    private Drawable background;

    public CalendarItemStyle(){
    }

    public CalendarItemStyle(int textColor, int weekendTextColor, Drawable background) {
        this(textColor, textColor, textColor, weekendTextColor, background);
    }

    public CalendarItemStyle(int colorTopText, int colorMiddleText, int colorBottomText, int colorWeekendText, Drawable background) {
        this.colorTopText = colorTopText;
        this.colorMiddleText = colorMiddleText;
        this.colorBottomText = colorBottomText;
        this.colorWeekendText = colorWeekendText;
        this.background = background;
    }

    public int getColorTopText() {
        return colorTopText;
    }

    public CalendarItemStyle setColorTopText(int colorTopText) {
        this.colorTopText = colorTopText;
        return this;
    }

    public int getColorMiddleText() {
        return colorMiddleText;
    }

    public CalendarItemStyle setColorMiddleText(int colorMiddleText) {
        this.colorMiddleText = colorMiddleText;
        return this;
    }

    public int getColorBottomText() {
        return colorBottomText;
    }

    public CalendarItemStyle setColorBottomText(int colorBottomText) {
        this.colorBottomText = colorBottomText;
        return this;
    }

    public int getColorWeekendText() { return colorWeekendText; }

    public CalendarItemStyle setColorWeekendText(int colorWeekendText) {
        this.colorWeekendText = colorWeekendText;
        return this;
    }


    public Drawable getBackground() {
        return background;
    }

    public CalendarItemStyle setBackground(Drawable background) {
        this.background = background;
        return this;
    }

    public void setupDefaultValues(CalendarItemStyle defaultValues) {
        if (defaultValues == null) {
            return;
        }
        if (colorTopText == 0) {
            colorTopText = defaultValues.colorTopText;
        }
        if (colorMiddleText == 0) {
            colorMiddleText = defaultValues.colorMiddleText;
        }
        if (colorBottomText == 0) {
            colorBottomText = defaultValues.colorBottomText;
        }
        if (colorWeekendText == 0) {
            colorWeekendText = defaultValues.colorWeekendText;
        }


        if (background == null) {
            background = defaultValues.background;
        }
    }
}
