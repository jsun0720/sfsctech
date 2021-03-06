package com.sfsctech.support.common.http.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Class AsyncHttpFuture
 *
 * @author 张麒 2016/4/12.
 * @version Description:
 */
public class AsyncHttpFuture<T> implements Future<T> {


    private final FutureCallback<T> callback;
    private volatile boolean completed;
    private volatile T result;
    private volatile Exception ex;

    public AsyncHttpFuture(final FutureCallback<T> callback) {
        super();
        this.callback = callback;
    }

    public boolean isDone() {
        return this.completed;
    }

    private T getResult() throws ExecutionException {
        if (this.ex != null) {
            throw new ExecutionException(this.ex);
        }
        return this.result;
    }

    public synchronized T get() throws InterruptedException, ExecutionException {
        while (!this.completed) {
            wait();
        }
        return getResult();
    }

    public synchronized T get(final long timeout, final TimeUnit unit) throws ExecutionException, InterruptedException {
        final long msecs = unit.toMillis(timeout);
        final long startTime = (msecs <= 0) ? 0 : System.currentTimeMillis();
        long waitTime = msecs;
        if (this.completed) {
            return getResult();
        } else if (waitTime <= 0) {
            throw new RuntimeException();
        } else {
            for (; ; ) {
                wait(waitTime);
                if (this.completed) {
                    return getResult();
                } else {
                    waitTime = msecs - (System.currentTimeMillis() - startTime);
                    if (waitTime <= 0) {
                        throw new InterruptedException();
                    }
                }
            }
        }
    }

    public boolean completed(final T result) {
        synchronized (this) {
            if (this.completed) {
                return false;
            }
            this.completed = true;
            this.result = result;
            notifyAll();
        }
        if (this.callback != null) {
            this.callback.completed(result);
        }
        return true;
    }

    public boolean failed(final Exception exception) {
        synchronized (this) {
            if (this.completed) {
                return false;
            }
            this.completed = true;
            this.ex = exception;
            notifyAll();
        }
        if (this.callback != null) {
            this.callback.failed(exception);
        }
        return true;
    }

    @Override
    public boolean cancel(boolean arg0) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }
}
