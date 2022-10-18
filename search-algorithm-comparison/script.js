// DOM queries for elements
const mainButton = document.querySelector(".main__button");
const linearDisplay = document.querySelector(".main__linear");
const binaryDisplay = document.querySelector(".main__binary");
const arrayDisplay = document.querySelector(".main__display");
const linearIndexDisplay = document.querySelector(".main__linear-index");
const binaryIndexDisplay = document.querySelector(".main__binary-index");
function linearSearch(array, target) {
  return array.findIndex((element) => element === target);
}

function binarySearch(list, target) {
  let low = 0;
  let high = list.length - 1;

  while (low <= high) {
    let mid = low + (high - low) / 2;

    if (list[mid] === target) {
      return mid;
    } else if (list[mid] > target) {
      high = mid - 1;
    } else {
      low = mid + 1;
    }
  }

  return -1;
}
