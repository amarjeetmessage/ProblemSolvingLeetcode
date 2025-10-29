/**
 * @param {Function} fn
 * @param {any[]} args
 * @param {number} t
 * @return {Function}
 */
var cancellable = function(fn, args, t) {
    const timeoutId = setTimeout(() => fn(...args), t);

    const cancelFn = () => {
        clearTimeout(timeoutId);
    };

    return cancelFn;
};
