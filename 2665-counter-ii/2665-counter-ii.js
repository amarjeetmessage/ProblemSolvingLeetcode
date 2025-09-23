/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let current = init; // define current to track value

    return {
        increment: function() {
            return ++current; // increase then return
        },
        decrement: function() {
            return --current; // decrease then return
        },
        reset: function() {
            current = init;   // reset to original init
            return current;
        }
    };
};

/**
 * const counter = createCounter(5)
 * console.log(counter.increment()); // 6
 * console.log(counter.reset());     // 5
 * console.log(counter.decrement()); // 4
 */
