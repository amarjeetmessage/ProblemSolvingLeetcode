/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    const cache = new Map();
    let callCount = 0;

    const memoizedFn = (...args) => {
        const key = JSON.stringify(args); // unique key based on arguments

        if (cache.has(key)) {
            return cache.get(key); // return cached value if present
        }

        const result = fn(...args);
        cache.set(key, result);
        callCount++; // function was actually called
        return result;
    };

    // helper method to get number of times function was called
    memoizedFn.getCallCount = () => callCount;

    return memoizedFn;
}
