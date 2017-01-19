package com.ragdroid.rxify.codelab;

import com.ragdroid.rxify.codelab.presenter.BaseCLPresenter;
import com.ragdroid.rxify.core.BaseSchedulerProvider;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;

/**
 * Created by garimajain on 15/01/17.
 */

public class ChillPresenter extends BaseCLPresenter<Long> implements CodeLabContract.Presenter {

    public Observable<Long> inputValues = Observable.interval(1, 1, TimeUnit.MICROSECONDS);

    public ChillPresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    //TODO Run the code.

//    @Override
//    protected Disposable getDisposable() {
//        return inputValues
//                .subscribeOn(provider.io())
//                .observeOn(provider.ui())
//                .subscribe(next, error, complete);
//    }

    //TODO Limit the number of inputs to 129

//    @Override
//    protected Disposable getDisposable() {
//        return inputValues
//                .take(129)
//                .subscribeOn(provider.io())
//                .observeOn(provider.ui())
//                .subscribe(next, error, complete);
//    }

    //TODO Buffer 10 items and concatenate them to a String

//    @Override
//    protected Disposable getDisposable() {
//        return inputValues
//                .take(129)
//                .buffer(10)
//                .flatMap(new Function<List<Long>, ObservableSource<String>>() {
//                    @Override
//                    public ObservableSource<String> apply(List<Long> longs) throws Exception {
//                        return Observable.fromIterable(longs)
//                                .reduce("", new BiFunction<String, Long, String>() {
//                                    @Override
//                                    public String apply(String oldString, Long aLong) throws Exception {
//                                        return oldString + "\n" + aLong;
//                                    }
//                                }).toObservable();
//                    }
//                })
//                .subscribeOn(provider.io())
//                .observeOn(provider.ui())
//                .subscribe(next, error, complete);
//    }

//    SIRIUSLY

    //TODO Use Debounce 1 Microsecond to drop some values


    @Override
    protected Disposable getDisposable() {
        return inputValues
                .take(129)
                .debounce(1, TimeUnit.MICROSECONDS)
                .subscribeOn(provider.io())
                .observeOn(provider.ui())
                .subscribe(next, error, complete);
    }
}
