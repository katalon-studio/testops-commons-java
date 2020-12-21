package com.katalon.testops.commons;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReportStorage {

    private final Map<String, Object> store = new ConcurrentHashMap<>();

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public <T> Optional<T> get(final String uuid, final Class<T> clazz) {
        readLock().lock();
        try {
            return Optional.ofNullable(store.get(uuid))
                    .filter(clazz::isInstance)
                    .map(clazz::cast);
        } finally {
            readLock().unlock();
        }
    }

    public <T> T put(final String uuid, final T item) {
        writeLock().lock();
        try {
            store.put(uuid, item);
            return item;
        } finally {
            writeLock().unlock();
        }
    }

    public void remove(final String uuid) {
        writeLock().lock();
        try {
            store.remove(uuid);
        } finally {
            writeLock().unlock();
        }
    }

    private Lock readLock() {
        return lock.readLock();
    }

    private Lock writeLock() {
        return lock.writeLock();
    }
}
