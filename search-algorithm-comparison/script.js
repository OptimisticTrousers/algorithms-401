// DOM queries for elements. All this is doing is grabbing the HTML elements to do things with them
const mainButton = document.querySelector(".main__button");
const linearSpeedDisplay = document.querySelectorAll(".main__speed")[0];
const binarySpeedDisplay = document.querySelectorAll(".main__speed")[1];
const arrayDisplay = document.querySelector(".main__array");
const arrayLength = document.querySelector(".main__length");

const foundElementDisplay = document.querySelector(".main__found");

const arrayLengthInput = document.querySelector(".main__input");

// Event listener called 'onClick' for click event on button
mainButton.addEventListener("click", onClick);

// Function that occurs when the button is clicked
function onClick() {
  // Creating a random array of unique values that is size 1,000,000 or the user generated value
  const inputValue = parseInt(arrayLengthInput.value);

  if (inputValue > 1000000) {
    arrayLengthInput.value = 1000000;
    return;
  }
  const randomArray = generateArray(inputValue);
  // Sorting the array for binary search
  const sortedRandomArray = sortArray(randomArray);

  const randomIndex = Math.floor(Math.random() * randomArray.length);

  const randomTarget = sortedRandomArray[randomIndex];
  displayArray(randomArray);
  // Arbitrarily picking 5 as the target
  // Don't worry about this part if it's confusing, but just know it gets the results from the 'findTime' helper function
  const binarySearchTime = findTime(
    binarySearch,
    sortedRandomArray,
    randomTarget
  );
  const linearSearchTime = findTime(
    linearSearch,
    sortedRandomArray,
    randomTarget
  );
  // Changing the text content of these 4 HTML elements
  linearSpeedDisplay.textContent = `Speed: ${linearSearchTime} ms`;
  binarySpeedDisplay.textContent = `Speed: ${binarySearchTime} ms ${
    binarySearchTime === 0 && "(Instantaneous)"
  }`;
  foundElementDisplay.textContent = `Found element: ${sortedRandomArray[randomIndex]}`;
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
  callback(array, target);
  const timeEnd = performance.now();
  const timeTaken = parseFloat(timeEnd - timeStart);

  // Returning timeTaken
  return timeTaken;
}

// Built in JS function to search for index. O(n) time
function linearSearch(array, target) {
  return array.findIndex((element) => element === target);
}

function binarySearch(list, target) {
  let low = 0;
  let high = list.length - 1;

  while (low <= high) {
    let mid = low + Math.floor((high - low) / 2);

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

const randomArray = generateArray(900000);
// Sorting the array for binary search
const sortedRandomArray = sortArray(randomArray);
displayArray(randomArray);
