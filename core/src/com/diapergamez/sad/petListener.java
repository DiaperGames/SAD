package com.diapergamez.sad;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
//TODO adjust the javadocs as the click listener is implemented;
public class petListener extends ClickListener {
    /**
     * Create a listener where {@link #clicked(InputEvent, float, float)} is only called for left clicks.
     *
     * @see #petListener(int)
     */
    public petListener() {
        super();
    }

    /**
     * @param button
     * @see #setButton(int)
     */
    public petListener(int button) {
        super(button);
    }

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        return super.touchDown(event, x, y, pointer, button);
    }

    @Override
    public void touchDragged(InputEvent event, float x, float y, int pointer) {
        super.touchDragged(event, x, y, pointer);
    }

    @Override
    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        super.touchUp(event, x, y, pointer, button);
    }

    @Override
    public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
        super.enter(event, x, y, pointer, fromActor);
    }

    @Override
    public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
        super.exit(event, x, y, pointer, toActor);
    }

    /**
     * If a touch down is being monitored, the drag and touch up events are ignored until the next touch up.
     */
    @Override
    public void cancel() {
        super.cancel();
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);
    }

    /**
     * Returns true if the specified position is over the specified actor or within the tap square.
     *
     * @param actor
     * @param x
     * @param y
     */
    @Override
    public boolean isOver(Actor actor, float x, float y) {
        return super.isOver(actor, x, y);
    }

    @Override
    public boolean inTapSquare(float x, float y) {
        return super.inTapSquare(x, y);
    }

    /**
     * Returns true if a touch is within the tap square.
     */
    @Override
    public boolean inTapSquare() {
        return super.inTapSquare();
    }

    /**
     * The tap square will no longer be used for the current touch.
     */
    @Override
    public void invalidateTapSquare() {
        super.invalidateTapSquare();
    }

    /**
     * Returns true if a touch is over the actor or within the tap square.
     */
    @Override
    public boolean isPressed() {
        return super.isPressed();
    }

    /**
     * Returns true if a touch is over the actor or within the tap square or has been very recently. This allows the UI to show a
     * press and release that was so fast it occurred within a single frame.
     */
    @Override
    public boolean isVisualPressed() {
        return super.isVisualPressed();
    }

    /**
     * If true, sets the visual pressed time to now. If false, clears the visual pressed time.
     *
     * @param visualPressed
     */
    @Override
    public void setVisualPressed(boolean visualPressed) {
        super.setVisualPressed(visualPressed);
    }

    /**
     * Returns true if the mouse or touch is over the actor or pressed and within the tap square.
     */
    @Override
    public boolean isOver() {
        return super.isOver();
    }

    @Override
    public void setTapSquareSize(float halfTapSquareSize) {
        super.setTapSquareSize(halfTapSquareSize);
    }

    @Override
    public float getTapSquareSize() {
        return super.getTapSquareSize();
    }

    /**
     * @param tapCountInterval time in seconds that must pass for two touch down/up sequences to be detected as consecutive
     */
    @Override
    public void setTapCountInterval(float tapCountInterval) {
        super.setTapCountInterval(tapCountInterval);
    }

    /**
     * Returns the number of taps within the tap count interval for the most recent click event.
     */
    @Override
    public int getTapCount() {
        return super.getTapCount();
    }

    @Override
    public void setTapCount(int tapCount) {
        super.setTapCount(tapCount);
    }

    @Override
    public float getTouchDownX() {
        return super.getTouchDownX();
    }

    @Override
    public float getTouchDownY() {
        return super.getTouchDownY();
    }

    /**
     * The button that initially pressed this button or -1 if the button is not pressed.
     */
    @Override
    public int getPressedButton() {
        return super.getPressedButton();
    }

    /**
     * The pointer that initially pressed this button or -1 if the button is not pressed.
     */
    @Override
    public int getPressedPointer() {
        return super.getPressedPointer();
    }

    /**
     * @see #setButton(int)
     */
    @Override
    public int getButton() {
        return super.getButton();
    }

    /**
     * Sets the button to listen for, all other buttons are ignored. Default is Use -1 for any button.
     *
     * @param button
     */
    @Override
    public void setButton(int button) {
        super.setButton(button);
    }
}
