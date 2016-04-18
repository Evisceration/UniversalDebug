/*
 * The MIT License
 *
 * Copyright (c) 2016 Alexander Martinz
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package at.amartinz.universaldebug.fabric.trees;

import android.support.annotation.NonNull;

import com.crashlytics.android.Crashlytics;

import at.amartinz.universaldebug.trees.BaseTree;
import at.amartinz.universaldebug.trees.CrashComponent;

/**
 * Log with {@link timber.log.Timber#e(Throwable, String, Object...)} with the specified crashPrefix
 * to send a non fatal exception log to Crashlytics.
 */
public class CrashlyticsComponent extends CrashComponent {
    public CrashlyticsComponent(@NonNull BaseTree baseTree) {
        super(baseTree);
    }

    public CrashlyticsComponent(@NonNull BaseTree baseTree, @NonNull String crashPrefix) {
        super(baseTree, crashPrefix);
    }

    @Override protected void reportCrash(int priority, String tag, String message, Throwable t) {
        final String errorString = String.format("%s: %s", tag, message);
        Crashlytics.logException(new RuntimeException(errorString));
    }
}
