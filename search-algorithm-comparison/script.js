// DOM queries for elements
const mainButton = document.querySelector(".main__button");
const linearDisplay = document.querySelector(".main__linear");
const binaryDisplay = document.querySelector(".main__binary");
const arrayDisplay = document.querySelector(".main__display");
const linearIndexDisplay = document.querySelector(".main__linear-index");
const binaryIndexDisplay = document.querySelector(".main__binary-index");
function displayArray(array) {
  // Displays the array on screen for now
  arrayDisplay.textContent = array;
}

// Generates random array
function generateArray(length) {
  // Using a set to generate unique, random values for an array
  const set = new Set();
  while (set.size !== length) {
    set.add(Math.floor(Math.random() * 1000000) + 1);
  }

  // Using Array.from converts this set into an array
  return Array.from(set);
}

// Finds the time of any searching algorithm by passing the function reference as 'callback', the array, and target
function findTime(callback, array, target) {
  const timeStart = performance.now();
  const foundIndex = callback(array, target);
  const timeEnd = performance.now();
  const timeTaken = timeEnd - timeStart;

  // Shorter sytanx for if statement
  return { foundIndex, timeTaken };
}

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
