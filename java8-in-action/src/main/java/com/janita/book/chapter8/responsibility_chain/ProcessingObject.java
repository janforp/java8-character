package com.janita.book.chapter8.responsibility_chain;

/**
 * Created by Janita on 2017/6/4- 12:39
 * 责任链模式
 */
abstract public class ProcessingObject<T> {

    protected ProcessingObject<T> successor;

    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    public T handle(T input) {

        T r = handleWork(input);

        if (successor != null) {
            return successor.handle(r);
        }
        return r;
    }

    abstract protected T handleWork(T input);
}
