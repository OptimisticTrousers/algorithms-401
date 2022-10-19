// DOM queries for elements. All this is doing is grabbing the HTML elements to do things with them
const mainButton = document.querySelector<HTMLButtonElement>(".main__button");
const linearSpeedDisplay =
  document.querySelectorAll<HTMLParagraphElement>(".main__speed")[0];
const binarySpeedDisplay =
  document.querySelectorAll<HTMLParagraphElement>(".main__speed")[1];
const arrayDisplay =
  document.querySelector<HTMLParagraphElement>(".main__array");
const arrayLength =
  document.querySelector<HTMLParagraphElement>(".main__length");
const linearIndexDisplay =
  document.querySelectorAll<HTMLParagraphElement>(".main__index")[0];
const binaryIndexDisplay =
  document.querySelectorAll<HTMLParagraphElement>(".main__index")[1];

// Event listener called 'onClick' for click event on button
mainButton?.addEventListener("click", onClick);

// Function that occurs when the button is clicked
function onClick(): void {
  // Creating a random array of unique values that is size 1,000,000
  const randomArray: number[] = generateArray(1000000);
  // Sorting the array for binary search
  const sortedRandomArray: number[] = sortArray(randomArray);
  displayArray(randomArray);
  // Arbitrarily picking 5 as the target
  // Don't worry about this part if it's confusing, but just know it gets the results from the 'findTime' helper function
  const {
    foundIndex: binaryIndex,
    timeTaken: binaryTime,
  }: { foundIndex: number; timeTaken: string } = findTime(
    binarySearch,
    sortedRandomArray,
    5
  );
  const {
    foundIndex: linearIndex,
    timeTaken: linearTime,
  }: { foundIndex: number; timeTaken: string } = findTime(
    linearSearch,
    randomArray,
    5
  );
  // Changing the text content of these 4 HTML elements
  linearSpeedDisplay!.textContent = `Speed display: ${linearTime} ms`;
  binarySpeedDisplay!.textContent = `Speed display: ${binaryTime} ms`;
  linearIndexDisplay!.textContent = `Found index: ${linearIndex}`;
  binaryIndexDisplay!.textContent = `Found index: ${binaryIndex}`;
}

// Generates random array
function generateArray(length: number): number[] {
  // Using a set to generate unique, random values for an array
  const arr: number[] = new Array(length);
  for (let i: number = 0; i < length; i++) {
    arr[i] = Math.floor(Math.random() * 100000) + 1;
  }
  // Using Array.from converts this set into an array
  return arr;
}

function sortArray(array: number[]): number[] {
  // ... is known as the 'spread syntax', used to copy an array. Not copying the array when sorting will mutate the original array, which we don't want because it can cause unintended side effects
  return [...array].sort((a, b) => a - b);
}

function displayArray(array: number[]): void {
  // Displays the last four elements of the array on the screen
  arrayDisplay!.textContent = `[...${array[array.length - 5]}, ${
    array[array.length - 4]
  }, ${array[array.length - 3]}, ${array[array.length - 2]}]`;
  arrayLength!.textContent = `Array length is ${array.length}`;
}

// Finds the time of any searching algorithm by passing the function reference as 'callback', the array, and target

function findTime(
  callback: (array: number[], target: number) => number,
  array: number[],
  target: number
) {
  const timeStart: number = performance.now();
  const foundIndex: number = callback(array, target);
  const timeEnd: number = performance.now();
  const timeTaken: string = (timeEnd - timeStart).toFixed(4);

  // Returning an object with the foundIndex and timeTaken
  return { foundIndex, timeTaken };
}

// Built in JS function to search for index. O(n) time
function linearSearch(array: number[], target: number): number {
  return array.findIndex((element: number) => element === target);
}

function binarySearch(array: number[], target: number): number {
  let low: number = 0;
  let high: number = array.length - 1;

  while (low <= high) {
    let mid: number = low + Math.floor((high - low) / 2);

    if (array[mid] === target) {
      return mid;
    } else if (array[mid] > target) {
      high = mid - 1;
    } else {
      low = mid + 1;
    }
  }

  return -1;
}
