// DOM queries for elements. All this is doing is grabbing the HTML elements to do things with them
const mainButton = document.querySelector(".main__button");
const linearSpeedDisplay = document.querySelectorAll(".main__speed")[0];
const binarySpeedDisplay = document.querySelectorAll(".main__speed")[1];
const arrayDisplay = document.querySelector(".main__array");
const arrayLength = document.querySelector(".main__length");
const linearIndexDisplay = document.querySelectorAll(".main__index")[0];
const binaryIndexDisplay = document.querySelectorAll(".main__index")[1];

// Event listener called 'onClick' for click event on button
mainButton.addEventListener("click", onClick);

// Function that occurs when the button is clicked
function onClick() {
  // Creating a random array of unique values that is size 1,000,000
  const randomArray = generateArray(1000000);
  // Sorting the array for binary search
  const sortedRandomArray = sortArray(randomArray);
  displayArray(randomArray);
  // Arbitrarily picking 5 as the target
  // Don't worry about this part if it's confusing, but just know it gets the results from the 'findTime' helper function
  const { foundIndex: binaryIndex, timeTaken: binaryTime } = findTime(
    binarySearch,
    sortedRandomArray,
    5
  );
  const { foundIndex: linearIndex, timeTaken: linearTime } = findTime(
    linearSearch,
    randomArray,
    5
  );
  // Changing the text content of these 4 HTML elements
  linearSpeedDisplay.textContent = `Speed display: ${linearTime} ms`;
  binarySpeedDisplay.textContent = `Speed display: ${binaryTime} ms`;
  linearIndexDisplay.textContent = `Found index: ${linearIndex}`;
  binaryIndexDisplay.textContent = `Found index: ${binaryIndex}`;
}

// Generates random array
function generateArray(length) {
  // Using a set to generate unique, random values for an array
  const arr = new Array(length);
  for(let i = 0; i < length; i++){
    arr[i] = Math.floor(Math.random() * 100000) + 1;
  }
  // Using Array.from converts this set into an array
  return arr;
}


function sortArray(array) {
  // ... is known as the 'spread syntax', used to copy an array. Not copying the array when sorting will mutate the original array, which we don't want because it can cause unintended side effects
  return [...array].sort((a, b) => a - b);
}

function sortArray(array) {
  // ... is known as the 'spread syntax', used to copy an array. Not copying the array when sorting will mutate the original array, which we don't want because it can cause unintended side effects
  return [...array].sort((a, b) => a - b);
}

function displayArray(array) {
  // Displays the last four elements of the array on the screen
  arrayDisplay.textContent = `[...${array[array.length - 5]}, ${
    array[array.length - 4]
  }, ${array[array.length - 3]}, ${array[array.length - 2]}]`;
  arrayLength.textContent = `Array length is ${array.length}`;
}

// Finds the time of any searching algorithm by passing the function reference as 'callback', the array, and target
function findTime(callback, array, target) {
  const timeStart = performance.now();
  const foundIndex = callback(array, target);
  const timeEnd = performance.now();
  const timeTaken = (timeEnd - timeStart).toFixed(4);

  // Returning an object with the foundIndex and timeTaken
  return { foundIndex, timeTaken };
}

// Built in JS function to search for index. O(n) time
function linearSearch(array, target) {
  return array.findIndex((element) => element === target);
}

function binarySearch(list, target) {
  let low = 0;
  let high = list.length - 1;

  while (low <= high) {
    let mid = low + Math.floor((high - low) / 2)

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
