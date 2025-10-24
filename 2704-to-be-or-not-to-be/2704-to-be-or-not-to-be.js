/**
 * @param {any} val
 * @return {Object}
 */
var expect = function(val) {
    return {
        toBe: function(otherVal) {
            if (val === otherVal) return true;
            throw new Error("Not Equal");
        },
        notToBe: function(otherVal) {
            if (val !== otherVal) return true;
            throw new Error("Equal");
        }
    };
};

/**
 * Example Usage:
 * expect(5).toBe(5);      // ✅ returns true
 * expect(5).notToBe(5);   // ❌ throws "Equal"
 * expect(5).notToBe(10);  // ✅ returns true
 */
