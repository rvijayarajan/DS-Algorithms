/***
 * In-place Algorithm
 * to reverse the array
 */
export const reverseArray = arr => {
    if (arr && arr.constructor == Array && arr.length > 1) {
        const arrLength = arr.length;
        const limit = Math.ceil(arrLength / 2);
        for (let i = 0; i < limit; i++) {
            let temp = arr[i];
            arr[i] = arr[arrLength - 1 - i];
            arr[arrLength - 1 - i] = temp; 
        }
        return arr;
    }
    return arr;
}
