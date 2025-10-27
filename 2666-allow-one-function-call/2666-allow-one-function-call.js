/**
 * @param {Function} fn
 * @return {Function}
 */
var once = function(fn) {
    let called = false;   // to track if fn has been called already
    let result;           // to store fn's return value
    
    return function(...args) {
        if (!called) {
            called = true;
            result = fn(...args);
            return result;
        }
        return undefined; // subsequent calls return undefined
    };
};
