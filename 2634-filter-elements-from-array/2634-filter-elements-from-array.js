/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    const result = [];
    for (let i = 0; i < arr.length; i++) {
        if (fn(arr[i], i)) {   // Apply fn and check if it's truthy
            result.push(arr[i]);
        }
    }
    return result;
};
