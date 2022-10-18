// DOM queries for elements
const mainButton = document.querySelector(".main__button");
const linearSpeedDisplay= document.querySelectorAll(".main__speed")[0];
const binarySpeedDisplay = document.querySelectorAll(".main__speed")[1];
const arrayDisplay = document.querySelector(".main__array");
const arrayLength = document.querySelector(".main__length")
const linearIndexDisplay = document.querySelectorAll(".main__index")[0];
const binaryIndexDisplay = document.querySelectorAll(".main__index")[1];

// Event listeners
mainButton.addEventListener("click", (event) => {
  // Creating a random array of unique values that is size 1,000,000
  const randomArray = generateArray(1000000);
  displayArray(randomArray)
  // Arbitrarily picking 5 as the target
  // Don't worry about this part if it's confusing
  const { foundIndex: binaryIndex, timeTaken: binaryTime } = findTime(
    binarySearch,
    randomArray,
    5
  );
  const { foundIndex: linearIndex, timeTaken: linearTime } = findTime(
    linearSearch,
    randomArray,
    5
  );

  linearSpeedDisplay.textContent = `Speed display: ${linearTime} ms`;
  binarySpeedDisplay.textContent = `Binary display: ${binaryTime} ms`;
  linearIndexDisplay.textContent = `Linear search found index: ${linearIndex}`;
  binaryIndexDisplay.textContent = `Binary search found index: ${binaryIndex}`;
});

function displayArray(array) {
  // Displays the array on screen for now
  arrayDisplay.textContent = `[...${array[array.length -2]}, ${array[array.length -3]}, ${array[array.length - 4]}, ${array[array.length - 5]}]`;
  arrayLength.textContent = `Array length is ${array.length}`
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
  const timeTaken = (timeEnd - timeStart).toFixed(4);

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
    let mid = (low + high) / 2;

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

console.log(binarySearch([2, 1, 4, 10, 15, 62, 6, 7, 9], 4))
