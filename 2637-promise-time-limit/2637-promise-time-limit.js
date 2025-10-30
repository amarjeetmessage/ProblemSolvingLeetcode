/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function(fn, t) {
    return async function(...args) {
        // Create a promise that rejects after `t` milliseconds
        const timeoutPromise = new Promise((_, reject) => {
            setTimeout(() => reject("Time Limit Exceeded"), t);
        });

        // Execute the original function with provided arguments
        const fnPromise = fn(...args);

        // Return whichever promise settles first
        return Promise.race([fnPromise, timeoutPromise]);
    };
};
