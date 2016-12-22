package com.auidbook.animationexamples;

import android.animation.TypeEvaluator;

/**
 * TypeEvaluator for CharSequences, handles nulls, empty values, and different lengths
 *
 * If you are animating from "Bacon" to "Power" the animation would look like this:
 * <ul>
 *     <li>Bacon</li>
 *     <li>Pacon</li>
 *     <li>Pocon</li>
 *     <li>Powon</li>
 *     <li>Powen</li>
 *     <li>Power</li>
 * </ul>
 *
 * Overshooting and undershooting are currently just clamped.
 *
 * @author Ian G. Clifton
 */
public class CharSequenceEvaluator implements TypeEvaluator<CharSequence> {

    @Override
    public CharSequence evaluate(float fraction, CharSequence startValue, CharSequence endValue) {
        final int initialTextLength = startValue == null ? 0 : startValue.length();
        final int finalTextLength = endValue == null ? 0 : endValue.length();

        // Handle two empty strings because someone's probably going to do this for some reason
        if (initialTextLength == 0 && finalTextLength == 0) {
            return endValue;
        }

        // Handle anticipation
        if (fraction <= 0) {
            return startValue;
        }
        // Handle overshooting
        if (fraction >= 1f) {
            return endValue;
        }

        // Fraction is based on the longer CharSequence
        final float maxLength = Math.max(initialTextLength, finalTextLength);
        final int charactersChanged = (int) (maxLength * fraction);
        if (charactersChanged == 0) {
            // Handle anything that rounds to 0
            return startValue;
        }

        if (finalTextLength < charactersChanged) {
            // More characters have changed than the length of the final string

            if (finalTextLength == 0) {
                // Moving toward no string, so just substring the initial values
                return startValue.subSequence(charactersChanged, initialTextLength);
            }

            if (initialTextLength <= charactersChanged) {
                // Use the endValue because the startValue has been passed
                return endValue.subSequence(0, charactersChanged);
            }

            // Both CharSequences have characters to use
            return endValue + startValue.subSequence(charactersChanged, initialTextLength).toString();
        }

        // endValue is longer than the number of characters that have changed
        if (initialTextLength <= charactersChanged) {
            // Already animated away start, use fraction of end
            return endValue.subSequence(0, charactersChanged).toString();
        }

        return endValue.subSequence(0, charactersChanged).toString() + startValue.subSequence(charactersChanged, initialTextLength);
    }
}